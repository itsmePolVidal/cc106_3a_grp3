package com.example.navigation;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Toast;

import com.example.navigation.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String[] UBMap = {"BLDG A", "BLDG B", "BLDG C", "Canteen", "Gym", "Bookstore","Study Area" };
        int[] image = {R.drawable.a,R.drawable.b, R.drawable.c, R.drawable.d, R.drawable.e, R.drawable.f, R.drawable.g};

        GridAdapter gridAdapter = new GridAdapter(MainActivity.this, UBMap, image);
        binding.gridView.setAdapter(gridAdapter);

        binding.gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                Toast.makeText(MainActivity.this, "You clicked on " + UBMap[position], Toast.LENGTH_SHORT).show();


            }
        });
    }


}
