package com.vernon.lee.widget;

import java.util.ArrayList;
import java.util.List;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.support.v4.app.NavUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.vernon.lee.R;

public class ListViewFragment extends ListFragment {
	private List<String> mAnimalData;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mAnimalData = new ArrayList<String>();
		setHasOptionsMenu(true);
	}
	
	@TargetApi(11)
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		if (Build.VERSION.SDK_INT > Build.VERSION_CODES.HONEYCOMB) {
			if (NavUtils.getParentActivityName(getActivity()) != null) {
				getActivity().getActionBar().setDisplayHomeAsUpEnabled(true);
			}
		}
		
		return super.onCreateView(inflater, container, savedInstanceState);
	}
	
	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		final ArrayAdapter<String> mAdapter = new ArrayAdapter<String>(getActivity(), 
				android.R.layout.simple_list_item_1, mAnimalData);
		
		ListView list = getListView();
		View emptyView = getActivity().getLayoutInflater().inflate(R.layout.empty_view, null);
		((ViewGroup)list.getParent()).addView(emptyView, new LayoutParams(LayoutParams.MATCH_PARENT, 
				LayoutParams.MATCH_PARENT));
		Button btnAdd = (Button) emptyView.findViewById(R.id.btn_add); 
		btnAdd.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				mAnimalData.add("老牛");
				mAnimalData.add("老虎");
				mAnimalData.add("老狮");
				mAnimalData.add("老猴");
				mAdapter.notifyDataSetChanged();
			}
		});
		
		list.setEmptyView(emptyView);
		setListAdapter(mAdapter);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch(item.getItemId()) {
		case android.R.id.home:
			getActivity().finish();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
