package a3blaf.a3blafgame;

/**
 * Created by Fredo on 16. 10. 2016.
 */
import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Menu extends Activity {

    Button singlePlayer, multiPlayer, options, newQuestion, sound;
    private boolean status = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.optionsmenu);

        singlePlayer = (Button) findViewById(R.id.bnt_singlePlayer);
        multiPlayer = (Button) findViewById(R.id.btn_multiPlayer);
        options = (Button) findViewById(R.id.btn_options);
        newQuestion = (Button) findViewById(R.id.btn_newQuestion);
        sound = (Button) findViewById(R.id.btn_sound);

        final MediaPlayer mp = MediaPlayer.create(this, R.raw.latch_click);

        singlePlayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.start();
                Intent intent = new Intent(Menu.this,
                        SingleplayerActivity.class);
                startActivity(intent);
                finish();
            }
        });

        multiPlayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (status) {
                    mp.start();
                }

                /*Intent intent = new Intent(Menu.this,
                        MultiplayerActivity.class);
                startActivity(intent);
                finish();*/
            }
        });
        options.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (status) {
                    mp.start();
                }
                /*Intent intent = new Intent(Menu.this,
                        To Do);
                startActivity(intent);
                finish();*/
            }
        });

        newQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (status) {
                    mp.start();
                }
                Intent intent = new Intent(Menu.this,
                        AddQuestion.class);
                startActivity(intent);
                finish();
            }
        });

        sound.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (status) {
                    status = false;
                }
                else {
                    status = true;
                    mp.start();
                }

            }
        });


    }

}
