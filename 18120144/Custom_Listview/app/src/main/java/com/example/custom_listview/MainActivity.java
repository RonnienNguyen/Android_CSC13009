package com.example.custom_listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;


import com.example.custom_listview.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TextView txtanu;
    ActivityMainBinding binding;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        anhxa();
        int[] imageId = {R.drawable.phuc,R.drawable.huy,R.drawable.toan,R.drawable.hung,R.drawable.tinh,
                R.drawable.minh,R.drawable.vinh,R.drawable.tamtam,R.drawable.vcd};
        String[] name = {"Nguyễn Đình Thiên Phúc","Nguyễn Thanh Tâm","Trần Ngọc Minh","Trần Nguyễn Thanh Phương","Trần Hoàng Minh Tâm","Nguyễn Thanh Tùng","Nguyễn Thông Thành Thái","Nguyễn Thái Đăng Tâm","Nguyễn Lương Duy Bằng"};
        String[] lastMessage = {"0347566738","0365478526","0356987523","0356987526","0365984122",
                "0369854122","0348965789","0369854126","0369854126"};

        ArrayList<User> userArrayList = new ArrayList<>();

        for(int i = 0;i< imageId.length;i++){
            User user = new User(name[i],lastMessage[i],imageId[i]);
            userArrayList.add(user);
        }


        ListAdapter listAdapter = new ListAdapter(MainActivity.this,userArrayList);

        binding.listview.setAdapter(listAdapter);
        binding.listview.setClickable(true);
        binding.listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    txtanu.setText("You choose: " + name[position]);
            }
        });

    }
    private void anhxa() {
        txtanu = findViewById(R.id.txtannounce);
    }
}