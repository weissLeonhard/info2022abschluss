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
    private EditText et_playerName;

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
        et_playerName = (EditText) this.findViewById(R.id.et_player1Name);

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
            String playerName = et_playerName.getText().toString();
            Player playerNew;
            playerNew = new Player(playerName, 0,0);
            playerList.add(playerNew);
            DatabaseHandler db = new DatabaseHandler(this);
            db.savePlayer(playerNew);
            playerList= db.loadPlayers();
            ArrayAdapter<Player> adapter1 = new ArrayAdapter<Player>(this, android.R.layout.simple_spinner_item, playerList);
            lv_players.setAdapter(adapter1);
            et_playerName.setText("");
        } else if (clickedButton.getText() != "X") {
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
                    String winner = "X";
                    winnerDialog(winner);
                }
            }
            if (b_2_1.getText() == "X") {
                if (b_3_1.getText() == "X") {
                    tv_turnCounter.setText("X gewinnt!");
                }
            }
            if (b_2_2.getText() == "X") {
                if (b_3_3.getText() == "X") {
                    tv_turnCounter.setText("X gewinnt!");
                }
            }
        }
        if (b_2_1.getText() == "X") {
            if (b_2_2.getText() == "X") {
                if (b_2_3.getText() == "X") {
                    tv_turnCounter.setText("X gewinnt!");
                }
            }
            if (b_1_2.getText() == "X") {
                if (b_3_2.getText() == "X") {
                    tv_turnCounter.setText("X gewinnt!");
                }
            }
            if (b_1_1.getText() == "X") {
                if (b_3_3.getText() == "X") {
                    tv_turnCounter.setText("X gewinnt!");
                }
            }
        }
        if (b_3_1.getText() == "X") {
            if (b_3_2.getText() == "X") {
                if (b_3_3.getText() == "X") {
                    tv_turnCounter.setText("X gewinnt!");
                }
            }
            if (b_2_3.getText() == "X") {
                if (b_1_3.getText() == "X") {
                    tv_turnCounter.setText("X gewinnt!");
                }
            }
            if (b_1_1.getText() == "X") {
                if (b_2_2.getText() == "X") {
                    tv_turnCounter.setText("X gewinnt!");
                }
            }
        }




        if (b_1_1.getText() == "O") {
            if (b_1_2.getText() == "O") {
                if (b_1_3.getText() == "O") {
                    tv_turnCounter.setText("O gewinnt!");
                }
            }
            if (b_2_1.getText() == "O") {
                if (b_3_1.getText() == "O") {
                    tv_turnCounter.setText("O gewinnt!");
                }
            }
            if (b_2_2.getText() == "O") {
                if (b_3_3.getText() == "O") {
                    tv_turnCounter.setText("O gewinnt!");
                }
            }
        }
        if (b_2_2.getText() == "O") {
            if (b_2_1.getText() == "O") {
                if (b_2_3.getText() == "O") {
                    tv_turnCounter.setText("O gewinnt!");
                }
            }
            if (b_1_2.getText() == "O") {
                if (b_3_2.getText() == "O") {
                    tv_turnCounter.setText("O gewinnt!");
                }
            }
            if (b_1_1.getText() == "O") {
                if (b_3_3.getText() == "O") {
                    tv_turnCounter.setText("O gewinnt!");
                }
            }
        }
        if (b_3_3.getText() == "O") {
            if (b_3_2.getText() == "O") {
                if (b_3_1.getText() == "O") {
                    tv_turnCounter.setText("O gewinnt!");
                }
            }
            if (b_2_3.getText() == "O") {
                if (b_1_3.getText() == "O") {
                    tv_turnCounter.setText("O gewinnt!");
                }
            }
            if (b_1_1.getText() == "O") {
                if (b_2_2.getText() == "O") {
                    tv_turnCounter.setText("O gewinnt!");
                }
            }
        }
        }

        //Stitch
        //Stitch

    private void winnerDialog(String winner) {
        AlertDialog.Builder dialog=new AlertDialog.Builder(this);
        dialog.setMessage(winner + " hat gewonnen!");
        dialog.setTitle("Ergebnis!");
        dialog.setPositiveButton("Aha",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,
                                        int which) {

                        Toast.makeText(getApplicationContext(), "Super!",Toast.LENGTH_LONG).show();
                    }
                });
        dialog.setNegativeButton("Ok",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(),"WOW!",Toast.LENGTH_LONG).show();
            }
        });
        AlertDialog alertDialog=dialog.create();
        alertDialog.show();
    }
        //Stitch

}
