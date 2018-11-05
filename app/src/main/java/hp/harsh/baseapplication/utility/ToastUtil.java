package hp.harsh.baseapplication.utility;

import android.content.Context;
import android.graphics.Typeface;

import com.github.johnpersano.supertoasts.SuperToast;

import hp.harsh.baseapplication.R;

public class ToastUtil {

    public static final boolean isToast = true;
    public static final String HELVETICA_NEUE_BOLD_OTF = "HelveticaNeue_Bold.otf";
    private static Typeface mTypeFace;

    public static void show(Context context, String message) {

        if (isToast) {
            try {
                mTypeFace = Typeface.createFromAsset(context.getAssets(), HELVETICA_NEUE_BOLD_OTF);
                final SuperToast superToast = new SuperToast(context);
                if (!superToast.isShowing()) {
                    superToast.setText(message);
                    //superToast.setIcon(R.mipmap.ic_launcher, SuperToast.IconPosition.LEFT);
                    superToast.setTextSize(SuperToast.TextSize.MEDIUM);
                    superToast.getTextView().setTypeface(mTypeFace);
                    superToast.setTextColor(context.getResources().getColor(R.color.black));
                    superToast.setBackground(SuperToast.Background.WHITE);
                    superToast.setDuration(SuperToast.Duration.SHORT);
                    superToast.setAnimations(SuperToast.Animations.SCALE);
                    superToast.show();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
