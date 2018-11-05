package hp.harsh.baseapplication.custom;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

/**
 * Created by harsh on 16/3/17.
 */

public class ImageButtonWithToolTip extends ImageButton {

    private static final int ESTIMATED_TOAST_HEIGHT_DIPS = 48;

    public ImageButtonWithToolTip(Context context) {
        super(context);
        init();
    }

    public ImageButtonWithToolTip(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ImageButtonWithToolTip(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @TargetApi(21)
    public ImageButtonWithToolTip(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        setOnLongClickListener(new OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                /**
                 * You should set the android:contentDescription attribute in this view's XML layout file.
                 */

                String contentDescription = getContentDescription().toString();

                if (TextUtils.isEmpty(contentDescription)) {

                    /**
                     * There's no content description, so do nothing.
                     */

                    return false; // Not consumed

                }
                else {

                    final int[] screenPos = new int[2]; // origin is device display
                    final Rect displayFrame = new Rect(); // includes decorations (e.g. status bar)
                    view.getLocationOnScreen(screenPos);
                    view.getWindowVisibleDisplayFrame(displayFrame);

                    final Context context = view.getContext();
                    final int viewWidth = view.getWidth();
                    final int viewHeight = view.getHeight();
                    final int viewCenterX = screenPos[0] + viewWidth / 2;
                    final int screenWidth = context.getResources().getDisplayMetrics().widthPixels;
                    final int estimatedToastHeight = (int) (ESTIMATED_TOAST_HEIGHT_DIPS
                            * context.getResources().getDisplayMetrics().density);

                    Toast toolTipToast = Toast.makeText(context, contentDescription, Toast.LENGTH_SHORT);
                    boolean showBelow = screenPos[1] < estimatedToastHeight;
                    if (showBelow) {
                        // Show below
                        // Offsets are after decorations (e.g. status bar) are factored in
                        toolTipToast.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL,
                                viewCenterX - screenWidth / 2,
                                screenPos[1] - displayFrame.top + viewHeight);
                    }
                    else {
                        // Show above
                        // Offsets are after decorations (e.g. status bar) are factored in
                        // NOTE: We can't use Gravity.BOTTOM because when the keyboard is up
                        // its height isn't factored in.
                        toolTipToast.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL,
                                viewCenterX - screenWidth / 2,
                                screenPos[1] - displayFrame.top - estimatedToastHeight);
                    }

                    toolTipToast.show();

                    return true; // Consumed

                }

            }

        });

    }

}