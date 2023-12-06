package com.stjerneklart.vizeprojesi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.Random;

public class RandomView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random);

        Button createButton = findViewById(R.id.buttonCreate);
        EditText countTextField = findViewById(R.id.countTextField);
        EditText maxTextField = findViewById(R.id.maxTextField);
        EditText minTextField = findViewById(R.id.minTextField);
        LinearLayout mainLayout = findViewById(R.id.mainLayout);

        ScrollView scrollView = new ScrollView(this);
        LinearLayout scrollLinearLayout = new LinearLayout(this);
        scrollView.addView(scrollLinearLayout);
        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String countString = countTextField.getText().toString();
                int count = Integer.parseInt(countString);

                String minString = countTextField.getText().toString();
                int min = Integer.parseInt(countString);

                String maxString = countTextField.getText().toString();
                int max = Integer.parseInt(countString);

                Random rnd = new Random();
                for (int i = 0; i < count; i++) {

                    LinearLayout sutun1 = new LinearLayout(RandomView.this);
                    LinearLayout satir1 = new LinearLayout(RandomView.this);
                    LinearLayout satir2 = new LinearLayout(RandomView.this);

                    sutun1.setOrientation(LinearLayout.VERTICAL);
                    satir1.setOrientation(LinearLayout.HORIZONTAL);
                    satir2.setOrientation(LinearLayout.HORIZONTAL);

                    TextView textView = new TextView(RandomView.this);
                    TextView textView2 = new TextView(RandomView.this);

                    ProgressBar progressBar = new ProgressBar(RandomView.this, null, android.R.attr.progressBarStyleHorizontal);

                    TextView textView3 = new TextView(RandomView.this);
                    int randomValueOne = rnd.nextInt(max - min + 1) + min;
                    int randomValueTwo = rnd.nextInt(max - min + 1) + min;

                    int maxValue;
                    int minValue;

                    if (randomValueOne > randomValueTwo) {

                        maxValue = randomValueOne;
                        minValue = randomValueTwo;
                    } else if (randomValueOne < randomValueTwo) {
                        minValue = randomValueOne;
                        maxValue = randomValueTwo;
                    } else {
                        maxValue = randomValueTwo;
                        minValue = randomValueOne;
                    }
                    int randomNumber = rnd.nextInt(maxValue - minValue + 1) + minValue;
                    double percent = (double) ((randomNumber - minValue) * 100 / maxValue - minValue);

                    int maxProgress = 100;
                    int progressValue = (int) ((percent / 100.0) * maxProgress);
                    textView.setText(Integer.toString(randomNumber) + "=%" + Double.toString(percent));
                    satir1.addView(textView);
                    textView2.setText("Min:" + Integer.toString(minValue));
                    satir2.addView(textView2);

                    progressBar.setProgress(progressValue);
                    satir2.addView(progressBar);

                    textView3.setText("Max:" + Integer.toString(maxValue));
                    satir2.addView(textView3);

                    sutun1.addView(satir1);
                    sutun1.addView(satir2);
                    scrollLinearLayout.addView(sutun1);

                }
                mainLayout.addView((scrollView));
            }
        });
    }
}