package a3blaf.a3blafgame;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class MultiplayerActivity extends Activity {
    List<Question> quesList;
    int score1 = 0,score2=0, n=0;
    int qid = 0;
    Question currentQ;
    String category;
    TextView txtQuestion,txtQuestion2, scored1,scored2;
    Button button1, button2, button3,button4,button5,button6;
    boolean isAnswered, zvuk;
    SharedPreferences prefs;
    MediaPlayer mp;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.multiplayer_activity);

        mp = MediaPlayer.create(this, R.raw.latch_click);
        prefs = getSharedPreferences("preferences",MODE_PRIVATE);
        zvuk = prefs.getBoolean("zvuk", true);
        context=this;

        Bundle b = getIntent().getExtras();
        category = b.getString("category");

        DatabaseHelper db = new DatabaseHelper(this);
        quesList = db.getAllQuestionsByCategory(category);
        currentQ = quesList.get(qid);
        txtQuestion = (TextView) findViewById(R.id.txtQuestion_m1);
        txtQuestion2 = (TextView) findViewById(R.id.txtQuestion_m2);
        isAnswered = false;

        button1 = (Button) findViewById(R.id.m_buttonA1);
        button2 = (Button) findViewById(R.id.m_buttonB1);
        button3 = (Button) findViewById(R.id.m_buttonC1);

        button4 = (Button) findViewById(R.id.m_buttonA2);
        button5 = (Button) findViewById(R.id.m_buttonB2);
        button6 = (Button) findViewById(R.id.m_buttonC2);


        scored1 = (TextView) findViewById(R.id.textView_skore1);
        scored2 = (TextView) findViewById(R.id.textView_skore2);

        scored1.setText("Skóre: "+Integer.toString(0));
        scored2.setText("Skóre: "+Integer.toString(0));
        setQuestionView();

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getAnswer(button1.getText().toString());
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getAnswer(button2.getText().toString());
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getAnswer(button3.getText().toString());
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getAnswer(button4.getText().toString());
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getAnswer(button5.getText().toString());
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getAnswer(button6.getText().toString());
            }
        });
    }
    public void getAnswer(String AnswerString) {
        if(!isAnswered) {
            if(zvuk) {
                mp = MediaPlayer.create(context, R.raw.latch_click);
                mp.start();
            }
            isAnswered=true;
            if ((button1.isPressed() || button2.isPressed() || button3.isPressed())) {
                if (currentQ.getANSWER().equals(AnswerString)) {
                    findViewById(R.id.m_player2_layout).setBackgroundColor(Color.GREEN);
                    score1++;
                } else {
                    findViewById(R.id.m_player2_layout).setBackgroundColor(Color.RED);
                    score1--;
                }
                scored1.setText("Skóre: " + score1);
                n++;
            } else if (((button4.isPressed() || button5.isPressed() || button6.isPressed()))) {
                if (currentQ.getANSWER().equals(AnswerString)) {
                    findViewById(R.id.m_player1_layout).setBackgroundColor(Color.GREEN);
                    score2++;
                } else {
                    findViewById(R.id.m_player1_layout).setBackgroundColor(Color.RED);
                    score2--;
                }
                scored2.setText("Skóre: " + score2);
                n++;
            }

            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    isAnswered=false;
                    findViewById(R.id.m_player1_layout).setBackgroundColor(Color.WHITE);
                    findViewById(R.id.m_player2_layout).setBackgroundColor(Color.BLACK);
                    if (qid < 15 && qid < quesList.size()) {
                        currentQ = quesList.get(qid);
                        setQuestionView();
                    } else { //All questions

                        Intent intent = new Intent(MultiplayerActivity.this,
                                FinalActivityMultiplayer.class);
                        Bundle b = new Bundle();
                        b.putInt("score", score1);
                        b.putInt("score2", score2);
                        b.putInt("n", n);
                        intent.putExtras(b);
                        startActivity(intent);
                        finish();
                    }
                }
            }, 1000);
        }
    }

    private void setQuestionView() {
        txtQuestion.setText(currentQ.getQUESTION());
        txtQuestion2.setText(currentQ.getQUESTION());
        button1.setText(currentQ.getOPTA());
        button2.setText(currentQ.getOPTB());
        button3.setText(currentQ.getOPTC());
        button4.setText(currentQ.getOPTA());
        button5.setText(currentQ.getOPTB());
        button6.setText(currentQ.getOPTC());
        qid++;
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder helpBuilder = new AlertDialog.Builder(this);
        helpBuilder.setTitle("Koniec");
        helpBuilder.setMessage("Chcete ukončiť hru?");
        helpBuilder.setPositiveButton("Ano",
                new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        Bundle b = new Bundle();
                        final Intent intent = new Intent(MultiplayerActivity.this, Menu.class);
                        startActivity(intent);
                        finish();
                    }
                });

        helpBuilder.setNegativeButton("Nie", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                return;
            }
        });

        // Remember, create doesn't show the dialog
        AlertDialog helpDialog = helpBuilder.create();
        helpDialog.show();
    }
}
