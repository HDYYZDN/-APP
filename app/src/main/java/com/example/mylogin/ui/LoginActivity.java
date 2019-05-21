package com.example.mylogin.ui;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.*;
import com.example.mylogin.R;
import com.example.mylogin.database.DataBaseHelper;

public class LoginActivity extends Activity {
    private DataBaseHelper dbHelper;
    private EditText id, passwd;
    private Button login;
    private TextView tv_forget,tv_new,tv_rule;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        dbHelper = new DataBaseHelper(this,"User.db",null,1);
        tv_forget = (TextView)findViewById(R.id.tv_forget);
        tv_new = (TextView)findViewById(R.id.tv_register);
        tv_rule = (TextView)findViewById(R.id.tv_rule);
        login = (Button)findViewById(R.id.bt_submit);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                id=(EditText)findViewById(R.id.et_id);
                passwd=(EditText)findViewById(R.id.et_passwd);
                String email=id.getText().toString();
                String passWord=passwd.getText().toString();
                if (login(email,passWord)) {
                    Toast.makeText(LoginActivity.this, "登陆成功", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(LoginActivity.this, "登陆失败", Toast.LENGTH_SHORT).show();
                }
            }
        });
        tv_forget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        tv_new.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterAvtivity.class);
                startActivity(intent);
            }
        });
        tv_rule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,Rule_Activity.class);
                startActivity(intent);
            }
        });
    }
    public boolean login(String email,String password) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String sql = "select * from userData where email=? and password=?";
        Cursor cursor = db.rawQuery(sql, new String[] {email, password});
        if (cursor.moveToFirst()) {
            cursor.close();
            return true;
        }
        return false;
    }

}