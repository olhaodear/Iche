package com.android.iche.widget;

import android.content.Context;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.iche.R;

/**
 * Created by dugang on 2016/02/15. 主菜单item
 */
public class WidgetMainMenu extends LinearLayout {
    private TextView textView;
    private ImageView imageView;

    private int mNormalIcon;
    private int mSelectedIcon;

    public WidgetMainMenu(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        setClickable(true);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT);
        lp.weight = 1;
        setLayoutParams(lp);
        setGravity(Gravity.CENTER);

        setOrientation(VERTICAL);

        imageView = new ImageView(context);
        addView(imageView);

        textView = new TextView(context);
        textView.setGravity(Gravity.CENTER);
        textView.setTextColor(getResources().getColor(R.color.main_menu_text_normal));
        addView(textView);

    }

    /**
     * 初始化菜单属性
     * @param menuName 菜单名称
     * @param normalIcon 普通图标
     * @param selectedIcon 选中图标
     */
    public void initMenuAttr(String menuName, int normalIcon, int selectedIcon) {
        textView.setText(menuName);

        this.mNormalIcon = normalIcon;
        this.mSelectedIcon = selectedIcon;

        imageView.setImageResource(normalIcon);
    }

    /**
     * 切换菜单选中状态
     * @param menuId 菜单id
     */
    public void toggleSelectedState(int menuId) {
        if (getId() == menuId){
            textView.setTextColor(getResources().getColor(R.color.main_menu_text_selected));
            imageView.setImageResource(mSelectedIcon);
        }else{
            textView.setTextColor(getResources().getColor(R.color.main_menu_text_normal));
            imageView.setImageResource(mNormalIcon);
        }
    }
}
