package com.timbo.tankwar;

/**
 * ������������Ĺ�����
 * @author timbo
 *
 */
public class ScreenScaleUtil {
	/**
	 *  ԭʼ�����Ŀ���
	 */
	static final float sHpWidth = 740;
	/**
	 *  ԭʼ�����ĸ߶�
	 */
	static final float sHpHeight = 320;
	/**
	 *  ԭʼ�����Ŀ��߱�
	 */
	static final float whHpRatio = sHpWidth / sHpHeight;
	/**
	 *  ԭʼ�����Ŀ���
	 */
	static final float sSpWidth = 740;
	/**
	 *  ԭʼ�����ĸ߶�
	 */
	static final float sSpHeight = 320;
	/**
	 *  ԭʼ�����Ŀ��߱�
	 */
	static final float whSpRatio = sSpWidth / sSpHeight;
	/**
	 * ��������
	 * @param targetWidth	Ŀ�����
	 * @param targetHeight	Ŀ��߶�
	 * @return
	 */
	public static ScreenScaleResult calScale(float targetWidth, 
			float targetHeight 
	) {
		ScreenScaleResult result = null;
		ScreenOrien so = null;

		// �����ж�Ŀ���Ǻ�����������
		if (targetWidth > targetHeight) {
			so = ScreenOrien.HP;
		} else {
			so = ScreenOrien.SP;
		}

		System.out.println(so);

		// ���к�������ļ���
		if (so == ScreenOrien.HP) {
			// ����Ŀ��Ŀ��߱�
			float targetRatio = targetWidth / targetHeight;

			if (targetRatio > whHpRatio) {
				// ��Ŀ����߱ȴ���ԭʼ���߱�����Ŀ��ĸ߶ȼ�����
				float ratio = targetHeight / sHpHeight;
				float realTargetWidth = sHpWidth * ratio;
				float lcuX = (targetWidth - realTargetWidth) / 2.0f;
				float lcuY = 0;
				result = new ScreenScaleResult((int) lcuX, (int) lcuY, ratio,
						so);
			} else {
				// ��Ŀ����߱�С��ԭʼ���߱�����Ŀ��Ŀ��ȼ�����
				float ratio = targetWidth / sHpWidth;
				float realTargetHeight = sHpHeight * ratio;
				float lcuX = 0;
				float lcuY = (targetHeight - realTargetHeight) / 2.0f;
				result = new ScreenScaleResult((int) lcuX, (int) lcuY, ratio,
						so);
			}
		}

		// ������������ļ���
		if (so == ScreenOrien.SP) {
			// ����Ŀ��Ŀ��߱�
			float targetRatio = targetWidth / targetHeight;

			if (targetRatio > whSpRatio) {
				// ��Ŀ����߱ȴ���ԭʼ���߱�����Ŀ��ĸ߶ȼ�����
				float ratio = targetHeight / sSpHeight;
				float realTargetWidth = sSpWidth * ratio;
				float lcuX = (targetWidth - realTargetWidth) / 2.0f;
				float lcuY = 0;
				result = new ScreenScaleResult((int) lcuX, (int) lcuY, ratio,
						so);
			} else {
				// ��Ŀ����߱�С��ԭʼ���߱�����Ŀ��Ŀ��ȼ�����
				float ratio = targetWidth / sSpWidth;
				float realTargetHeight = sSpHeight * ratio;
				float lcuX = 0;
				float lcuY = (targetHeight - realTargetHeight) / 2.0f;
				result = new ScreenScaleResult((int) lcuX, (int) lcuY, ratio,
						so);
			}

		}

		return result;
	}
}