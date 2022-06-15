package com.example.appshub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.appshub.databinding.ActivityEncryptBinding;
import com.example.appshub.databinding.ActivityMainBinding;

public class cryptography extends AppCompatActivity {
    ActivityEncryptBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(getWindow().FEATURE_NO_TITLE);
        binding= ActivityEncryptBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().hide();
        setContentView(R.layout.activity_encrypt);


        Button enc, dec;



        // link both the button variables with its id
        enc = findViewById(R.id.btVar1);
        dec = findViewById(R.id.btVar2);

        // onClick function for encryption
        enc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Intent function to move to another activity
                Intent intent = new Intent(getApplicationContext(), Encoder.class);
                startActivity(intent);
            }
        });

        // onClick function for decryption
        dec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Intent function to move to another activity
                Intent intent = new Intent(getApplicationContext(), Decoder.class);
                startActivity(intent);
            }
        });
    }
}
