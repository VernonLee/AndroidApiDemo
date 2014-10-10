package com.vernon.lee.communication;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.vernon.lee.R;

/**
 * 通信方式： activity 和 broadcastreceiver之间通信 
 * 原 理：利用双广播机制实现二者通信，具体为在activity先发送一个广播，当broadcastreciver接受到 
 * 该广播后发送一个广播给activit。当然这种情况只能在activity处于可见状态下执行，如果activity 
 * ondestory 后需要借助sharedpreference数据文件交互。
 * @since 2014-10-10
 * @author huailiang
 */
public class ActivityAndBroadCastReceiverActivity extends Activity implements
		OnClickListener {
	private Button btnSendBroadcast;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.comm_activity_and_broadcastreceiver);
		btnSendBroadcast = (Button) findViewById(R.id.btn_send_broadcast);
	}

	@Override
	protected void onResume() {
		super.onResume();
		registerReceiver(mBroadcastReceiver, new IntentFilter("WEAKUP_SUCESS"));
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		// ? 猜想 在设置定时执行广播后，加入退出activity并且不取消
		// 注册广播 会不会实现收到广播接收器发送的广播
		unregisterReceiver(mBroadcastReceiver);
		finish();
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		// 发送广播
		case R.id.btn_send_broadcast:
			this.sendBroadcast(new Intent(getApplicationContext(),
					BroadcastReceiverOne.class));
			break;
		}
	}

	private BroadcastReceiver mBroadcastReceiver = new BroadcastReceiver() {
		@Override
		public void onReceive(Context context, Intent intent) {
			btnSendBroadcast.setText("广播接受成功");
		}
	};
}
