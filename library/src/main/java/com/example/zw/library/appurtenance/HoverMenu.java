package com.example.zw.library.appurtenance;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import com.example.zw.library.R;

import java.util.List;

/**
 * Created by dell on 2016/7/22.
 * Android系统菜单有三种：上下文菜单、子菜单、选项菜单。要实现的是自定义的悬浮菜单
 */
public class HoverMenu extends ViewGroup implements View.OnClickListener{

    //========================fields=====================================

    /**
     * the statuses of the menu
     */
    public enum Status{
        OPEN,CLOSE
    }

    /**
     * the directions of the menu
     */
    public enum Direction{
        STRAIGHT,CIRCLE
    }

    /**
     * the positions of the menu
     */
    public enum Position{
        LEFT_TOP, LEFT_BOTTOM, RIGHT_TOP, RIGHT_BOTTOM
    }
    private final int POS_LEFT_TOP = 0;
    private final int POS_LEFT_BOTTOM = 1;
    private final int POS_RIGHT_TOP = 2;
    private final int POS_RIGHT_BOTTOM = 3;
    private final int STATUS_OPEN = 0;
    private final int STATUS_CLOSE = 1;

    public enum Shape{
        CIRCLE, STRAIGHT
    }
    private final int SHAPE_CIRCLE = 0;
    private final int SHAPE_STRAIGHT = 1;

    /**
     * the position of the menu,right_bottom by default
     */
    private Position mPosition = Position.RIGHT_BOTTOM;
    /**
     * the total length of open status for straight
     * the radius of open status for circle
     * it will be compute according the screen and num of menu items
     */
    private int mLength;
    /**
     * the main button of the menu
     */
    private View mainButton;
    private int mStatus;
    private Shape mShape;

    private MenuItem.OnMenuItemClickListener onMenuItemClickListener;

    //========================constructors===============================
    public HoverMenu(Context context) {
        this(context,null);
    }

    public HoverMenu(Context context, AttributeSet attrs) {
        this(context,attrs,0);
    }

    public HoverMenu(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.HoverMenu);
        int position = ta.getInt(R.styleable.HoverMenu_position,POS_RIGHT_BOTTOM);
        switch (position){
            case POS_LEFT_BOTTOM:
                mPosition = Position.LEFT_BOTTOM;
                break;
            case POS_RIGHT_BOTTOM:
                mPosition = Position.RIGHT_BOTTOM;
                break;
            case POS_RIGHT_TOP:
                mPosition = Position.RIGHT_TOP;
                break;
            case POS_LEFT_TOP:
                mPosition = Position.LEFT_TOP;
                break;
        }
        int shape = ta.getInt(R.styleable.HoverMenu_shape,SHAPE_CIRCLE);
        switch (shape){
            case SHAPE_CIRCLE:
                mShape = Shape.CIRCLE;
                break;
            case SHAPE_STRAIGHT:
                mShape = Shape.STRAIGHT;
                break;
        }

        float defLength = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,100
               ,context.getResources().getDisplayMetrics());
        int length = (int) ta.getDimension(R.styleable.HoverMenu_length, defLength);
        mLength = length;
        ta.recycle();
        mStatus = STATUS_CLOSE;
    }

    //=======================methods======================================

    public void setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener menuItemClickListener){
        this.onMenuItemClickListener = menuItemClickListener;
    }

    /**
     * close or open menu according the menu state
     * @param v
     */
    @Override
    public void onClick(View v) {
        toggleMenu(mShape);
    }

    private void toggleMenu(Shape mShape) {

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        for (int i = 0,count = getChildCount();i < count;i++){
            measureChild(getChildAt(i),widthMeasureSpec,heightMeasureSpec);
        }
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        layoutMainButton();
    }

    private void layoutMainButton() {
        mainButton = getChildAt(0);
        int l = 0;
        int t = 0;
        int w = mainButton.getMeasuredWidth();
        int h = mainButton.getMeasuredHeight();
        switch (mPosition){
            case LEFT_TOP:
                l = t = 0;
                break;
            case RIGHT_TOP:
                l = getMeasuredWidth()-w;
                t = 0;
                break;
            case LEFT_BOTTOM:
                l = 0;
                t = getMeasuredHeight()-h;
                break;
            case RIGHT_BOTTOM:
                l = getMeasuredWidth()-w;
                t = getMeasuredHeight()-h;
                break;
        }
        mainButton.layout(l,t,l+w,t+h);
        mainButton.setOnClickListener(this);
    }
}
