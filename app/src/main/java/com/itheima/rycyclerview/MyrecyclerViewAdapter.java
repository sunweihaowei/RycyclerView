package com.itheima.rycyclerview;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MyrecyclerViewAdapter extends RecyclerView.Adapter<MyrecyclerViewAdapter.MyViewHolder> {

    private final Context context;
    private final List <String> list;

    public MyrecyclerViewAdapter(Context context, List<String> list) {
        this.context=context;
        this.list=list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {//
        View view=View.inflate( context,R.layout.item_rckv,null );
        return new MyViewHolder( view );//这个为下面的MyViewHolder
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        String s = list.get( i );        myViewHolder.tv_name.setText( s );

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        private ImageView iv_Title,iv_content,iv_reply;
        private TextView tv_name,tv_content,tv_time,tv_type,tv_reply;
        public MyViewHolder(@NonNull View itemView) {
            super( itemView );
            iv_Title=itemView.findViewById( R.id.iv_title );
            iv_content=itemView.findViewById( R.id.iv_content );
            iv_reply=itemView.findViewById( R.id.iv_reply );
            tv_name=itemView.findViewById( R.id.tv_name );
            tv_content=itemView.findViewById( R.id.tv_content );
            tv_time=itemView.findViewById( R.id.tv_time );
            tv_type=itemView.findViewById( R.id.tv_type );
            tv_reply=itemView.findViewById( R.id.tv_reply );
            iv_content.setOnClickListener( new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent=new Intent(context, Main2Activity.class);
                    context.startActivity( intent );

                }
            } );
        }
    }
}
