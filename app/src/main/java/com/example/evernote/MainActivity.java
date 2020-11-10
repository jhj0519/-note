package com.example.evernote;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    SQLiteHelper dbHelper;

    RecyclerView recyclerView;
    RecyclerAdapter recyclerAdapter;
    Button btnAdd;

    List<Memo> memoList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = new SQLiteHelper(MainActivity.this);

        memoList = new ArrayList<>();
        memoList = dbHelper.selectAll();

        recyclerView = findViewById(R.id.Recycle);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        recyclerAdapter = new RecyclerAdapter(memoList);
        recyclerView.setAdapter(recyclerAdapter);
        btnAdd = findViewById(R.id.btn_add);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MemoActivity.class);
                startActivityForResult(intent,0);
            }
        });

    }
    //onactivityresu
    //startActicityForResult으로 실행한 액티비티가 끝났을 때, 여기에서 데이터를 받는다.
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 0){
            String strTitle = data.getStringExtra("title");
            String strText = data.getStringExtra("text");

            Memo memo = new Memo(strTitle, strText);
            recyclerAdapter.addItem(memo);
            recyclerAdapter.notifyDataSetChanged();

           dbHelper.insertMemo(memo);

        }
    }

    //Adapter사용
    class  RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ItemViewHolder>{
    private List<Memo> listdata;
    public RecyclerAdapter(List<Memo> listdata){
        this.listdata =listdata;
    }
    public  int getItemCount(){
        return listdata.size();
    }

        @NonNull
        @Override
        public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item,viewGroup,false);
            return new ItemViewHolder(view);
            //return null;
        }

        //데이터를 어떻게  레이아웃에 넣어줄 것인지 정해준다.
    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder itemViewHolder,int i){
        Memo memo = listdata.get(i);

        itemViewHolder.title.setText(memo.getTitle());
        itemViewHolder.text.setText(memo.getText());

    }

    //리스트를 추가, 제거하는 함수
        void addItem(Memo memo){
        listdata.add(memo);
        }
        void removeItem(int position){
        listdata.remove(position);
        }


    class ItemViewHolder extends RecyclerView.ViewHolder{
      private TextView title;
      private TextView text;

      public ItemViewHolder(@NonNull View itemView){
          super(itemView);

          title= itemView.findViewById(R.id.list_title);
          text = itemView.findViewById(R.id.list_text);

      }
    }

    }
}