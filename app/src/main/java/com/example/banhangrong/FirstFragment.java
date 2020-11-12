package com.example.banhangrong;

import android.content.Context;
import android.os.Bundle;
import android.view.View.OnClickListener;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.banhangrong.Class.SellerAccount;
import com.example.banhangrong.Model.DatabaseHandler;
import com.example.banhangrong.Model.SellerAccountModel;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FirstFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FirstFragment extends Fragment {
    HorizontalScrollView customerScroll;
    DatabaseHandler database;
    SellerAccountModel sam;
    ArrayList<SellerAccount> sellerAccounts;
    private LinearLayout itemCustomer;
    private ImageView imgFood;
    private ImageView imgDrink;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FirstFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FirstFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FirstFragment newInstance(String param1, String param2) {
        FirstFragment fragment = new FirstFragment();
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
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_first, container, false);
        //set Scroll Customer
        customerScroll = v.findViewById(R.id.customerScroll);
        itemCustomer = v.findViewById(R.id.listCustomer);
        imgFood =  v.findViewById(R.id.imgFood);
        imgDrink = v.findViewById(R.id.imgDrink);
        Context context = inflater.getContext();
        database = new DatabaseHandler(context);
        sam = new SellerAccountModel(context);
        sellerAccounts = sam.getAllSelers();
        //set value for scroll
        for (int i = 1; i < 5; i++) {
            View view = inflater.inflate(R.layout.item_customer, null);
            TextView txtName = view.findViewById(R.id.textFoodName);
            TextView txtAddress = view.findViewById(R.id.txtFoodAddress);
            TextView txtKilometer = view.findViewById(R.id.txtKilometer);
            txtAddress.setText(sellerAccounts.get(0).getAddress() + i);
            txtName.setText(sellerAccounts.get(0).getSellerName() + i);
            txtKilometer.setText((float) i + " Km");
            itemCustomer.addView(view);
        }
        imgFood.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                FoodFragment foodFragment = new FoodFragment();
                FragmentManager manager = getFragmentManager();
                manager.beginTransaction().replace(R.id.fragment,foodFragment,foodFragment.getTag()).commit();
            }
        });
        imgDrink.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                DrinkFragment drinkFragment = new DrinkFragment();
                FragmentManager manager = getFragmentManager();
                manager.beginTransaction().replace(R.id.fragment,drinkFragment,drinkFragment.getTag()).commit();
            }
        });
        return v ;
    }


}