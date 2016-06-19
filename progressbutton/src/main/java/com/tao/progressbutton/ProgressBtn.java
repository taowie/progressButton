package com.tao.progressbutton;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.widget.Button;

/**
 * 创建者     taowei
 * 创建时间   2016/6/6 8:20
 * 描述	      ${TODO}
 * <p/>
 * 更新者     $Author$
 * 更新时间   $Date$
 * 更新描述   ${TODO}
 */
public class ProgressBtn extends Button {

    private int max ;
    private int progress;

    public void setMax(int max) {
        this.max = max;
    }

    public void setProgress(int progress) {
        this.progress = progress;
        //ondraw() method will execute again
        invalidate();
    }

    public ProgressBtn(Context context) {
        this(context, null);
    }

    public ProgressBtn(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        ColorDrawable drawable = new ColorDrawable(Color.BLUE);
        int right = (int) ((float)progress/max *getMeasuredWidth() +.5f);
        drawable.setBounds(getLeft(),getTop(),right,getBottom());
        drawable.draw(canvas);
        super.onDraw(canvas);
    }
}
