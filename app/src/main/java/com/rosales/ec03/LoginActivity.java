package com.rosales.ec03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.View;
import android.widget.Toast;

import com.rosales.ec03.databinding.ActivityLoginBinding;

import java.util.regex.Pattern;

public class LoginActivity extends AppCompatActivity {
    private ActivityLoginBinding binding  ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.btnLogin.setOnClickListener(v -> {
            //Toast.makeText(this,"Login Press", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, PrincipalActivity.class);
            intent.putExtra(PrincipalActivity.EMAIL,binding.tilEmail.getEditText().getText().toString());
            startActivity(intent);
            finish();
        });
        binding.tilEmail.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                boolean isOk = isCredentialsValidate(s.toString(),binding.tilPassword.getEditText().getText().toString());
                binding.btnLogin.setEnabled(isOk);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        binding.tilPassword.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                boolean isOk = isCredentialsValidate(binding.tilEmail.getEditText().getText().toString(),s.toString());
                binding.btnLogin.setEnabled(isOk);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private boolean isCredentialsValidate(String email, String password){
        boolean isEmailOk = (!email.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()) || email.equals("ejemplo@idat.com.pe");
        boolean isPasswordOk = (password.length() >= 8) || password.equals("Peru123.");
        return isEmailOk && isPasswordOk;
    }
}