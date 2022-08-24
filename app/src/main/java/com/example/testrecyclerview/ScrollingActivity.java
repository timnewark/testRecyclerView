package com.example.testrecyclerview;

import android.os.Bundle;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.testrecyclerview.databinding.ActivityScrollingBinding;

public class ScrollingActivity extends AppCompatActivity{

    private ActivityScrollingBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //this is all getting the extras from the intents on mainactivity
        String name = getIntent().getStringExtra("NAME");
        String abbrBig = getIntent().getStringExtra("ABBR_BIG");
        String abbrSmall = getIntent().getStringExtra("ABBR_SMALL");
        String description = getIntent().getStringExtra("DESCRIPTION");
        int image = getIntent().getIntExtra("IMAGE", 0);
        //end

        // this is setting the textviews in MainActivity2 (MA2) to the above created strings
        TextView MA2NameTextView = findViewById(R.id.SV2TV1BPname);
        TextView MA23LettersTextView = findViewById(R.id.SV2TV2threeLetter);
        TextView MA21Letter = findViewById(R.id.SV2TV2oneLetter);
        TextView SA_Description = findViewById(R.id.SV2TVdescription);
        ImageView MA2Image = findViewById(R.id.SV2imageView);
        //end

        //below is setting the text views to match what the intentStringExtra has inside it
        MA2NameTextView.setText(name);
        MA23LettersTextView.setText(abbrBig);
        MA21Letter.setText(abbrSmall);
        SA_Description.setText(description);
        MA2Image.setImageResource(image);
        //end

        binding = ActivityScrollingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Toolbar toolbar = binding.toolbar;
        setSupportActionBar(toolbar);
        CollapsingToolbarLayout toolBarLayout = binding.toolbarLayout;
        toolBarLayout.setTitle(getTitle());

        FloatingActionButton fab = binding.fab;
        fab.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
}