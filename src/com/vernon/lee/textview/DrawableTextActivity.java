package com.vernon.lee.textview;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import com.vernon.lee.R;

public class DrawableTextActivity extends Activity implements OnClickListener{
	private TextView tvDrawable;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.textview_drawable_left);
		tvDrawable = (TextView)findViewById(R.id.txt_drawable);
	}

	@Override
	public void onClick(View v) {
		Drawable dra = getResources().getDrawable(
				R.drawable.setting_icon_bluetooth_64);

		if (dra != null) {
			tvDrawable.setText("蓝牙");
			tvDrawable.setCompoundDrawablesWithIntrinsicBounds(dra, null, null,
					null);
		}
	}
}
