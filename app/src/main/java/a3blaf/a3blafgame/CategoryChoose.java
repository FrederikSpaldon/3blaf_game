package a3blaf.a3blafgame;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.List;

/**
 * Created by Fredo on 2. 11. 2016.
 */
public class CategoryChoose extends Activity {

    Button informatika,matematika,dejepis,vedeli,vlastne;
    Boolean zvuk;
    int tmp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final Bundle a= getIntent().getExtras();

        final SharedPreferences prefs = getSharedPreferences("preferences",MODE_PRIVATE);
        zvuk = prefs.getBoolean("zvuk", true);

        final MediaPlayer mp = MediaPlayer.create(this, R.raw.latch_click);
        setContentView(R.layout.category);
        informatika = (Button) findViewById(R.id.btn_informatika);
        matematika = (Button) findViewById(R.id.btn_matematika);
        dejepis = (Button) findViewById(R.id.btn_dejepis);
        vedeli = (Button) findViewById(R.id.btn_vedeli);
        vlastne = (Button) findViewById(R.id.btn_vlastne);
        if(a.getInt("zobraz")==2){
            vedeli.setVisibility(View.GONE);
        }

        informatika.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle b = new Bundle();
                b.putString("category", "Informatika");
                Intent intent;
                if(a.getInt("zobraz")==1){
               intent = new Intent(CategoryChoose.this,
                        SingleplayerActivity.class);
                intent.putExtras(b);}
                else { intent = new Intent(CategoryChoose.this,
                        MultiplayerActivity.class);
                    intent.putExtras(b);}
                if(zvuk) {
                    mp.start();
                }
                startActivity(intent);
                finish();
            }
        });
        matematika.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle b = new Bundle();
                b.putString("category", "Matematika");
                Intent intent;
                if (a.getInt("zobraz") == 1) {
                    intent = new Intent(CategoryChoose.this,
                            SingleplayerActivity.class);
                    intent.putExtras(b);
                } else {
                    intent = new Intent(CategoryChoose.this,
                            MultiplayerActivity.class);
                    intent.putExtras(b);
                }
                if(zvuk) {
                    mp.start();
                }
                startActivity(intent);
                finish();
            }});
        dejepis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle b = new Bundle();
                b.putString("category", "Dejepis");
                Intent intent;
                if (a.getInt("zobraz") == 1) {
                    intent = new Intent(CategoryChoose.this,
                            SingleplayerActivity.class);
                    intent.putExtras(b);
                } else {
                    intent = new Intent(CategoryChoose.this,
                            MultiplayerActivity.class);
                    intent.putExtras(b);
                }
                if(zvuk) {
                    mp.start();
                }
                startActivity(intent);
                finish();
            }});
        vedeli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle b = new Bundle();
                b.putString("category", "Vedelisteze");
                Intent intent = new Intent(CategoryChoose.this,
                        SingleplayerActivity.class);
                intent.putExtras(b);
                if(zvuk) {
                    mp.start();
                }
                startActivity(intent);
                finish();
            }
        });

        vlastne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseHelper db = new DatabaseHelper(CategoryChoose.this);  // database helper
                List<Question> quesList = db.getAllQuestionsByCategory("Vlastne");  // get all question

                //if empty category , create new question pop-up
                if (quesList == null || quesList.isEmpty()) {
                    addQuestionPopup();
                }
                else {
                    Bundle b = new Bundle();
                    b.putString("category", "Vlastne");
                    Intent intent;
                    if (a.getInt("zobraz") == 1) {
                        intent = new Intent(CategoryChoose.this,
                                SingleplayerActivity.class);
                        intent.putExtras(b);
                    } else {
                        intent = new Intent(CategoryChoose.this,
                                MultiplayerActivity.class);
                        intent.putExtras(b);
                    }
                    if (zvuk) {
                        mp.start();
                    }
                    startActivity(intent);
                    finish();
                }
            }});

    }
    @Override
    public void onBackPressed() {
        Bundle b = new Bundle();
        Intent intent = new Intent(CategoryChoose.this, Menu.class);
        startActivity(intent);
        finish();
    }

    public void addQuestionPopup(){
        AlertDialog.Builder helpBuilder = new AlertDialog.Builder(this);
        helpBuilder.setTitle("Nové otázky");
        helpBuilder.setMessage("Kategória neobsahuje žiadne otázky. Chceli by ste ich vytvoriť?");
        helpBuilder.setPositiveButton("Ano",
                new DialogInterface.OnClickListener() {
                    public void onClick (DialogInterface dialog,int which){
                        final Intent intent = new Intent(CategoryChoose.this, AddQuestion.class);
                        startActivity(intent);
                        finish();
                    }
                });
        helpBuilder.setNegativeButton("Nie",
                new DialogInterface.OnClickListener(){
                    public void onClick (DialogInterface dialog,int which){

                    }
                });

        // Remember, create doesn't show the dialog
        AlertDialog helpDialog = helpBuilder.create();
        helpDialog.show();
    }
}
