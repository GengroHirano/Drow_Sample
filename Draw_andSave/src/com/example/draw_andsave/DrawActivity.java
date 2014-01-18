package com.example.draw_andsave;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

public class DrawActivity extends Activity {

	int num;
	TouchPaint _tPaint;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        _tPaint = new TouchPaint(getApplicationContext());
        setContentView(_tPaint);
        num = 0;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.draw, menu);
		return true;
	}

	public void button1(){
		_tPaint.changeColor(num);
	}

}
