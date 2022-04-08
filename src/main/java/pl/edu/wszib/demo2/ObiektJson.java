package pl.edu.wszib.demo2;

import java.util.Arrays;

public class ObiektJson {
    int liczba;
    String tekst;
    String[] lista;
    ObiektJson2 obiekt;

    @Override
    public String toString() {
        return "ObiektJson{" +
                "liczba=" + liczba +
                ", tekst='" + tekst + '\'' +
                ", lista=" + Arrays.toString(lista) +
                ", obiekt=" + obiekt +
                '}';
    }

    class ObiektJson2 {
        String nowy_tekst;
    };
//    "nowe_pole" : true
}
