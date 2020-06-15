package com.adamclmns.diskpersistence.filestorage.crypto;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * The type My random crypted pojo.
 */
public class MyRandomCryptedPojo extends CryptedObject implements Serializable {
    private String a;
    private int b;
    private List<String> c;
    private Map<Integer, String> d;

    /**
     * Instantiates a new My random crypted pojo.
     *
     * @param bytes the bytes
     */
    public MyRandomCryptedPojo(byte[] bytes) {
        super(bytes);
    }

    /**
     * Instantiates a new My random crypted pojo.
     */
    public MyRandomCryptedPojo() {
        super(null);
    }

    /**
     * Instantiates a new My random crypted pojo.
     *
     * @param a the a
     * @param b the b
     * @param c the c
     * @param d the d
     */
    public MyRandomCryptedPojo(String a, int b, List<String> c, Map<Integer, String> d) {
        super(null);
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MyRandomCryptedPojo that = (MyRandomCryptedPojo) o;

        if (getB() != that.getB()) return false;
        if (!getA().equals(that.getA())) return false;
        if (!getC().equals(that.getC())) return false;
        return getD().equals(that.getD());
    }

    @Override
    public int hashCode() {
        int result = getA().hashCode();
        result = 31 * result + getB();
        result = 31 * result + getC().hashCode();
        result = 31 * result + getD().hashCode();
        return result;
    }

    /**
     * Gets a.
     *
     * @return the a
     */
    public String getA() {
        return a;
    }

    /**
     * Sets a.
     *
     * @param a the a
     */
    public void setA(String a) {
        this.a = a;
    }

    /**
     * Gets b.
     *
     * @return the b
     */
    public int getB() {
        return b;
    }

    /**
     * Sets b.
     *
     * @param b the b
     */
    public void setB(int b) {
        this.b = b;
    }

    /**
     * Gets c.
     *
     * @return the c
     */
    public List<String> getC() {
        return c;
    }

    /**
     * Sets c.
     *
     * @param c the c
     */
    public void setC(List<String> c) {
        this.c = c;
    }

    /**
     * Gets d.
     *
     * @return the d
     */
    public Map<Integer, String> getD() {
        return d;
    }

    /**
     * Sets d.
     *
     * @param d the d
     */
    public void setD(Map<Integer, String> d) {
        this.d = d;
    }
}
