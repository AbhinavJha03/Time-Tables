package com.example.timetables;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView timesTableListView;
    public void generate(int  timesTableNumber)
    {
        ArrayList<String> arrayList= new ArrayList<String>();
        for(int j=1;j<=100;j++)
        {
            arrayList.add(Integer.toString(j*timesTableNumber));
        }
        ArrayAdapter<String> arrayAdapter =new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayList);
        timesTableListView.setAdapter(arrayAdapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SeekBar timesTablesSeekBar = findViewById(R.id.timesTableSeekBar);
        timesTableListView= findViewById(R.id.timesTableListView);
        int max=20;
        int startingposition=10;
        timesTablesSeekBar.setMax(max);
        timesTablesSeekBar.setProgress(startingposition);
        generate(startingposition);

        timesTablesSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean fromUser) {
                int min=1;
                int timesTableNumber;
                if (i<min)
                {
                    timesTableNumber = min;
                    timesTablesSeekBar.setProgress(min);
                }
                else
                {
                    timesTableNumber=i;
                }
                Log.i("Seekbar Value",Integer.toString(timesTableNumber));
                generate(timesTableNumber);


            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}











