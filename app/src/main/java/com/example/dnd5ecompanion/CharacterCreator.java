package com.example.dnd5ecompanion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class CharacterCreator extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_creator);
        Button publishButton = findViewById(R.id.button2);
       /* publishButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                publishToDatabase();
            }
        });*/
    }

    public void publishToDatabase(View view) {
        // Write Character to the database
        //Variables
        String name = "";
        String race = "";
        Map<String, characterSheet> characters = new HashMap<>();
        //Input retrieval
        EditText details = findViewById(R.id.editText);
        name = details.getText().toString();
        details = findViewById(R.id.editText2);
        race = details.getText().toString();
        //Database call
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference charactersRef = database.getReference("CharacterSheet/Characters");
        //Database write
        characters.put("1", new characterSheet(name,race));
        charactersRef.setValue(characters);
    }
}
