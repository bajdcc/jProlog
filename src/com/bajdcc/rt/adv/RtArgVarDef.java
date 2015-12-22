package com.bajdcc.rt.adv;

import java.util.ArrayList;
import java.util.List;

/**
 * 参变量
 */
public class RtArgVarDef {

    private final int id;
    private final int type;
    private List<Integer> elements = new ArrayList<>();

    public RtArgVarDef(int id, int type) {
        this.id = id;
        this.type = type;
    }

    public void add(int id) {
        elements.add(id);
    }

    public int getId() {
        return id;
    }

    public int getType() {
        return type;
    }
}
