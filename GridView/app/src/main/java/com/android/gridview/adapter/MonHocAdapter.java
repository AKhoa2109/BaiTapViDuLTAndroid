package com.android.gridview.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.android.gridview.R;
import com.android.gridview.model.MonHoc;

import java.util.List;

public class MonHocAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<MonHoc> monHocList;

    public MonHocAdapter(Context context, int layout, List<MonHoc> monHocList) {
        this.context = context;
        this.layout = layout;
        this.monHocList = monHocList;
    }

    private class ViewHolder{
        protected TextView textName,textDesc;
        protected ImageView imagePic;


        public TextView getTextName() {
            return textName;
        }

        public void setTextName(TextView textName) {
            this.textName = textName;
        }

        public TextView getTextDesc() {
            return textDesc;
        }

        public void setTextDesc(TextView textDesc) {
            this.textDesc = textDesc;
        }

        public ImageView getImagePic() {
            return imagePic;
        }

        public void setImagePic(ImageView imagePic) {
            this.imagePic = imagePic;
        }
    }

    @Override
    public Object getItem(int position) {
        return monHocList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getCount() {
        return monHocList.size();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater)
                    context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout, null);
            viewHolder = new ViewHolder();
            viewHolder.textName = (TextView) view.findViewById(R.id.textView1);
            viewHolder.textDesc = (TextView) view.findViewById(R.id.textView2);
            viewHolder.imagePic = (ImageView) view.findViewById(R.id.imageView);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        MonHoc monHoc = monHocList.get(i);
        viewHolder.textName.setText(monHoc.getName());
        viewHolder.textDesc.setText(monHoc.getDesc());
        viewHolder.imagePic.setImageResource(monHoc.getPic());
        return view;
    }
}



