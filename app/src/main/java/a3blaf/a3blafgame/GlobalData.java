package a3blaf.a3blafgame;

import android.app.Application;

/**
 * Created by Fredo on 2. 11. 2016.
 */
public class GlobalData extends Application {

    private Boolean zvuk;

    public Boolean getZvuk() {
        return zvuk;
    }

    public void setZvuk(Boolean zvuk) {
        this.zvuk = zvuk;
    }
}
