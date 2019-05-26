package com.itheima.rycyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<String> list=new ArrayList <>(  );
    private RecyclerView recyclerView;
    private MyrecyclerViewAdapter myrecyclerViewAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        initView();
        for (int i=0;i<=50;i++){
            list.add( "联系人"+i );
        }

        myrecyclerViewAdapter=new MyrecyclerViewAdapter(MainActivity.this,list);
        recyclerView.setAdapter( myrecyclerViewAdapter );
        recyclerView.setLayoutManager( new LinearLayoutManager( MainActivity.this,LinearLayoutManager.VERTICAL,false ) );

    }

    private void initView() {
        recyclerView = (RecyclerView) findViewById( R.id.recyclerView );
    }
}
