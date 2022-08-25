package com.example.testrecyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class SV extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sv);

        //this is all getting the extras from the intents on mainactivity
        String name = getIntent().getStringExtra("NAME");
        String abbrBig = getIntent().getStringExtra("ABBR_BIG");
        String abbrSmall = getIntent().getStringExtra("ABBR_SMALL");
        String description = getIntent().getStringExtra("DESCRIPTION");
        int image = getIntent().getIntExtra("IMAGE", 0);

        // this is setting the textviews in MainActivity2 (MA2) to the above created strings
        TextView SV2NameTextView = findViewById(R.id.SV2TV1BPname);
        TextView SV23LettersTextView = findViewById(R.id.SV2TV2threeLetter);
        TextView SV21Letter = findViewById(R.id.SV2TV2oneLetter);
        TextView SV2Description = findViewById(R.id.SV2TVdescription);
        ImageView SV2Image = findViewById(R.id.SV2imageView);

        //below is setting the text views to match what the intentStringExtra has inside it
        SV2NameTextView.setText(name);
        SV23LettersTextView.setText(abbrBig);
        SV21Letter.setText(abbrSmall);
        SV2Description.setText(description);
        SV2Image.setImageResource(image);
    }

    public void previousButtonClick(View view) {
        Toast.makeText(SV.this, "Previous CLICKED", Toast.LENGTH_SHORT).show();
        Log.i("SV", "button pressed");
        Intent intent = new Intent(SV.this, MainActivity.class);
        intent.putExtra("NAME", bridgeModelsArrayList.get(position).getBridgePartName());
        intent.putExtra("ABBR_BIG", bridgeModelsArrayList.get(position).getBridgePartAbbreviation());
        intent.putExtra("ABBR_SMALL", bridgeModelsArrayList.get(position).getBridgePartAbbreviationSmall());
        intent.putExtra("DESCRIPTION", bridgeModelsArrayList.get(position).getDescription());

    }
    public void nextButtonClick(View view) {
        Toast.makeText(SV.this, "Next CLICKED", Toast.LENGTH_SHORT).show();
        Log.i("SV", "button pressed");

    }
}