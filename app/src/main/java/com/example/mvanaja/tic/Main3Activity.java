package com.example.mvanaja.tic;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;




public class Main3Activity extends AppCompatActivity {
    int activePlayer=1;//0 is for red
    int[][] winningLocation={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    int[] gameState={2,2,2,2,2,2,2,2,2};//2 means unplayed
    boolean gameOver=false;
    Button button[]= new Button[9];
    public void gameLogic1(View view) {
        Button tappedview = (Button) view;
        // tappedview.setTranslationY(-3000f);
        int tappedLocation = Integer.parseInt(view.getTag().toString());
        if (gameState[tappedLocation] == 2 && gameOver == false) {
            gameState[tappedLocation] = activePlayer;
            if (activePlayer == 0) {

                tappedview.setText("O");
                activePlayer = 1;

            } else if (activePlayer == 1) {

                tappedview.setText("X");
                activePlayer = 0;

            }
        }
        winningLogic();

    }
    public void winningLogic(){
        String msg = "";
        for (int[] winningPosition : winningLocation) {
            if (gameState[winningPosition[0]] == gameState[winningPosition[1]]
                    && gameState[winningPosition[1]] == gameState[winningPosition[2]]
                    && gameState[winningPosition[0]] != 2) {

                if (activePlayer == 0) {
                    //Toast.makeText(getApplicationContext(), "X is the winner", Toast.LENGTH_LONG).show();
                    msg = "X is the winner";
                }
                if (activePlayer == 1) {
                    // Toast.makeText(getApplicationContext(), "O is the winner", Toast.LENGTH_LONG).show();
                    msg = "O is the winner";
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



    public void playAgain(View view) {
        LinearLayout winnerLayout = (LinearLayout) findViewById(R.id.winnerLayout);
        winnerLayout.setVisibility(View.INVISIBLE);

        gameOver = false;
        activePlayer = 1;
        for (int i = 0; i < gameState.length; i++)
            gameState[i] = 2;
        button[0] = (Button) findViewById(R.id.button0);
        button[1] = (Button) findViewById(R.id.button1);
        button[2] = (Button) findViewById(R.id.button2);
        button[3] = (Button) findViewById(R.id.button3);
        button[4] = (Button) findViewById(R.id.button4);
        button[5] = (Button) findViewById(R.id.button5);
        button[6] = (Button) findViewById(R.id.button6);
        button[7] = (Button) findViewById(R.id.button7);
        button[8] = (Button) findViewById(R.id.button8);
        for (Button btn : button) {
            btn.setText("");
        }




    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
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
