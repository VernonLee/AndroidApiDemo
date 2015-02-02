package com.vernon.lee;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.util.Log;

import com.vernon.lee.fragment.FeatureListFragment;
import com.vernon.lee.utils.FeatureUtils;

public class FeatureActivity extends SingleFragmentActivity {
	private static final String TAG = "FeatureActivity";
	
	@Override
	protected Fragment createFragment() {
		String featureName = null;
		Intent i = getIntent();
		if(i != null) {
			featureName = i.getStringExtra(
					FeatureListFragment.EXTRA_FEATURE_DETAIL_NAME);
		}
		
		if(featureName == null) {
			Log.i(TAG, "没有获取详细页面");
			finish();
		}
		
		return FeatureUtils.getFragmentByFeatureName(featureName);
	}
}
