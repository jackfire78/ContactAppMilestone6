package com.example.jackf.contactapp;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class Adapter extends BaseAdapter {

    Activity mActivity;
    AddressBook addressBook;

    public Adapter(Activity mActivity, AddressBook addressBook){
        this.mActivity = mActivity;
        this.addressBook = addressBook;
    }

    @Override
    public int getCount() {
        return addressBook.getLists().size();
    }

    @Override
    public BaseContact getItem(int position) {
        return addressBook.getLists().get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View onePersonLine;

        LayoutInflater inflater = (LayoutInflater) mActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        onePersonLine = inflater.inflate(R.layout.person_one_line, parent, false);

        TextView tv_name = onePersonLine.findViewById(R.id.tv_name);
        TextView tv_phone = onePersonLine.findViewById(R.id.tv_phone);
        ImageView iv_icon = onePersonLine.findViewById(R.id.iv_icon);

        BaseContact p = this.getItem(position);

        tv_name.setText(p.getName());
        tv_phone.setText(p.getPhone());

        int icon_resource_numbers [] = {
                R.drawable.icon01_01,
                R.drawable.icon01_02,
                R.drawable.icon01_03,
                R.drawable.icon01_04,
                R.drawable.icon01_05,
                R.drawable.icon01_06,
                R.drawable.icon01_07,
                R.drawable.icon01_08,
                R.drawable.icon01_09,
                R.drawable.icon01_10,
        };
        iv_icon.setImageResource(icon_resource_numbers[p.getPictureNum()]);
        return onePersonLine;
    }

}
