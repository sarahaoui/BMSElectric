package com.example.bmselectric;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;

public class Signup extends AppCompatActivity {
    FirebaseAuth auth;
    TextInputLayout firstname,lastname,email,password;
    Button signup,back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        firstname = (TextInputLayout) findViewById(R.id.firstName);
        lastname = (TextInputLayout) findViewById(R.id.lastname);
        email = (TextInputLayout) findViewById(R.id.email);
        password = (TextInputLayout) findViewById(R.id.password);
        signup = (Button)findViewById(R.id.signup);
        back = (Button) findViewById(R.id.back);
        auth = FirebaseAuth.getInstance();

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text_username = firstname.getEditText().getText().toString();
                String text_email = email.getEditText().getText().toString();
                String text_password = password.getEditText().getText().toString();
                if(TextUtils.isEmpty(text_email) || TextUtils.isEmpty(text_password) || TextUtils.isEmpty(text_username)){
                    Toast.makeText(Signup.this, "Empty credentials", Toast.LENGTH_SHORT).show();
                }
                else if(text_password.length()<6){
                    Toast.makeText(Signup.this, "Password too short", Toast.LENGTH_SHORT).show();
                }
                else{
                    RegisterUser(text_email,text_password);
                }
            }
        });
    }

    public void back(View view) {
        Intent intent= new Intent(this,Signup.class);
        startActivity(intent);
    }

    private void RegisterUser(String email, String password) {
        auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(Signup.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){

                            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

                            UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
                                    .setDisplayName(firstname.getEditText().getText().toString())
                                    .build();

                            Toast.makeText(Signup.this, "Registration successful", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Toast.makeText(Signup.this, "Registration failed", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}
