package com.example.shah.starbuzz;

/**
 * Created by Shah on 7/25/2017.
 */

public class Drink {
    private String name;
    private String description;
    private int imageResourceId;

    public static final Drink[] drinks= {new Drink("Latte","A couple espresso shots with steamed milk",
            R.drawable.latte),new Drink("Cappuccino","Esspresso steamed milk",R.drawable.cappuccino),
            new Drink("Filter","Fresh black coffee",R.drawable.filter)};

    public Drink(String name, String description, int imageResourceId){
        this.name = name;
        this.description = description;
        this.imageResourceId = imageResourceId;
    }

    public String getName(){
        return name;
    }

    public String getDescription(){
        return description;
    }

    public int getImageResourceId(){
        return imageResourceId;
    }

    public String toString(){
        return this.name;
    }


}
