package com.vernon.lee.textview;

import com.vernon.lee.R;

import android.app.Activity;
import android.os.Bundle;

/**
 * 跑马灯：文字环形滚动
 * @since 2014-9-30
 * @author huailiang
 * 
 * 主要是利用textview的属性
 * 			android:ellipsize="marquee" // 当文字广场时 显示模式  eg: start:省略号在开头
 *          android:focusable="true"
 *          android:focusableInTouchMode="true" // 再触摸情况下获取焦点
 *          android:marqueeRepeatLimit="marquee_forever"
 *          android:scrollHorizontally="true" // 水平滚动
 *          android:singleLine="true" // 单行显示
 */
public class MarqueenActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.textview_marqueen);
	}
}
