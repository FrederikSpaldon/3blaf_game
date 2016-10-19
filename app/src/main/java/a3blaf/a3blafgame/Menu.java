package a3blaf.a3blafgame;

/**
 * Created by Fredo on 16. 10. 2016.
 */
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Menu extends Activity {

    Button singlePlayer, multiPlayer, options;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.optionsmenu);

        singlePlayer = (Button) findViewById(R.id.bnt_singlePlayer);
        multiPlayer = (Button) findViewById(R.id.btn_multiPlayer);
        options = (Button) findViewById(R.id.btn_options);

        singlePlayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Menu.this,
                        SingleplayerActivity.class);
                startActivity(intent);
                finish();
            }
        });

        multiPlayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Intent intent = new Intent(Menu.this,
                        MultiplayerActivity.class);
                startActivity(intent);
                finish();*/
            }
        });
        options.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Intent intent = new Intent(Menu.this,
                        To Do);
                startActivity(intent);
                finish();*/
            }
        });


    }

}
