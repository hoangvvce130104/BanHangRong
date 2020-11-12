package com.example.banhangrong;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.List;

public class Login extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener {
    private SellerAccountModel sellerAccountModel;
    private Button btnLogin;
    private SignInButton btnGmail;
    private EditText txtPhone, txtPassword;
    private GoogleApiClient googleApiClient;
    private static final int SIGN_IN = 1;


    private TextView txtRegister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_login);
        txtRegister = findViewById(R.id.txtRegister);
        btnLogin = findViewById(R.id.btnLogin);
        txtPhone = findViewById(R.id.txtUsername);
        txtPassword = findViewById(R.id.txtPassword);
        sellerAccountModel = new SellerAccountModel(this);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String checkPhone = txtPhone.getText().toString();
                String checkPass = txtPassword.getText().toString();

                if(!checkPhone.isEmpty()||!checkPass.isEmpty()){
                    List<SellerAccount> list = sellerAccountModel.getAllSelers();
                    for (SellerAccount ac : list) {
                        if(ac.getPhoneNumber().equals(checkPhone) && ac.getPassword().equals(checkPass)){
                            SellerAccount account = ac;
                            Toast.makeText(Login.this, "Login Success", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(Login.this,Home.class);
                            intent.putExtra("Infor",account );
                            startActivity(intent);
                        }
                    }
                    Toast.makeText(Login.this, "Login Fail", Toast.LENGTH_SHORT).show();
                }else{
                    if(checkPhone.isEmpty())
                        txtPhone.setError("Please enter this field");
                    if(checkPass.isEmpty())
                        txtPassword.setError("Please enter this field");
                }

            }
        });


        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        googleApiClient = new GoogleApiClient.Builder(this).enableAutoManage(this,this)
                .addApi(Auth.GOOGLE_SIGN_IN_API,gso).build();
        btnGmail = findViewById(R.id.btnSiginGmail);
        btnGmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = Auth.GoogleSignInApi.getSignInIntent(googleApiClient);
                startActivityForResult(intent,SIGN_IN);
            }
        });

        txtRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this,Register.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == SIGN_IN) {
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            if(result.isSuccess()){
                startActivity(new Intent(Login.this, Home.class));
            }else{
                Toast.makeText(this, "Login with Google fail", Toast.LENGTH_SHORT).show();
            }
        }
    }
}