package com.example.dnd5ecompanion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import static com.example.dnd5ecompanion.CreateCharacter5eActivity.cha;
import static com.example.dnd5ecompanion.CreateCharacter5eActivity.con;
import static com.example.dnd5ecompanion.CreateCharacter5eActivity.dex;
import static com.example.dnd5ecompanion.CreateCharacter5eActivity.intel;
import static com.example.dnd5ecompanion.CreateCharacter5eActivity.name;
import static com.example.dnd5ecompanion.CreateCharacter5eActivity.str;
import static com.example.dnd5ecompanion.CreateCharacter5eActivity.wis;
import static com.example.dnd5ecompanion.StatRollerStyleSelection5e.EXTRA_MESSAGE;
/**
 * Author Frank
 * This class takes the inputs and displays them.
 */
public class Main_Character_Sheet extends AppCompatActivity {
    String message = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main__character__sheet);
        TextView details = findViewById(R.id.Name_view);
        details.setText(name);

        details = findViewById(R.id.STR_mod_view);
        details.setText(str);

        details = findViewById(R.id.DEX_mod_view);
        details.setText(dex);

        details = findViewById(R.id.CON_mod_view);
        details.setText(con);

        details = findViewById(R.id.INT_mod_view);
        details.setText(intel);

        details = findViewById(R.id.WIS_mod_view);
        details.setText(wis);

        details = findViewById(R.id.CHA_mod_view);
        details.setText(cha);

    }

}
