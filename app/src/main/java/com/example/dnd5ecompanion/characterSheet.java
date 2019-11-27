package com.example.dnd5ecompanion;

public class characterSheet {
    private String id;
    private String name;
    private String race;
    characterSheet(String aId, String aName, String aRace) {
        this.id = aId;
        this.name = aName;
        this.race = aRace;
    }

    public String getId() { return id; }
    public void setId(String aId){aId = id;}

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
