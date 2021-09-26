package com.company;

import java.util.Arrays;

public class Pet {
    private String name;
    private String species;
    private String[] favFoods;
    private int birthYear;
    private String photo;

    //ctor
    public Pet(String name, String species, String[] favFoods, int birthYear, String photo) {
        this.name = name;
        this.species = species;
        this.favFoods = favFoods;
        this.birthYear = birthYear;
        this.photo = photo;
    }

//    public static Pet fromJson(String json){
//
//    }

    //getters and setters:
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSpecies() {
        return species;
    }
    public void setSpecies(String species) {
        this.species = species;
    }
    public String[] getFavFoods() {
        return favFoods;
    }
    public void setFavFoods(String[] favFoods) {
        this.favFoods = favFoods;
    }
    public int getBirthYear() {
        return birthYear;
    }
    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }
    public String getPhoto() {
        return photo;
    }
    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "name='" + name + '\'' +
                ", species='" + species + '\'' +
                ", favFoods=" + Arrays.toString(favFoods) +
                ", birthYear=" + birthYear +
                ", photo='" + photo + '\'' +
                '}';
    }
}
