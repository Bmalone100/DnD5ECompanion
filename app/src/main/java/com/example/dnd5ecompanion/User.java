package com.example.dnd5ecompanion;

public class User {
        private String name;
        private String email;
        private String id;
        User(String aName, String aEmail, String aId) {
            this.name = aName;
            this.email = aEmail;
            this.id = aId;
        }

        public String getName(){ return name; }
        public void setName(String aName){ aName = name; }

        public String getEmail(){return email;}
        public void setEmail(String aEmail){aEmail = email;}

        public String getId() { return id; }
        public void setId(String aId){aId = id;}

/*
    public String toString(){
        return this.name + " " + this.race + "";
    }*/

}
