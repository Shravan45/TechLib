package com.example.shravan.techlib20;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class IndexActivity extends Activity{

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);

        String username_logged_in = getIntent().getStringExtra("username");
        TextView usr = (TextView)findViewById(R.id.textView_username_logged_in);
        usr.setText(username_logged_in);

    }
}
