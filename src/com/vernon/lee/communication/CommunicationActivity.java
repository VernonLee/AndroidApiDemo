package com.vernon.lee.communication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.vernon.lee.R;
import com.vernon.lee.utils.ToastUtil;

/**
 * android常用通信处理
 * @since 2014-10-10
 * @author huailiang
 */
public class CommunicationActivity extends Activity {
	private ListView mListView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_communication);
		initViews();
	}

	private void initViews() {
		mListView = (ListView) findViewById(R.id.lv_communication);
		mListView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				ToastUtil.show(getApplicationContext(), position);
				
				Class<?> cls = null;
				switch(position) {
				case 0:
					cls = ActivityAndBroadCastReceiverActivity.class;
					break;
				}
				
				if(cls != null) {
					startActivity(new Intent(CommunicationActivity.this, cls));
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
