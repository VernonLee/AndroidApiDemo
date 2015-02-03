package com.vernon.lee.widget;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vernon.lee.R;
import com.vernon.lee.fragment.FeatureFragment;
import com.vernon.lee.view.ExpandableTextView;

public class ListViewFragment extends FeatureFragment {
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_widget_listview, null);
		
		// Header Footer View
		ExpandableTextView hfView = (ExpandableTextView) v.findViewById(R.id.txt_header_footer_view_note);
		hfView.setText(R.string.content_header_footer_view);
		
		// EmptyView
		ExpandableTextView emptyView = (ExpandableTextView) v.findViewById(R.id.txt_empty_view_note);
		emptyView.setText(R.string.content_empty_view);
		return v;
	}
}
