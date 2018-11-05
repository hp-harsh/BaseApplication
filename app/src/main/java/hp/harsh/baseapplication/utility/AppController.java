package hp.harsh.baseapplication.utility;

import android.app.Application;

/**
 * Created by Harsh on 2/10/2016.
 */
public class AppController extends Application {

    public static final String TAG = AppController.class
            .getSimpleName();

    private static AppController mInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        PreferenceManager preferenceManager = new PreferenceManager(getApplicationContext());
    }

    public static synchronized AppController getInstance() {
        return mInstance;
    }

}
