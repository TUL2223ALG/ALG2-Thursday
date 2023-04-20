/*
 * Copyright (C) 2023 Jirina Kralovcova
 * This program is part of Java programing education. 
 * You can use it as you need to learn Java. 
 */
package alg2.p07.osoby.dat;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.EOFException;
import java.io.IOException;
import java.text.Collator;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Locale;
import java.util.Objects;

/**
 *
 * @author Jirina
 */
public class OsobaFixLength {

    public static final int DELKA_JM_PART = 10;
    public static final int DELKA_ZAZNAMU_OSOBA = 2 * DELKA_JM_PART * Character.BYTES
            + Integer.BYTES + Double.BYTES;
    private final int ic;
    private final char[] jm;
    private final char[] pr;
    private final double vyska;

    public OsobaFixLength(int ic, String jm, String pr, double vyska) {
        this.ic = ic;
        this.jm = Arrays.copyOf(jm.toCharArray(), DELKA_JM_PART);
        this.pr = Arrays.copyOf(pr.toCharArray(), DELKA_JM_PART);
        this.vyska = vyska;
    }

    private OsobaFixLength(int ic, char[] jm, char[] pr, double vyska) {
        this.ic = ic;
        this.jm = Arrays.copyOf(jm, DELKA_JM_PART);
        this.pr = Arrays.copyOf(pr, DELKA_JM_PART);
        this.vyska = vyska;
    }

    public int getIc() {
        return ic;
    }

    public String getJm() {
        return new String(jm);
    }

    public String getPr() {
        return new String(pr);
    }

    public double getVyska() {
        return vyska;
    }

    public String toStringFmt() {
        return String.format("%10s %10s %4d %.1f", getJm(), getPr(), ic, vyska);
    }

    @Override
    public String toString() {
        return "Osoba{" + "ic=" + ic + ", jm=" + new String(jm)
                + ", pr=" + new String(pr) + ", vyska=" + vyska + '}';
    }

    public void saveToFile(DataOutput dos) throws IOException {
        dos.writeInt(ic);
        for (char c : jm) {
            dos.writeChar(c);
        }
        for (char c : pr) {
            dos.writeChar(c);
        }
        dos.writeDouble(vyska);
    }

    public static OsobaFixLength loadFromFile(DataInput dis) throws IOException {
        try {
            int ic = dis.readInt();
            char[] jm = new char[DELKA_JM_PART];
            for (int i = 0; i < jm.length; i++) {
                jm[i] = dis.readChar();
            }
            char[] pr = new char[DELKA_JM_PART];
            for (int i = 0; i < pr.length; i++) {
                pr[i] = dis.readChar();
            }
            double v = dis.readDouble();
            OsobaFixLength os = new OsobaFixLength(ic, jm, pr, v);
            return os;
        } catch (EOFException ex) {
            return null;
        }
    }

}
