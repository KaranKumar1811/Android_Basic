package com.example.android_basic;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SecondActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

       Bundle mBundle = getIntent().getExtras();
       textView=findViewById(R.id.txt);
        if(mBundle!=null)
        {
            String name= mBundle.getString("name");
            Log.d("Name",name);
            textView.setText(name);
        }
    }
}
