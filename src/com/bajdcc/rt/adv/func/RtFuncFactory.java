package com.bajdcc.rt.adv.func;

import com.bajdcc.rt.adv.RtFunc;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.HashMap;
import java.util.Map;

/**
 * 方法工厂
 */
public class RtFuncFactory {
    private static final RtFuncFactory ourInstance = new RtFuncFactory();
    private final Map<String, FuncType> nameMap = new HashMap<>();

    private RtFuncFactory() {
        for (FuncType type : FuncType.values()) {
            nameMap.put(type.getName(), type);
        }
    }

    public static RtFuncFactory getInstance() {
        return ourInstance;
    }

    public boolean contains(String string) {
        return nameMap.containsKey(string);
    }

    private FuncType getType(String string) {
        return nameMap.get(string);
    }

    public int getTypeIndex(String string) {
        return getType(string).ordinal();
    }

    public RtFunc createFunc(String string) {
        switch (getType(string)) {
            case MUTEX:
                return new RtMutexFunc();
            case PRINT:
                return new RtPrintFunc();
            case SETTING:
                return new RtSettingFunc();
        }
        throw new NotImplementedException();
    }

    private enum FuncType {
        MUTEX("互斥"),
        PRINT("输出"),
        SETTING("设置");

        private final String name;

        FuncType(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }
}
