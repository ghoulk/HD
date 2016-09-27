package com.zeus.ak95.hd;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class First_Login extends AppCompatActivity implements View.OnClickListener {
    EditText et1,et2;
    Button bt1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first__login);
        et1 = (EditText) findViewById(R.id.ft1);
        et2 = (EditText) findViewById(R.id.ft2);
        bt1 = (Button) findViewById(R.id.fb1);

        bt1.setOnClickListener(this);

    }

    @Override
    public void onClick(View v){
        String user = et1.getText().toString().toLowerCase();
        String pass = et2.getText().toString().toLowerCase();

        switch(v.getId()){
            case R.id.fb1 :
                if(user.length()==0||pass.length()==0){
                    Toast t = Toast.makeText(getApplicationContext(),"Enter Username/Password",Toast.LENGTH_SHORT);
                    t.show();
                }
                else {
                    if((user.equals("limca")||user.equals("ak"))&&(pass.equals("sprite")||pass.equals("aa"))){
                        Intent i = new Intent();
                        i.setClass(First_Login.this,Second_Main.class);
                        startActivity(i);
                    }
                    else{
                        Toast t = Toast.makeText(getApplicationContext(),"Incorrect Username/Password",Toast.LENGTH_SHORT);
                        t.show();
                    }
                }

        }
    }

}
