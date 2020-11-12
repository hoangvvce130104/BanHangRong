package com.example.banhangrong;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.banhangrong.Class.SellerAccount;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.OptionalPendingResult;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.io.InputStream;

public class Profile extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener {
    private TextView txtName, txtGmail, txtA;
    private ImageView avt;
    private Button btnLogout;
    private GoogleApiClient googleApiClient;
    private GoogleSignInOptions gso;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_second);

        avt = findViewById(R.id.imageView);
        txtName = findViewById(R.id.txtName);
        txtGmail = findViewById(R.id.txtGmail);
        btnLogout = findViewById(R.id.btnLogout);

        Intent intent = this.getIntent();
        SellerAccount account = (SellerAccount) intent.getSerializableExtra("Infor");
        if(account != null){
            txtName.setText(account.getSellerName());
            txtGmail.setText(account.getGmail());
            avt.setImageResource(R.drawable.avtdefault);
            }
        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();

        googleApiClient = new GoogleApiClient.Builder(this).enableAutoManage(this,this)
                .addApi(Auth.GOOGLE_SIGN_IN_API,gso).build();

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Auth.GoogleSignInApi.signOut(googleApiClient).setResultCallback(new ResultCallback<Status>() {
                    @Override
                    public void onResult(@NonNull Status status) {
                        if(status.isSuccess()){
                            gotoLogin();
                        }else{
                            Toast.makeText(Profile.this, "Cannot logout", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });


    }
    private void gotoLogin(){
        startActivity(new Intent(Profile.this, Login.class));
        finish();
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    private void handlerSigninResult(GoogleSignInResult result){
        if(result.isSuccess()){
            GoogleSignInAccount in =  result.getSignInAccount();
            txtName.setText(in.getDisplayName());
            txtGmail.setText(in.getEmail());
            Picasso.get().load(in.getPhotoUrl()).placeholder(R.mipmap.ic_launcher).into(avt);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();

        OptionalPendingResult<GoogleSignInResult> opr = Auth.GoogleSignInApi.silentSignIn(googleApiClient);
        if(opr.isDone()){
            GoogleSignInResult result = opr.get();
            handlerSigninResult(result);
        }else{
            opr.setResultCallback(new ResultCallback<GoogleSignInResult>() {
                @Override
                public void onResult(@NonNull GoogleSignInResult googleSignInResult) {
                    handlerSigninResult(googleSignInResult);
                }
            });
        }
    }



}