package a3blaf.a3blafgame;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import android.view.View;
import android.widget.TextView;


public class FinalActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TextView textResult = (TextView) findViewById(R.id.textResult);

        Bundle b = getIntent().getExtras();

        int score = b.getInt("score");
        int pocetOtazok = b.getInt("n");
        SharedPreferences prefs= this.getSharedPreferences("preferences", Context.MODE_PRIVATE);
        prefs.edit().putInt("skore",score).apply();
        textResult.setText("Koniec hry\nVáš stav je " + " " + score + " z " + pocetOtazok + ". \nVďaka za hru.");

    }

    public void playagain(View o) {

        Intent intent = new Intent(this, Menu.class);

        startActivity(intent);


    }
    @Override
    public void onBackPressed() {
        Bundle b = new Bundle();
        Intent intent = new Intent(FinalActivity.this, Menu.class);
        startActivity(intent);
        finish();
    }
}
