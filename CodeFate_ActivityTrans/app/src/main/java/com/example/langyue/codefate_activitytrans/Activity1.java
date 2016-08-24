package com.example.langyue.codefate_activitytrans;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by langyue on 16/8/24.
 */

public class Activity1 extends Activity {

    Button btnToInternalActivity;
    Button btnToExternalActivity;
    EditText tbBundle;

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        Log.e("Activity1", "onCreate: ");//显示当前状态 onCreate与onDestroy对应
        setContentView(R.layout.main1);

        btnToInternalActivity = (Button)this.findViewById(R.id.main1_Btn01);
        btnToExternalActivity = (Button)this.findViewById(R.id.main1_Btn02);
        btnToInternalActivity.setOnClickListener(new ClickEvent());
        btnToExternalActivity.setOnClickListener(new ClickEvent());
        tbBundle = (EditText)this.findViewById(R.id.EditText01);

    }




    class ClickEvent implements View.OnClickListener{

        @Override
        public void onClick(View v){

            if (v==btnToInternalActivity){

                Log.e("TAG", "onClick:=======");
                Intent intent = new Intent();
                intent.setClass(Activity1.this,Activity2.class);

                //new 一个BUndle对象 并将要传递的数据传入
                Bundle bundle = new Bundle();
                bundle.putString("Text",tbBundle.getText().toString());

                //将Bundle对象assign给Intent
                intent.putExtras(bundle);

                //调用Activity2
                startActivity(intent);

                Activity1.this.finish();//会触发onDestroy();


            }else if(v == btnToExternalActivity){
                Log.e("TAG", "onClick:+++++++++");
                //有些外部调用需要开启权限
                Uri uri = Uri.parse("http://www.baidu.com");
                Intent it = new Intent(Intent.ACTION_VIEW,uri);
                startActivity(it);


            }


        }

    }





}
