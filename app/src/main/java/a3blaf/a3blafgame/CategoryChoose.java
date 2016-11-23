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

    Button informatika,matematika,dejepis,vedeli,vlastne;
    Boolean status;
    int tmp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       final Bundle a= getIntent().getExtras();
        final MediaPlayer mp = MediaPlayer.create(this, R.raw.latch_click);
        setContentView(R.layout.category);
        informatika = (Button) findViewById(R.id.btn_informatika);
        matematika = (Button) findViewById(R.id.btn_matematika);
        dejepis = (Button) findViewById(R.id.btn_dejepis);
        vedeli = (Button) findViewById(R.id.btn_vedeli);
        vlastne = (Button) findViewById(R.id.btn_vlastne);



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
                b = getIntent().getExtras();
                status = b.getBoolean("Zvuk");
                if(status) {
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
        dejepis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle b = new Bundle();
                b.putString("category", "Dejepis");
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
        vedeli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle b = new Bundle();
                b.putString("category", "Vedelisteze");
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
                //tmp =b.getInt("zobraz");
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
