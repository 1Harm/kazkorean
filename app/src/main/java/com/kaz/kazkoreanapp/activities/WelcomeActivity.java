package com.kaz.kazkoreanapp.activities;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.kaz.kazkoreanapp.MainActivity;
import com.kaz.kazkoreanapp.R;
import com.kaz.kazkoreanapp.adapter.LoginDatabaseAdapter;

public class WelcomeActivity extends Activity {
    Button btnSignUp;
    TextView btnSignIn;
    LoginDatabaseAdapter loginDataBaseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        loginDataBaseAdapter=new LoginDatabaseAdapter(this);
        loginDataBaseAdapter=loginDataBaseAdapter.open();
        btnSignIn =(TextView)findViewById(R.id.buttonSignIN);
        btnSignUp=(Button)findViewById(R.id.buttonSignUP);

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intentSignUP=new Intent(getApplicationContext(),RegistrationActivity.class);
                startActivity(intentSignUP);
            }
        });
    }
    public void signIn(View V)
    {
        final Dialog dialog = new Dialog(WelcomeActivity.this);
        dialog.setContentView(R.layout.activity_login);
        dialog.setTitle("Login");

        final EditText editTextUserName=(EditText)dialog.findViewById(R.id.editTextUserNameToLogin);
        final EditText editTextPassword=(EditText)dialog.findViewById(R.id.editTextPasswordToLogin);

        Button btnSignIn=(Button)dialog.findViewById(R.id.buttonSignIn);

        btnSignIn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                String userName=editTextUserName.getText().toString();
                String password=editTextPassword.getText().toString();

                String storedPassword=loginDataBaseAdapter.getSinlgeEntry(userName);

                if(password.equals(storedPassword))
                {
                    Toast.makeText(WelcomeActivity.this, "Congrats: Login Successfull", Toast.LENGTH_LONG).show();
                    dialog.dismiss();
                    Intent intent = new Intent(WelcomeActivity.this, MainActivity.class);
                    startActivity(intent);


                }
                else
                {
                    Toast.makeText(WelcomeActivity.this, "User Name or Password does not match", Toast.LENGTH_LONG).show();
                }
            }
        });

        dialog.show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        loginDataBaseAdapter.close();
    }
}