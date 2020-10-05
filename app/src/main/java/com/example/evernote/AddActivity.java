package com.example.evernote;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AddActivity extends AppCompatActivity {

    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        editText = findViewById(R.id.ediMemo);

        findViewById(R.id.btn_done).setOnClickListener(new View.OnClickListener() {
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

                    Toast.makeText(AddActivity.this, str + "," + substr, Toast.LENGTH_SHORT).show();

                }
            }
        });

        findViewById(R.id.btn_content).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}