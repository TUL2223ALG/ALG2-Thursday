/*
 * Copyright (C) 2022 Jirina
 * This program is part of Java programing education. 
 * You can use it as you need to learn Java. 
 */
package jk.p145.primypristup;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

/**
 *
 * @author Jirina
 */
public class Zaznam implements Comparable<Zaznam> {

    public static int DELKA_ZAZNAMU = Short.BYTES + Float.BYTES;
    private final short id;
    private float value;

    public Zaznam(short id, float value) {
        this.id = id;
        this.value = value;
    }

    public static Zaznam loadFromFile(DataInput di) throws IOException {
        return new Zaznam(di.readShort(), di.readFloat());
    }

    public void saveToFile(DataOutput dof) throws IOException {
        dof.writeShort(id);
        dof.writeFloat(value);
    }
    public short getId() {
        return id;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public String toStringFmt() {
        return String.format("%5d  %8.2f", id, value);
    }

    @Override
    public String toString() {
        return "Zaznam{" + "id=" + id + ", value=" + value + '}';
    }

    @Override
    public int compareTo(Zaznam o) {
        return id - o.id;
    }

}
