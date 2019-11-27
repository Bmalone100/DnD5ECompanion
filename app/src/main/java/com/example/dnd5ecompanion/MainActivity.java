package com.example.dnd5ecompanion;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.IdpResponse;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.ActionCodeSettings;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Called when the user taps the Login button
     */
    public void goToLogin(View view) {
        Intent loginIntent = new Intent(this, LoginActivity.class);
        startActivity(loginIntent);
}
    /**
     * Called when the user taps the Help button
     */
    public void goToHelp(View view) {
        //Intent intent = new Intent(this, help.class);
        //startActivity(intent);
    }
    /**
     * Called when the user taps the New Character button
     */
    public void goToCharacterCreator(View view) {
        Intent characterIntent = new Intent(this, CharacterCreator.class);
        startActivity(characterIntent);
    }

    /**
     * Called when the user taps the Existing Character button
     */
    public void goToCharacter(View view) {
        //Intent intent = new Intent(this, FirebaseUIActivity.class);
        //startActivity(intent);
    }


}
