package com.example.zw.library.content;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * 流式布局
 * Created by dell on 2016/6/14.
 */
public class FlowLayout extends ViewGroup{

    //存储所有的子view
    private List<List<View>> mAllChildViews = new ArrayList<>();
    //存储每一行的行高
    private List<Integer> mLineHeights = new ArrayList<>();

    public FlowLayout(Context context) {
        this(context,null);
    }

    public FlowLayout(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public FlowLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //父控件传进来的宽高和模式
        int sizeWidth = MeasureSpec.getSize(widthMeasureSpec);
        int modeWidth = MeasureSpec.getMode(widthMeasureSpec);
        int sizeHeight = MeasureSpec.getSize(heightMeasureSpec);
        int modeHeight = MeasureSpec.getMode(heightMeasureSpec);

        //测量结果
        int width = 0;
        int height = 0;
        //记录当前行高和当前行宽
        int lineWidth = 0;
        int lineHeight = 0;

        mAllChildViews.clear();
        mLineHeights.clear();

        int childCount = getChildCount();
        List<View> lineViews = new ArrayList<View>();
        for (int i = 0;i < childCount;i++){
            View view = getChildAt(i);
            measureChild(view,widthMeasureSpec,heightMeasureSpec);
            MarginLayoutParams lp = (MarginLayoutParams) view.getLayoutParams();
            int childWidth = view.getMeasuredWidth() + lp.leftMargin + lp.rightMargin;
            int childHeight = view.getMeasuredHeight() + lp.topMargin + lp.bottomMargin;

            if (lineWidth + childWidth > sizeWidth){//需要换行
                mLineHeights.add(lineHeight);
                height += lineHeight;
                width = Math.max(width,lineWidth);
                lineHeight = childHeight;
                lineWidth = childWidth;
                mAllChildViews.add(lineViews);
                lineViews = new ArrayList<View>();
            } else {
                lineHeight = Math.max(childHeight,lineHeight);
                lineWidth += childWidth;

                lineViews.add(view);
            }

            //处理最后一行
            if (i == childCount-1){
                width = Math.max(lineWidth,width);
                height += lineHeight;
                mLineHeights.add(lineHeight);
                mAllChildViews.add(lineViews);
            }
        }

        setMeasuredDimension(modeWidth == MeasureSpec.EXACTLY?sizeWidth:width + getPaddingLeft() + getPaddingRight(),
                modeHeight == MeasureSpec.EXACTLY?sizeHeight:height + getPaddingTop() + getPaddingBottom());
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int top = 0;
        int left = 0;
        int lineCount = mAllChildViews.size();

        int lineHeight = 0;//当前列高，用来更新top值
        List<View> lineViews = null;

        for (int i = 0; i < lineCount;i++){
            //获取当前行的子view
            lineViews = mAllChildViews.get(i);
            lineHeight = mLineHeights.get(i);
            int viewCount = lineViews.size();
            for (int j = 0;j < viewCount;j++){
                View childView = lineViews.get(j);
                MarginLayoutParams lp = (MarginLayoutParams) childView.getLayoutParams();
                int childLeft = left + lp.leftMargin;
                int childRight = childLeft + childView.getMeasuredWidth();
                int childTop = top + lp.topMargin;
                int childBottom = childTop + childView.getMeasuredHeight();
                childView.layout(childLeft,childTop,childRight,childBottom);

                left = left + childRight + lp.rightMargin;
            }
            left = 0;
            top += lineHeight;
        }

    }

    @Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new MarginLayoutParams(getContext(),attrs);
    }
}
