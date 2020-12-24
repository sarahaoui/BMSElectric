package com.example.bmselectric;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {
    TextInputLayout email,password;
    String em,pass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }


    public void creatcompte(View view) {
        Intent intent= new Intent(this,Signup.class);
        startActivity(intent);
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
