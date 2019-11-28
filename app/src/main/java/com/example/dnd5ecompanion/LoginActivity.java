package com.example.dnd5ecompanion;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.ErrorCodes;
import com.firebase.ui.auth.IdpResponse;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Arrays;
import java.util.List;

public class LoginActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private static final int RC_SIGN_IN = 123;
    private static final String TAG = "LoginActivity";
    FirebaseDatabase databaseCharacterSheets;
    DatabaseReference myRef;
    public static String id ="";

    /**
        Sets up the Firebase Authentication and the Action Listener to update UI as needed.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        FirebaseAuth.AuthStateListener mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                Log.e(TAG, "Authentication state changed.");
                FirebaseUser user = firebaseAuth.getCurrentUser();
                updateUI(user);
            }
        };
        mAuth.addAuthStateListener(mAuthListener);
    }

    /**
        This method takes a string and creates a snackbar pop up message.
     */
    private void showPopupMessage(String message) {
        Log.e(TAG, message);
        CoordinatorLayout coordinatorLayout = findViewById(R.id.coordinator_layout);
        Snackbar.make(coordinatorLayout, message,
                Snackbar.LENGTH_INDEFINITE)
                .show();
    }
    /**
        This method builds the sign in methods and sends the user to sign in.
     */
        public void onClickSignIn(View view) {
            List<AuthUI.IdpConfig> providers = Arrays.asList(
                    new AuthUI.IdpConfig.EmailBuilder().build(),
                    new AuthUI.IdpConfig.GoogleBuilder().build());
            startActivityForResult(
                    AuthUI.getInstance()
                            .createSignInIntentBuilder()
                            .setAvailableProviders(providers)
                            .build(),
                    RC_SIGN_IN);
        }

    /**
        This method catches the result of sign in.
     */
        @Override
        protected void onActivityResult(int requestCode, int resultCode, Intent data) {
            super.onActivityResult(requestCode, resultCode, data);
            if (requestCode == RC_SIGN_IN) {
                IdpResponse response = IdpResponse.fromResultIntent(data);
                if (resultCode == RESULT_OK) {
                    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                    assert user != null;
                    showPopupMessage("Sign in successful, " +
                            "displayName=" + user.getDisplayName() + ", " +
                            "email=" + user.getEmail() + ", " +
                            "uid=" + user.getUid());
                    //Write user to database
                    //Database write
                    databaseCharacterSheets = FirebaseDatabase.getInstance();
                    myRef = databaseCharacterSheets.getReference("Users");
                    id = myRef.push().getKey();
                    User aUser = new User(id,user.getEmail(), user.getDisplayName());
                    myRef.push().setValue(aUser);
                    // Read from the database
                    myRef.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            // This method is called once with the initial value and again
                            // whenever data at this location is updated.
                            String value = dataSnapshot.getValue(String.class);
                            Log.d(TAG, "Value is: " + value);
                        }

                        @Override
                        public void onCancelled(DatabaseError error) {
                            // Failed to read value
                            Log.w(TAG, "Failed to read value.", error.toException());
                        }
                    });
                } else {
                    if (response == null) {
                        showPopupMessage("Sign in cancelled!");
                        return;
                    }
                    if (response.getError().getErrorCode() == ErrorCodes.NO_NETWORK) {
                        showPopupMessage("No internet connection!");
                        return;
                    }
                    showPopupMessage("Sign-in error: " + response.getError());
                }
            }
        }
    /**
        This method checks for the status of the current user and updates UI.
     */
    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        updateUI(currentUser);
    }

    /**
        This method changes the displayed strings containing user details.
     */
    private void updateUI(FirebaseUser currentUser) {
        FirebaseUser user = mAuth.getCurrentUser();
        TextView tvDisplayName = findViewById(R.id.display_name);
        TextView tvEmail = findViewById(R.id.email);
        TextView tvUid = findViewById(R.id.uid);
        if(user != null) {
            tvDisplayName.setText(user.getDisplayName());
            tvEmail.setText(user.getEmail());
            tvUid.setText(user.getUid());
        } else {
            tvDisplayName.setText("Generic Name");
            tvEmail.setText("Johndoe@emaildomain.extension");
            tvUid.setText("0000");
        }
    }

    /**
        This method removes the current user account.
     */
    public void onClickDeleteAccount(View view) {
        AuthUI.getInstance()
                .delete(this)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    public void onComplete(@NonNull Task<Void> task) {
                        showPopupMessage("User account deleted.");
                    }
                });
    }

    /**
        This method signs out the current user and the strings will update back to default.
     */
    public void onClickSignOut(View view) {
            AuthUI.getInstance()
                    .signOut(this)
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        public void onComplete(@NonNull Task<Void> task) {
                            showPopupMessage("Sign-out completed.");
                        }
                    });
    }
}