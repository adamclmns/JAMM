package com.adamclmns.diskpersistence.filestorage.simple;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class MyRandomPojo implements Serializable {
    private String a;
    private int b;
    private List<String> c;
    private Map<Integer, String> d;

    MyRandomPojo(String a, int b, List<String> c, Map<Integer, String> d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public List<String> getC() {
        return c;
    }

    public void setC(List<String> c) {
        this.c = c;
    }

    public Map<Integer, String> getD() {
        return d;
    }

    public void setD(Map<Integer, String> d) {
        this.d = d;
    }
}
