package com.example.dnd5ecompanion;

import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class CharacterCreator extends AppCompatActivity {
    //Variables Needed for class methods
    public static String id ="";
    public static String name ="";
    public static String race = "";
    private static final String TAG = "CharacterCreator";

    FirebaseDatabase databaseCharacterSheets;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_creator);
        }

    private void showPopupMessage(String message) {
        Log.e(TAG, message);
        CoordinatorLayout coordinatorLayout = findViewById(R.id.coordinator_layout);
        Snackbar.make(coordinatorLayout, message,
                Snackbar.LENGTH_INDEFINITE)
                .show();
    }

    public void obtainName(){
        //Input retrieval
        EditText details = findViewById(R.id.editText);
        name = details.getText().toString();
    }

    public void obtainRace(){
        //Input retrieval
        EditText details = findViewById(R.id.editText2);
        race = details.getText().toString();
    }

    public void publishToDatabase(View view) {
        // Write Character to the database
        //Database call
        obtainName();
        obtainRace();
        if(name!=null && race!= null)
            showPopupMessage("Name: " + name + ", " + "Race: " + race);

        //Database write
        databaseCharacterSheets = FirebaseDatabase.getInstance();
        DatabaseReference myRef = databaseCharacterSheets.getReference("dnd5ecompanion/CharacterSheets");
        id = myRef.push().getKey();
        characterSheet aCharacter = new characterSheet(id,name,race);
        myRef.push().setValue(aCharacter);
        //showPopupMessage(name + "Added");
        //Return to main
        Intent mainIntent = new Intent(this, MainActivity.class);
        startActivity(mainIntent);
    }
}
