package com.bajdcc.rt.adv.func;

import com.bajdcc.rt.RtEnv;
import com.bajdcc.rt.RtSettings;
import com.bajdcc.rt.adv.RtFunc;
import com.bajdcc.rt.adv.exp.RtExp;
import com.bajdcc.rt.adv.exp.RtTExp;
import com.bajdcc.rt.adv.token.RtTNumber;
import com.bajdcc.rt.adv.token.RtTString;
import com.bajdcc.rt.error.SemanticException;
import com.bajdcc.rt.symbol.RtStringFactory;
import com.sun.istack.internal.NotNull;

import java.util.*;

/**
 * 设置
 */
public class RtSettingFunc extends RtFunc {

    private enum SettingType {
        MULTI_ANSWER("多解"),
        REPORT_TIMER("定时"),
        COPYRIGHT("版权"),
        ;

        private String desc;

        SettingType(String desc) {
            this.desc = desc;
        }

        public String getDesc() {
            return desc;
        }

        private static Map<String, SettingType> map = new HashMap<>();
        static {
            for (SettingType type : SettingType.values()) {
                map.put(type.getDesc(), type);
            }
        }

        public static SettingType find(String string) {
            return map.get(string);
        }
    }

    private Iterator<RtExp> iter;
    private RtStringFactory sf;

    public void set(@NotNull RtEnv env) throws SemanticException {
        List<RtExp> args = getExp().getChilren().get(0).getChilren();
        sf = env.getStringFactory();;
        iter = args.iterator();
        String name = getNextString();
        SettingType type = SettingType.find(name);
        if (type == null) {
            throw new SemanticException("没有这个设置选项", "参数错误",
                    SemanticException.SemanticErrorType.EPARAM);
        }
        dealWithSettingId(type, env.getSettings());
        if (iter.hasNext()) {
            throw new SemanticException("请减少参数", "参数太多",
                    SemanticException.SemanticErrorType.EPARAM);
        }
    }

    private String getNextString() throws SemanticException {
        if (iter.hasNext()) {
            return iter.next().tryGetToken().getToken().tryGetString(sf);
        }
        throw new SemanticException("获取字串失败", "参数不够",
                SemanticException.SemanticErrorType.EPARAM);
    }

    private int getNextNumber() throws SemanticException {
        if (iter.hasNext()) {
            return iter.next().tryGetToken().getToken().tryGetNumber();
        }
        throw new SemanticException("获取数字失败", "参数不够",
                SemanticException.SemanticErrorType.EPARAM);
    }

    private static int clamp(int target, int lower, int upper) throws SemanticException {
        if (target > upper || target < lower) {
            throw new SemanticException(
                    String.format("数字%d不在区间[%d,%d]内", target, lower, upper),
                    "参数错误",
                    SemanticException.SemanticErrorType.EPARAM);
        }
        return target;
    }

    private void dealWithSettingId(@NotNull SettingType type, @NotNull RtSettings settings) throws SemanticException {
        switch (type) {
            case MULTI_ANSWER:
                settings.multiAnswer = true;
                break;
            case REPORT_TIMER:
                settings.reportTimer = clamp(getNextNumber(), 500, 10000);
                break;
            case COPYRIGHT:
                settings.displayCopyright = getNextString();
                break;
        }
    }

    @Override
    public String toString() {
        return "RtSettingFunc{} " + super.toString();
    }
}
