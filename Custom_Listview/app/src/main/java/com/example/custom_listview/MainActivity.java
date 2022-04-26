package com.example.custom_listview;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends FragmentActivity implements MainCallbacks {
    FragmentTransaction ft;
    FragmentRed redFragment; FragmentBlue blueFragment ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //BLUE
        ft = getSupportFragmentManager().beginTransaction();
        blueFragment = FragmentBlue.newInstance("first-blue");
        ft.replace(R.id.main_holder_blue, blueFragment);
        ft.commit();


        //RED
        ft = getSupportFragmentManager().beginTransaction();
        redFragment = FragmentRed.newInstance("first-red");
        ft.replace(R.id.main_holder_red, redFragment);
        ft.commit();



    }

    @Override
    public void onMsgFromFragToMain(String sender, int id, String strValue, String strName, String strMssv, String diemtrungbinh) {

        if(sender.equals("BLUE-FRAG1")){
            try{
                redFragment.onMsgFromMainToFragment(strValue, strName, strMssv, diemtrungbinh);
            }catch (Exception e){
                Log.e("ERROR", "onStrFromFragToMain" + e.getMessage());
            }
        }
        if(sender.equals("BLUE-FRAG")){
            try{
                redFragment.onMsgFromMainToFragment(strValue, strName, strMssv, diemtrungbinh);
            }catch (Exception e){
                Log.e("ERROR", "onStrFromFragToMain" + e.getMessage());
            }
        }
    }

    @Override
    public void onMsgFromFragToMainBtn(String sender, int id, String strValue, String strName, String strMssv, String diemtrungbinh) {

    }
}