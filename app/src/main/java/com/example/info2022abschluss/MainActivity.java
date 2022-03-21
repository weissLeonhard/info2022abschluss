package com.example.info2022abschluss;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button b_1_1;
    private Button b_1_2;
    private Button b_1_3;

    private Button b_2_1;
    private Button b_2_2;
    private Button b_2_3;

    private Button b_3_1;
    private Button b_3_2;
    private Button b_3_3;

    private TextView tv_turnCounter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        b_1_1 = (Button) this.findViewById(R.id.b_1_1);
        b_1_2 = (Button) this.findViewById(R.id.b_1_2);
        b_1_3 = (Button) this.findViewById(R.id.b_1_3);

        b_2_1 = (Button) this.findViewById(R.id.b_2_1);
        b_2_2 = (Button) this.findViewById(R.id.b_2_2);
        b_2_3 = (Button) this.findViewById(R.id.b_2_3);

        b_3_1 = (Button) this.findViewById(R.id.b_3_1);
        b_3_2 = (Button) this.findViewById(R.id.b_3_2);
        b_3_3 = (Button) this.findViewById(R.id.b_3_3);

        tv_turnCounter = (TextView) this.findViewById(R.id.tv_turnCounter);

        b_1_1.setOnClickListener(this);
        b_1_2.setOnClickListener(this);
        b_1_3.setOnClickListener(this);

        b_2_1.setOnClickListener(this);
        b_2_2.setOnClickListener(this);
        b_2_3.setOnClickListener(this);

        b_3_1.setOnClickListener(this);
        b_3_2.setOnClickListener(this);
        b_3_3.setOnClickListener(this);


    }
    public Integer turnCounter = 0;
    @Override
    public void onClick(View view) {
        Button clickedButton = (Button) view;
        if (clickedButton.getText() != "X") {
            if (clickedButton.getText() != "O") {
                if (turnCounter % 2 == 0) {
                    tv_turnCounter.setText("O ist dran!");
                    clickedButton.setText("X");
                    turnCounter++;
                } else if (turnCounter % 2 != 0) {
                    tv_turnCounter.setText("X ist dran!");
                    clickedButton.setText("O");
                    turnCounter++;
                }
            }
        }
        if (b_1_1.getText() == "X") {
            if (b_1_2.getText() == "X") {
                if (b_1_3.getText() == "X") {
                    tv_turnCounter.setText("X gewinnt!");
                }
            }
            if (b_2_1.getText() == "X") {
                if (b_3_1.getText() == "X") {
                    tv_turnCounter.setText("X gewinnt!");
                }
            }
        }
        }
    }