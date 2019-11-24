package com.example.dnd5ecompanion;

public class characterSheet {
    private String name;
    private String race;
    characterSheet(String aName, String aRace) {
        aName = name;
        aRace = race;
    }

    public String getName(){
        return name;
    }
    public void setName(String aName){
        aName = name;
    }

    public String getRace(){
        return race;
    }

    public void setRace(String aRace){
        aRace = race;
    }
/*
    public String toString(){
        return this.name + " " + this.race + "";
    }*/
}
