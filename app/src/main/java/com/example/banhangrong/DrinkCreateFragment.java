package com.example.banhangrong;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.banhangrong.Class.Food;
import com.example.banhangrong.Class.FoodImage;
import com.example.banhangrong.Model.FoodModel;

import java.io.ByteArrayOutputStream;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DrinkCreateFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DrinkCreateFragment extends Fragment {
    private ImageView imgView;
    private ImageView imgView2;
    private ImageView imgView3;
    private ImageButton btnDelete1;
    private ImageButton btnDelete2;
    private ImageButton btnDelete3;
    private Button btnReturn;
    private Button btnAddFood;
    private TextView txtFoodName;
    private TextView txtPrice;
    private TextView txtDes;
    private TextView txtNumber;
    private static final int IMAGE_PICK_CODE = 1000;
    private static final int PERMISSTION_CODE = 100;
    private int check = 0;
    FoodModel foodModel;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public DrinkCreateFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DrinkCreateFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DrinkCreateFragment newInstance(String param1, String param2) {
        DrinkCreateFragment fragment = new DrinkCreateFragment();
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
        View v = inflater.inflate(R.layout.fragment_drink_create, container, false);
        imgView = v.findViewById(R.id.imgView);
        imgView2 = v.findViewById(R.id.imgView2);
        imgView3 = v.findViewById(R.id.imgView3);
        btnDelete1 = v.findViewById(R.id.btnDelete1);
        btnDelete2 = v.findViewById(R.id.btnDelete2);
        btnDelete3 = v.findViewById(R.id.btnDelete3);
        btnReturn = v.findViewById(R.id.btnReturn);
        btnAddFood = v.findViewById(R.id.btnAddFood);
        txtDes = v.findViewById(R.id.txtDescription);
        txtFoodName = v.findViewById(R.id.textFoodName);
        txtNumber = v.findViewById(R.id.txtNumber);
        txtPrice = v.findViewById(R.id.txtPrice);
        //hidden button
        btnDelete1.setVisibility(View.GONE);
        btnDelete2.setVisibility(View.GONE);
        btnDelete3.setVisibility(View.GONE);
        imgView.setImageResource(R.drawable.ic_action_add);
        imgView2.setImageResource(R.drawable.ic_action_add);
        imgView3.setImageResource(R.drawable.ic_action_add);
        //set onlick button
        imgView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requestPermission();
                check = 1;
            }
        });
        imgView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requestPermission();
                check = 2;
            }
        });
        imgView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requestPermission();
                check = 3;
            }

        });
        btnDelete1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgView.setImageResource(R.drawable.ic_action_add);
                btnDelete1.setVisibility(View.GONE);
            }
        });
        btnDelete2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgView2.setImageResource(R.drawable.ic_action_add);
                btnDelete2.setVisibility(View.GONE);
            }
        });
        btnDelete3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgView3.setImageResource(R.drawable.ic_action_add);
                btnDelete3.setVisibility(View.GONE);
            }
        });
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FoodFragment foodFragment = new FoodFragment();
                FragmentManager manager = getFragmentManager();
                manager.beginTransaction().replace(R.id.fragment,foodFragment,foodFragment.getTag()).commit();
            }
        });
        btnAddFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameFood = txtFoodName.getText().toString();
                Float price = Float.parseFloat(txtPrice.getText().toString());
                String des = txtDes.getText().toString();
                int number = Integer.parseInt(txtNumber.getText().toString());
                int sellerID = 1;
                int typeID = 2;
                int status = 1;
                int foodID = foodModel.addFood(new Food(nameFood,sellerID,typeID,price,number,des,status));
                if(foodID>0){
                    if(imgView.getDrawable()!=null){
                        Bitmap bitmap = ((BitmapDrawable) imgView.getDrawable()).getBitmap();
                        foodModel.addFoodImage(new FoodImage(getBitmapAsByteArray(bitmap),foodID,1));
                    }
                    if(imgView2.getDrawable()!=null){
                        Bitmap bitmap = ((BitmapDrawable) imgView2.getDrawable()).getBitmap();
                        foodModel.addFoodImage(new FoodImage(getBitmapAsByteArray(bitmap),foodID,1));
                    }
                    if(imgView3.getDrawable()!=null){
                        Bitmap bitmap = ((BitmapDrawable) imgView3.getDrawable()).getBitmap();
                        foodModel.addFoodImage(new FoodImage(getBitmapAsByteArray(bitmap),foodID,1));
                    }
                    DrinkFragment drinkFragment = new DrinkFragment();
                    FragmentManager manager = getFragmentManager();
                    manager.beginTransaction().replace(R.id.fragment,drinkFragment,drinkFragment.getTag()).commit();
                }else{
                    Toast.makeText(getContext(), "Add Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return v;
    }
    public static byte[] getBitmapAsByteArray(Bitmap bitmap) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 0, outputStream);
        return outputStream.toByteArray();
    }
    public void requestPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
                //not granted
                requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, PERMISSTION_CODE
                );

            } else {
                //already granted
                pickImageFromGallery();
            }
        } else {
            pickImageFromGallery();
        }
    }

    private void pickImageFromGallery() {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*");
        intent.putExtra("extra", 1);
        startActivityForResult(intent, IMAGE_PICK_CODE);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case PERMISSTION_CODE: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    pickImageFromGallery();
                } else {
                    Toast.makeText(getContext(), "Denied", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == IMAGE_PICK_CODE) {
            switch (check) {
                case 1:
                    imgView.setImageURI(data.getData());
                    btnDelete1.setVisibility(View.VISIBLE);
                    check = 0;
                    break;
                case 2:
                    imgView2.setImageURI(data.getData());
                    btnDelete2.setVisibility(View.VISIBLE);
                    check = 0;
                    break;
                case 3:
                    imgView3.setImageURI(data.getData());
                    btnDelete3.setVisibility(View.VISIBLE);
                    check = 0;
                    break;
                default:
                    break;
            }
        }
    }
}