package com.vernon.lee.utils;

public class FeatureData {
	public static final String FEATURE_WIDGET = "控件";
	public static final String FEATURE_WIDGET_LISTVIEW = "ListView";
	public static final String FEATURE_WIDGET_TEXTVIEW = "TextView";
	
	public static final String FEATURE_SYSTEM = "系统";
	public static final String FEATURE_FILE = "文件";
	public static final String FEATURE_MEDIA = "媒体";
	public static final String FEATURE_INTERNET = "网络";
	public static final String FEATURE_BLOG = "博客";
	
	public static String[] features = new String[] {
		"控件", "系统", "媒体", "文件", "网络", "博客"
	};
	
	public static class Widget {
		public static String[] widgets = new String[] {
			"ListView", "TextView"
		};
	}
}
