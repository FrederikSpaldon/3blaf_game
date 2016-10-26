package a3blaf.a3blafgame;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddQuestion extends Activity{
    Button addQuestion ;
    EditText question ;
    EditText optA ;
    EditText optB ;
    EditText optC ;
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
        databaseHelper=new DatabaseHelper(this);


        addQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isCorrectInput()) {
                    //add question
                    databaseHelper.addOwnQuestion(new Question(question.getText().toString(),optA.getText().toString(),optB.getText().toString(),optC.getText().toString(),optA.getText().toString()));

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

    }

    public boolean isCorrectInput(){
        if(TextUtils.isEmpty(optA.getText()) || TextUtils.isEmpty(optB.getText()) || TextUtils.isEmpty(optC.getText()) || TextUtils.isEmpty(question.getText())){
            return false;
        }
        return true;
    }

}
