package com.example.android.amas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.android.amas.R;

public class MainActivity extends AppCompatActivity {

    RadioGroup selectUser;
    Button buttonSubmit;
    TextView display;
    boolean HOD;
    boolean faculty;
    boolean student;
    //String selection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        selectUser = (RadioGroup)(findViewById(R.id.selectUser));
        buttonSubmit = (Button)(findViewById(R.id.buttonSubmit));
        display = (TextView)(findViewById(R.id.display));

        selectUser.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = (RadioButton)(findViewById(checkedId));
                switch (radioButton.getId())
                {
                    case R.id.HOD:
                        //selection = "HOD";
                        HOD = true;
                        buttonSubmit.setEnabled(true);
                        buttonSubmit.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                //display.setText(selection);
                                Intent i = new Intent(MainActivity.this, HODLoginActivity.class);
                                startActivity(i);
                                finish();
                            }
                        });
                        break;
                    case R.id.Faculty:
                        //selection = "Faculty";
                        faculty = true;
                        buttonSubmit.setEnabled(true);
                        buttonSubmit.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                //display.setText(selection);
                                Intent i = new Intent(MainActivity.this, StaffLoginActivity.class);
                                startActivity(i);
                                finish();
                            }
                        });
                        break;
                    case R.id.Student:
                        //selection = "Student";
                        student = true;
                        buttonSubmit.setEnabled(true);
                        buttonSubmit.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                //display.setText(selection);
                                Intent i = new Intent(MainActivity.this, StudentLoginActivity.class);
                                startActivity(i);
                                finish();
                            }
                        });
                        break;

                }
            }
        });

        /*buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //display.setText(selection);
                Intent i = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(i);
                finish();
            }
        });*/
    }
}