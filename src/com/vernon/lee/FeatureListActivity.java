package com.vernon.lee;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;

import com.vernon.lee.fragment.MainFragment;
import com.vernon.lee.utils.FeatureUtils;

public class FeatureListActivity extends SingleFragmentActivity {
	private static final String TAG = "FeatureListActivity";
	private String mFeatureName;
	
	@Override
	protected Fragment createFragment() {
		Intent i = getIntent();
		if(i != null) {
			mFeatureName = i.getStringExtra(MainFragment.EXTRA_FEATURE_NAME);
		}
		
		if(TextUtils.isEmpty(mFeatureName)) {
			Log.w(TAG, "没有获得模块名称");
			finish();
		}
		return FeatureUtils.getFragmentByFeatureName(mFeatureName);
	}
}
