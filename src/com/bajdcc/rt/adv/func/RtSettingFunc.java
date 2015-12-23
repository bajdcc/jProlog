package com.bajdcc.rt.adv.func;

import com.bajdcc.rt.RtEnv;
import com.bajdcc.rt.RtSettings;
import com.bajdcc.rt.adv.RtFunc;
import com.bajdcc.rt.adv.exp.RtTExp;
import com.bajdcc.rt.adv.token.RtTNumber;
import com.bajdcc.rt.error.SemanticException;

/**
 * 设置
 */
public class RtSettingFunc extends RtFunc {

    public void set(RtEnv env) throws SemanticException {
        if (getExp().getChilren().get(0).getChilren().get(0) instanceof RtTExp) {
            RtTExp texp = (RtTExp) getExp().getChilren().get(0).getChilren().get(0);
            if (texp.getToken() instanceof RtTNumber) {
                RtTNumber number = (RtTNumber) texp.getToken();
                dealWithSettingId(number.getIntValue(), env.getSettings());
                return;
            }
        }
        throw new SemanticException("参数要求是数字", "参数无效", SemanticException.SemanticErrorType.EPARAM);
    }

    private void dealWithSettingId(int intValue, RtSettings settings) {
        switch (intValue) {
            case 1:
                settings.multiAnswer = true;
                break;
        }
    }

    @Override
    public String toString() {
        return "RtSettingFunc{} " + super.toString();
    }
}
