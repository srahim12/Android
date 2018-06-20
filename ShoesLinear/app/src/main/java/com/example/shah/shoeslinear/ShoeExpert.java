package com.example.shah.shoeslinear;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shah on 7/23/2017.
 */

public class ShoeExpert {
    List<String> getBrands(String color){
        List<String> brands = new ArrayList<String>();
        if(color.equals("White")){
            brands.add("Joggars");
            brands.add("Shaq");

        }
        else if(color.equals("Black")){
            brands.add("Jordan");
            brands.add("Nike");
        }
        else if(color.equals("Gray")){
            brands.add("Reebok");
            brands.add("Adidas");
        }
        return brands;
    }
}
