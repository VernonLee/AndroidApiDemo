package com.vernon.lee.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;

import com.vernon.lee.FeatureListActivity;
import com.vernon.lee.R;
import com.vernon.lee.utils.FeatureData;

public class MainFragment extends Fragment {
	public static final String EXTRA_FEATURE_NAME = "feature_name";
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.frag_main, null);
		
		View emptyView = getActivity().getLayoutInflater().inflate(R.layout.empty_view, null);
		getActivity().addContentView(emptyView, new LayoutParams(LayoutParams.MATCH_PARENT, 
				LayoutParams.MATCH_PARENT));
		
		ArrayAdapter<String> featuresAdaper = new ArrayAdapter<String>(getActivity(), 
				R.layout.grid_item_feature, FeatureData.features);
		
		GridView featuresView = (GridView) v.findViewById(R.id.grid_frag_main_features);
		featuresView.setEmptyView(emptyView);
		featuresView.setAdapter(featuresAdaper);
		featuresView.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view, int position,
					long id) {
				TextView textView = (TextView) view;
				String text = textView.getText().toString();
				Intent i = new Intent(getActivity(), FeatureListActivity.class);
				i.putExtra(EXTRA_FEATURE_NAME, text);
				startActivity(i);
			}
		});
		
		return v;
	}
}
