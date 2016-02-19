package com.android.library.base;

import android.view.View;

import butterknife.ButterKnife;

/**
 * Created by dugang on 2016/02/19.
 */
public class BaseViewHolder {

    public BaseViewHolder(View view) {
        ButterKnife.bind(this, view);
    }
}
