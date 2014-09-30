package com.vernon.lee.textview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.vernon.lee.R;
import com.vernon.lee.utils.ToastUtil;

public class TextViewActivity extends Activity {
	private ListView mListView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_textview);
		initViews();
	}
	
	private void initViews() {
		mListView = (ListView)findViewById(R.id.lv_textview);
		mListView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position,
					long id) {
				ToastUtil.show(getApplicationContext(), position);
				
				Class<?> cls = null;
				switch (position) {
				case 0:
					cls = MarqueenActivity.class;
					break;
				case 1:
					cls = DrawableTextActivity.class;
					break;
				}

				if (cls != null) {
					startActivity(new Intent(TextViewActivity.this, cls));
				}
			}
		});
	}
}
