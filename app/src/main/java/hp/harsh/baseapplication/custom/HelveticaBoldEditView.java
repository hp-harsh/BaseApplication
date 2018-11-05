package hp.harsh.baseapplication.custom;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.EditText;

import com.wedowebapps.vhmaintenance.R;

public class HelveticaBoldEditView extends EditText {

	public HelveticaBoldEditView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init(attrs);
	}

	public HelveticaBoldEditView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init(attrs);

	}

	public HelveticaBoldEditView(Context context) {
		super(context);
		init(null);
	}

	private void init(AttributeSet attrs) {
		Typeface myTypeface = Typeface.createFromAsset(getContext().getAssets(), getContext().getResources().getString(R.string.font_helvetica_bold));
		setTypeface(myTypeface);
	}

}
