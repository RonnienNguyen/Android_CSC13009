package com.example.hw3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class resultform extends AppCompatActivity {

    TextView res_username, res_password, res_gender, res_birthday, res_hobbies, res_info;
    Button exit;
    LinearLayout resultform;
    TextView txtpass;
    public static final String EXTRA_DATA = "EXTRA_DATA";
    @Override
    public void onCreate(Bundle saveInstanceStates) {
        getWindow().requestFeature(12);
        super.onCreate(saveInstanceStates);

        setContentView(R.layout.resultform);
        anhxa();
        actionbtn();

        Bundle extras = this.getIntent().getExtras();
        String username = extras.getString("username");
        String password = extras.getString("password");
        String birthdate = extras.getString("birthdate");
        String sex = extras.getString("sex");
        String hob1 = extras.getString("hob1");
        String hob2 = extras.getString("hob2");
        String hob3 = extras.getString("hob3");
        String abc = "";
        res_username.setText("Username: " + username);
        res_password.setText("Password: " + password);
        res_birthday.setText("Birthday: " + birthdate);
        res_gender.setText("Gender: " + sex);

        if(hob1 == null)
        {
            hob1 = abc;
        }
        if(hob2 == null)
        {
            hob2 = abc;
        }
        if(hob3 == null)
        {
            hob3 = abc;
        }
        res_hobbies.setText("Hobbies: " + hob1 + " " + hob2 + " " + hob3);
    }

    private void actionbtn() {
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Intent data = new Intent();
                data.putExtra(EXTRA_DATA, "finish");
                setResult(Activity.RESULT_OK, data);
                finish();
            }
        });
    }

    private void anhxa() {
        res_username = findViewById(R.id.rs_username);
        res_birthday = findViewById(R.id.rs_birthday);
        res_gender = findViewById(R.id.rs_gender);
        res_password = findViewById(R.id.rs_password);
        res_hobbies = findViewById(R.id.rs_hobbies);
        res_info = findViewById(R.id.rs_info);

        exit = findViewById(R.id.button_exit);
        txtpass = findViewById(R.id.textpass);
        resultform = findViewById(R.id.resultform_linear);
    }
    @Override
    public void onBackPressed() {
        setResult(Activity.RESULT_CANCELED);
        super.onBackPressed();
    }
}
