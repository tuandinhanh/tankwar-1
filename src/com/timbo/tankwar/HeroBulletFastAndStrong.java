package com.timbo.tankwar;
import java.util.ArrayList;
/**
 * ��ǿӢ���ӵ��ٶȺ�ǿ���ࣨӢ��̹�˳����������ǵ�״̬��
 * @author timbo
 * @version v1.0
 */
public class HeroBulletFastAndStrong extends HeroBullet
{
	public HeroBulletFastAndStrong(int direction, int x, int y)
	{	
		super(MySurfaceView.heroBullet,direction, x, y);
		this.span=Constant.HERO_BULLET_SPAN_FAST;
	}

	@Override
	boolean canGo(int xTemp,int yTemp)
	{
		  boolean canGoFlag=true;
		  //�ж��ӵ��Ƿ�ɳ��߽�
		  if(!Constant.isBulletInGameView(xTemp, yTemp))
		  {
			  canGoFlag=false;
		  }
		  //�ж��ӵ��Ƿ���е���̹��
			
			ArrayList<Tank> alTank=new ArrayList<Tank>(MySurfaceView.alTank);
			for(Tank t:alTank)
			{
				if(
						Constant.oneIsInAnother
						(
								x, y,Constant.BULLET_SIZE, Constant.BULLET_SIZE,
								t.x, t.y, Constant.TANK_SIZE, Constant.TANK_SIZE
						)
				)//�ж��Ƿ���е�̹��
				{
					if(!t.lifeMinusOne())
					{
						t.explode();				
					}
					canGoFlag=false;
				}
			}
			ArrayList<Bullet> alBullet=new ArrayList<Bullet>(MySurfaceView.alBullet);
			for(Bullet b:alBullet)
			{
				if(
						Constant.oneIsInAnother
						(
								x, y,Constant.BULLET_SIZE, Constant.BULLET_SIZE,
								b.x, b.y,Constant.BULLET_SIZE, Constant.BULLET_SIZE
						)
				)//�ж��Ƿ�����ӵ���ײ
				{
					b.explode();
					canGoFlag=false;
				}
			}
			//����ӵ��Ƿ������ϰ���
			if(MySurfaceView.map.isStrongBulletMetWithBarrier(xTemp,yTemp))
			{
				canGoFlag=false;
			}
			return canGoFlag;
	}
	void go()
	{
		int xTemp=x;
		int yTemp=y;
		
		
		//�ӵ��н�
		switch(direction)
		{
			case 0:
				yTemp=y-span;
			break;
			case 2:
				yTemp=y+span;
			break;	
			case 1:
				xTemp=x+span;
			break;
			case 3:
				xTemp=x-span;
			break;											
		}
		if(canGo(xTemp,yTemp))//�ж��ܲ����ƶ����µ�λ��
		{
			x=xTemp;
			y=yTemp;
			//�ӵ��ߵ���λ�ú��ж��Ƿ��������
			if(MySurfaceView.map.isBulletMetWithHome(x, y))
			{
				this.explode();
				MySurfaceView.map.home.explode();
			}
		}
		else
		{
			explode();
		}
	}
}