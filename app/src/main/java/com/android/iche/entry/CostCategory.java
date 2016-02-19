package com.android.iche.entry;

import android.os.Parcel;

import com.android.library.base.BaseObject;

/**
 * Created by dugang on 2016/02/19.花费分类
 */
public class CostCategory extends BaseObject {
    private String name;
    private String icon;
    private int type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.icon);
        dest.writeInt(this.type);
    }

    public CostCategory() {
    }

    protected CostCategory(Parcel in) {
        this.name = in.readString();
        this.icon = in.readString();
        this.type = in.readInt();
    }

    public static final Creator<CostCategory> CREATOR = new Creator<CostCategory>() {
        public CostCategory createFromParcel(Parcel source) {
            return new CostCategory(source);
        }

        public CostCategory[] newArray(int size) {
            return new CostCategory[size];
        }
    };
}
