package com.vernon.lee;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;


import com.vernon.lee.communication.CommunicationActivity;
import com.vernon.lee.graphics.GraphicsActivity;
import com.vernon.lee.textview.TextViewActivity;

public class MainActivity extends Activity {
	private ListView mListView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initViews();
	}
	
	private void initViews() {
		mListView = (ListView) findViewById(R.id.lv_all);
		mListView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Class<?> cls = null;
				switch (position) {
				case 0:
					cls = TextViewActivity.class;
					break;
				case 1:
					cls = CommunicationActivity.class;
				case 3:
					cls = GraphicsActivity.class;
				}

				if (cls != null) {
					startActivity(new Intent(MainActivity.this, cls));
				}
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}
