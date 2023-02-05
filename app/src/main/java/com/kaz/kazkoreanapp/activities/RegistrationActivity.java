package com.kaz.kazkoreanapp.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.kaz.kazkoreanapp.R;
import com.kaz.kazkoreanapp.adapter.LoginDatabaseAdapter;

public class RegistrationActivity extends Activity {
    EditText editTextUserName, editTextPassword, editTextConfirmPassword;
    Button btnCreateAccount;
    LoginDatabaseAdapter loginDataBaseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        loginDataBaseAdapter = new LoginDatabaseAdapter(this);
        loginDataBaseAdapter = loginDataBaseAdapter.open();

// Get Refferences of Views
        editTextUserName = (EditText) findViewById(R.id.editTextUserName);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        editTextConfirmPassword = (EditText) findViewById(R.id.editTextConfirmPassword);

        btnCreateAccount = (Button) findViewById(R.id.button_reg);
        btnCreateAccount.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
// TODO Auto-generated method stub

                String userName = editTextUserName.getText().toString();
                String password = editTextPassword.getText().toString();
                String confirmPassword = editTextConfirmPassword.getText().toString();

                if (userName.equals("") || password.equals("") || confirmPassword.equals("")) {
                    Toast.makeText(getApplicationContext(), "Field Empty", Toast.LENGTH_LONG).show();
                    return;
                }
                if (!password.equals(confirmPassword)) {
                    Toast.makeText(getApplicationContext(), "Password does not match", Toast.LENGTH_LONG).show();
                    return;
                } else {
                    loginDataBaseAdapter.insertEntry(userName, password);
                    Toast.makeText(getApplicationContext(), "Account Successfully Created ", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        loginDataBaseAdapter.close();
    }

    public void onClickLogin(View view) {
        Intent intent = new Intent(RegistrationActivity.this,WelcomeActivity.class);
        startActivity(intent);
    }


}
