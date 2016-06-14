package com.example.zw.library.entrance;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.zw.library.R;

/**
 * 登录界面模板
 * Created by dell on 2016/6/7.
 */
public class LoginView extends RelativeLayout{

    //自定义属性
    private Drawable logoBackground;
    private Drawable btnBackground;
    private float btnTextSize;
    private int btnTextColor;
    private String btnText;
    private Drawable accountIconBackground;
    private Drawable pwdIconBackground;

    //界面所需控件
    private ImageView logo;
    private ImageView accountIcon;
    private ImageView pwdIcon;
    private EditText etAccount;
    private EditText etPwd;
    private Button btnLogin;

    LayoutParams logoParams,accountIconParams,pwdIconParams,etAccountParams,etPwdParams,btnLoginParams;

    public LoginView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.LoginView);
        logoBackground = ta.getDrawable(R.styleable.LoginView_logo);
        accountIconBackground = ta.getDrawable(R.styleable.LoginView_account_icon);
        pwdIconBackground = ta.getDrawable(R.styleable.LoginView_pwd_icon);
        btnBackground = ta.getDrawable(R.styleable.LoginView_login_btn_background);
        btnTextSize = ta.getDimension(R.styleable.LoginView_login_btn_textSize,0);
        btnTextColor = ta.getColor(R.styleable.LoginView_login_btn_textColor,0);
        btnText = ta.getString(R.styleable.LoginView_login_btn_text);
        ta.recycle();
        initView(context);
    }

    private void initView(Context context) {
        //初始化登录界面所需控件
        logo = new ImageView(context);
        accountIcon = new ImageView(context);
        pwdIcon = new ImageView(context);
        etAccount = new EditText(context);
        etPwd = new EditText(context);
        btnLogin = new Button(context);

        //为控件设置属性
        logo.setBackground(logoBackground);
        accountIcon.setBackground(accountIconBackground);
        pwdIcon.setBackground(pwdIconBackground);
        btnLogin.setBackground(btnBackground);
        btnLogin.setText(btnText);
        btnLogin.setTextColor(btnTextColor);
        btnLogin.setTextSize(btnTextSize);

        //为控件设置布局
        logoParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        logoParams.addRule(RelativeLayout.CENTER_HORIZONTAL,TRUE);
        logoParams.addRule(RelativeLayout.ALIGN_PARENT_TOP,TRUE);
        addView(logo,logoParams);
        accountIconParams = new

    }


}
