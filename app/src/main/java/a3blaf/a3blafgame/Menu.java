package a3blaf.a3blafgame;

/**
 * Created by Fredo on 16. 10. 2016.
 */
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Menu extends Activity {

    Button singlePlayer, multiPlayer, options, newQuestion, sound;
    ImageView volumeOn,volumeOff,info;
    TextView sk;
    private boolean status = true;
    int skore;
    PopupWindow popUpWindow;
    LayoutInflater layoutInflater;
    RelativeLayout relative;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.optionsmenu);

        singlePlayer = (Button) findViewById(R.id.bnt_singlePlayer);
        multiPlayer = (Button) findViewById(R.id.btn_multiPlayer);
      //  options = (Button) findViewById(R.id.btn_options);
       newQuestion = (Button) findViewById(R.id.btn_newQuestion);
       // sound = (Button) findViewById(R.id.btn_sound);
        volumeOn=(ImageView) findViewById(R.id.volumeOn);
        volumeOff=(ImageView) findViewById(R.id.volumeOff);
        info=(ImageView) findViewById(R.id.btn_about);
        relative = (RelativeLayout) findViewById(R.id.relative);
       // scoreboard=(ImageButton) findViewById(R.id.star);
        sk=(TextView) findViewById(R.id.textView);

        final MediaPlayer mp = MediaPlayer.create(this, R.raw.latch_click);
        SharedPreferences prefs = getSharedPreferences("skore",MODE_PRIVATE);
        skore=prefs.getInt("skore", 0);
        sk.setText("Vaše dosiahnuté skóre je: " + Integer.toString(skore));
        singlePlayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (status) {
                    mp.start();
                }
                Intent intent = new Intent(Menu.this,
                        CategoryChoose.class);
                intent.putExtra("Zvuk", status);
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
                intent.putExtra("Zvuk", status);
                startActivity(intent);
                finish();*/
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
                intent.putExtra("Zvuk", status);
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
                Intent intent = new Intent(Menu.this, AddQuestion.class);
                intent.putExtra("Zvuk", status);
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
                } else {
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
                } else {
                    status = true;
                    volumeOff.setVisibility(View.GONE);
                    volumeOn.setVisibility(View.VISIBLE);
                    mp.start();
                }

            }
        });
        info.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(LAYOUT_INFLATER_SERVICE);
                ViewGroup container = (ViewGroup) layoutInflater.inflate(R.layout.about,null);
                // popUpWindow.showAtLocation(, Gravity.BOTTOM, 10, 10);
                popUpWindow = new PopupWindow(container,800,1300,true);
                popUpWindow.showAtLocation(relative, Gravity.NO_GRAVITY,150 , 400);

                container.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        popUpWindow.dismiss();
                        return true;
                    }
                });


            }


        });


    }
    @Override
    public void onBackPressed() {
        finish();
    }

}
