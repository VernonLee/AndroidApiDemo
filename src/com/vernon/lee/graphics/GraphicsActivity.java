package com.vernon.lee.graphics;

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

	public class GraphicsActivity extends Activity {
		private ListView mListView;
		
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_graphics);
			initViews();
		}
		
		private void initViews() {
			mListView = (ListView) findViewById(R.id.lv_graphics);
			mListView.setOnItemClickListener(new OnItemClickListener() {
				@Override
				public void onItemClick(AdapterView<?> parent, View view, int position,
						long id) {
					ToastUtil.show(GraphicsActivity.this, position);
					
					Class<?> cls = null;
					switch(position) {
					case 0: 
						cls = CanvasActivity.class;
						break;
					}
					
					if(cls != null) {
					startActivity(new Intent(GraphicsActivity.this,
							CanvasActivity.class));
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
