package com.example.navigation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Signup extends AppCompatActivity {
    EditText etUser, etPwd, etRepwd;
    Button btnRegister, btnGoToLogin;
    DBHelper dbHelper;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        etUser = findViewById(R.id.editUser);
        etPwd = findViewById(R.id.editPass);
        etRepwd = findViewById(R.id.editRePass);
        btnRegister = findViewById(R.id.btnSignUp);
        dbHelper = new DBHelper(this);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user, pwd, rePwd;
                user = etUser.getText().toString();
                pwd = etPwd.getText().toString();
                rePwd = etRepwd.getText().toString();
                if (user.isEmpty() || pwd.isEmpty() || rePwd.isEmpty()) {
                    Toast.makeText(Signup.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                } else if (!pwd.equals(rePwd)) {
                    Toast.makeText(Signup.this, "Passwords do not match", Toast.LENGTH_SHORT).show();  // Validate password match
                } else {
                    Boolean checkUser = dbHelper.checkUsername(user);
                    if(!checkUser) {
                        Boolean insert = dbHelper.insertData(user, pwd);
                        if(insert) {
                            Toast.makeText(Signup.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), Login.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);
                            finish();
                        } else {
                            Toast.makeText(Signup.this, "Registration failed", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(Signup.this, "User already exists! Please sign in", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    // Define the onSignInClick method
    public void onSignInClick(View view) {
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }
}