package com.example.evernote;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AddActivity extends AppCompatActivity {

    EditText editText;
    Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        Init();
        SetLestener();

    }
    public void  SetLestener(){

        //findViewById(R.id.btn_done).setOnClickListener(new View.OnClickListener() {
        editText.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view){
                String str = editText.getText().toString();

                if(str.length() > 0){
                    Date data = new Date();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy - MM - dd");
                    String substr= sdf.format(data);

                    Intent intent = new Intent();
                    intent.putExtra("main", str);
                    intent.putExtra("sub",substr);
                    setResult(RESULT_OK,intent);

                    finish();

                    Toast.makeText(AddActivity.this, "day:" + substr, Toast.LENGTH_SHORT).show();

                }
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void  onClick(View v){
                Intent intent = new Intent(AddActivity.this,MainActivity.class);
                startActivityForResult(intent,0);
            }
        });

    }
    private void Init(){
        editText = findViewById(R.id.ediMemo);
        btnBack = findViewById(R.id.btn_back);
    }
}