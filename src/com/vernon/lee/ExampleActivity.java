package com.vernon.lee;

	import android.app.Activity;
	import android.os.Bundle;
	import android.view.Menu;
	import android.view.View;
	import android.widget.AdapterView;
	import android.widget.AdapterView.OnItemClickListener;
	import android.widget.ListView;

	import com.vernon.lee.utils.ToastUtil;

	public class ExampleActivity extends Activity {
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
				public void onItemClick(AdapterView<?> parent, View view, int position,
						long id) {
					ToastUtil.show(ExampleActivity.this, position);
				}
			});
		}

		@Override
		public boolean onCreateOptionsMenu(Menu menu) {
			getMenuInflater().inflate(R.menu.main, menu);
			return true;
		}

	}
