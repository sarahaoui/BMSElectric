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

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    TextInputLayout email,password;
    Button login;
    String em,pass;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);


        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login);
        auth = FirebaseAuth.getInstance();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text_email = email.getEditText().getText().toString();
                String text_password = password.getEditText().getText().toString();
                if(TextUtils.isEmpty(text_email) || TextUtils.isEmpty(text_password)){
                    Toast.makeText(MainActivity.this, "Empty credentials", Toast.LENGTH_SHORT).show();
                }
                else if(text_password.length()<6){
                    Toast.makeText(MainActivity.this, "Password too short", Toast.LENGTH_SHORT).show();
                }
                else{
                    LoginUser(text_email,text_password);
                }
            }
        });
    }


    public void creatcompte(View view) {
        Intent intent= new Intent(this,Signup.class);
        startActivity(intent);
    }

    private void LoginUser(String email, String password) {
        // Checking if he entered the credentials
        if(TextUtils.isEmpty(email) || TextUtils.isEmpty(password)){
            Toast.makeText(MainActivity.this,"Please enter your credentials",Toast.LENGTH_SHORT).show();
            return;
        }
        // Logging the user in
        auth.signInWithEmailAndPassword(email, password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                Toast.makeText(MainActivity.this, "Logged in successfully", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void resetpassword(View view) {
        em=email.getEditText().getText().toString().trim();
        pass=password.getEditText().getText().toString().trim();
        if(em.isEmpty()){
            Toast.makeText(MainActivity.this,"Entre your @ email !!",Toast.LENGTH_SHORT).show();
            return;
        }
       /* FirebaseAuth auth= FirebaseAuth.getInstance();
        auth.sendPasswordResetEmail(em).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()){
                    Toast.makeText(Login.this,"Success",Toast.LENGTH_SHORT).show();

                }else
                    Toast.makeText(Login.this,"Failure:"+task.getException().getMessage(),Toast.LENGTH_SHORT).show();


            }
        });*/

    }
}
