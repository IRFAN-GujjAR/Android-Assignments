package com.example.androida1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import com.example.androida1.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.convertToInches.setOnClickListener(v->{
            String ftTxt= binding.feetEditTxt.getText().toString().trim();
            String errMsg="Enter value greater than 1";
            if(!ftTxt.isEmpty()){
                int ft=Integer.parseInt(ftTxt);
                if(ft<1){
                    binding.feetTxtInputLayout.setHelperText(errMsg);
                }else{
                    hideKeyBoard();
                    Toast toast=Toast.makeText(getApplicationContext(),ftTxt+" Feet = "+convertFeetToInches(ft)+" Inches",Toast.LENGTH_SHORT);
                    toast.show();
                }
            }else{
                binding.feetTxtInputLayout.setHelperText(errMsg);
            }
        });

    }


    private String convertFeetToInches(int feet){
        return Integer.toString(feet*12);
    }

    private void hideKeyBoard(){
        View view = findViewById(android.R.id.content);
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

}