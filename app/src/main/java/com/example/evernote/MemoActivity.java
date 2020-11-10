package com.example.evernote;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MemoActivity extends AppCompatActivity {

    EditText titleText, memoText;
    Button btnBack, btnSave;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //상단바 제거
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_memo);

        Init();
        SetLestener();

    }
    public void  SetLestener(){

        //findViewById(R.id.btn_done).setOnClickListener(new View.OnClickListener() {
        titleText.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view){
                String title = titleText.getText().toString();
                String memo = memoText.getText().toString();

                if(title.length() > 0||memo.length()>0){
                    Date data = new Date();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy - MM - dd");
                    String dayData= sdf.format(data);

                    intent = new Intent();
                    intent.putExtra("title", title);
                    intent.putExtra("text",memo);
                    setResult(RESULT_OK,intent);

                    finish();
                    //makeMessege

                    }
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                intent = new Intent(MemoActivity.this, MainActivity.class);
                startActivityForResult(intent,0);
            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(MemoActivity.this,MainActivity.class),0);
            }
        });

    }
    private void Init(){
        titleText = findViewById(R.id.btn_memo_tatle);
        memoText = findViewById(R.id.btn_memo_memo);
        btnBack = findViewById(R.id.btn_cancel);
        btnSave = findViewById(R.id.btn_save);
    }
}