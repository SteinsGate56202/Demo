package com.eee.demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by li124 on 2017/3/19.
 */

public class shopActivity extends AppCompatActivity implements View.OnClickListener{
    TextView health,power,sen,name;
    TextView health2,power2,sen2,name2;
    ImageView imageView;
    ImageView imageView2;
    private ItemShop item1,item2,item3;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shop);
        findViewById(R.id.item1).setOnClickListener(this);
        health=(TextView)findViewById(R.id.addHealth1);
        power=(TextView)findViewById(R.id.addPower1);
        sen=(TextView)findViewById(R.id.addSen1);
        name=(TextView)findViewById(R.id.itemName1);
        imageView=(ImageView)findViewById(R.id.skill1);
        findViewById(R.id.item2).setOnClickListener(this);
        health2=(TextView)findViewById(R.id.addHealth2);
        power2=(TextView)findViewById(R.id.addPower2);
        sen2=(TextView)findViewById(R.id.addSen2);
        name2=(TextView)findViewById(R.id.itemName2);
        imageView2=(ImageView)findViewById(R.id.skill2);
//        Intent get=getIntent();
//        int kind=get.getIntExtra("kind",1);

            item1 = new ItemShop("Tactical Eyepiecee", 10, 40, 10);
            name.setText(item1.getName() + "");
            health.setText("Health++" + item1.getHealth());
            power.setText("Power++" + item1.getPower());
            sen.setText("Sen++" + item1.getSen());
            imageView.setImageResource(R.drawable.skill_76);

            item2 = new ItemShop("Hero Never Die", 20, 10, 40);
            name2.setText(item2.getName() + "");
            health2.setText("Health++" + item2.getHealth());
            power2.setText("Power++" + item2.getPower());
            sen2.setText("Sen++" + item2.getSen());
            imageView2.setImageResource(R.drawable.skill_mercy);

    }
    public void onClick(View view){
        switch (view.getId()){
            case R.id.item1:
                Intent put1 =new Intent(shopActivity.this,charActivity.class);
                put1.putExtra("Gears",item1);
                setResult(1001,put1);
                finish();
                break;
            case R.id.item2:
                Intent put2 =new Intent(shopActivity.this,charActivity.class);
                put2.putExtra("Gears",item2);
                setResult(1001,put2);
                finish();
                break;
        }
    }
}
