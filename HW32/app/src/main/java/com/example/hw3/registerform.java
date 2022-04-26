package com.example.hw3;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class registerform extends AppCompatActivity {

    TextView username_text, password_text, retype_text, birthday_text, gender_text, hobbies_text;
    EditText username_edit, password_edit, retype_edit, birthday_edit;
    Button select_calendar, reset_btn, signup_btn;
    RadioButton radio_male, radio_femail, radiobutton;
    RadioGroup radioGroup;
    CheckBox checkBox1, checkBox2, checkBox3;

    DatePickerDialog datePickerDialog;
    private static final int REQUEST_CODE_EXAMPLE = 0x9345;
    public static Activity activity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registerform);
        activity=this;
        anhxa();
        setcalendar();
//        checkboxcheck();

        signup_action();

        reset();

    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQUEST_CODE_EXAMPLE) {

            if(resultCode == Activity.RESULT_OK) {
                final String result = data.getStringExtra(resultform.EXTRA_DATA);
                if(result == "finish")
                {
                    CloseApp();
                }
            } else {
                Toast.makeText(this, "FALSE", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public static void CloseApp(){
        activity.finish();
    }

    private void reset() {
        reset_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view == reset_btn)
                {
                    startActivity(new Intent(registerform.this, registerform.class));
                }
            }
        });
    }

    private void signup_action() {

        signup_btn.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                if(validate() && checkdatevalidate() && sex()){

                    final Intent getinfo = new Intent(registerform.this,resultform.class);
                    getinfo.putExtra("username", username_edit.getText().toString());
                    getinfo.putExtra("password", password_edit.getText().toString());
                    getinfo.putExtra("birthdate", birthday_edit.getText().toString());
                    getinfo.putExtra("sex", radiobutton.getText().toString());
                    if(checkBox1.isChecked())
                    {
                        getinfo.putExtra("hob1", checkBox1.getText().toString());
                    }
                    if(checkBox2.isChecked())
                    {
                        getinfo.putExtra("hob2", checkBox2.getText().toString());
                    }
                    if(checkBox3.isChecked())
                    {
                        getinfo.putExtra("hob3", checkBox3.getText().toString());
                    }
//                    getinfo.putExtra("hob", checkBox1.getText().toString() + "," + checkBox2.getText().toString() +"," + checkBox3.getText().toString());
                    startActivityForResult(getinfo, REQUEST_CODE_EXAMPLE);
                }
            }

            private boolean sex(){
                boolean temp = true;
                int selectedId = radioGroup.getCheckedRadioButtonId();
                radiobutton = findViewById(selectedId);

                if(radioGroup.getCheckedRadioButtonId() == -1)
                {
                    Toast.makeText(registerform.this, "PLEASE FILL YOUR SEX", Toast.LENGTH_SHORT).show();
                    temp = false;
                }
                return temp;
            }

            private boolean validate(){
                boolean temp = true;
                String username = username_edit.getText().toString();
                String password = password_edit.getText().toString();
                String retype = retype_edit.getText().toString();

                if(username.length() > 0 && password.length() > 0){
                    if(!retype.equals(password))
                    {
                        Toast.makeText(registerform.this, "RETYPE INCORRECT", Toast.LENGTH_SHORT).show();
                        temp = false;
                    }
                }

                return temp;
            }

            private boolean checkdatevalidate(){
                boolean temp = true;
                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                format.setLenient(false);

                String date = birthday_edit.getText().toString();
                try {
                    format.parse(date);
                }catch (ParseException e) {
                    String toasterror = "Date " + date + " is not valid according to " + format.toPattern() + " pattern. ";
                    Toast.makeText(registerform.this, toasterror , Toast.LENGTH_SHORT).show();
                    temp = false;
                }
                return temp;
            }

        });
    }


    private void setcalendar() {
        Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);

        select_calendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        registerform.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int day) {
                        month = month + 1;
                        String date = day + "/" + month + "/" + year;
                        birthday_edit.setText(date);
                    }
                }, year, month, day);
                datePickerDialog.show();
            }
        });

    }

    private void anhxa() {
        username_edit = findViewById(R.id.editTextTextPersonName);
        password_edit = findViewById(R.id.editTextTextPassword);
        retype_edit = findViewById(R.id.editTextTextPassword3);
        birthday_edit = findViewById(R.id.editTextTextPersonName2);

        username_text = findViewById(R.id.username);
        password_text = findViewById(R.id.password);
        retype_text = findViewById(R.id.retype);
        birthday_text = findViewById(R.id.birthdaytext);
        gender_text = findViewById(R.id.gender);
        hobbies_text = findViewById(R.id.hobbies);

        select_calendar = findViewById(R.id.selectbutton);
        reset_btn = findViewById(R.id.reset);
        signup_btn = findViewById(R.id.signup);

        radioGroup = findViewById(R.id.radioGroup);
        radio_male = findViewById(R.id.maleradio);
        radio_femail = findViewById(R.id.femaleradio);

        checkBox1 = findViewById(R.id.checkBox2);
        checkBox2 = findViewById(R.id.checkBox5);
        checkBox3 = findViewById(R.id.checkBox6);
    }
}