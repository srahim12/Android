package com.example.shah.workout;

/**
 * Created by Shah on 8/2/2017.
 */

public class Workout {
    private String name;
    private String description;

    public static final Workout[] workouts = {
            new Workout("The Limb Loosener",
                    "5 Handstand push-ups\n10 1-legged squats\n15 Pull-ups"),
            new Workout("Core Agony",
                    "100 Pull-ups\n100 Push-ups\n 100 Sit-ups\n 100 Squats"),
            new Workout("Rahim","8-10 min Bycicle\n 3 min crunches\n Run 30 min")};

    public Workout(String name, String description){
        this.name = name;
        this.description = description;
    }

    public String getName(){
        return name;
    }

    public String getDescription(){
        return description;
    }

    public String toString(){
        return this.name;
    }



}
