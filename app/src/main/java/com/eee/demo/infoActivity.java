package com.eee.demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by li124 on 2017/3/19.
 */

public class infoActivity extends AppCompatActivity {
    Button button;
    TextView tv1,tv2,tv3;
    public String sex,username,password;

        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_info);
            button=(Button)findViewById(R.id.chara);
            tv1=(TextView)findViewById(R.id.tv_username);
            tv2=(TextView)findViewById(R.id.tv_password);
            tv3=(TextView)findViewById(R.id.tv_sex);
            Intent getData=getIntent();
            Bundle bundle =getData.getExtras();
             username=bundle.getString("username");
             password=bundle.getString("password");
            int code=bundle.getInt("sex");
            if (code==1){
                sex="man";
            }else if (code==2){
                sex="woman";
            }
            tv1.setText("Your username is "+username);
            tv2.setText("Your password is "+password);
            tv3.setText("Your Sex is "+sex);
            pass();
        }
    public void pass(){
        final Intent intent =new Intent(infoActivity.this,charActivity.class);
        intent.putExtra("username",username);
        intent.putExtra("sex",sex);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent);
            }
        });

    }
}
