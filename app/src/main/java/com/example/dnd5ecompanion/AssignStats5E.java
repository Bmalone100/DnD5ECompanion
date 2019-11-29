package com.example.dnd5ecompanion;

import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;
/**
 * Author Colm
 * This class allows user input of rolled stats.
 */
public class AssignStats5E extends AppCompatActivity {

    private static String EXTRA_MESSAGE = "aString";
    private static final String TAG = "AssStat";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assign_stats5_e);

        message();
    }

    private void showPopupMessage(String message) {
        Log.e(TAG, message);
        CoordinatorLayout coordinatorLayout = findViewById(R.id.coordinator_layout);
        Snackbar.make(coordinatorLayout, message,
                Snackbar.LENGTH_INDEFINITE)
                .show();
    }

    public void message(){
        Intent intent = getIntent();

        TextView text_Rolls = findViewById(R.id.text_Rolls);
        text_Rolls.setText(intent.getStringExtra(StatRollerStyleSelection5e.EXTRA_MESSAGE));
    }

    public void statProceed(View view){
        TextView text_input_str = findViewById(R.id.text_input_str);
        TextView text_input_dex = findViewById(R.id.text_input_dex);
        TextView text_input_con = findViewById(R.id.text_input_con);
        TextView text_input_int = findViewById(R.id.text_input_int);
        TextView text_input_wis = findViewById(R.id.text_input_wis);
        TextView text_input_cha = findViewById(R.id.text_input_cha);

        String temp = "";
        Bundle stats_bundle = new Bundle();

        temp = String.valueOf(text_input_str.getText());
        stats_bundle.putString("Strength", temp);

        temp = String.valueOf(text_input_dex.getText());
        stats_bundle.putString("Dexterity", temp);

        temp = String.valueOf(text_input_con.getText());
        stats_bundle.putString("Constitution", temp);

        temp = String.valueOf(text_input_int.getText());
        stats_bundle.putString("Intelligence", temp);

        temp = String.valueOf(text_input_wis.getText());
        stats_bundle.putString("Wisdom", temp);

        temp = String.valueOf(text_input_cha.getText());
        stats_bundle.putString("Charisma", temp);

        Intent intent = new Intent(this, CreateCharacter5eActivity.class);
        intent.putExtra("Stats Bundle", stats_bundle);
        startActivity(intent);
    }

    public void statHelp(View view) {
        Snackbar.make(view, "This page lets you assign your stats, the stats you rolled on the previous page are shown on the right.", Snackbar.LENGTH_INDEFINITE)
                .setAction("Action", null).show();
    }
}
