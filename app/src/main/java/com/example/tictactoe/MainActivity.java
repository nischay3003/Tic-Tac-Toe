package com.example.tictactoe;

import java.util.*;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentManager;


public class MainActivity extends AppCompatActivity {
    public static final String TAG = "Home";

    static int turn = 0;

    Button Btn01;
    Button Btn02;
    Button Btn03;
    Button Btn04;
    Button Btn05;
    Button Btn06;
    Button Btn07;
    Button Btn08;
    Button Btn09;
    Button resetBtn;
    TextView player1;
    TextView player2;
    Boolean winner = false;
    Button Start_btn;
    Boolean Start = false;
    ImageButton back_btn;
    FrameLayout flStartFragment;
//    FrameLayout flRulesFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            setContentView(R.layout.activity_main);

//            flRulesFragment=findViewById(R.id.fl_rules_container);
            flStartFragment=findViewById(R.id.fl_start_container);
            Btn01 = findViewById(R.id.button01);
            Btn02 = findViewById(R.id.button02);
            Btn03 = findViewById(R.id.button03);
            Btn04 = findViewById(R.id.button04);
            Btn05 = findViewById(R.id.button05);
            Btn06 = findViewById(R.id.button06);
            Btn07 = findViewById(R.id.button07);
            Btn08 = findViewById(R.id.button08);
            Btn09 = findViewById(R.id.button09);
            resetBtn = findViewById(R.id.rst_btn);
            player1 = findViewById(R.id.textView8);
            player2 = findViewById(R.id.textView7);
            Start_btn = findViewById(R.id.start_btn);


            if (savedInstanceState == null) {
                // Add the fragment to the 'fragment_container' FrameLayout
                flStartFragment.setVisibility(View.VISIBLE);
                StartFragment startFragment = new StartFragment();
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(flStartFragment.getId(), startFragment)
                        .commit();
            }

            btnclickListener();
            unclickableBtn();
            player1.setText("Player1(O)");
            player2.setText("Player2(X)");
            Log.d(TAG, "onCreate:Player1 & 2 setText ");
            player1.setVisibility(View.INVISIBLE);
            player2.setVisibility(View.INVISIBLE);
            Log.d(TAG, "onCreate:Player1 & 2 visibility Done ");
            clickableBtn();
            Start = true;
            winner = false;

            if (turn == 0) {
                Log.d(TAG, "onClick: turn 0");

                player1.setVisibility(View.VISIBLE);
                player2.setVisibility(View.INVISIBLE);
            } else if (turn == 1) {
                player1.setVisibility(View.INVISIBLE);
                player2.setVisibility(View.VISIBLE);

            }
            resetBtn = findViewById(R.id.rst_btn);
            resetBtn.setVisibility(View.VISIBLE); // Ensure reset button is visible initially
            resetBtn.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    reset();
                }
            });
            back_btn = findViewById(R.id.back_btn);
            back_btn.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    flStartFragment.setVisibility(View.VISIBLE);
                    StartFragment startFragment = new StartFragment();
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    fragmentManager.beginTransaction()
                            .replace(flStartFragment.getId(), startFragment)
                            .commit();
                    reset();
                }
            });
            return insets;
        });
    }
