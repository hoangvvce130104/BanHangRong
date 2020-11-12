package com.example.banhangrong;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

import com.example.banhangrong.Class.Food;
import com.example.banhangrong.Class.FoodImage;
import com.example.banhangrong.Model.FoodModel;

import java.util.ArrayList;

public class FoodAdapter extends BaseAdapter implements Filterable {
    private Context context;
    private ArrayList<Food> foods;
    private ArrayList<Food> tempFoods;
    private ArrayList<FoodImage> foodsImages;
    private int layout;
    private FoodModel foodModel;
    FragmentManager fragmentManager;
    CustomFiller customFiller;
    public FoodAdapter(Context context, ArrayList<Food> foods, int layout, FragmentManager fragmentManager) {
        this.context = context;
        this.foods = foods;
        this.layout = layout;
        this.fragmentManager = fragmentManager;
        this.tempFoods = foods;
        foodModel = new FoodModel(context);
    }

    @Override
    public int getCount() {
        return foods.size();
    }

    @Override
    public Object getItem(int position) {
        return foods.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(layout, null);
        TextView txtName = convertView.findViewById(R.id.textFoodName);
        TextView txtAddress = convertView.findViewById(R.id.txtFoodAddress);
        TextView txtStatus = convertView.findViewById(R.id.txtStatus);
        ViewFlipper viewFlipper = convertView.findViewById(R.id.viewFlipper);
        //set text
        txtAddress.setText(foods.get(position).getDescription());
        txtName.setText(foods.get(position).getFoodName());
        if (foods.get(position).getStatus() == 1) {
            txtStatus.setText("Open");
        } else {
            txtStatus.setText("Close");
            txtStatus.setTextColor(Color.WHITE);
            txtStatus.setBackgroundTintList(context.getResources().getColorStateList(R.color.buttonDelete));
        }Log.e("Size food image",foods.get(position).getFoodId()+"");
        foodsImages = foodModel.getAllFoodImageByID(foods.get(position).getFoodId());

        for (FoodImage foodImages : foodsImages) {
            //get Image
            byte[] image = foodImages.getURL();
            Bitmap bmp = BitmapFactory.decodeByteArray(image, 0, image.length);
            //set adapter for flipper
            ImageView imageView = new ImageView(context);
            imageView.setImageBitmap(bmp);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            //set Slider Image
            viewFlipper.setFlipInterval(3000);
            viewFlipper.setAutoStart(true);
            viewFlipper.addView(imageView);
            int id = foods.get(position).getFoodId();
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    DrinkDetailFragment drinkDetailFragment = new DrinkDetailFragment();
                    //FragmentManager manager = getFragmentManager();
                    Bundle bundle = new Bundle();
                    bundle.putInt("foodID", id);
                    //set Fragmentclass Arguments
                    drinkDetailFragment.setArguments(bundle);
                    fragmentManager.beginTransaction().replace(R.id.fragment, drinkDetailFragment, drinkDetailFragment.getTag()).commit();

                }
            });
        }
        return convertView;
    }

    @Override
    public Filter getFilter() {
        if(customFiller == null){
            customFiller = new CustomFiller();
        }
        return customFiller;
    }

    class CustomFiller extends Filter {

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults results = new FilterResults();
            if (constraint != null && constraint.length() > 0) {
                constraint = constraint.toString().toUpperCase();
                ArrayList<Food> foodCurrent = new ArrayList<>();
                for (int i = 0; i < tempFoods.size(); i++) {
                    if (tempFoods.get(i).getFoodName().toUpperCase().contains(constraint)) {
                        Food f = new Food(tempFoods.get(i).getFoodId(),tempFoods.get(i).getFoodName(), tempFoods.get(i).getSellID(), tempFoods.get(i).getTypeID(), tempFoods.get(i).getPrice(),
                                tempFoods.get(i).getNumber(), tempFoods.get(i).getDescription(), tempFoods.get(i).getStatus());
                        foodCurrent.add(f);
                    }
                }
                results.count = foodCurrent.size();
                results.values = foodCurrent;
            } else {
                results.count = tempFoods.size();
                results.values = tempFoods;
            }
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            foods = (ArrayList<Food>) results.values;
            notifyDataSetChanged();
        }
    }
}
