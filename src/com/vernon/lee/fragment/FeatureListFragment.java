package com.vernon.lee.fragment;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.support.v4.app.NavUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.vernon.lee.FeatureActivity;

public class FeatureListFragment extends ListFragment {
	private static final String EXTRA_FEATURE_DETAIL_NAME = "detail_name";

	@TargetApi(11)
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setHasOptionsMenu(true);
		
		if(Build.VERSION.SDK_INT > Build.VERSION_CODES.HONEYCOMB) {
			if(NavUtils.getParentActivityName(getActivity()) != null) {
				getActivity().getActionBar().setDisplayHomeAsUpEnabled(true);
			}
		}
	}
	
	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		TextView textView = (TextView)v;
		String text = textView.getText().toString();
		Intent i = new Intent(getActivity(), FeatureActivity.class);
		i.putExtra(EXTRA_FEATURE_DETAIL_NAME, text);
		startActivity(i);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch(item.getItemId()) {
		case android.R.id.home:
			if(NavUtils.getParentActivityName(getActivity()) != null) {
				NavUtils.navigateUpFromSameTask(getActivity());
			}
			return true;
		}
		return true;
	}
}
