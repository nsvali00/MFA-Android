package com.example.mfa.mfa_android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText Email = (EditText)findViewById(R.id.email);
        final EditText Password = (EditText)findViewById(R.id.password);
        Button Login = (Button)findViewById(R.id.btnLogin);

        Login.setOnClickListener(new View.OnClickListener() {
            //@Override
            public void onClick(View view) {
                validate(Email.getText().toString(), Password.getText().toString());
            }
        });
    }

    private void validate(String userEmail, String userPassword) {
        if ((userEmail.contains("@")) && (userPassword.length() > 4)) {
            Intent intent = new Intent(MainActivity.this, HomeActivity.class);
            startActivity(intent);
        }
        else {
            if (!userEmail.contains("@")) {
                Toast.makeText(getApplicationContext(), "Invalid email address", Toast.LENGTH_SHORT).show();
            } else if (userPassword.length() <= 4) {
                Toast.makeText(getApplicationContext(), "Too short password", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
