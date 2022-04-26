package com.example.custom_listview;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class FragmentBlue<on> extends Fragment {


    MainActivity main;
    Context context = null;


    int[] imageId = {R.drawable.phuc,R.drawable.huy,R.drawable.toan,R.drawable.hung,R.drawable.tinh,
            R.drawable.minh,R.drawable.vinh,R.drawable.tamtam,R.drawable.vcd,R.drawable.toan,R.drawable.tinh,R.drawable.toan,R.drawable.vcd,R.drawable.minh,R.drawable.phuc,R.drawable.vcd,R.drawable.vcd,R.drawable.vcd};
    String[] name = {"Nguyễn Đình Thiên Phúc","Nguyễn Thanh Tâm","Trần Ngọc Minh","Trần Nguyễn Thanh Phương","Trần Hoàng Minh Tâm","Nguyễn Thanh Tùng","Nguyễn Thông Thành Thái","Nguyễn Thái Đăng Tâm","Nguyễn Lương Duy Bằng", "Hoang Quoc Thinh", "Hoang Nhan Tan", "Dang Thanh Tam", "Nguyen Chi Cuong", "Robert James", "Tony Stark", "Chris Evan", "John Cena", "Undertaker"};

    String [] mssv = {"A1", "A2", "A3", "A4", "A5", "A6", "A7", "A8", "A9", "A10", "A11", "A12", "A13", "A14", "A15", "A16", "A17", "A18"};

    String[] diemtrungbinh = {"10", "8", "9", "7", "7", "8", "8", "9", "10", "8", "9", "7", "9", "8", "9", "6", "9", "8"};

    String[] lop = {"A1_2340", "A2_2345", "A3_2143", "A4_3493", "A5_1234", "A6_1243", "A7_2432", "A8_1242", "A9_2439", "A10_324", "A11_234", "A12_538", "A13_299", "A14_211", "A15_999", "A16_124", "A17_121", "A18_124"};


    public static FragmentBlue newInstance(String strArg) {
        FragmentBlue fragment = new FragmentBlue();
        Bundle args = new Bundle();
        args.putString("strArg1", strArg);
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        try {
            context = getActivity();
            main = (MainActivity) getActivity();
        }catch (IllegalStateException e){
            throw new IllegalStateException("Main Activity must implement CallBacks");
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        LinearLayout layout_blue = (LinearLayout) inflater.inflate(R.layout.layout_blue, null);
        final TextView txtBlue = (TextView) layout_blue.findViewById(R.id.textView1Blue);
        ListView listView = (ListView) layout_blue.findViewById(R.id.listView1Blue);
        listView.setBackgroundColor(Color.parseColor("#ffccddff"));

        ArrayList<User> userArrayList = new ArrayList<>();

        for(int i = 0;i< name.length;i++){
            User user = new User(mssv[i],imageId[i], lop[i], diemtrungbinh[i],name[i]);
            userArrayList.add(user);
        }

        ListAdapter listAdapter = new ListAdapter(getContext(), userArrayList);

        listView.setAdapter(listAdapter);


        listView.setSelection(0);

        listView.smoothScrollToPosition(0);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                main.onMsgFromFragToMain("BLUE-FRAG", position, lop[position], name[position], mssv[position], diemtrungbinh[position]);
                txtBlue.setText(" Mã Số " + lop[position]);
            }});

        main.onMsgFromFragToMain("BLUE-FRAG1", 1, lop[1], name[1], mssv[1], diemtrungbinh[1]);
        return layout_blue;


    }
}
