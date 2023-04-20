package p07.osoby.dat;

/*
 * Copyright (C) 2023 Jirina Kralovcova
 * This program is part of Java programing education. 
 * You can use it as you need to learn Java. 
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.EOFException;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.Collator;
import java.util.Comparator;
import java.util.Locale;
import java.util.Objects;
import java.util.Scanner;

/**
 *
 * @author Jirina
 */
public class Osoba implements Comparable<Osoba> {

    private final int ic;
    private final String jm;
    private final String pr;
    private final double vyska;

    private static Collator col_cz = Collator.getInstance(new Locale("cs", "CZ"));

    public final static Comparator<Osoba> COMP_DLE_VYSKY
            = new Comparator<Osoba>() {
        @Override
        public int compare(Osoba o1, Osoba o2) {
            return (int) Math.signum(o1.getVyska() - o2.getVyska());
        }
    };
    public final static Comparator<Osoba> COMP_DLE_IC
            = new Comparator<Osoba>() {
        @Override
        public int compare(Osoba o1, Osoba o2) {
            return o1.compareTo(o2);
        }
    };
    public final static Comparator<Osoba> COMP_DLE_JMEN
            = new Comparator<Osoba>() {
        @Override
        public int compare(Osoba o1, Osoba o2) {
            int v = col_cz.compare(o1.pr, o2.pr);
            if (v != 0) {
                return v;
            }
            return col_cz.compare(o1.jm, o2.jm);
        }
    };

    public Osoba(int ic, String jm, String pr, double vyska) {
        this.ic = ic;
        this.jm = jm;
        this.pr = pr;
        this.vyska = vyska;
    }

    public int getIc() {
        return ic;
    }

    public String getJm() {
        return jm;
    }

    public String getPr() {
        return pr;
    }

    public double getVyska() {
        return vyska;
    }

    @Override
    public String toString() {
        return "Osoba{" + "ic=" + ic + ", jm=" + jm + ", pr=" + pr + ", vyska=" + vyska + '}';
    }

    public String toStringFmt() {
        return String.format("%10s %10s %4d %.1f", jm, pr, ic, vyska);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.ic;
        hash = 97 * hash + Objects.hashCode(this.jm);
        hash = 97 * hash + Objects.hashCode(this.pr);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Osoba other = (Osoba) obj;
        if (this.ic != other.ic) {
            return false;
        }
        if (!Objects.equals(this.jm, other.jm)) {
            return false;
        }
        return Objects.equals(this.pr, other.pr);
    }

    @Override
    public int compareTo(Osoba o) {
        return ic - o.ic;
    }

    // zapis do souboru v binarnim tvaru
    public void saveToFile(DataOutput dos) throws IOException {
        dos.writeInt(ic);
        dos.writeUTF(jm);
        dos.writeUTF(pr);
        dos.writeDouble(vyska);
    }

    // nacteni z binarniho souboru
    public static Osoba loadFromFile(DataInput dis) throws IOException {
        try {
            Osoba os = new Osoba(dis.readInt(), dis.readUTF(),
                    dis.readUTF(), dis.readDouble());
            return os;
        } catch (EOFException ex) {
            return null;
        }
    }

    // zapis do textoveho souboru v jistem formatu
    // zde pouze volny format
    public void saveToFile(PrintWriter pw) throws IOException {
        pw.format("%d %s %s %f%n", ic, jm, pr, vyska);
    }

    public void saveToFile(BufferedWriter bw) throws IOException {
        bw.write(String.format("%d %s %s %f", ic, jm, pr, vyska));
        bw.newLine();
    }

    // nacteni dat z textoveho souboru
    // v obou nasledujicich metodach
    // je predpokladan format, ve kterem byla data ulozena nekterou z vyse uvedenych metod
    //   a zaroven jmeno a prijmeni muhou byt pouze jednoslovni retezce
    //   jedna se o prilis omezujici podminku pro realne pripady
    //   v pripade obecnejsich dat by bylo nutyno upravit format zapisu, 
    //   aby bylo mozne pri nacteni jednoznacne oodelit jmeno a prijmeni
    //   realne cislo muze byt uchovano s desetinnou teckou nebo carkou
    public static Osoba loadFromFile(BufferedReader br) throws IOException {
        String radek = br.readLine();
        if (radek == null) { //konec souboru
            return null;
        }
        String[] dataStr = radek.split(" +");
        // pole dataStr musi mit delku 4 - vhodne overit, pripadne resit
        int ic = Integer.parseInt(dataStr[0]);
        double v = Double.parseDouble(dataStr[3].replaceAll(",", "."));
        Osoba os = new Osoba(ic, dataStr[1], dataStr[2], v);
        return os;
    }

    public static Osoba loadFromFile(Scanner scf) throws IOException {
        if(scf.hasNext()){
            Osoba os = new Osoba(scf.nextInt(), scf.next(), scf.next(), scf.nextDouble());
            return os;
        }
        return null;
    }

}
