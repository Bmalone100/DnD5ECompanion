package com.example.dnd5ecompanion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;
/**
 * Author Colm
 * This class rolls stats in multiple methods for use in stat assignment
 */
public class StatRollerStyleSelection5e extends AppCompatActivity {
    public static String EXTRA_MESSAGE = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stat_roller_style_selection5e);
    }

    int rollAmount = 6;
    int rolled = 0;
    int lowRoll = 0;
    int randomRoll = 0;

    public void extraRollChecked(View view)
    {
        boolean checked = ((CheckBox) view).isChecked();

        switch(view.getId()) //Reason for switch is too allow more checkboxes in future
        {
            case R.id.statSelect5EExtraRollCheck:
                if (checked)
                {
                    rollAmount = 7;
                }
                else rollAmount = 6;
                break;
        }
    }

    public void roll1d20(View view) {
        String message = "";
        for(int i =0; i < rollAmount; i++) {
            rolled = (int) ((20 * Math.random()) + 1);
            message += rolled + "  ";
            rolled = 0;
        }
        Intent intent = new Intent(this, AssignStats5E.class);
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    public void roll3d6(View view) {
        String message = "";
        for(int i =0; i < rollAmount; i++) {
            rolled = (int) ((6 * Math.random()) + 1);
            rolled += (int) ((6 * Math.random()) + 1);
            rolled += (int) ((6 * Math.random()) + 1);
            message += rolled + "  ";
            rolled = 0;
        }
        Intent intent = new Intent(this, AssignStats5E.class);
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    public void roll4d6(View view) {
        String message = "";
        for(int i =0; i < rollAmount; i++) {
            rolled = (int) ((6 * Math.random()) + 1);
            rolled += (int) ((6 * Math.random()) + 1);
            rolled += (int) ((6 * Math.random()) + 1);
            rolled += (int) ((6 * Math.random()) + 1);
            message += rolled + "  ";
            rolled = 0;
        }
        Intent intent = new Intent(this, AssignStats5E.class);
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    public void roll4d6Low(View view) {
        String message = "";
        for(int i =0; i < rollAmount; i++) {
            rolled = (int) ((6 * Math.random()) + 1);
            lowRoll = rolled;
            randomRoll = (int) ((6 * Math.random()) + 1);
            if (randomRoll<lowRoll)
            {
                lowRoll = randomRoll;
            }
            rolled += randomRoll;
            randomRoll = (int) ((6 * Math.random()) + 1);
            if (randomRoll<lowRoll)
            {
                lowRoll = randomRoll;
            }
            rolled += randomRoll;
            randomRoll = (int) ((6 * Math.random()) + 1);
            if (randomRoll<lowRoll)
            {
                lowRoll = randomRoll;
            }
            rolled += randomRoll;
            rolled = rolled - lowRoll;
            message += rolled + "  ";
            rolled = 0;
        }
        Intent intent = new Intent(this, AssignStats5E.class);
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);

    }

    public void statHelp(View view) {
            Snackbar.make(view, "This page lets you select what set of dice are rolled to give you your stat numbers. /n The checkbox lets you add a 7th spare dice roll to the normal 6.", Snackbar.LENGTH_INDEFINITE)
                    .setAction("Action", null).show();
        }

}

