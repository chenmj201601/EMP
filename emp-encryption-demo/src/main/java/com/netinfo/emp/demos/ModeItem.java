package com.netinfo.emp.demos;

/**
 * Project emp-encryption-demo
 * Package com.netinfo.emp.demos
 * <p>
 * Created by Charley on 2017/3/1.
 */
public class ModeItem {
    private String name;
    private int mode;

    public ModeItem() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMode() {
        return mode;
    }

    public void setMode(int mode) {
        this.mode = mode;
    }

    @Override
    public String toString() {
        return String.format("[%d] %s", mode, name);
    }
}
