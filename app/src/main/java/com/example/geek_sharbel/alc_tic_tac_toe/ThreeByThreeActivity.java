package com.example.geek_sharbel.alc_tic_tac_toe;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;
import android.widget.Toast;

public class ThreeByThreeActivity extends AppCompatActivity {

      private Button[][] btnBoard;
      private TextView tvPlayer_X;
      private TextView tvPlayer_O;
      private TextView tv_draw;
      private boolean gameTurn = true;
      private int counter;
      private  int xPoints;
      private int OPoints;
      private int draw;
      GridLayout grid;
      AlertDialog.Builder builder;
    private static final String TAG = "ThreeByThreeActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three_by_three);

        tvPlayer_X = findViewById(R.id.tv_Xscore);
        tvPlayer_O = findViewById(R.id.tv_Oscore);
        tv_draw = findViewById(R.id.tv_draw);
        builder = new AlertDialog.Builder(this);

        grid = findViewById(R.id.gridLayout);
        btnBoard = new Button[3][3];
        for(int i = 0; i < 3; i++){
            for(int j=0; j<3; j++){
                btnBoard[i][j] = (Button) grid.getChildAt(3 * i + j);
            }
        }

        Button btnReset = findViewById(R.id.btn_reset);
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              startGame();
            }
        });

    }

    public void playMove(View view){
        int index = grid.indexOfChild(view);
        int i = index / 3;
        int j = index % 3;

        if (!(btnBoard[i][j].getText().toString().equals(""))){
            return;
        }

        if(gameTurn) {
            btnBoard[i][j].setText("X");
        } else {
            btnBoard[i][j].setText("O");
        }

        counter++;

        if(checkGameWin()) {
            if(gameTurn){
                // Log.v(TAG,"player x win");
                playerXWins();
            } else{
                // Log.v(TAG,"player o win");
                playerOWins();
            }
        } else if (counter == 9){
           //  Log.v(TAG,"draw");
            draw();
        } else {
            gameTurn = !gameTurn;
        }

    }

    protected boolean checkGameWin(){

        for(int i = 0; i < 3; i++){
            /**
             * Horizontal Rows
             */
            if (btnBoard[i][0].getText().toString().equals(btnBoard[i][1].getText().toString())
                    && btnBoard[i][0].getText().toString().equals(btnBoard[i][2].getText().toString())
                       && !btnBoard[i][0].getText().toString().equals("")) {
                return true;
            }

            /**
             * Vertical Rows
             */
            if (btnBoard[0][i].getText().toString().equals(btnBoard[1][i].getText().toString())
                    && btnBoard[0][i].getText().toString().equals(btnBoard[2][i].getText().toString())
                    && !btnBoard[0][i].getText().toString().equals("")) {
                    return true;
            }

            /**
             *  1st Diagonal
             */
            if (btnBoard[0][0].getText().toString().equals(btnBoard[1][1].getText().toString())
                    && btnBoard[0][0].getText().toString().equals(btnBoard[2][2].getText().toString())
                    && !btnBoard[0][0].getText().toString().equals("")) {
                return true;
            }

            /**
             * 2nd Diagonal
             */
            if (btnBoard[0][2].getText().toString().equals(btnBoard[1][1].getText().toString())
                    && btnBoard[0][2].getText().toString().equals(btnBoard[2][0].getText().toString())
                    && !btnBoard[0][2].getText().toString().equals("")) {
                return true;
            }
        }
        return false;
    }

    protected void resetGame(){
         for(int i = 0; i < 3; i++){
             for(int j = 0; j < 3; j++) {
                 btnBoard[i][j].setText("");
             }
         }

         counter = 0;
         gameTurn = true;
    }
    protected void updateScores(){
        tvPlayer_X.setText(" X :   "+ xPoints);
        tvPlayer_O.setText(" O :   "+ OPoints);
        tv_draw.setText(" Draw :   "+ draw);
    }
    protected void playerXWins(){
        xPoints++;
        builder.setMessage("X Wins").setTitle("Game Over!!!").setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                updateScores();
                resetGame();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();

    }
    protected void playerOWins(){
        OPoints++;
        builder.setMessage("O Wins").setTitle("Game Over!!!").setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                updateScores();
                resetGame();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();

    }
    protected void draw(){
        draw++;
        builder.setMessage("It's a Draw").setTitle("Game Over!!!").setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                updateScores();
                resetGame();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();

    }

    protected void startGame(){
        xPoints = 0;
        OPoints = 0;
        draw = 0;
        updateScores();
        resetGame();
    }
    // Todo: set icon
//
//    AlertDialog alertDialog = new AlertDialog.Builder(AlertDialogActivity.this).create();
//alertDialog.setTitle("Alert Dialog");
//alertDialog.setMessage("Welcome to dear user.");
//alertDialog.setIcon(R.drawable.welcome);
//
//alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
//        public void onClick(DialogInterface dialog, int which) {
//            Toast.makeText(getApplicationContext(), "You clicked on OK", Toast.LENGTH_SHORT).show();
//        }
//    });

//alertDialog.show();

}
