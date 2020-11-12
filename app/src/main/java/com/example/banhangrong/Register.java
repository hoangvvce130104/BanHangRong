package com.example.banhangrong;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.banhangrong.Class.SellerAccount;
import com.example.banhangrong.Model.SellerAccountModel;

public class Register extends AppCompatActivity {
    private TextView txtLogin;
    private EditText txtName,txtPhoneNumber,txtPassword, txtRepassword;
    private Button btnRegister;
    private SellerAccountModel model;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        txtLogin = findViewById(R.id.txtLogin);
        txtName = findViewById(R.id.txtName);
        txtPhoneNumber = findViewById(R.id.txtPhone);
        txtPassword = findViewById(R.id.txtPassword);
        txtRepassword = findViewById(R.id.txtRePassword);
        btnRegister = findViewById(R.id.btnRegister);
        model = new SellerAccountModel(this);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String checkName = txtName.getText().toString().trim();
                    String checkPassword = txtPassword.getText().toString().trim();
                    String checkRepassword = txtRepassword.getText().toString().trim();
                    String checkPhone = txtPhoneNumber.getText().toString().trim();
                    System.out.println(checkName);
                    if(!checkName.isEmpty() && !checkPassword.isEmpty() && !checkPhone.isEmpty() && !checkRepassword.isEmpty() && checkPassword.equals(checkRepassword)){
                        SellerAccount sellerAccount = new SellerAccount();
                        sellerAccount.setSellerName(txtName.getText().toString());
                        sellerAccount.setPhoneNumber(txtPhoneNumber.getText().toString());
                        sellerAccount.setPassword(txtPassword.getText().toString());
                        if(txtPassword.getText().toString().equals(txtRepassword.getText().toString())){
                            model.addUserAccount(sellerAccount);
                            Toast.makeText(Register.this, "Create new account successful", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(Register.this, "Cannot create account success", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else{
                        if(checkName.isEmpty())
                            txtName.setError("Input this field");
                        if(checkPassword.isEmpty())
                            txtPassword.setError("Input this field");
                        if(checkPhone.isEmpty())
                            txtPhoneNumber.setError("Input this field");
                        if(checkRepassword.isEmpty())
                            txtRepassword.setError("Input this field");
                        if(!checkPassword.equals(checkRepassword))
                            txtRepassword.setError("Password and Re-password not match!!");
                    }
                }catch (Exception e){
                    Toast.makeText(Register.this, "Error Register: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });

        txtLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Register.this,Login.class);
                startActivity(intent);
            }
        });
    }
}
