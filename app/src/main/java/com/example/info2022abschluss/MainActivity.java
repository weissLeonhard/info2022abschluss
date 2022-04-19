package com.example.info2022abschluss;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

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

    private Button b_createPlayer;
    private TextView tv_turnCounter;
    private ListView lv_players;
    private EditText et_player1Name;
    private EditText et_player2Name;

    private String player1;
    private String player2;
    private Boolean matchInProgress = false;

    private ArrayList<Player> playerList = new ArrayList<>();



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


        b_createPlayer = (Button) this.findViewById(R.id.b_createPlayer);
        tv_turnCounter = (TextView) this.findViewById(R.id.tv_turnCounter);
        lv_players = (ListView) this.findViewById(R.id.lv_matchHistory);
        et_player1Name = (EditText) this.findViewById(R.id.et_player1Name);
        et_player2Name = (EditText) this.findViewById(R.id.et_player2Name);

        b_1_1.setOnClickListener(this);
        b_1_2.setOnClickListener(this);
        b_1_3.setOnClickListener(this);

        b_2_1.setOnClickListener(this);
        b_2_2.setOnClickListener(this);
        b_2_3.setOnClickListener(this);

        b_3_1.setOnClickListener(this);
        b_3_2.setOnClickListener(this);
        b_3_3.setOnClickListener(this);

        b_createPlayer.setOnClickListener(this);

        DatabaseHandler db = new DatabaseHandler(this);
        playerList= db.loadPlayers();
        ArrayAdapter<Player> adapter1 = new ArrayAdapter<Player>(this, android.R.layout.simple_spinner_item, playerList);
        lv_players.setAdapter(adapter1);
    }
    public Integer turnCounter = 0;
    @Override
    public void onClick(View view) {
        Button clickedButton = (Button) view;
        if (clickedButton == b_createPlayer) {
            if (matchInProgress == false) {
                player1 = et_player1Name.getText().toString();
                player2 = et_player2Name.getText().toString();
                et_player1Name.setText("");
                et_player2Name.setText("");
                matchInProgress = true;
                Toast.makeText(getApplicationContext(), "Match gestartet!",Toast.LENGTH_LONG).show();
                b_createPlayer.setText("Match läuft");
                tv_turnCounter.setText(player1 +" ist dran!");
            }



        } else if (clickedButton.getText() != "X" & matchInProgress == true) {
            if (clickedButton.getText() != "O") {
                if (turnCounter % 2 == 0) {
                    tv_turnCounter.setText(player2 +" ist dran!");
                    clickedButton.setText("X");
                    turnCounter++;
                } else if (turnCounter % 2 != 0) {
                    tv_turnCounter.setText(player1 +" ist dran!");
                    clickedButton.setText("O");
                    turnCounter++;
                }
            }
        }
        //Gewinnercheck-Logikblock
        //Habe leider keine elegantere Lösung gefunden, die im Zeitrahmen liegt
        if (b_1_1.getText() == "X" & b_1_2.getText() == "X" & b_1_3.getText() == "X") {
            winnerDialog("<--");
        }
        if (b_2_1.getText() == "X" & b_2_2.getText() == "X" & b_2_3.getText() == "X") {
            winnerDialog("<--");
        }
        if (b_3_1.getText() == "X" & b_3_2.getText() == "X" & b_3_3.getText() == "X") {
            winnerDialog("<--");
        }


        if (b_1_1.getText() == "X" & b_2_1.getText() == "X" & b_3_1.getText() == "X") {
            winnerDialog("<--");
        }
        if (b_1_2.getText() == "X" & b_2_2.getText() == "X" & b_3_2.getText() == "X") {
            winnerDialog("<--");
        }
        if (b_1_3.getText() == "X" & b_2_3.getText() == "X" & b_3_3.getText() == "X") {
            winnerDialog("<--");
        }
        if (b_1_1.getText() == "X" & b_2_2.getText() == "X" & b_3_3.getText() == "X") {
            winnerDialog("<--");
        }
        if (b_3_1.getText() == "X" & b_2_2.getText() == "X" & b_1_3.getText() == "X") {
            winnerDialog("<--");
        }

        if (b_1_1.getText() == "O" & b_1_2.getText() == "O" & b_1_3.getText() == "O") {
            winnerDialog("-->");
        }
        if (b_2_1.getText() == "O" & b_2_2.getText() == "O" & b_2_3.getText() == "O") {
            winnerDialog("-->");
        }
        if (b_3_1.getText() == "O" & b_3_2.getText() == "O" & b_3_3.getText() == "O") {
            winnerDialog("-->");
        }


        if (b_1_1.getText() == "O" & b_2_1.getText() == "O" & b_3_1.getText() == "O") {
            winnerDialog("-->");
        }
        if (b_1_2.getText() == "O" & b_2_2.getText() == "O" & b_3_2.getText() == "O") {
            winnerDialog("-->");
        }
        if (b_1_3.getText() == "O" & b_2_3.getText() == "O" & b_3_3.getText() == "O") {
            winnerDialog("-->");
        }

        if (b_1_1.getText() == "O" & b_2_2.getText() == "O" & b_3_3.getText() == "O") {
            winnerDialog("-->");
        }
        if (b_3_1.getText() == "O" & b_2_2.getText() == "O" & b_1_3.getText() == "O") {
            winnerDialog("-->");
        }
        if (turnCounter >= 9) {
            winnerDialog("---");
        }

    }

        //Stitch
        //Stitch

    private void winnerDialog(String winner) {

        Player matchNew;
        matchNew = new Player(player1, winner,player2);
        playerList.add(matchNew);
        DatabaseHandler db = new DatabaseHandler(this);
        db.savePlayer(matchNew);
        playerList= db.loadPlayers();
        ArrayAdapter<Player> adapter1 = new ArrayAdapter<Player>(this, android.R.layout.simple_spinner_item, playerList);
        lv_players.setAdapter(adapter1);
        matchInProgress = false;
        b_createPlayer.setText("Match Beginnen");
        tv_turnCounter.setText("Gebt eure Namen ein und beginnt!");
        turnCounter = 0;
        b_1_1.setText("");
        b_1_2.setText("");
        b_1_3.setText("");

        b_2_1.setText("");
        b_2_2.setText("");
        b_2_3.setText("");

        b_3_1.setText("");
        b_3_2.setText("");
        b_3_3.setText("");

        et_player1Name.setText("Spieler 1");
        et_player2Name.setText("Spieler 2");



        AlertDialog.Builder dialog=new AlertDialog.Builder(this);
        if (winner == "<--") {
            dialog.setMessage(player1 + " hat gewonnen!");
        } else if (winner == "-->") {
            dialog.setMessage(player2 + " hat gewonnen!");
        } else if (winner == "---") {
            dialog.setMessage("Unentschieden!");
        }
        dialog.setTitle("Ergebnis!");
        dialog.setPositiveButton("Aha",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,
                                        int which) {

                        Toast.makeText(getApplicationContext(), "Ergebnis eingetragen",Toast.LENGTH_LONG).show();
                    }
                });
        dialog.setNegativeButton("Ok",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(),"Ergebnis eingetragen - Pfeil zeigt auf Sieger",Toast.LENGTH_LONG).show();
            }
        });
        AlertDialog alertDialog=dialog.create();
        alertDialog.show();
    }
        //Stitch

}
