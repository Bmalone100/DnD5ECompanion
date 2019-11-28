package com.example.dnd5ecompanion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CreateCharacter5eActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    public static String str;
    public static String dex;
    public static String con;
    public static String intel;
    public static String wis;
    public static String cha;

    public static String id ="";
    public static String name ="";
    public static String race = "";

    public static String theClass = "";
    FirebaseDatabase databaseCharacterSheets;
    DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_character_5e);

        EditText details = findViewById(R.id.text_enterText);
        name = details.getText().toString();

        Bundle stats = getIntent().getBundleExtra("Stats Bundle");
        String temp = "";

        temp = stats.getString("Strength");
        TextView stat_show_str = findViewById(R.id.stat_show_str);
        stat_show_str.setText(temp);
        str = temp;

        temp = stats.getString("Dexterity");
        TextView stat_show_dex = findViewById(R.id.stat_show_dex);
        stat_show_dex.setText(temp);
        dex = temp;

        temp = stats.getString("Constitution");
        TextView stat_show_con = findViewById(R.id.stat_show_con);
        stat_show_con.setText(temp);
        con = temp;

        temp = stats.getString("Intelligence");
        TextView stat_show_int = findViewById(R.id.stat_show_int);
        stat_show_int.setText(temp);
        intel = temp;

        temp = stats.getString("Wisdom");
        TextView stat_show_wis = findViewById(R.id.stat_show_wis);
        stat_show_wis.setText(temp);
        wis = temp;

        temp = stats.getString("Charisma");
        TextView stat_show_cha = findViewById(R.id.stat_show_cha);
        stat_show_cha.setText(temp);
        cha = temp;

        Spinner spinnerRace = (Spinner) findViewById(R.id.spinner_race);
        spinnerRace.setOnItemSelectedListener(this);
        ArrayAdapter<CharSequence> adapterRace = ArrayAdapter.createFromResource(this, R.array.races_array, android.R.layout.simple_spinner_item);
        adapterRace.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerRace.setAdapter(adapterRace);

        Spinner spinnerClass = (Spinner) findViewById(R.id.spinner_class);
        spinnerClass.setOnItemSelectedListener(this);
        ArrayAdapter<CharSequence> adapterClass = ArrayAdapter.createFromResource(this, R.array.classes_array, android.R.layout.simple_spinner_item);
        adapterClass.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerClass.setAdapter(adapterClass);

        race = spinnerRace.getOnItemSelectedListener().toString();
        theClass = spinnerClass.getOnItemSelectedListener().toString();

        //Database write
        databaseCharacterSheets = FirebaseDatabase.getInstance();
        DatabaseReference myRef = databaseCharacterSheets.getReference("Users/CharacterSheets");
        id = myRef.push().getKey();
        characterSheet aCharacter = new characterSheet(id,name,race,theClass,str,dex,con,intel,wis,cha);
        myRef.push().setValue(aCharacter);
    }

    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {
    }
    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }

    public void statHelp(View view) {
        Snackbar.make(view, "This page lets you enter a name for your character and use drop downs to choose a class and race.", Snackbar.LENGTH_INDEFINITE)
                .setAction("Action", null).show();
    }

    public void publishToDatabase(View view) {
        //Database write
        databaseCharacterSheets = FirebaseDatabase.getInstance();
        myRef = databaseCharacterSheets.getReference("Users/CharacterSheets");
        id = myRef.push().getKey();
        characterSheet aCharacter = new characterSheet(id,name,race,theClass,str,dex,con,intel,wis,cha);
        myRef.push().setValue(aCharacter);
    }
}