package com.example.arsara2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class Login extends AppCompatActivity {

    EditText editUsername, editPassword;
    Button btnLogin;
    DBHelper DB = new DBHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editUsername = findViewById(R.id.editUsername1);
        editPassword = findViewById(R.id.editPassword1);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = editUsername.getText().toString();
                String pass = editPassword.getText().toString();

                if(user.equals("")){
                    Toast.makeText(Login.this, "Email must be filled", Toast.LENGTH_SHORT).show();
                }
                else if(pass.equals("")){
                    Toast.makeText(Login.this, "Password must be filled", Toast.LENGTH_SHORT).show();
                }
                else{
                    Boolean checkUserPass = DB.checkUsernamePassword(user,pass);
                    if(checkUserPass==true){
                        Toast.makeText(Login.this, "Sign In Successful", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Login.this,StoryPage.class);
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(Login.this, "Username or password does not match", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}