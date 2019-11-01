package com.example.dnd5ecompanion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class AssignStats5E extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assign_stats5e);

        Intent intent = getIntent();
        String message = intent.getStringExtra(StatRollerStyleSelection5e.EXTRA_MESSAGE);

        Bundle stats = new Bundle();

        TextView StatAssignStatList = findViewById(R.id.StatAssignStatList);
        StatAssignStatList.setText(message);
    }
}
