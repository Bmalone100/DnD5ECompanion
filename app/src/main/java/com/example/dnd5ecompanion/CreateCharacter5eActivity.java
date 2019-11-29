package com.example.dnd5ecompanion;

import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CreateCharacter5eActivity extends AppCompatActivity {
    public static String str;
    public static String dex;
    public static String con;
    public static String intel;
    public static String wis;
    public static String cha;

    public static String id ="";
    public static String name ="";
    public static String race = "";

    private static final String TAG = "CrCh5eActivity";

    public static String theClass = "";
    FirebaseDatabase databaseCharacterSheets;
    DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_character_5e);

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

        obtainName();
        obtainRace();
        obtainClass();
    }

    public void obtainRace(){
        //Input retrieval
        Spinner spinnerRace = (Spinner) findViewById(R.id.spinner_race);
        ArrayAdapter<CharSequence> adapterRace = ArrayAdapter.createFromResource(this, R.array.races_array, android.R.layout.simple_spinner_item);
        adapterRace.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerRace.setAdapter(adapterRace);

        spinnerRace.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                race = ((Spinner)findViewById(R.id.spinner_race)).getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                showPopupMessage("Race: " + race + " Class: " + theClass);
            }

        });
    }
    public void obtainClass(){
        //Input retrieval
        Spinner spinnerClass = (Spinner) findViewById(R.id.spinner_class);
        ArrayAdapter<CharSequence> adapterClass = ArrayAdapter.createFromResource(this, R.array.classes_array, android.R.layout.simple_spinner_item);
        adapterClass.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerClass.setAdapter(adapterClass);

        spinnerClass.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                theClass = ((Spinner)findViewById(R.id.spinner_class)).getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                showPopupMessage("Race: " + race + " Class: " + theClass);
            }

        });

    }

    public void obtainName(){
        //Input retrieval
        EditText details = findViewById(R.id.text_enterText);
        name = details.getText().toString();
    }

    private void showPopupMessage(String message) {
        Log.e(TAG, message);
        CoordinatorLayout coordinatorLayout = findViewById(R.id.coordinator_layout);
        Snackbar.make(coordinatorLayout, message,
                Snackbar.LENGTH_INDEFINITE)
                .show();
    }

    public void statHelp(View view) {
        Snackbar.make(view, " Race: " + race + " Class: " + theClass, Snackbar.LENGTH_INDEFINITE)
                .setAction("Action", null).show();
    }

    public void publishToDatabase(View view) {
        //Database write
        obtainName();
        obtainRace();
        obtainClass();
        databaseCharacterSheets = FirebaseDatabase.getInstance();
        myRef = databaseCharacterSheets.getReference("Users/CharacterSheets");
        id = myRef.push().getKey();
        characterSheet aCharacter = new characterSheet(id,name,race,theClass,str,dex,con,intel,wis,cha);
        myRef.push().setValue(aCharacter);
    }
}