package hp.harsh.baseapplication.custom;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

import com.wedowebapps.vhmaintenance.R;

public class HelveticaThinTextView extends TextView {

	public HelveticaThinTextView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init(attrs);
	}

	public HelveticaThinTextView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init(attrs);

	}

	public HelveticaThinTextView(Context context) {
		super(context);
		init(null);
	}

	private void init(AttributeSet attrs) {
		Typeface myTypeface = Typeface.createFromAsset(getContext().getAssets(), getContext().getResources().getString(R.string.font_helvetica_thin));
		setTypeface(myTypeface);
	}

}
