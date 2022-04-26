package com.example.custom_listview;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentRed extends Fragment implements FragmentCallBacks {

    MainActivity main;
    TextView txtRed, txtName, txtLop, txtDiem;
    Button btnRedClock;
    public static FragmentRed newInstance(String strArg1)
    {
        FragmentRed fragment = new FragmentRed();
        Bundle bundle = new Bundle();
        bundle.putString("arg1", strArg1);
        fragment.setArguments(bundle);
        return  fragment;

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (!(getActivity() instanceof MainCallbacks)){
            throw new IllegalStateException("Activity must Callbacks");

        }
        main = (MainActivity) getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        RelativeLayout view_layout_red = (RelativeLayout) inflater.inflate(R.layout.layout_red, null);
        txtRed = (TextView) view_layout_red.findViewById(R.id.idlop);
        txtName = (TextView) view_layout_red.findViewById(R.id.idname);
        txtLop = (TextView) view_layout_red.findViewById(R.id.idmssv);
        txtDiem = (TextView) view_layout_red.findViewById(R.id.iddiemtrungbinh);
        try {
            Bundle arguments = getArguments();
            txtRed.setText(arguments.getString("args1", ""));

        }catch (Exception e)
        {
            Log.e("RED BUNDLE ERROR-", "" + e.getMessage());
        }
        btnRedClock = (Button) view_layout_red.findViewById(R.id.btnfirst);
        btnRedClock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                main.onMsgFromFragToMain("DETAIL", strValue);

            }
        });
        return view_layout_red;
    }

    @Override
    public void onMsgFromMainToFragment(String strValue, String strName, String strMssv, String diemtrungbinh){
        txtRed.setText(strValue);
        txtName.setText("Họ tên: " + strName);
        txtLop.setText("Lớp: " + strMssv);
        txtDiem.setText("Điểm trung bình: " + diemtrungbinh);
    }
}
