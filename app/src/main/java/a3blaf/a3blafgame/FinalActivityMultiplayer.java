package a3blaf.a3blafgame;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by Laci on 30.11.2016.
 */
public class FinalActivityMultiplayer extends Activity {
    Boolean zvuk;
    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_multiplayer);
        TextView textResult = (TextView) findViewById(R.id.textM1);
        TextView textResult2 = (TextView) findViewById(R.id.textM2);
        zvuk = getSharedPreferences("preferences",MODE_PRIVATE).getBoolean("zvuk", true);
        mp = MediaPlayer.create(this, R.raw.latch_click);

        Bundle b = getIntent().getExtras();
        int score1 = b.getInt("score");
        int score2 = b.getInt("score2");

        if (score1>score2){
        textResult.setText("Vyhral si!\nTvoje skóre je: "+score1);
        textResult2.setText("Prehral si!\nTvoje skóre je: "+score2);
        }
        else{
            textResult.setText("Prehral si!\nTvoje skóre je: "+score1);
            textResult2.setText("Vyhral si!\nTvoje skóre je: "+score2);
        }
    }


    @Override
    public void onBackPressed() {
        if (zvuk) mp.start();
        Intent intent = new Intent(FinalActivityMultiplayer.this, Menu.class);
        startActivity(intent);
        finish();
    }
}