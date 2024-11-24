package com.example.myapplication;

public class Zadanie {
    private String nazwa;
    private String opis;

    public Zadanie(String nazwa, String opis) {
        this.nazwa = nazwa;
        this.opis = opis;
    }

    public String getName() {
        return nazwa;
    }

    public String getOpis() {
        return opis;
    }

    public void setName(String name) {
        this.nazwa = name;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }
}