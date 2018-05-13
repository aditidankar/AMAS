package com.example.android.amas;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistrationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        final EditText FirstName = (EditText) (findViewById(R.id.etFirstName));
        final EditText LastName = (EditText) (findViewById(R.id.etLastName));
        final EditText PhoneNumber = (EditText) (findViewById(R.id.etPhoneNumber));
        final EditText Email = (EditText) (findViewById(R.id.etEmail));

        final EditText LoginID = (EditText) (findViewById(R.id.etLoginID));
        final EditText Password = (EditText) (findViewById(R.id.etPassword));
        final EditText ConfirmPassword = (EditText) (findViewById(R.id.etConfirmPassword));

        final Button bLogin = (Button) (findViewById(R.id.bLogin));

        bLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(FirstName.getText().toString()) || TextUtils.isEmpty(LastName.getText().toString())) {
                    Toast.makeText(RegistrationActivity.this, "Enter Name", Toast.LENGTH_SHORT).show();
                }
                else if (TextUtils.isEmpty(PhoneNumber.getText().toString())) {
                    Toast.makeText(RegistrationActivity.this, "Enter Phone Number", Toast.LENGTH_SHORT).show();
                }
                else if (PhoneNumber.getText().length() != 10) {
                    Toast.makeText(RegistrationActivity.this, "Incorrect Phone Number", Toast.LENGTH_SHORT).show();
                }
                else if (TextUtils.isEmpty(Email.getText().toString())) {
                    Toast.makeText(RegistrationActivity.this, "Enter Email", Toast.LENGTH_SHORT).show();
                }
                else if (!Patterns.EMAIL_ADDRESS.matcher(Email.getText().toString()).matches()) {
                    Toast.makeText(RegistrationActivity.this, "Incorrect Email", Toast.LENGTH_SHORT).show();
                }
                else if (TextUtils.isEmpty(LoginID.getText().toString())) {
                    Toast.makeText(RegistrationActivity.this, "Enter LoginID", Toast.LENGTH_SHORT).show();
                }
                else if (TextUtils.isEmpty(Password.getText().toString())) {
                    Toast.makeText(RegistrationActivity.this, "Enter Password", Toast.LENGTH_SHORT).show();
                }
                else if(Password.getText().length()<6){
                    Toast.makeText(RegistrationActivity.this, "Password too small", Toast.LENGTH_SHORT).show();
                }
                else if (TextUtils.isEmpty(ConfirmPassword.getText().toString())) {
                    Toast.makeText(RegistrationActivity.this, "Confirm Password", Toast.LENGTH_SHORT).show();
                }
                else if (Password.getText().toString().equals(ConfirmPassword.getText().toString()) == false){
                    Toast.makeText(RegistrationActivity.this, "Passwords don't match", Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent intent = new Intent(RegistrationActivity.this, NavigationActivity.class);
                    startActivity(intent);
                    finish();
                }

            }

        });
    }
}
