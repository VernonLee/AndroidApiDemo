package com.vernon.lee.communication;

import com.vernon.lee.utils.ToastUtil;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * 接受广播后在发送一个广播给activity
 * @since 2014-10-10
 * @author huailiang
 */
public class BroadcastReceiverOne extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		if(context == null || intent == null) {
			return;
		}
		
		ToastUtil.show(context, "一号收到广播了");
		// 发送给activity
	    context.sendBroadcast(new Intent("WEAKUP_SUCESS"));
	}
}
