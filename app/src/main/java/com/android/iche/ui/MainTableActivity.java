package com.android.iche.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.android.iche.R;
import com.android.iche.ui.cost.IcheCostFragment;
import com.android.iche.widget.WidgetMainMenu;
import com.android.library.base.BaseActivity;

import butterknife.Bind;

/**
 * Created by dugang on 2016/02/15. 主菜单
 */
public class MainTableActivity extends BaseActivity implements View.OnClickListener {
    @Bind(R.id.bottom_menu) LinearLayout bottom_menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_table);

        initMainMenu();
    }

    private void initMainMenu() {
        bottom_menu.removeAllViews();
        //行车花费
        WidgetMainMenu menu_cost = new WidgetMainMenu(this);
        menu_cost.setId(R.id.main_menu_cost);
        menu_cost.initMenuAttr(getString(R.string.main_menu_text_cost), R.mipmap.main_menu_cost_normal, R.mipmap.main_menu_cost_selected);
        menu_cost.setOnClickListener(this);
        bottom_menu.addView(menu_cost);
        //更多
        WidgetMainMenu menu_option = new WidgetMainMenu(this);
        menu_option.setId(R.id.main_menu_option);
        menu_option.initMenuAttr(getString(R.string.main_menu_text_options), R.mipmap.main_menu_option_normal, R.mipmap.main_menu_option_selected);
        menu_option.setOnClickListener(this);
        bottom_menu.addView(menu_option);

        //默认显示第一个fragment
        bottom_menu.getChildAt(0).performClick();
    }

    @Override
    public void onClick(View v) {
        int viewId = v.getId();
        //切换菜单的选中状态
        int count = bottom_menu.getChildCount();
        for (int i = 0; i < count; i++) {
            WidgetMainMenu menu = (WidgetMainMenu) bottom_menu.getChildAt(i);
            menu.toggleSelectedState(viewId);
        }
        //响应点击事件
        switch (viewId) {
            case R.id.main_menu_cost:
                setTitle("行车花费");
                showIcheCostFragment();
                break;
            case R.id.main_menu_option:
                setTitle("更多");
                break;
        }
    }

    private void showIcheCostFragment() {
        IcheCostFragment fragment = new IcheCostFragment();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);
        getSupportFragmentManager().beginTransaction().replace(R.id.center_content, fragment).commit();

    }
}
