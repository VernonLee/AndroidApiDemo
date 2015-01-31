package com.vernon.lee;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

public abstract class SingleFragmentActivity extends FragmentActivity {
	protected abstract Fragment createFragment();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_single_fragment);

		FragmentManager fm = getSupportFragmentManager();
		Fragment fragment = createFragment();
		if (fragment != null) {
			fm.beginTransaction()
			.replace(R.id.fragment_container, fragment)
			.commit();
		}
	}
}
