package a3blaf.a3blafgame;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class AddQuestion extends Activity{
    Button addQuestion ;
    EditText question ;
    EditText optA ;
    EditText optB ;
    EditText optC ;
    RadioButton checkboxA;
    RadioButton checkboxB;
    RadioButton checkboxC;

    private static DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.add_question);

        addQuestion = (Button) findViewById(R.id.addButton);
        question = (EditText) findViewById(R.id.questionAdd);
        optA = (EditText) findViewById(R.id.optA);
        optB = (EditText) findViewById(R.id.optB);
        optC = (EditText) findViewById(R.id.optC);
        checkboxA = (RadioButton) findViewById(R.id.checkboxA);
        checkboxB = (RadioButton) findViewById(R.id.checkboxB);
        checkboxC = (RadioButton) findViewById(R.id.checkboxC);
        databaseHelper=new DatabaseHelper(this);


        addQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isCorrectInput()) {
                    //add question
                    databaseHelper.addOwnQuestion(new Question(question.getText().toString(),optA.getText().toString(),optB.getText().toString(),optC.getText().toString(),getAnswer()));

                    //change activity
                    Intent intent = new Intent(AddQuestion.this,
                            Menu.class);
                    startActivity(intent);
                    finish();
                }
                else{
                    new AlertDialog.Builder(AddQuestion.this).setTitle("Warning").setMessage("Wrong Input").setCancelable(true).show();
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

}
