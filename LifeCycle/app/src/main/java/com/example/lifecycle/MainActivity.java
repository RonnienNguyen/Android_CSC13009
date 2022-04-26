package com.example.lifecycle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    Button btn1;
    private ConstraintLayout myScreen;
    EditText txtColor;
    TextView txtview;
    private String PREFNAME = "myPrefFile1";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(this, "onCreate", Toast.LENGTH_SHORT).show();
        anhxa();
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        txtColor.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {  }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
            @Override
            public void afterTextChanged(Editable s) {

                String chosenColor = s.toString().toLowerCase(Locale.US);
                txtview.setText(chosenColor);
                setBackgroundColor(chosenColor, myScreen);
            }
        });

        Toast.makeText(getApplicationContext(), "onCreate", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStart()
    {
        super.onStart();
        updateMeUsingSavedStateData();
        Toast.makeText(getApplicationContext(),"onStart", Toast.LENGTH_SHORT).show(); //onStart Called
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        Toast.makeText(getApplicationContext(),"onResume", Toast.LENGTH_SHORT).show(); //onStart Called
    }

    @Override
    protected void onPause()
    {
        super.onPause();
        Toast.makeText(getApplicationContext(),"onPause", Toast.LENGTH_SHORT).show();
        String chosenColor = txtview.getText().toString();//onStart Called
        saveStateData(chosenColor);
    }

    @Override
    protected void onStop()
    {
        super.onStop();
        Toast.makeText(getApplicationContext(),"onStop", Toast.LENGTH_SHORT).show(); //onStart Called
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        Toast.makeText(getApplicationContext(),"onDestroy", Toast.LENGTH_SHORT).show(); //onStart Called
    }

    private void setBackgroundColor(String chosenColor, ConstraintLayout myScreen) {
        if (chosenColor.contains("thinh")) myScreen.setBackgroundColor(0xff712793);
        if (chosenColor.contains("phuc")) myScreen.setBackgroundColor(0xff120144);
        if (chosenColor.contains("tung")) myScreen.setBackgroundColor(0xff120641);
    }
    private void saveStateData(String chosenColor) {
        SharedPreferences myPrefContainer = getSharedPreferences(PREFNAME, Activity.MODE_PRIVATE);
        SharedPreferences.Editor myPrefEditor = myPrefContainer.edit();
        String key = "chosenBackgroundColor", value = txtview.getText().toString();
        myPrefEditor.putString(key, value);
        myPrefEditor.commit();
    }

    private void updateMeUsingSavedStateData() {
        SharedPreferences myPrefContainer = getSharedPreferences(PREFNAME, Activity.MODE_PRIVATE);
        String key = "chosenBackgroundColor";
        String defaultValue = "white";
        if (( myPrefContainer != null ) && myPrefContainer.contains(key)){
            String color = myPrefContainer.getString(key, defaultValue);
            setBackgroundColor(color, myScreen);
        }
    }
    private void anhxa() {
        btn1 = findViewById(R.id.btn_id);
        txtColor = (EditText)findViewById(R.id.edit_text);
        txtview = (TextView) findViewById(R.id.textView);
        myScreen = (ConstraintLayout) findViewById(R.id.myscreen);

    }

}