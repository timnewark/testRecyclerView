package com.example.testrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements RecyclerViewInterface{

    ArrayList<bridgeModel> bridgeModelsArrayList = new ArrayList<>();

    int[] bridgeImages = {      //need to be in correct order
            R.drawable.ic_bridgerecyclerview1_frv, R.drawable.ic_bridgerecyclerview2_sof,
            R.drawable.ic_bridgerecyclerview3_abt, R.drawable.ic_bridgerecyclerview4_wwl,
            R.drawable.ic_bridgerecyclerview5_spw, R.drawable.ic_bridgerecyclerview6_ppt,
            R.drawable.ic_baseline_video_settings_24, R.drawable.ic_baseline_volume_mute_24,
            R.drawable.ic_baseline_wb_sunny_24, R.drawable.ic_launcher_background,
            R.drawable.ic_baseline_18mp_24, R.drawable.ic_baseline_23mp_24,
            R.drawable.ic_baseline_18mp_24, R.drawable.ic_bridgerecyclerview14_rvt,
            R.drawable.ic_baseline_explore_24, R.drawable.ic_baseline_gps_not_fixed_24,
            R.drawable.ic_bridgerecyclerview17_pir, R.drawable.ic_baseline_volume_mute_24,
            R.drawable.ic_baseline_wb_sunny_24, R.drawable.ic_launcher_background,
            //vectors for the views. favicon displayed on left <-------
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.myRecyclerViewID);

        setUpBridgeModelsMethod();

        recyclerViewAdapter adapter = new recyclerViewAdapter(this, bridgeModelsArrayList, this);


        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    private void setUpBridgeModelsMethod(){
    String[] bridgeNamesFull = getResources().getStringArray(R.array.bridge_parts_full_txt);
    String[] bridgeNamesAbbv = getResources().getStringArray(R.array.bridge_parts_three_letter_txt);
    String[] bridgeNamesAbbvSmall = getResources().getStringArray(R.array.bridge_parts_one_letter_txt);
    String[] description = getResources().getStringArray(R.array.description_strings_array);
    //this takes all the information in the string file and transposes it into a string array (String[])

    for( int i=0; i<bridgeNamesFull.length;i++){
        bridgeModelsArrayList.add(new bridgeModel(bridgeNamesFull[i],
                bridgeNamesAbbv[i],
                bridgeNamesAbbvSmall[i],
                bridgeImages[i],
                description[i]));


// this takes all the names in the length of the bridgeNamesFull String[] and puts them in bridgeModeArrayList[]
    }
    }


    @Override
    public void onItemClick(int position) { //all information to exe when button is clicked to be put in here!!!
// will swap user from mainactity to MA2 and will take information from the adapted (position) and put that in an intent
        //putExtra adds information to the intent
        Intent intent = new Intent(MainActivity.this, SV.class);
        intent.putExtra("NAME", bridgeModelsArrayList.get(position).getBridgePartName());
        intent.putExtra("ABBR_BIG", bridgeModelsArrayList.get(position).getBridgePartAbbreviation());
        intent.putExtra("ABBR_SMALL", bridgeModelsArrayList.get(position).getBridgePartAbbreviationSmall());
        intent.putExtra("DESCRIPTION", bridgeModelsArrayList.get(position).getDescription());

        intent.putExtra("IMAGE", bridgeModelsArrayList.get(position).getImage());

        //second set for scrolling view-
        Intent SA_intent = new Intent(MainActivity.this, SV.class);
        intent.putExtra("NAME", bridgeModelsArrayList.get(position).getBridgePartName());
        intent.putExtra("ABBR_BIG", bridgeModelsArrayList.get(position).getBridgePartAbbreviation());
        intent.putExtra("ABBR_SMALL", bridgeModelsArrayList.get(position).getBridgePartAbbreviationSmall());
        intent.putExtra("DESCRIPTION", bridgeModelsArrayList.get(position).getDescription());
        intent.putExtra("IMAGE", bridgeModelsArrayList.get(position).getImage());
        //end of new SA code


        startActivity(intent);
    }
}