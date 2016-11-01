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
import android.widget.ImageButton;

public class Menu extends Activity {

    Button singlePlayer, multiPlayer, options, newQuestion, sound;
    ImageButton volumeOn,volumeOff,scoreboard;
    private boolean status = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.optionsmenu);

        singlePlayer = (Button) findViewById(R.id.bnt_singlePlayer);
        multiPlayer = (Button) findViewById(R.id.btn_multiPlayer);
      //  options = (Button) findViewById(R.id.btn_options);
       newQuestion = (Button) findViewById(R.id.btn_newQuestion);
       // sound = (Button) findViewById(R.id.btn_sound);
        volumeOn=(ImageButton) findViewById(R.id.volumeOn);
        volumeOff=(ImageButton) findViewById(R.id.volumeOff);
        scoreboard=(ImageButton) findViewById(R.id.star);

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
        scoreboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (status) {
                    mp.start();
                }
            }
        });
        /*options.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (status) {
                    mp.start();
                }
                /*Intent intent = new Intent(Menu.this,
                        To Do);
                startActivity(intent);
                finish();
            }
        });*/

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

        volumeOn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (status) {
                    status = false;
                    volumeOn.setVisibility(View.GONE);
                    volumeOff.setVisibility(View.VISIBLE);
                }
                else {
                    status = true;
                    volumeOff.setVisibility(View.GONE);
                    volumeOn.setVisibility(View.VISIBLE);
                    mp.start();
                }

            }
        });
        volumeOff.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (status) {
                    status = false;
                    volumeOn.setVisibility(View.GONE);
                    volumeOff.setVisibility(View.VISIBLE);
                }
                else {
                    status = true;
                    volumeOff.setVisibility(View.GONE);
                    volumeOn.setVisibility(View.VISIBLE);
                    mp.start();
                }

            }
        });


    }

}
