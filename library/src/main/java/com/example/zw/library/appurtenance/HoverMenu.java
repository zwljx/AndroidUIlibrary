package com.example.zw.library.appurtenance;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

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
    private static final int POS_LEFT_TOP = 0;
    private static final int POS_LEFT_BOTTOM = 1;
    private static final int POS_RIGHT_TOP = 2;
    private static final int POS_RIGHT_BOTTOM = 3;

    /**
     * the position of the menu,right_bottom by default
     */
    private Position mPosition = Position.RIGHT_BOTTOM;
    /**
     * the total length of open status for straight
     * the radius of open status for circle
     * it will be compute according the screen and num of menu items
     */
    private int length;
    /**
     * the main button of the menu
     */
    private View mainButton;
    //private List<Bitmap> iconsForMenuItems;
    //private List<OnClickListener> clickListenersForMenuItems;
    //========================constructors===============================
    public HoverMenu(Context context) {
        this(context,null);
    }

    public HoverMenu(Context context, AttributeSet attrs) {
        this(context,attrs,0);
    }

    public HoverMenu(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }


    @Override
    public void onClick(View v) {

    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

    }
}
