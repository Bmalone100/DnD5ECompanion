/*package com.example.dnd5ecompanion;

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
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

import static com.example.dnd5ecompanion.CharacterViewerAdapter.listOfCharacters;
import static com.example.dnd5ecompanion.CreateCharacter5eActivity.cha;
import static com.example.dnd5ecompanion.CreateCharacter5eActivity.con;
import static com.example.dnd5ecompanion.CreateCharacter5eActivity.dex;
import static com.example.dnd5ecompanion.CreateCharacter5eActivity.intel;
import static com.example.dnd5ecompanion.CreateCharacter5eActivity.str;
import static com.example.dnd5ecompanion.CreateCharacter5eActivity.theClass;
import static com.example.dnd5ecompanion.CreateCharacter5eActivity.wis;

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
        DatabaseReference myRef = databaseCharacterSheets.getReference("Users/CharacterSheets");
        id = myRef.push().getKey();
        characterSheet aCharacter = new characterSheet(id,name,race,theClass,str,dex,con,intel,wis,cha);
        myRef.push().setValue(aCharacter);
        //showPopupMessage(name + "Added");
        // Read from the database
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                characterSheet value = dataSnapshot.getValue(characterSheet.class);
                System.out.println(value);
                listOfCharacters.add(value);
                Log.d(TAG, "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
        //Return to main
        //Intent mainIntent = new Intent(this, MainActivity.class);
        //startActivity(mainIntent);
    }
}*/
