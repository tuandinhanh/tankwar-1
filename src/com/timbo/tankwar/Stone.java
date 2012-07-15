package com.timbo.tankwar;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
/**
 * �ϰ���ʯͷ�࣬(�̳��ϰ�����)
 * @author timbo
 *
 */
public class Stone extends Barrier {
	public Stone(Bitmap bitmap) {
		this.bitmap = bitmap;
	}

	@Override
	void drawSelf(Canvas canvas, Paint paint, int x, int y) {
		canvas.drawBitmap(bitmap, x, y, paint);
	}

}