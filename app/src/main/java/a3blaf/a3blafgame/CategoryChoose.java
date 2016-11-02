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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.category);

        informatika = (Button)findViewById(R.id.btn_informatika);
        vlastne = (Button)findViewById(R.id.btn_vlastne);

        informatika.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle b = new Bundle();
                b.putString("category", "Informatika");
                Intent intent = new Intent(CategoryChoose.this,
                        SingleplayerActivity.class);
                intent.putExtras(b);
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
                startActivity(intent);
                finish();
            }
        });

    }
}
