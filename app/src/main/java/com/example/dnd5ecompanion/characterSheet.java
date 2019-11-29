package com.example.dnd5ecompanion;
/**
 * Author Frank
 * This class contains the object that is written to the database.
 */
public class characterSheet {
    private String id;
    private String name;
    private String race;
    //Added 28-11-19
    private static String str;
    private static String dex;
    private static String con;
    private static String intel;
    private static String wis;
    private static String cha;
    private static String theClass;

    characterSheet(String aId, String aName, String aRace, String aClass, String aStr, String aDex, String aCon, String aIntel, String aWis, String aCha ) {
        this.id = aId;
        this.name = aName;
        this.race = aRace;
        this.theClass = aClass;
        this.str = aStr;
        this.dex = aDex;
        this.con = aCon;
        this.intel = aIntel;
        this.wis = aWis;
        this.cha = aCha;
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

    public String getStr(){return  str;}

    public String getDex(){return dex;}

    public String getCon(){return con;}

    public String getIntel(){return intel;}

    public String getWis(){return wis;}

    public String getCha(){return cha;}

    /*
    public String toString(){
        return this.name + " " + this.race + "";
    }*/
}
