package com.example.android.amas;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StudentLoginActivity extends AppCompatActivity {

    private RetrofitApiInterface RetrofitApiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_login);

        final EditText LoginID = (EditText)findViewById(R.id.etLoginID);
        final EditText Password = (EditText)findViewById(R.id.etPassword);
        final TextView Register = (TextView)findViewById(R.id.tvRegister);

        RetrofitApiInterface = RetrofitApiClient.getRetroApiClient().create(RetrofitApiInterface.class);

        Button bLogin = findViewById(R.id.bLogin);

        bLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(LoginID.getText().toString()) || TextUtils.isEmpty(Password.getText().toString()))
                {
                    Toast.makeText(StudentLoginActivity.this, "Enter Credentials", Toast.LENGTH_SHORT).show();
                }
                else if(Password.getText().length()<6){
                    Toast.makeText(StudentLoginActivity.this, "Password too small", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Call<List<RetrofitArrayData>> call = RetrofitApiInterface.StudentLogin(LoginID.getText().toString(),Password.getText().toString());
                    call.enqueue(new Callback<List<RetrofitArrayData>>() {
                        String loginid = LoginID.getText().toString();
                        @Override
                        public void onResponse(Call<List<RetrofitArrayData>> call, Response<List<RetrofitArrayData>> response) {
                            //Toast.makeText(getApplicationContext(),response.body().get(0).getCode(),Toast.LENGTH_LONG).show();
                            if (response.body().get(0).getStatus().equals("successful")) {
                                //String pass=response.body().get(0).getPassword();
                                String fname=response.body().get(0).getFname();
                                String lname=response.body().get(0).getLname();
                                final String name = fname + " " + lname;

                                /*Intent intent = new Intent(StudentLoginActivity.this , NavigationActivity.class);
                                startActivity(intent);
                                finish();*/

                                new android.support.v7.app.AlertDialog.Builder(StudentLoginActivity.this)
                                        .setTitle("Successful")
                                        .setMessage("Login successful")
                                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialogInterface, int i) {
                                                Intent intent = new Intent(getApplicationContext(), NavigationActivity.class);
                                                intent.putExtra("LoginID", loginid);
                                                intent.putExtra("UserName", name);
                                                intent.putExtra("Privilege", "Student");
                                                intent.putExtra("PrivilegeCode", "1");
                                                startActivity(intent);
                                                dialogInterface.dismiss();
                                                finish();
                                            }
                                        })
                                        .setCancelable(false)
                                        .show();

                                //Toast.makeText(getApplicationContext(),"Feedback submited Successfully !!!",Toast.LENGTH_LONG).show();
                            }
                            else {
                                new android.support.v7.app.AlertDialog.Builder(StudentLoginActivity.this)
                                        .setTitle("Login Failed")
                                        .setMessage("Invalid User ID or Password")
                                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialogInterface, int i) {
                                                LoginID.setText("");
                                                Password.setText("");
                                                dialogInterface.dismiss();
                                            }
                                        })
                                        .setCancelable(false)
                                        .show();
                            }

                        }

                        @Override
                        public void onFailure(Call<List<RetrofitArrayData>> call, Throwable t) {
                            Toast.makeText(getApplicationContext(),"Connection Failure \nCheck Internet Connection",Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });

        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StudentLoginActivity.this, ForgotPasswordActivity.class);
                startActivity(intent);
                //finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(StudentLoginActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
