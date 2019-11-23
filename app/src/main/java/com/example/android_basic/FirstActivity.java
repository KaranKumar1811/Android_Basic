package com.example.android_basic;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

public class FirstActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText editText;
    private Button btnGoNext;
    private ToggleButton tBtn;
    private TextView txtColor;
    private Switch aSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        editText=findViewById(R.id.nameEditText);
        btnGoNext=findViewById(R.id.btn);
        tBtn=findViewById(R.id.toggleButton);
        txtColor=findViewById(R.id.txtColor);
        aSwitch=findViewById(R.id.switch1);
        btnGoNext.setOnClickListener(this);
    tBtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if(tBtn.isChecked())
                {
                    txtColor.setTextColor(Color.BLUE);
                editText.setText(editText.getText().toString().toLowerCase());
                }
            else{
                    txtColor.setTextColor(Color.RED);
                    editText.setText(editText.getText().toString().toUpperCase());
                }

            }
    });


    aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if(aSwitch.isChecked())
            {
                txtColor.setTextColor(Color.BLUE);
                editText.setText(editText.getText().toString().toLowerCase());
            }
            else{
                txtColor.setTextColor(Color.RED);
                editText.setText(editText.getText().toString().toUpperCase());
            }

        }
    });

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
