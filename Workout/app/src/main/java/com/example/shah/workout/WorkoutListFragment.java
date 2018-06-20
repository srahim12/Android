package com.example.shah.workout;

import android.app.Activity;
import android.app.ListFragment;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class WorkoutListFragment extends ListFragment {

    static interface WorkoutListListener{
        void itemClicked(long id);
    };
    private WorkoutListListener listener;

    @Override
    public View onCreateView(LayoutInflater inflator, ViewGroup container,Bundle savedInstanceState){
        String[] names = new String[Workout.workouts.length];
        for(int i = 0;i<Workout.workouts.length;i++){
            names[i] = Workout.workouts[i].getName();
        }

        ArrayAdapter<String> listAdapter = new ArrayAdapter<String>(inflator.getContext(),android.R.layout.simple_list_item_1,names);
        setListAdapter(listAdapter);
        return super.onCreateView(inflator,container,savedInstanceState);


    }

    @Override
    public void onAttach(Activity activity){
        super.onAttach(activity);
        this.listener = (WorkoutListListener)activity;

    }

    public void onListItemClick(ListView l,View v, int position, long id){
        if(listener!=null){
            listener.itemClicked(id);
        }
    }



}
