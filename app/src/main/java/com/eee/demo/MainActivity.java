package com.eee.demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener{
    Button b1,b2;
    RadioButton r1,r2;
    EditText et1,et2;
    String username,password;
    int sex ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        b1=(Button)findViewById(R.id.bt_register);
        b2=(Button)findViewById(R.id.bt_cancel);
        r1=(RadioButton)findViewById(R.id.man);
        r2=(RadioButton)findViewById(R.id.woman);
        et1=(EditText)findViewById(R.id.et_username);
        et2=(EditText)findViewById(R.id.et_password);
        b1.setOnClickListener(this);
    }
    public void onClick(View view){
        switch (view.getId()){
            case R.id.bt_register:
                username=et1.getText().toString();
                password=et2.getText().toString();
                if (r1.isChecked()){
                    sex=1;
                }else if (r2.isChecked()){
                    sex=2;
                }
                passData();
                break;
            case R.id.bt_cancel:

                break;
        }
    }
    public void passData(){
        Intent intent =new Intent(this,infoActivity.class);
        Bundle bundle =new Bundle();
        bundle.putString("username",username);
        bundle.putString("password",password);
        bundle.putInt("sex",sex);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
