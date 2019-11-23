package com.example.android_basic;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class FirstActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText editText;
    private Button btnGoNext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        editText=findViewById(R.id.nameEditText);
        btnGoNext=findViewById(R.id.btn);

        btnGoNext.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
     if(editText.getText().toString().trim().length()!=0)
     {
         Intent i=new Intent(FirstActivity.this,SecondActivity.class);
         i.putExtra("name",editText.getText().toString());
         startActivity(i);
     }
     else {
         //editText.setError("Please Enter Name");
         showAlert();
     }
    }

    private void showAlert()
    {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setIcon(R.drawable.ic_person);
        alertDialogBuilder.setTitle("Login Error");
        alertDialogBuilder.setMessage("Please Enter Your Name");
        alertDialogBuilder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        alertDialogBuilder.setNegativeButtonIcon(getResources().getDrawable(R.drawable.ic_person));
         AlertDialog alertDialog = alertDialogBuilder.create();
         alertDialog.show();

    }
}