//    public void back_btn_visible(){
//        back_btn.setVisibility(View.VISIBLE);
//    }
//    public void back_btn_invisible(){
//        back_btn.setVisibility(View.GONE);
//    }
    public void showRulesFragment() {
        Log.d("home", "showRulesFragment: entered ");
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fl_start_container, new RulebookFragment())
                .addToBackStack(null)  // Optional: Allow back navigation
                .commit();
    }
    public void navigateToRulebookFragment() {
        Log.d("home", "navigateToRulebookFragment: entered ");
//        getSupportFragmentManager().beginTransaction()
//                .replace(R.id.fl_start_container, new RulebookFragment())
//                .commit();

        flStartFragment.setVisibility(View.GONE);
    }
    public void startFragment(){
        flStartFragment.setVisibility(View.GONE);
    }

    public void btnclickListener() {

        Btn01.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                setBtn(Btn01, 1);
            }

        });
        Btn02.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                setBtn(Btn02, 2);
            }

        });
        Btn03.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                setBtn(Btn03, 3);
            }

        });
        Btn04.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                setBtn(Btn04, 4);
            }

        });
        Btn05.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                setBtn(Btn05, 5);
            }

        });
        Btn06.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                setBtn(Btn06, 6);
            }

        });
        Btn07.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                setBtn(Btn07, 7);
            }

        });
        Btn08.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                setBtn(Btn08, 8);
            }

        });
        Btn09.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                setBtn(Btn09, 9);
            }


        });
    }

    public void clickableBtn() {
        Btn01.setClickable(true);
        Btn02.setClickable(true);
        Btn03.setClickable(true);
        Btn04.setClickable(true);
        Btn05.setClickable(true);
        Btn06.setClickable(true);
        Btn07.setClickable(true);
        Btn08.setClickable(true);
        Btn09.setClickable(true);

    }

    public void exit() {
        finish(); // This will close the current activity
        // System.exit(0); // This will terminate the app (not recommended)
    }

    public void unclickableBtn() {
        Btn01.setClickable(false);
        Btn02.setClickable(false);
        Btn03.setClickable(false);
        Btn04.setClickable(false);
        Btn05.setClickable(false);
        Btn06.setClickable(false);
        Btn07.setClickable(false);
        Btn08.setClickable(false);
        Btn09.setClickable(false);


    }

    public void setWinner(Button b) {
        if (b.getText().toString().equals("O")) {
            winner = true;
            player1.setText("Winner:Player1(O)");
            player1.setVisibility(View.VISIBLE);
            unclickableBtn();
            Log.d(TAG, "Winner set as O");
        } else if (b.getText().toString().equals("X")) {
            winner = true;
            player2.setText("Winner:Player2(X)");
            player2.setVisibility(View.VISIBLE);
            unclickableBtn();
            Log.d(TAG, "Winner set as X");
        }
    }

    public void chkDraw() {
        String btn01 = Btn01.getText().toString();
        String btn02 = Btn02.getText().toString();
        String btn03 = Btn03.getText().toString();
        String btn04 = Btn04.getText().toString();
        String btn05 = Btn05.getText().toString();
        String btn06 = Btn06.getText().toString();
        String btn07 = Btn07.getText().toString();
        String btn08 = Btn08.getText().toString();
        String btn09 = Btn09.getText().toString();
        if (!btn01.isEmpty() && !btn02.isEmpty() && !btn03.isEmpty() && !btn04.isEmpty() && !btn05.isEmpty() && !btn06.isEmpty() && !btn07.isEmpty() && !btn08.isEmpty() && !btn09.isEmpty()) {
            if (!winner) {

                player2.setText("Draw");
                player2.setVisibility(View.VISIBLE);
                unclickableBtn();

            }
        }
        resetBtn.setVisibility(View.VISIBLE);
        return;
    }

    public void setBtn(Button b, int i) {
        String btnText = b.getText().toString();
        Log.d("home", "setBtn: " + btnText + " start: " + Start + " winner " + winner);

        if (Start && !winner) {
            if (turn == 0 && btnText.isEmpty()) {
                b.setText("O");
                turn = 1;
                Log.d(TAG, "setBtn:player1 ");
                player2.setVisibility(View.VISIBLE);
                player1.setVisibility(View.INVISIBLE);

            } else if (turn == 1 && btnText.isEmpty()) {
                b.setText("X");
                Log.d(TAG, "setBtn: Player2");
                turn = 0;
                player1.setVisibility(View.VISIBLE);
                player2.setVisibility(View.INVISIBLE);
            }

            chkWinner(i);
        }
    }

    public void reset() {
        Log.d(TAG, "reset: is clicked");
        Btn01.setText("");
        Btn02.setText("");
        Btn03.setText("");
        Btn04.setText("");
        Btn05.setText("");
        Btn06.setText("");
        Btn07.setText("");
        Btn08.setText("");
        Btn09.setText("");
        player1.setText("");
        player2.setText("");
        turn = 0;
        player1.setVisibility(View.VISIBLE);
        player2.setVisibility(View.INVISIBLE);
        clickableBtn();
            winner=false;
            Start=true;
        Log.d(TAG, "reset: ");
        player1.setText("Player1(O)");
        player2.setText("Player2(X)");
    }

    public void chkWinner(int i) {
        Log.d(TAG, "chkWinner: i : " + i);
        String btn01 = Btn01.getText().toString();
        String btn02 = Btn02.getText().toString();
        String btn03 = Btn03.getText().toString();
        String btn04 = Btn04.getText().toString();
        String btn05 = Btn05.getText().toString();
        String btn06 = Btn06.getText().toString();
        String btn07 = Btn07.getText().toString();
        String btn08 = Btn08.getText().toString();
        String btn09 = Btn09.getText().toString();

        if (i == 1) {
            Log.d(TAG, "chkWinner: btn01 : " + btn01 + " : " + btn02);
            if ((btn01.equals(btn02) && btn01.equals(btn03)) || (btn01.equals(btn04) && btn01.equals(btn07)) || (btn01.equals(btn05) && btn01.equals(btn09))) {
                Log.d(TAG, "chkWinner: i1 : " + i);
                setWinner(Btn01);

            } else {
                chkDraw();
            }

        }
        if (i == 2) {
            if ((btn02.equals(btn01) && btn02.equals(btn03)) || (btn02.equals(btn05) && btn02.equals(btn08))) {
                setWinner(Btn02);
            } else {
                chkDraw();
            }

        }
        if (i == 3) {
            if ((btn06.equals(btn03) && btn09.equals(btn03)) ||
                    (btn03.equals(btn05) && btn03.equals(btn07)) ||
                    (btn01.equals(btn03) && btn02.equals(btn03))) {
                setWinner(Btn03);
            } else {
                chkDraw();
            }
        }
        if (i == 4) {
            if ((btn04.equals(btn05) && btn04.equals(btn06)) ||
                    (btn04.equals(btn01) && btn04.equals(btn07))) {
                setWinner(Btn04);
            } else {
                chkDraw();
            }
        }
        if (i == 5) {
            if ((btn05.equals(btn01) && btn05.equals(btn09)) ||
                    (btn05.equals(btn03) && btn05.equals(btn07)) ||
                    (btn05.equals(btn04) && btn05.equals(btn06)) ||
                    (btn05.equals(btn02) && btn05.equals(btn08))) {
                setWinner(Btn05);
            } else {
                chkDraw();
            }
        }

        if (i == 6) {
            if ((btn06.equals(btn03) && btn06.equals(btn09)) ||
                    (btn06.equals(btn04) && btn06.equals(btn05))
            ) {
                setWinner(Btn06);
            } else {
                chkDraw();
            }
        }
        if (i == 7) {
            if ((btn07.equals(btn04) && btn07.equals(btn01)) ||
                    (btn07.equals(btn08) && btn07.equals(btn09)) ||
                    (btn07.equals(btn03) && btn07.equals(btn05))) {
                setWinner(Btn07);
            } else {
                chkDraw();
            }
        }
        if (i == 8) {
            if ((btn08.equals(btn05) && btn08.equals(btn02)) || (btn08.equals(btn09) && btn08.equals(btn07))) {
                setWinner(Btn08);
            } else {
                chkDraw();
            }
        }
        if (i == 9) {
            if ((btn09.equals(btn06) && btn09.equals(btn03)) ||
                    (btn09.equals(btn08) && btn09.equals(btn07)) ||
                    (btn09.equals(btn05) && btn09.equals(btn01))) {
                setWinner(Btn09);

            } else {
                chkDraw();
            }
        }


    }
}



