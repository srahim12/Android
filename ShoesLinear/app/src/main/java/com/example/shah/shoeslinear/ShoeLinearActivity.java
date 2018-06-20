package com.example.shah.shoeslinear;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ShoeLinearActivity extends AppCompatActivity {

    private ShoeExpert expert = new ShoeExpert();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shoe_linear);
    }

    public void onClickFind(View view){
        TextView brands = (TextView)findViewById(R.id.brands);
        Spinner colors = (Spinner)findViewById(R.id.colors);
        String shoe_type = String.valueOf(colors.getSelectedItem());
        List<String> brands_list = expert.getBrands(shoe_type);
        StringBuilder brandsFormatted = new StringBuilder();
        for(String brand:brands_list){
            brandsFormatted.append(brand).append('\n');
        }

        brands.setText(brandsFormatted);
    }
}
