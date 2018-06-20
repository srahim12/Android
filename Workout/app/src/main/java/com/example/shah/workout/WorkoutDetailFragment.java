package com.example.shah.workout;

import android.app.FragmentTransaction;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class WorkoutDetailFragment extends Fragment {


    private long workoutId;

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState){
        if(savedInstanceState!= null){
            workoutId= savedInstanceState.getLong("workoutId");
        }

        else{
            FragmentTransaction ft = getChildFragmentManager().beginTransaction();
            StopwatchFragment stopwatchFragment = new StopwatchFragment();
            ft.replace(R.id.stopwatch_container,stopwatchFragment);
            ft.addToBackStack(null);
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.commit();
        }

        return inflater.inflate(R.layout.fragment_workout_detail,container,false);
    }

    public void setWorkoutId(long id){
        this.workoutId = id;
    }

    @Override
    public void onStart(){
        super.onStart();
        View view = getView();
        if(view != null){
            TextView workout_name = (TextView)view.findViewById(R.id.workout_name);
            Workout workout = Workout.workouts[(int)workoutId];
            workout_name.setText(workout.getName());
            TextView workout_description = (TextView)view.findViewById(R.id.workout_description);
            workout_description.setText(workout.getDescription());
        }
    }

    public void onSaveInstanceState(Bundle savedInstanceState){
        savedInstanceState.putLong("workoutId",workoutId);
    }
}
