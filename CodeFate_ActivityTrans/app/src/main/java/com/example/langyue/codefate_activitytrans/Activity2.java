package com.example.langyue.codefate_activitytrans;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

/**
 * Created by langyue on 16/8/24.
 */

public class Activity2 extends Activity {

    Button btnBackMain1;


    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);


        setContentView(R.layout.main2);
        Log.e("Activity2", "onCreate: ");//显示当前状态 onCreate与onDestroy对应
        //加载爱车tivity2.xml

        //得到Intent中的Bundle对象
        Bundle bundle = this.getIntent().getExtras();
        //取得Bundle对象中的对象
        //Log.i("In_Text", bundle.getString("Text"));
        btnBackMain1=(Button)this.findViewById(R.id.main2_Btn01);

        btnBackMain1.setOnClickListener(new ClickEvent());

    }


    @Override
    public void onDestroy(){
        super.onDestroy();
        Log.e("TAG", "onDestroy: ");//显示当前状态 onCreate与onDestroy对应
    }

    @Override
    public void onStart(){
        super.onStart();
        Log.e("TAG", "onStart: ");//显示当前状态,onStart与onStop对应
    }

    @Override
    public void onStop(){
        super.onStop();
        Log.e("TAG", "onStop: ");//显示当前状态,onStart与onStop对应
    }

    @Override
    public void onRestart(){
        super.onRestart();
        Log.e("TAG", "onRestart: ");
    }

    @Override
    public void onResume(){
        super.onResume();
        Log.e("TAG", "onResume: ");
    }


    @Override
    public void onPause(){
        super.onPause();
        Log.e("TAG", "onPause: ");
    }






    class ClickEvent implements View.OnClickListener{

        @Override
        public void onClick(View v){

            if (v==btnBackMain1){

                Intent intent = new Intent();
                intent.setClass(Activity2.this,Activity1.class);
                //调用Activity1
                startActivity(intent);
                Activity2.this.finish();//会触发onDestroy();

            }
        }

    }


}
