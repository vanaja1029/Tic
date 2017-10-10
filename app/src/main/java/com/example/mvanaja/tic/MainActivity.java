package com.example.mvanaja.tic;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

import static com.example.mvanaja.tic.R.id.onePlayer;
import static com.example.mvanaja.tic.R.id.twoPlayer;

public class MainActivity extends AppCompatActivity {
    Random rand=new Random();
    int[] gameState={2,2,2,2,2,2,2,2,2};//2 means unplayed
    Button button[]= new Button[9];
    private TextView mInfoTextView;
    boolean gameOver=false;
    int activePlayer=1;//0 is for red
    int[][] winningLocation={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    /* int[][] possibleWin={
             {1,2},{3,6},{4,8},
             {0,2},{4,7},
             {0,1},{5,8},{4,6},
             {0,6},{4,5},
             {0,8},{2,6},{1,7},{3,5},
             {2,8},{3,4},
             {0,3},{7,8},{4,2},
             {6,8},{1,4},
             {6,7},{5,2},{0,4}};
     int possibleWin[]=new int[9];
      possibleWin={win0,win1};*/
    int[][] win0= {{1,2},{3,6},{4,8}};
    int[][] win1={{0,2},{4,7}};
    int[][] win2=  {{0,1},{5,8},{4,6}};
    int[][] win3=  {{0,6},{4,5}};
    int[][] win4= {{0,8},{2,6},{1,7},{3,5}};
    int[][] win5= {{2,8},{3,4}};
    int[][] win6= {{0,3},{7,8},{4,2}};
    int[][] win7 ={{6,8},{1,4}};
    int[][] win8={{6,7},{5,2},{0,4}};




    public void gameLogic(View view) {
        Button tappedview=(Button) view;
        int tappedLocation=Integer.parseInt(view.getTag().toString());
        if(gameState[tappedLocation]==2&&gameOver==false) {
            gameState[tappedLocation]=activePlayer;//0 is computer
            if (activePlayer == 1) {
                tappedview.setText("X");
                activePlayer = 0;


            }
            winnerLogic();


        }
        if(!gameOver)
            compMove();
    }
    public void compMove() {
       button[0] = (Button) findViewById(R.id.button0);
        button[1] = (Button) findViewById(R.id.button1);
        button[2] = (Button) findViewById(R.id.button2);
        button[3] = (Button) findViewById(R.id.button3);
        button[4] = (Button) findViewById(R.id.button4);
        button[5] = (Button) findViewById(R.id.button5);
        button[6] = (Button) findViewById(R.id.button6);
        button[7] = (Button) findViewById(R.id.button7);
        button[8] = (Button) findViewById(R.id.button8);

        if (activePlayer == 0) {
            boolean markedOnce = false;
            for (int j = 0; j < gameState.length; j++) {

                if(gameState[j]==2)
                {
                    if(j==0) {
                        for (int[] move2 : win0) {

                            if ((gameState[move2[0]] == gameState[move2[1]] && gameState[move2[0]] == 0) && !(markedOnce)) {
                                gameState[j] = 0;
                                button[j].setText("O");
                                markedOnce = true;

                            }
                        }


                    }
                    else if(j==1) {
                        for (int[] move2 : win1) {

                            if ((gameState[move2[0]] == gameState[move2[1]] && (gameState[move2[0]] == 0 )) && !(markedOnce)) {
                                gameState[j] = 0;
                                button[j].setText("O");
                                markedOnce = true;

                            }
                        }

                    }
                    else if(j==2) {
                        for (int[] move2 : win2) {

                            if ((gameState[move2[0]] == gameState[move2[1]] && (gameState[move2[0]] == 0 )) && !(markedOnce)) {
                                gameState[j] = 0;
                                button[j].setText("O");
                                markedOnce = true;

                            }
                        }

                    }
                    else if(j==3) {
                        for (int[] move2 : win3) {

                            if ((gameState[move2[0]] == gameState[move2[1]] && (gameState[move2[0]] == 0 )) && !(markedOnce)) {
                                gameState[j] = 0;
                                button[j].setText("O");
                                markedOnce = true;

                            }
                        }

                    }
                    else if(j==4) {
                        for (int[] move2 : win4) {

                            if ((gameState[move2[0]] == gameState[move2[1]] && (gameState[move2[0]] == 0 )) && !(markedOnce)) {
                                gameState[j] = 0;
                                button[j].setText("O");
                                markedOnce = true;

                            }
                        }

                    }
                    else if(j==5) {
                        for (int[] move2 : win5) {

                            if ((gameState[move2[0]] == gameState[move2[1]] && (gameState[move2[0]] == 0 )) && !(markedOnce)) {
                                gameState[j] = 0;
                                button[j].setText("O");
                                markedOnce = true;

                            }
                        }

                    }
                    else if(j==6) {
                        for (int[] move2 : win6) {

                            if ((gameState[move2[0]] == gameState[move2[1]] && (gameState[move2[0]] == 0 )) && !(markedOnce)) {
                                gameState[j] = 0;
                                button[j].setText("O");
                                markedOnce = true;

                            }
                        }

                    }
                    else if(j==7) {
                        for (int[] move2 : win7) {

                            if ((gameState[move2[0]] == gameState[move2[1]] && (gameState[move2[0]] == 0 )) && !(markedOnce)) {
                                gameState[j] = 0;
                                button[j].setText("O");
                                markedOnce = true;

                            }
                        }

                    }
                    else if(j==8) {
                        for (int[] move2 : win8) {

                            if ((gameState[move2[0]] == gameState[move2[1]] && (gameState[move2[0]] == 0 )) && !(markedOnce)) {
                                gameState[j] = 0;
                                button[j].setText("O");
                                markedOnce = true;

                            }
                        }
                    }

                }
            }
            if(!markedOnce) {
                for (int j = 0; j < gameState.length; j++) {
                    if (gameState[j] == 2) {

                        if (j == 0) {
                            for (int[] move2 : win0) {

                                if ((gameState[move2[0]] == gameState[move2[1]] && gameState[move2[0]] == 1) && !(markedOnce)) {
                                    gameState[j] = 0;
                                    button[j].setText("O");
                                    markedOnce = true;
                                }
                            }

                        } else if (j == 1) {
                            for (int[] move2 : win1) {

                                if ((gameState[move2[0]] == gameState[move2[1]] && gameState[move2[0]] == 1) && !(markedOnce)) {
                                    gameState[j] = 0;
                                    button[j].setText("O");
                                    markedOnce = true;
                                }
                            }

                        } else if (j == 2) {
                            for (int[] move2 : win2) {

                                if ((gameState[move2[0]] == gameState[move2[1]] && gameState[move2[0]] == 1) && !(markedOnce)) {
                                    gameState[j] = 0;
                                    button[j].setText("O");
                                    markedOnce = true;
                                }
                            }

                        } else if (j == 3) {
                            for (int[] move2 : win3) {

                                if ((gameState[move2[0]] == gameState[move2[1]] && gameState[move2[0]] == 1) && !(markedOnce)) {
                                    gameState[j] = 0;
                                    button[j].setText("O");
                                    markedOnce = true;
                                }
                            }

                        } else if (j == 4) {
                            for (int[] move2 : win4) {

                                if ((gameState[move2[0]] == gameState[move2[1]] && gameState[move2[0]] == 1) && !(markedOnce)) {
                                    gameState[j] = 0;
                                    button[j].setText("O");
                                    markedOnce = true;
                                }
                            }

                        } else if (j == 5) {
                            for (int[] move2 : win5) {

                                if ((gameState[move2[0]] == gameState[move2[1]] && gameState[move2[0]] == 1) && !(markedOnce)) {
                                    gameState[j] = 0;
                                    button[j].setText("O");
                                    markedOnce = true;
                                }
                            }

                        } else if (j == 6) {
                            for (int[] move2 : win6) {

                                if ((gameState[move2[0]] == gameState[move2[1]] && gameState[move2[0]] == 1) && !(markedOnce)) {
                                    gameState[j] = 0;
                                    button[j].setText("O");
                                    markedOnce = true;
                                }
                            }

                        } else if (j == 7) {
                            for (int[] move2 : win7) {

                                if ((gameState[move2[0]] == gameState[move2[1]] && gameState[move2[0]] == 1) && !(markedOnce)) {
                                    gameState[j] = 0;
                                    button[j].setText("O");
                                    markedOnce = true;
                                }
                            }

                        } else if (j == 8) {
                            for (int[] move2 : win8) {

                                if ((gameState[move2[0]] == gameState[move2[1]] && gameState[move2[0]] == 1) && !(markedOnce)) {
                                    gameState[j] = 0;
                                    button[j].setText("O");
                                    markedOnce = true;

                                }
                            }

                        }


                    }
         }
            }

            if(!markedOnce){
                {
                    int a ;
                    do
                    {
                        a= rand.nextInt(9);
                    } while (gameState[a] == 0 || gameState[a] == 1);

                    button[a].setText("O");
                    gameState[a]=activePlayer;
                    markedOnce = true;

                }

            }



            activePlayer = 1;
            winnerLogic();
        }
    }
    public void winnerLogic(){
        String msg = "";
        for (int[] winningPosition : winningLocation) {
            if (gameState[winningPosition[0]] == gameState[winningPosition[1]]
                    && gameState[winningPosition[1]] == gameState[winningPosition[2]]
                    && gameState[winningPosition[0]] != 2) {

                if (activePlayer == 0) {
                    msg = "you won";
                }
                if (activePlayer == 1) {
                    msg = "you lost";
                }
                LinearLayout winnerLayout = (LinearLayout) findViewById(R.id.winnerLayout);
                winnerLayout.setVisibility(View.VISIBLE);
                TextView winnerText = (TextView) findViewById(R.id.editText);
                winnerText.setText(msg);
                gameOver = true;
            }
        }
        boolean emptySquare = false;
        for(int gs: gameState)
        {

            if(gs==2)
            {
                emptySquare=true;
                break;
            }
        }
        if(!emptySquare&&!gameOver)
        {
            gameOver=true;
            msg="The game is draw";
            LinearLayout winnerLayout=(LinearLayout)findViewById(R.id.winnerLayout );
            winnerLayout.setVisibility(View.VISIBLE);
            TextView winnerText=(TextView)findViewById(R.id.editText) ;
            winnerText.setText(msg);


        }

    }

    public void playAgain(View view){


            LinearLayout winnerLayout = (LinearLayout) findViewById(R.id.winnerLayout);
            winnerLayout.setVisibility(View.INVISIBLE);
            boolean markedOnce = false;
            activePlayer = 1;
            gameOver = false;
            // activePlayer=0;
            for (int i = 0; i < gameState.length; i++)
                gameState[i] = 2;

            for (Button btn : button) {
                btn.setText("");
            }
            mInfoTextView.setText("X's turn");

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        LinearLayout winnerLayout=(LinearLayout)findViewById(R.id.winnerLayout );
        winnerLayout.setVisibility(View.INVISIBLE);



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
