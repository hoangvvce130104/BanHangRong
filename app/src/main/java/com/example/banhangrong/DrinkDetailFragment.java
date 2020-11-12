package com.example.banhangrong;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.example.banhangrong.Class.Food;
import com.example.banhangrong.Class.FoodImage;
import com.example.banhangrong.Model.FoodModel;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DrinkDetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DrinkDetailFragment extends Fragment {
    private ArrayList<Food> foods;
    private ArrayList<FoodImage> foodImages;
    private LinearLayout itemFood;
    private FoodModel foodModel;
    private TextView textFoodName;
    private TextView txtPrice;
    private TextView txtNumber;
    private TextView txtDes;
    private Button btnUpdate;
    private Button btnDelete;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public DrinkDetailFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DrinkDetailFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DrinkDetailFragment newInstance(String param1, String param2) {
        DrinkDetailFragment fragment = new DrinkDetailFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        foodModel = new FoodModel(getContext());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_drink_detail, container, false);
        int foodID = getArguments().getInt("foodID");
        textFoodName = v.findViewById(R.id.textFoodName);
        txtPrice = v.findViewById(R.id.txtPrice);
        txtNumber = v.findViewById(R.id.txtNumber);
        txtDes = v.findViewById(R.id.txtDescription);
        itemFood = v.findViewById(R.id.listFood);
        btnUpdate = v.findViewById(R.id.btnUpdateFood);
        btnDelete = v.findViewById(R.id.btnDelete);
        foods = foodModel.getFoodByID(foodID);
        //get list Food
        for (int i = 0; i < 1; i++) {
            View view = inflater.inflate(R.layout.item_food, null);
            TextView txtName = view.findViewById(R.id.textFoodName);
            TextView txtAddress = view.findViewById(R.id.txtFoodAddress);
            TextView txtStatus = view.findViewById(R.id.txtStatus);
            ViewFlipper viewFlipper = view.findViewById(R.id.viewFlipper);
            //set text
            txtAddress.setText(foods.get(i).getDescription());
            txtName.setText(foods.get(i).getFoodName());
            if (foods.get(i).getStatus() == 1) {
                btnDelete.setText("Ngừng Kinh Doanh");
                txtStatus.setText("Open");
            } else {
                btnDelete.setText("Mở Bán");
                btnDelete.setBackgroundTintList(getResources().getColorStateList(R.color.buttonAdd));
                txtStatus.setText("Close");
                txtStatus.setTextColor(Color.WHITE);
                txtStatus.setBackgroundTintList(getResources().getColorStateList(R.color.buttonDelete));
            }
            textFoodName.setText(foods.get(i).getFoodName());
            txtNumber.setText(String.valueOf(foods.get(i).getNumber()));
            txtPrice.setText(String.valueOf(foods.get(i).getPrice()));
            txtDes.setText(foods.get(i).getDescription());
            //set image
            foodImages = foodModel.getAllFoodImageByID(foods.get(i).getFoodId());
            //get list Image Food
            for (FoodImage foodImages : foodImages) {
                //get Image
                byte[] image = foodImages.getURL();
                Bitmap bmp = BitmapFactory.decodeByteArray(image, 0, image.length);
                //set adapter for flipper
                ImageView imageView = new ImageView(getContext());
                imageView.setImageBitmap(bmp);
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                //set Slider Image
                viewFlipper.setFlipInterval(3000);
                viewFlipper.setAutoStart(true);
                viewFlipper.addView(imageView);
            }
            //add View
            itemFood.addView(view);
        }
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (foods.get(0).getStatus() == 1) {
                    foodModel.changeStatusFood(0, foodID);
                    // Reload current fragment
                    DrinkFragment drinkFragment = new DrinkFragment();
                    FragmentManager manager = getFragmentManager();
                    manager.beginTransaction().replace(R.id.fragment,drinkFragment,drinkFragment.getTag()).commit();
                } else {
                    foodModel.changeStatusFood(1, foodID);
                    // Reload current fragment
                    DrinkFragment drinkFragment = new DrinkFragment();
                    FragmentManager manager = getFragmentManager();
                    manager.beginTransaction().replace(R.id.fragment,drinkFragment,drinkFragment.getTag()).commit();
                }
            }
        });
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String foodName = textFoodName.getText().toString();
                String des = txtDes.getText().toString();
                Float price = Float.parseFloat(txtPrice.getText().toString());
                int number = Integer.parseInt(txtNumber.getText().toString());
                foodModel.editFood(foodID,foodName,price,number,des);
                // Reload current fragment
                FoodFragment foodFragment = new FoodFragment();
                FragmentManager manager = getFragmentManager();
                manager.beginTransaction().replace(R.id.fragment,foodFragment,foodFragment.getTag()).commit();
            }
        });
        return v;
    }
}