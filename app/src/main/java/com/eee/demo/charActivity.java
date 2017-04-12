package com.eee.demo;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

/**
 * Created by li124 on 2017/3/19.
 */

public class charActivity extends AppCompatActivity implements View.OnClickListener{
    Button button;
    ImageView imageView;
    TextView topic;
    TextView status;
    TextView tv_health,tv_power,tv_sen;
    ProgressBar pb_health,pb_power,pb_sen;
    int kind=1;// this will change the shop`s Item!

        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_char);
            button=(Button)findViewById(R.id.shop);
            topic=(TextView)findViewById(R.id.text);
            tv_health=(TextView)findViewById(R.id.healthNum);
            tv_power=(TextView)findViewById(R.id.powerNum);
            tv_sen=(TextView)findViewById(R.id.senNum);
            status=(TextView)findViewById(R.id.status);
            imageView=(ImageView)findViewById(R.id.TX);
            pb_health=(ProgressBar)findViewById(R.id.healthBar);
            pb_power=(ProgressBar)findViewById(R.id.powerBar);
            pb_sen=(ProgressBar)findViewById(R.id.senBar);
            button.setOnClickListener(this);
            Intent get=getIntent();
            String username=get.getStringExtra("username");
            String sex=get.getStringExtra("sex");
            if(sex.equals("man")){
                topic.setText(username+"`s character is Soldier76");
                imageView.setBackground(getDrawable(R.drawable.soldier76));
                kind=1;
            }
            else if(sex.equals("woman")){
                topic.setText(username+"`s character is Mercy");
                imageView.setBackground(getDrawable(R.drawable.angel));
                kind=2;
            }
            initProgress();

        }
    public void onClick(View view){
        Intent intent=new Intent(charActivity.this,shopActivity.class);
        intent.putExtra("kind",kind);
        startActivityForResult(intent,1001);
    }
    public void initProgress(){
        int x;
        pb_health.setMax(100);
        pb_power.setMax(100);
        pb_sen.setMax(100);
        if (kind==1){
            pb_health.setProgress(80);
            pb_power.setProgress(70);
            pb_sen.setProgress(60);
            tv_health.setText(pb_health.getProgress()+"");
            tv_power.setText(pb_power.getProgress()+"");
            tv_sen.setText(pb_sen.getProgress()+"");
            x=pb_health.getProgress();
            judgeStatus(x);
        }else if(kind==2){
            pb_health.setProgress(60);
            pb_power.setProgress(40);
            pb_sen.setProgress(80);
            tv_health.setText(pb_health.getProgress()+"");
            tv_power.setText(pb_power.getProgress()+"");
            tv_sen.setText(pb_sen.getProgress()+"");
            x=pb_health.getProgress();
            judgeStatus(x);
        }
    }
    @Override
    protected void onActivityResult(int requestCode,int resultCode,Intent data){
        if(data!=null){
            if(resultCode==1001){
                if(requestCode==1001){
                    ItemShop info =(ItemShop) data.getSerializableExtra("Gears");
                    updataProgressBar(info);
                }
            }
        }
    }
//    @Override
//    public void onActivityResult(int requestCode,int resultCode,Intent data){
//        switch (resultCode){
//            case 1001:
//                if(requestCode==1){
//                    ItemShop itemShop=(ItemShop)data.getSerializableExtra("Gears");
//                    updataProgressBar(itemShop);
//                }
//                break;
//        }
//
//    }
    public void updataProgressBar(ItemShop itemShop){
        int p1,p2,p3,x;
        p1=pb_health.getProgress();
        p2=pb_power.getProgress();
        p3=pb_sen.getProgress();
        pb_health.setProgress(p1+itemShop.getHealth());
        pb_power.setProgress(p2+itemShop.getPower());
        pb_sen.setProgress(p3+itemShop.getSen());
        tv_health.setText(pb_health.getProgress()+"");
        tv_power.setText(pb_power.getProgress()+"");
        tv_sen.setText(pb_sen.getProgress()+"");
        x=pb_health.getProgress();
        judgeStatus(x);
    }

    public void judgeStatus(int x){
       x= pb_health.getProgress();
        if(x>0&&x<=25) {
            status.setText("Warning");
            status.setTextColor(Color.rgb(255, 0, 0));
        }else if (x>25&&x<=70){
            status.setText("Good");
            status.setTextColor(Color.rgb(255,255,0));
        }else if(x>70&&x<=100){
            status.setText("Wonderful");
            status.setTextColor(Color.rgb(0,255,0));
        }

    }
}
