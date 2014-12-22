package com.vernon.lee.textview;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import com.vernon.lee.R;

public class TextViewActivity extends Activity implements OnClickListener {
	private TextView tvDrawable;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_textview);
		
		tvDrawable = (TextView)findViewById(R.id.txt_drawable);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		default:
		case R.id.btn_drawable_change:
			Drawable dra = getResources().getDrawable(
					R.drawable.setting_icon_bluetooth_64);

			if (dra != null) {
				tvDrawable.setText("蓝牙");
				tvDrawable.setCompoundDrawablesWithIntrinsicBounds(dra, null,
						null, null);
			}
			break;
		case R.id.btn_drawable_hide:
			/**
			 * 隐藏某一个方向上的Drawable，调用一下方法，将该方向上的值设为0，如：下面将left设为0
			 *  setCompoundDrawablesWithIntrinsicBounds(int left, int top, int right, int bottom)
			 */
			tvDrawable.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);  
			break;
		}
	}
}
