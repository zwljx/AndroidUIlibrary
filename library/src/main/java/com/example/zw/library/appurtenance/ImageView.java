package com.example.zw.library.appurtenance;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.Toast;

/**
 * Created by lujinxin on 16/8/23.
 */
public class ImageView extends android.widget.ImageView{

    private int count = 0;
    private boolean isDoubleClick = false;
    //private boolean isLongClick = false;
    private Listener listener;

    public ImageView(Context context) {
        super(context);
    }

    public ImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setListener(Listener listener){
        this.listener = listener;
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                if (count == 0){
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            if (count == 2){
                                isDoubleClick = true;
                            } else if (count == 1){
                                listener.onClick();
                            }else if (count == 0){
                                listener.onLongClick();
                            }
                            count = 0;
                        }
                    },500);
                }
                break;
            case MotionEvent.ACTION_UP:
                if (isDoubleClick == true){
                    isDoubleClick = false;
                    listener.onDoubleClick();
                }
                /*if (isLongClick == true){
                    isLongClick = false;
                    listener.onLongClick();
                }*/
                count++;
                break;
        }
        return true;
    }

    public interface Listener {
        void onClick();

        void onDoubleClick();

        void onLongClick();
    }
}
