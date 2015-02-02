package com.vernon.lee.widget;

import java.util.Calendar;

import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.vernon.lee.R;
import com.vernon.lee.fragment.FeatureFragment;
import com.vernon.lee.view.ExpandableTextView;

public class TextViewFragment extends FeatureFragment {
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_feature_textview, null);
		
		// 跑马灯
		ExpandableTextView marqueeTextView = (ExpandableTextView) v.findViewById(R.id.txt_marquee_note);
		marqueeTextView.setText(R.string.content_marquee);
		
		// Drawable Text
		TextView tvDrawable = (TextView) v.findViewById(R.id.txt_drawable_text_feature);
		tvDrawable.setText(DateFormat.format("yyyy-MM-dd", Calendar.getInstance().getTime()));
		ExpandableTextView drawableTextView = (ExpandableTextView) v.findViewById(R.id.txt_drawable_text_note);
		drawableTextView.setText(R.string.context_drawable_text);
		return v;
	}
}
