package com.vernon.lee.widget;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.vernon.lee.fragment.FeatureListFragment;
import com.vernon.lee.utils.FeatureData;

public class WidgetListFragment extends FeatureListFragment {
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v = super.onCreateView(inflater, container, savedInstanceState);
		
		ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getActivity(), 
				android.R.layout.simple_list_item_1, FeatureData.Widget.widgets);
		setListAdapter(arrayAdapter);
		
		return v;
	}
}
