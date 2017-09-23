package com.example.shravan.techlib20;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper myDb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void OnButtonClicked(View View){
        String button_text;
        button_text =((Button)View).getText().toString();


        if(button_text.equals("LOGIN"))
        {
            EditText username_login = (EditText)findViewById(R.id.editText_username_login);
            String username_login_str = username_login.getText().toString();

            EditText password_login = (EditText)findViewById(R.id.editText_password_login);
            String password_login_str = password_login.getText().toString();



            String searched_password = myDb.searchPass(username_login_str,password_login_str);

            if(searched_password.equals(password_login_str))
            {
                //Toast.makeText(MainActivity.this , "login success" , Toast.LENGTH_SHORT).show();
                Intent login = new Intent(this,IndexActivity.class);
                login.putExtra("username" , username_login_str);
                startActivity(login);
            }
            else
            {
                Toast.makeText(MainActivity.this , "login fail" , Toast.LENGTH_SHORT).show();
            }
            /*if(searched_password.equals(password_login_str))
            {
                Intent login = new Intent(this,IndexActivity.class);
                login.putExtra("username" , username_login_str);
                startActivity(login);
            }
            else
            {
                Toast.makeText(MainActivity.this , "Invalid Username or Password!" , Toast.LENGTH_SHORT).show();
            }*/

            //Intent login = new Intent(this,IndexActivity.class);
            //login.putExtra("username" , username_login_str);
            //startActivity(login);*/
        }
        else if (button_text.equals("SIGNUP"))
        {
            Intent signup = new Intent(this,SignupActivity.class);
            startActivity(signup);
        }
    }
}
