package com.vernon.lee.utils;

import com.vernon.lee.widget.ListViewFragment;
import com.vernon.lee.widget.TextViewFragment;
import com.vernon.lee.widget.WidgetListFragment;

import android.support.v4.app.Fragment;

public class FeatureUtils {
	
	/**
	 * 根据模块名称获取对应类
	 * @param name
	 * @return
	 */
	public static Fragment getFragmentByFeatureName(String featureName) {
		Fragment fragment = null;
		if(featureName.equals(FeatureData.FEATURE_WIDGET)) { // 控件类
			fragment = new WidgetListFragment();
		}
		
		if(featureName.equals(FeatureData.FEATURE_WIDGET_LISTVIEW)) {
			fragment = new ListViewFragment(); 
		}
		
		if(featureName.equals(FeatureData.FEATURE_WIDGET_TEXTVIEW)) {
			fragment = new TextViewFragment();
		}
		
		return fragment;
	}
}
