package com.zeroeur.ltmapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Luca on 16/02/2017.
 */

public class LoginActivity extends Activity implements View.OnClickListener{

    EditText usernameET;
    EditText passwordET;



    Button loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // link activity to layout
        setContentView(R.layout.activity_login);

        // assign xml items
        usernameET = (EditText) findViewById(R.id.login_username_et);
        passwordET = (EditText) findViewById(R.id.login_pwd_et);
        loginBtn = (Button) findViewById(R.id.login_btn);


        loginBtn.setOnClickListener(this);

    }


    private boolean doLogin(String username, String password){

        // do something

        return true;

    }

    @Override
    public void onClick(View view) {

        if(view.getId() == R.id.login_btn){
            String username = usernameET.getText().toString();
            String password = passwordET.getText().toString();
            if (doLogin(username, password)) {
                Toast.makeText(LoginActivity.this, getString(R.string.login_success), Toast.LENGTH_SHORT)
                        .show();
                Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }

        }


    }
}
