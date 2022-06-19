package com.example.intelligentfaultdiagnosis;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Message> messagedata=new ArrayList<>();
    private Button button1;
    private EditText editText;
    private MyMessageAdapter MyAdapt;
    ListView listview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listview=findViewById(R.id.List_Vessel);//初始化listview布局
        button1=(Button)findViewById(R.id.send_button );//初始化发送按钮布局
        button1.setOnClickListener((v)->{sendMessage(button1);});//设置点击监听器，sendMessage有个View形参以确定是哪个布局
        editText=(EditText)findViewById(R.id.SendText);//初始化输入框布局
        Message message1=new Message();
        message1.setMessage("我是您的小助手鹏鹏，请问您遇到了什么问题？",2);
        messagedata.add(message1);
        MyAdapt=new MyMessageAdapter(messagedata,this);//初始化渲染列表
        listview.setAdapter(MyAdapt);
    }

    //sendMessage函数将获取的输入框内容封装成Message实例，更新mainActivity里的messagedata列表
    // 然后再用update函数更新MyMessageAdapter，最后重新渲染列表
    public void sendMessage(View View)
    {
        editText=(EditText)findViewById(R.id.SendText);
        String SendMsg=editText.getText().toString();
        Message userMsg=new Message();
        userMsg.setMessage(SendMsg,0);
        messagedata.add(userMsg);
        MyAdapt.update(messagedata,this);//更新Listview列表
        listview.setAdapter(MyAdapt);
    }
}