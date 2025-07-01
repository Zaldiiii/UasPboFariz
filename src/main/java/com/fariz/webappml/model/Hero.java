package com.fariz.webappml.model;

public class Hero {
    private int idHero;
    private String namaHero;
    private String kategori;
    private String gender;

    // constructor, getter, setter
    public Hero(String namaHero, String kategori, String gender) {
        this.namaHero = namaHero;
        this.kategori = kategori;
        this.gender = gender;
    }

    public Hero() {
    }


    public int getIdHero() {
        return idHero;
    }

    public void setIdHero(int idHero) {
        this.idHero = idHero;
    }

    public String getNamaHero() {
        return namaHero;
    }

    public void setNamaHero(String namaHero) {
        this.namaHero = namaHero;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}