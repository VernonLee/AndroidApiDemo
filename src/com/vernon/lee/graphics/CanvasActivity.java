package com.vernon.lee.graphics;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Region.Op;
import android.os.Bundle;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.View;

import com.vernon.lee.R;

/**
 * ① 画布工具使用 
 *  The Canvas class holds the "draw" calls. To draw something, you need
 *  4 basic components: 绘制需要四个成分： 
 *  A Bitmap to hold the pixels, a Canvas to host the draw calls (writing into the bitmap),
 *  a drawing primitive (e.g. Rect,Path, text, Bitmap), 
 *  and a paint (to describe the colors and styles for the drawing).
 * 
 * ② 矩形坐标（x0, y0, x1, y2）对应左上坐标点和右下坐标点
 * 
 * ③ save 和 restore() 的区别 save保存canvas的状态 restore用于对canvas进行平移、放缩、旋转、错切、裁剪等操作之后，
 * 目的是防止在此期间对canvas进行操作
 * 
 * @since 2014-10-14
 * @author huailiang
 */
public class CanvasActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(new CanvasView(this));
		initViews();
	}

	private void initViews() {

	}

	public class CanvasView extends View {
		private Bitmap mBitmap;
		private Paint mPaint;
		private TextPaint mTextPaint;
		private StaticLayout mTextLayout;
		private Rect mBitmapRect;
		private Rect mRect;
		private Rect clipRect;
		private Rect mDestRect;

		public CanvasView(Context context) {
			this(context, null);
		}

		public CanvasView(Context context, AttributeSet attrs) {
			this(context, attrs, 0);
		}

		public CanvasView(Context context, AttributeSet attrs, int defStyle) {
			super(context, attrs, defStyle);

			mPaint = new Paint();
			mTextPaint = new TextPaint();
			mTextPaint.setTextSize(24);
			mTextPaint.setAntiAlias(true);
			mTextPaint.setColor(Color.BLACK);
			mBitmap = BitmapFactory.decodeResource(getResources(),
					R.drawable.logo);

			mBitmapRect = new Rect(150, 0, mBitmap.getWidth() + 150,
					mBitmap.getHeight());
			mRect = new Rect(150, 100, 250, 200);
			clipRect = new Rect(150, 350, 200, 400);
			mDestRect = new Rect(150, 350, 250, 450);
			mTextLayout = new StaticLayout(
					"translate画布起始位置变画, 在translate后的操作都是以... \n 变化后的画布作为新起始坐标",
					mTextPaint, 500, Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
		}

		@Override
		protected void onDraw(Canvas canvas) {
			// TODO Auto-generated method stub
			super.onDraw(canvas);
			mPaint.setColor(Color.BLUE);

			// 画图片
			canvas.drawText("画图片", 50, 50, mTextPaint);
			canvas.drawBitmap(mBitmap, null, mBitmapRect, mPaint);
			canvas.save();

			// 画矩形
			canvas.drawText("画矩形", 50, 150, mTextPaint);
			canvas.drawRect(mRect, mPaint);
			canvas.save();

			// 由于下面的操作没有save，所以不会产生影响
			canvas.drawPoint(50, 300, mTextPaint);
			canvas.restore();

			// 画布变换之translate
			canvas.translate(50, 250);
			mTextLayout.draw(canvas);
			canvas.restore();

			// 画布剪切【注意顺序，先clipRect 后drawRect】
			canvas.drawText("画布剪切", 50, 400, mTextPaint);
			canvas.clipRect(clipRect);
			// INTERSECT 取两者交集，默认的方式
			// DIFFERENCE 第一次不同于第二次的部分显示出来
			// REPLACE 显示第二次的
			// REVERSE_DIFFERENCE 第二次不同于第一次的部分显示
			// UNION 取全集
			// XOR 补集，就是全集的减去交集的剩余部分显示
			canvas.drawRect(mDestRect, mPaint);
			canvas.restore();
		}
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		finish();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}
