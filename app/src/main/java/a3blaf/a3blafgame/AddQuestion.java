package a3blaf.a3blafgame;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;

import java.util.List;

public class AddQuestion extends Activity{
    Button addQuestion ;
    EditText question ;
    EditText optA ;
    EditText optB ;
    EditText optC ;
    RadioButton checkboxA;
    RadioButton checkboxB;
    RadioButton checkboxC;
    String category;
    Boolean status;

    List<Question> allQuestions;

    private static DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final MediaPlayer mp = MediaPlayer.create(this, R.raw.latch_click);

        Bundle b = getIntent().getExtras();

        setContentView(R.layout.add_question);

        addQuestion = (Button) findViewById(R.id.addButton);
        question = (EditText) findViewById(R.id.questionAdd);
        optA = (EditText) findViewById(R.id.optA);
        optB = (EditText) findViewById(R.id.optB);
        optC = (EditText) findViewById(R.id.optC);
        checkboxA = (RadioButton) findViewById(R.id.checkboxA);
        checkboxB = (RadioButton) findViewById(R.id.checkboxB);
        checkboxC = (RadioButton) findViewById(R.id.checkboxC);
        category = "Vlastne";
        databaseHelper=new DatabaseHelper(this);

        displayAllQuestions();


        addQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isCorrectInput()) {
                    Bundle b = getIntent().getExtras();
                    status = b.getBoolean("Zvuk");
                    if(status) {
                        mp.start();
                    }
                    //add question
                    databaseHelper.addOwnQuestion(new Question(question.getText().toString(),optA.getText().toString(),optB.getText().toString(),optC.getText().toString(),getAnswer(),category));

                    //change activity
                    Intent intent = new Intent(AddQuestion.this,
                            Menu.class);
                    startActivity(intent);
                    finish();
                }
                else{
                    new AlertDialog.Builder(AddQuestion.this).setTitle("Upozornenie").setMessage("Vyplňte všetky polia").setCancelable(true).show();
                }
            }
        });

        checkboxA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uncheckOther();
                checkboxA.setChecked(true);
            }
        });

        checkboxB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uncheckOther();
                checkboxB.setChecked(true);
            }
        });

        checkboxC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uncheckOther();
                checkboxC.setChecked(true);
            }
        });

    }

    public void uncheckOther(){
        checkboxA.setChecked(false);
        checkboxB.setChecked(false);
        checkboxC.setChecked(false);
    }

    public boolean isCorrectInput(){
        if(TextUtils.isEmpty(optA.getText()) || TextUtils.isEmpty(optB.getText()) || TextUtils.isEmpty(optC.getText()) || TextUtils.isEmpty(question.getText())){
            return false;
        }
        return true;
    }

    public String getAnswer(){
        if(checkboxA.isChecked()){
            return optA.getText().toString();
        }
        else if(checkboxB.isChecked()){
            return optB.getText().toString();
        }
        else{
            return optC.getText().toString();
        }
    }

    private void displayAllQuestions(){
        allQuestions = databaseHelper.getAllQuestionsByCategory("Vlastne");

        for (final Question question : allQuestions) {
            Button btn = new Button(this);
            btn.setText(question.getQUESTION());

            LinearLayout ll = (LinearLayout) findViewById(R.id.layout_removeQuestion);
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    AlertDialog.Builder helpBuilder = new AlertDialog.Builder(AddQuestion.this);
                    helpBuilder.setTitle("Vymazanie");
                    helpBuilder.setMessage("Chcete vymazať otázku?");
                    helpBuilder.setPositiveButton("Ano",
                            new DialogInterface.OnClickListener() {

                                public void onClick(DialogInterface dialog, int which) {
                                    databaseHelper.removeQuestion(question.getID());
                                    finish();
                                    startActivity(getIntent());
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
            });

            ll.addView(btn, lp);
        }
    }

    @Override
    public void onBackPressed() {
        Bundle b = new Bundle();
        Intent intent = new Intent(AddQuestion.this, Menu.class);
        startActivity(intent);
        finish();
    }
}
