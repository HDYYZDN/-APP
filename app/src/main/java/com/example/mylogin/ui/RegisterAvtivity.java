package com.example.mylogin.ui;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;
import com.example.mylogin.R;
import com.example.mylogin.database.DataBaseHelper;

public class RegisterAvtivity extends Activity {
    EditText email,passwd1,passwd2;
    ImageView imageButton;
    private DataBaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_avtivity);
        dbHelper = new DataBaseHelper(this,"User.db",null,1);
        imageButton = (ImageView) findViewById(R.id.ib_register);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email=(EditText)findViewById(R.id.et_email);
                passwd1=(EditText)findViewById(R.id.et_pass1);
                passwd2=(EditText)findViewById(R.id.et_pass2);

                String s_email= email.getText().toString();
                String password=passwd1.getText().toString();
                String password2 = passwd2.getText().toString();
                if (CheckIsDataAlreadyInDBorNot(s_email)) {
                    Toast.makeText(RegisterAvtivity.this,"该邮箱已被注册，请使用其他邮箱",Toast.LENGTH_LONG).show();
                    }else {
                    if(!password.equals(password2)){
                        Toast.makeText(RegisterAvtivity.this,"两次输入的密码不一致",Toast.LENGTH_LONG).show();
                    }else {
                        if (register(s_email, password)) {
                            Toast.makeText(RegisterAvtivity.this,"注册成功，返回登录",Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(RegisterAvtivity.this,LoginActivity.class);
                            startActivity(intent);
                        }
                    }
                }
                }

        });
    }
    public boolean register(String email,String password){
        SQLiteDatabase db= dbHelper.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("email",email);
        values.put("password",password);
        db.insert("userData",null,values);
        db.close();
        //db.execSQL("insert into userData (name,password) values (?,?)",new String[]{username,password});
        return true;
    }
    //检验用户名是否已存在
    public boolean CheckIsDataAlreadyInDBorNot(String value){
        SQLiteDatabase db=dbHelper.getWritableDatabase();
        String Query = "Select * from userData where email =?";
        Cursor cursor = db.rawQuery(Query,new String[] { value });
        if (cursor.getCount()>0){
            cursor.close();
            return  true;
        }
        cursor.close();
        return false;
    }

}
