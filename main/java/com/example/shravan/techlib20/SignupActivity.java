package com.example.shravan.techlib20;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignupActivity extends Activity {

    DatabaseHelper myDb;

    EditText editfname,editlname,editgenre,editusername,editpassword,editconpassword;
    Button btnAddData;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        myDb = new DatabaseHelper(this);

        editfname = (EditText)findViewById(R.id.editText_fname);
        editlname = (EditText)findViewById(R.id.editText_lname);
        editgenre = (EditText)findViewById(R.id.editText_genre);
        editusername = (EditText)findViewById(R.id.editText_username);
        editpassword = (EditText)findViewById(R.id.editText_pass);
        editconpassword = (EditText)findViewById(R.id.editText_conpass);

        btnAddData = (Button)findViewById(R.id.button_SignUp);

        AddData();
    }

    public  void AddData() {
        btnAddData.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String conpass =  editconpassword.getText().toString();
                        String pass =  editpassword.getText().toString();
                        if(pass.equals(conpass))
                        {
                            boolean isInserted = myDb.insertData(editfname.getText().toString(),
                                    editlname.getText().toString(),
                                    editgenre.getText().toString(),
                                    editusername.getText().toString(),
                                    editpassword.getText().toString());
                            if(isInserted == true)
                                Toast.makeText(SignupActivity.this,"Data Inserted",Toast.LENGTH_LONG).show();
                            else
                                Toast.makeText(SignupActivity.this,"Data not Inserted",Toast.LENGTH_LONG).show();
                        }
                        else
                        {
                            //popup message
                            Toast.makeText(SignupActivity.this , "Err..Passwords don't match!" , Toast.LENGTH_SHORT).show();
                        }

                    }
                }
        );
    }
}
