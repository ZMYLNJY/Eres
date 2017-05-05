package com.se.erest.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.widget.ImageView;

public class TableActivity extends Activity implements OnTouchListener,OnClickListener{
	private ImageView imgTable1,imgTable2,imgTable3,imgTable4;
	private ImageView imgTable5,imgTable6,imgTable7,imgTable8,imgTable9;
	private DisplayMetrics displayMetrics;
	private float lastX=0;
	private float lastY=0;
	private int screenWidth=0;
	private int screenHeight=0;
	private int left;
	private int right;
	private int top;
	private int bottom;
	private boolean isFirst=true;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_table);
		initView();
		
	}
	private void initView() {
		imgTable1 = (ImageView) findViewById(R.id.imgTable1);
		imgTable2 = (ImageView) findViewById(R.id.imgTable2);
		imgTable3 = (ImageView) findViewById(R.id.imgTable3);
		imgTable4 = (ImageView) findViewById(R.id.imgTable4);
		imgTable5 = (ImageView) findViewById(R.id.imgTable5);
		imgTable6 = (ImageView) findViewById(R.id.imgTable6);
		imgTable7 = (ImageView) findViewById(R.id.imgTable7);
		imgTable8 = (ImageView) findViewById(R.id.imgTable8);
		imgTable9 = (ImageView) findViewById(R.id.imgTable9);
		imgTable1.setOnTouchListener(this);
		imgTable2.setOnTouchListener(this);
		imgTable3.setOnTouchListener(this);
		imgTable4.setOnTouchListener(this);
		imgTable5.setOnTouchListener(this);
		imgTable6.setOnTouchListener(this);
		imgTable7.setOnTouchListener(this);
		imgTable8.setOnTouchListener(this);
		imgTable9.setOnTouchListener(this);
		//点击桌子进入菜单
		imgTable1.setOnClickListener(this);
		imgTable2.setOnClickListener(this);
		imgTable3.setOnClickListener(this);
		imgTable4.setOnClickListener(this);
		imgTable5.setOnClickListener(this);
		imgTable6.setOnClickListener(this);
		imgTable7.setOnClickListener(this);
		imgTable8.setOnClickListener(this);
		imgTable9.setOnClickListener(this);
	}
	public boolean onTouch(View view, MotionEvent event) {
		if(isFirst){
			displayMetrics = getResources().getDisplayMetrics();
			screenWidth = displayMetrics.widthPixels;
			Rect rect = new Rect();
			Window window = getWindow();
			imgTable1.getWindowVisibleDisplayFrame(rect);
			int statusBarHeight = rect.top;
			int contentViewTop = window.findViewById(Window.ID_ANDROID_CONTENT).getTop();
			int titleBarHeight = contentViewTop - statusBarHeight;
			screenHeight = displayMetrics.heightPixels-(statusBarHeight+titleBarHeight);
			isFirst = false;
		}
		int action=event.getAction();  
        switch (action) {  
        //按下  
        case MotionEvent.ACTION_DOWN:  
            //按下处坐标  
            lastX=event.getRawX();  
            lastY=event.getRawY();  
            break;  
        //移动  
        case MotionEvent.ACTION_MOVE:  
            //移动的距离  
            float distanceX=event.getRawX()-lastX;  
            float distanceY=event.getRawY()-lastY;  
            //移动后控件的坐标  
            left=(int)(view.getLeft()+distanceX);  
            top=(int)(view.getTop()+distanceY);  
            right=(int)(view.getRight()+distanceX);  
            bottom=(int)(view.getBottom()+distanceY);  
            //处理拖出屏幕的情况  
            if (left<0) {  
                left=0;  
                right=view.getWidth();  
            }  
            if (right>screenWidth) {  
                right=screenWidth;  
                left=screenWidth-view.getWidth();  
            }  
            if (top<0) {  
                top=0;  
                bottom=view.getHeight();  
            }  
            if (bottom>screenHeight) {  
                bottom=screenHeight;  
                top=screenHeight-view.getHeight();  
            }  
            //显示图片  
            view.layout(left, top, right, bottom);  
            lastX=event.getRawX();  
            lastY=event.getRawY();  
            break;  
        //抬起  
        case MotionEvent.ACTION_UP:  
            break;  
        default:  
            break;  
        }  
		return false;
	}
	public void onClick(View view) {
		//获取桌子号码，进入对应桌子详情
		//根据桌子状态不同分别进入点餐，订单和清理界面
		int tableID = view.getId();
		//数据库查询，根据ID取得桌子状态
		//if(table.statusID)
		Intent tableIntent = new Intent(this,OrderActivity.class);
		//传递桌子实体
		//创建实体类
        //People people = new People();
        //people.setName("Mark");
        //people.setSex("boy");
        //people.setAge(20);
        //添加传送数据
        tableIntent.putExtra("tableID", 1);
		startActivity(tableIntent);		
	}

}
