package com.example.appshub;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.appshub.databinding.ActivityContactBinding;

public class contact extends AppCompatActivity {
   ActivityContactBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityContactBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}