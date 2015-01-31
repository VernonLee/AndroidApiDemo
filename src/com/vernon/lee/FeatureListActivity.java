package com.vernon.lee;

import com.vernon.lee.fragment.FeatureListFragment;

import android.support.v4.app.Fragment;

public class FeatureListActivity extends SingleFragmentActivity {

	@Override
	protected Fragment createFragment() {
		return new FeatureListFragment();
	}
}
