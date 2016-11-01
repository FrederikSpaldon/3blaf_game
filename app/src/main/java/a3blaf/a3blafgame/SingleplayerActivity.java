package a3blaf.a3blafgame;

import java.util.List;
import java.util.concurrent.TimeUnit;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Fredo on 16. 10. 2016.
 */
public class SingleplayerActivity extends Activity {
    List<Question> quesList;
    int score = 0;
    int qid = 0;
    int n = 0;

    Question currentQ;
    TextView txtQuestion, times, scored;
    Button option1, option2, option3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatabaseHelper db = new DatabaseHelper(this);  // database helper
        quesList = db.getAllQuestions();  // get all question
        currentQ = quesList.get(qid); //  current question

        txtQuestion = (TextView) findViewById(R.id.txtQuestion); // question text view

        // option buttons
        option1 = (Button) findViewById(R.id.button1);
        option2 = (Button) findViewById(R.id.button2);
        option3 = (Button) findViewById(R.id.button3);



        final MediaPlayer mp = MediaPlayer.create(this, R.raw.latch_click);


        // the textview in which score will be displayed
        scored = (TextView) findViewById(R.id.score);

        // the timer
        times = (TextView) findViewById(R.id.timers);


        // method which will set the things up for our game
        setQuestionView();
        times.setText("00:02:00");

        // A timer of 60 seconds to play for, with an interval of 1 second (1000 milliseconds)
        CounterClass timer = new CounterClass(60000, 1000);
        timer.start();

        // button click listeners
        option1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // passing the button text to check whether the anser is correct or not
                getAnswer(option1.getText().toString());
                mp.start();
            }
        });

        option2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getAnswer(option2.getText().toString());
                mp.start();
            }
        });

        option3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getAnswer(option3.getText().toString());
                mp.start();
            }
        });
    }

    public void getAnswer(String AnswerString) {

        if (currentQ.getANSWER().equals(AnswerString)) {

            // if conditions matches increase the int (score) by 1
            // and set the text of the score view
            score++;
            n++;
            scored.setText("Score : " + score);
        } else {


            Intent intent = new Intent(SingleplayerActivity.this,
                    FinalActivity.class);

            n++;
            // passing the int value
            Bundle b = new Bundle();
            b.putInt("score", score); // Your score
            b.putInt("n", n);
            intent.putExtras(b); // Put your score to your next
            startActivity(intent);
            finish();
        }
        if (qid < 5) {

            // if questions are not over then do this
            currentQ = quesList.get(qid);
            setQuestionView();
        } else {

            // if over do this
            Intent intent = new Intent(SingleplayerActivity.this,
                    FinalActivity.class);
            Bundle b = new Bundle();
            Bundle c = new Bundle();
            b.putInt("score", score); // Your score
            b.putInt("n", n);
            intent.putExtras(b); // Put your score to your next
            startActivity(intent);
            finish();
        }


    }


    @TargetApi(Build.VERSION_CODES.GINGERBREAD)
    @SuppressLint("NewApi")
    public class CounterClass extends CountDownTimer {

        public CounterClass(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
            // TODO Auto-generated constructor stub
        }


        @Override
        public void onFinish() {
            times.setText("Time is up");
        }

        @Override
        public void onTick(long millisUntilFinished) {
            // TODO Auto-generated method stub

            long millis = millisUntilFinished;
            String hms = String.format(
                    "%02d:%02d:%02d",
                    TimeUnit.MILLISECONDS.toHours(millis),
                    TimeUnit.MILLISECONDS.toMinutes(millis)
                            - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS
                            .toHours(millis)),
                    TimeUnit.MILLISECONDS.toSeconds(millis)
                            - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS
                            .toMinutes(millis)));
            System.out.println(hms);
            times.setText(hms);
        }


    }

    private void setQuestionView() {

        // the method which will put all things together
        txtQuestion.setText(currentQ.getQUESTION());
        option1.setText(currentQ.getOPTA());
        option2.setText(currentQ.getOPTB());
        option3.setText(currentQ.getOPTC());

        qid++;
    }
}
