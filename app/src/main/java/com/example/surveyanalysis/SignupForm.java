package com.example.surveyanalysis;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.surveyanalysis.model.UserInfo;
import com.example.surveyanalysis.retrofit.RetrofitConnection;
import com.example.surveyanalysis.service.SurveyanalysisService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignupForm extends AppCompatActivity {
    EditText regFullNameId;
    EditText regUserNameId;
    EditText regEmailId;
    EditText regPasswordId;
    Button btn_regSubmi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_form);
        getSupportActionBar().setTitle("Singup Form");
        regFullNameId=findViewById(R.id.regFullNameId);
        regUserNameId=findViewById(R.id.regUserNameId);
        regEmailId=findViewById(R.id.regEmailId);
        regPasswordId=findViewById(R.id.regPasswordId);
        btn_regSubmi=findViewById(R.id.btn_regSubmi);
        btn_regSubmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              String fullName=regFullNameId.getText().toString();
                String userName=regUserNameId.getText().toString();
                String email=regEmailId.getText().toString();
                String password=regPasswordId.getText().toString();
                SurveyanalysisService service = RetrofitConnection.getRetrofitInstance().create(SurveyanalysisService.class);
                 UserInfo userInfo= new UserInfo();
                userInfo.setFirstName(fullName);
                userInfo.setUsername(userName);
                userInfo.setEmail(email);
                userInfo.setPassword(password);
                Call<UserInfo> call=service.register(userInfo);
                call.enqueue(new Callback<UserInfo>() {
                    @Override
                    public void onResponse(Call<UserInfo> call, Response<UserInfo> response) {
                        UserInfo userInfo=response.body();
                        Toast.makeText(getApplicationContext(),"Save successfully", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<UserInfo> call, Throwable t) {
                        Toast.makeText(getApplicationContext(),"Save faield", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}
