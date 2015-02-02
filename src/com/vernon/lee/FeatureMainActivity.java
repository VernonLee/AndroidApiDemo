package com.vernon.lee;

import com.vernon.lee.fragment.FeatureMainFragment;

import android.support.v4.app.Fragment;

public class FeatureMainActivity extends SingleFragmentActivity {

	@Override
	protected Fragment createFragment() {
		return new FeatureMainFragment();
	}
}
