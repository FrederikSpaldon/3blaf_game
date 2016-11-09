package a3blaf.a3blafgame;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by Fredo on 2. 11. 2016.
 */
public class CategoryChoose extends Activity {

    Button informatika,vlastne;
    Boolean status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.category);

        informatika = (Button)findViewById(R.id.btn_informatika);
        vlastne = (Button)findViewById(R.id.btn_vlastne);

        final MediaPlayer mp = MediaPlayer.create(this, R.raw.latch_click);

        informatika.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle b = new Bundle();
                b.putString("category", "Informatika");
                Intent intent = new Intent(CategoryChoose.this,
                        SingleplayerActivity.class);
                intent.putExtras(b);
                b = getIntent().getExtras();
                status = b.getBoolean("Zvuk");
                if(status) {
                    mp.start();
                }
                startActivity(intent);
                finish();
            }
        });

        vlastne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle b = new Bundle();
                b.putString("category", "Vlastne");
                Intent intent = new Intent(CategoryChoose.this,
                        SingleplayerActivity.class);
                intent.putExtras(b);
                b = getIntent().getExtras();
                status = b.getBoolean("Zvuk");
                if(status) {
                    mp.start();
                }
                startActivity(intent);
                finish();
            }
        });

    }
    @Override
    public void onBackPressed() {
        Bundle b = new Bundle();
        Intent intent = new Intent(CategoryChoose.this, Menu.class);
        startActivity(intent);
        finish();
    }
}
