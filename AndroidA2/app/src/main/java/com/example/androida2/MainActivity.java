package com.example.androida2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.webkit.URLUtil;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    TextInputLayout uriInputLayout;
    TextInputEditText uriInputEditText;
    MaterialButton openURIBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        uriInputLayout=findViewById(R.id.uriInputLayout);
        uriInputEditText=findViewById(R.id.uriEditTxt);
        openURIBtn=findViewById(R.id.openUriBtn);

        openURIBtn.setOnClickListener(view -> {
                openUri();
        });


    }


    private void openUri(){
        String uri=uriInputEditText.getText().toString().trim();
        String errorMsg="Please enter a valid URL";
        hideKeyPad();
        if(!uri.isEmpty()){
            if(URLUtil.isValidUrl(uri)) {
                uriInputLayout.setHelperText("");
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(uri));
                startActivity(intent);
            }else {
                uriInputLayout.setHelperText(errorMsg);
            }
        }else{
            uriInputLayout.setHelperText(errorMsg);
        }

    }

    private void hideKeyPad(){
        View view=findViewById(android.R.id.content);
        if(view!=null){
            InputMethodManager inputMethodManager=(InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(),0);
        }
    }

}