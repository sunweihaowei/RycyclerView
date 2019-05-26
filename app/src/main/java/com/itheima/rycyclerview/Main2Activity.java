package com.itheima.rycyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/*总结：recyclerView的item点击
  在adapter.ViewHold上建立建立监听，（与在OnBindViewHolder上绑定有很大的区别，OnbindViewHolder已经绑定好了ViewHold，而它则没有
  绑定好了，即为不可改，而ViewHolder上则可以改）；

  接口的使用：
  1.先定义接口：interface，在接口内定义方法，并且写参数
  2.实例化，private a a；
  3.创建setter，即为构建方法，作用可以用来调用

 监听：
 1.MyViewHolder的布局上设置监听，判断是否有这个方法，然后 类.方法（之前设置了实例化，现在派上用场）
 注意：方法getlayoutposition得到刷新后的项
2.在主界面上调用这个方法


 */
public class Main2Activity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private RecyclerView recyclerView;
    private MyrecyclerViewAdapter2 myrecyclerViewAdapter2;
    private List<Map<String,Object>> list=new ArrayList <>(  );
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main2 );
        initView();
        Toolbar toolbar = findViewById( R.id.toolbar );
        setSupportActionBar( toolbar );
        FloatingActionButton fab = findViewById( R.id.fab );
        fab.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make( view, "Replace with your own action", Snackbar.LENGTH_LONG )
                        .setAction( "Action", null ).show();
            }
        } );
        DrawerLayout drawer = findViewById( R.id.drawer_layout );
        NavigationView navigationView = findViewById( R.id.nav_view );
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close );
        drawer.addDrawerListener( toggle );
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener( this );
        myrecyclerViewAdapter2=new MyrecyclerViewAdapter2(Main2Activity.this,list);
        for (int i=0;i<50;i++){
            Map<String,Object> map=new HashMap <>(  );
            map.put( "sunweihao","sunweihao"+i);
            list.add( map );
        }
        recyclerView.setAdapter( myrecyclerViewAdapter2 );
        recyclerView.setLayoutManager( new LinearLayoutManager( Main2Activity.this,LinearLayoutManager.HORIZONTAL,false ) );
        myrecyclerViewAdapter2.setOnItemClickListener( new MyrecyclerViewAdapter2.OnItemClickListener() {
            @Override
            public void onItemClick(View view, Map <String, Object> data) {
               Toast.makeText( Main2Activity.this,"weihao="+data,Toast.LENGTH_LONG ).show();
            }
        } );
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById( R.id.drawer_layout );
        if (drawer.isDrawerOpen( GravityCompat.START )) {
            drawer.closeDrawer( GravityCompat.START );
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate( R.menu.main2, menu );
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected( item );
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_tools) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = findViewById( R.id.drawer_layout );
        drawer.closeDrawer( GravityCompat.START );
        return true;
    }

    private void initView() {
        recyclerView = (RecyclerView) findViewById( R.id.recyclerView );
    }
}
