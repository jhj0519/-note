package com.example.evernote;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerAdapter recyclerAdapter;

    List<Memo> memoList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        memoList =new ArrayList<>();
        memoList.add(new Memo("test1","test11",0));
        memoList.add(new Memo("test2","test22",1));
        memoList.add(new Memo("test3","test33",0));
        memoList.add(new Memo("test4","test44",1));

        recyclerView = findViewById(R.id.Recycle);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        recyclerAdapter = new RecyclerAdapter(memoList);
        recyclerView.setAdapter(recyclerAdapter);
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
        if(memo.getIndone() == 0 ){
            itemViewHolder.img.setBackgroundColor(Color.YELLOW);
        }else if (memo.getIndone() == 1){
            itemViewHolder.img.setBackgroundColor(Color.BLACK);
        }
    }

    //리스트를 추가, 제거하는 함수
        void addItem(Memo memo){
        listdata.add(memo);
        }
        void  removeItem(int position){
        listdata.remove(position);
        }


    class ItemViewHolder extends RecyclerView.ViewHolder{
      private TextView title;
      private TextView text;
      private ImageView img;

      public ItemViewHolder(@NonNull View itemView){
          super(itemView);

          title= itemView.findViewById(R.id.list_title);
          text = itemView.findViewById(R.id.list_text);
          img = itemView.findViewById(R.id.list_Image);

      }
    }
    }
}