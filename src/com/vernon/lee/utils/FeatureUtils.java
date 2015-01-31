package com.vernon.lee.utils;

import com.vernon.lee.widget.WidgetListFragment;

import android.support.v4.app.Fragment;

public class FeatureUtils {

	public static Fragment getFragmentByFeatureName(String featureName) {
		Fragment frament = null;
		if(featureName.equals(FeatureData.FEATURE_WIDGET)) { // 控件类
			frament = new WidgetListFragment();
		}
//		else if () {
//			
//		}
		return frament;
	}
}
