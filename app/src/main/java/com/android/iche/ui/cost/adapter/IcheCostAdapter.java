package com.android.iche.ui.cost.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.iche.R;
import com.android.iche.entry.CostCategory;
import com.android.library.base.BaseViewHolder;

import java.util.List;

import butterknife.Bind;

/**
 * Created by dugang on 2016/02/19.
 */
public class IcheCostAdapter extends BaseAdapter {
    private Context mContext;
    private List<CostCategory> mCategories;

    public IcheCostAdapter(Context context, List<CostCategory> categories) {
        mContext = context;
        mCategories = categories;
    }

    @Override
    public int getCount() {
        return mCategories.size();
    }

    @Override
    public CostCategory getItem(int position) {
        return mCategories.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_gv_cost_category, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.init(getItem(position));
        return convertView;
    }

    public class ViewHolder extends BaseViewHolder {
        @Bind(R.id.item_iv) ImageView category_icon;
        @Bind(R.id.item_tv) TextView category_name;

        public ViewHolder(View view) {
            super(view);
        }

        public void init(CostCategory costCategory) {
            int iconId = mContext.getResources().getIdentifier(costCategory.getIcon(), "mipmap", mContext.getPackageName());
            category_icon.setImageResource(iconId);
            category_name.setText(costCategory.getName());
        }
    }
}
