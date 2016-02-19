package com.android.iche.ui.cost;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.alibaba.fastjson.JSON;
import com.android.iche.R;
import com.android.iche.entry.CostCategory;
import com.android.iche.ui.cost.adapter.IcheCostAdapter;
import com.android.library.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * Created by dugang on 2016/02/19.行车花费
 */
public class IcheCostFragment extends BaseFragment {
    @Bind(R.id.costCategories) GridView costCategories;

    private List<CostCategory> mCostCategories = new ArrayList<>();
    private IcheCostAdapter mIcheCostAdapter;

    @Override
    protected View inflaterLayoutView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_iche_cost, container, false);
    }

    @Override
    protected void initData() {
        mIcheCostAdapter = new IcheCostAdapter(getActivity(),mCostCategories);
        costCategories.setAdapter(mIcheCostAdapter);
        costCategories.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });

        String json = getString(R.string.cost_category);
        mCostCategories.addAll(JSON.parseArray(json, CostCategory.class));
        mIcheCostAdapter.notifyDataSetChanged();
    }
}
