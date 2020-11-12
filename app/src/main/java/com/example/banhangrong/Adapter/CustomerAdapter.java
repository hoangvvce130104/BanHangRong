package com.example.banhangrong.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.banhangrong.R;

public class CustomerAdapter extends BaseAdapter {
    public CustomerAdapter(Context context, int layout ) {
        this.layout = layout;
        this.context = context;

    }

    private int layout;
    private Context context;
    //private ArrayList<Customer> customers;

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(layout, null);
        TextView txtName = convertView.findViewById(R.id.textFoodName);
        TextView txtAddress = convertView.findViewById(R.id.txtFoodAddress);
        ImageButton btnImage = convertView.findViewById(R.id.btnImageFood);
        txtName.setText("Hoang Vu");
        txtAddress.setText("Ninh Kiều, Cần Thơ");
        return convertView;
    }
}
