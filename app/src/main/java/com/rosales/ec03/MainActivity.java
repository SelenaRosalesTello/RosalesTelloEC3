package com.rosales.ec03;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.rosales.ec03.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    //private Button btnGetStarted;
    private ActivityMainBinding binding ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.btnGetStarted.setOnClickListener(v->{
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
            finish();

        });
        binding.txtMoview.setText(R.string.get_started_title);

    }
}