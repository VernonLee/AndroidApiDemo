package com.vernon.lee;

import com.vernon.lee.fragment.FeatureFragment;

import android.support.v4.app.Fragment;

public class FeatureActivity extends SingleFragmentActivity {

	@Override
	protected Fragment createFragment() {
		return new FeatureFragment();
	}
}
