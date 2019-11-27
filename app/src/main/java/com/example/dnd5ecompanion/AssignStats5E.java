package com.example.dnd5ecompanion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

public class AssignStats5E extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assign_stats5_e);
        Intent intent = getIntent();
        String message = intent.getStringExtra(StatRollerStyleSelection5e.EXTRA_MESSAGE);

        Bundle stats = new Bundle();

        TextView StatAssignStatList = findViewById(R.id.StatAssignStatList);
        StatAssignStatList.setText(message);
    }
    public void statHelp(View view) {
        Snackbar.make(view, "This page lets you assign your stats, the stats you rolled on the previous page are shown on the right. /nThe racial bonuses are also displayed between the two.", Snackbar.LENGTH_INDEFINITE)
                .setAction("Action", null).show();
    }
}
