package a3blaf.a3blafgame;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView a=(TextView) findViewById(R.id.text);
        a.setText("3BLAF GAME"); // text
        a.setTextColor(Color.RED);
    }
}
