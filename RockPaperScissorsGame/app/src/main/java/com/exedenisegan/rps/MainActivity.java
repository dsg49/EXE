package com.exedenisegan.rps;

import android.media.Image;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView rockButton;
    private ImageView paperButton;
    private ImageView scissorButton;
    private ImageView zombieChoice;

    private TextView results;
    private String list[] = {"Rock", "Paper", "Scissors"};
    private int images[] = {R.drawable.rock, R.drawable.paper, R.drawable.scissors};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rockButton = (ImageView) findViewById(R.id.buttonRock);
        paperButton = (ImageView) findViewById(R.id.buttonPaper);
        scissorButton = (ImageView) findViewById(R.id.buttonScissors);
        zombieChoice = (ImageView) findViewById(R.id.titleId);

        results = (TextView) findViewById(R.id.textViewId);

        rockButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random randNum = new Random();
                int rand = randNum.nextInt(list.length);
                results.setText(list[rand]);

                zombieChoice.setImageResource(images[rand]);

                if (list[rand].equals("Scissors")) {
                    results.setText(list[rand] + ", " + getString(R.string.win_text));
                } else if (list[rand].equals("Paper")) {
                    results.setText(list[rand] + ", " + getString(R.string.lose_text));
                } else {
                    results.setText(list[rand] + "," + getString(R.string.tie_text));
                }
            }
        });

    }
}
