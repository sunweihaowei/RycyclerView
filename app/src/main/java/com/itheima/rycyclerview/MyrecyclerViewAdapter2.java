package com.itheima.rycyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.Map;

class MyrecyclerViewAdapter2 extends RecyclerView.Adapter<MyrecyclerViewAdapter2.MyViewHolder> {

    private final Context context;
    private final List <Map <String, Object>> list;

    public MyrecyclerViewAdapter2(Context context, List<Map<String, Object>> list) {
        this.context=context;
        this.list=list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=View.inflate(context,R.layout.item_rckv,null );
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, final int i) {
        Object sunweihao = list.get( i ).get( "sunweihao" );
        myViewHolder.tv_title.setText( (String) sunweihao );
        //这里为已经绑定

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView tv_title;
        public MyViewHolder(@NonNull View itemView) {
            super( itemView );
            tv_title=itemView.findViewById( R.id.tv_name);
           tv_title.setOnClickListener( new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   Map <String, Object> map = list.get( getLayoutPosition() );
                   if (onItemClickListener!=null){
                       onItemClickListener.onItemClick( v,map );
                   }
               }
           } );
        }
    }
    //接口
    public interface OnItemClickListener{
        public void onItemClick(View view, Map <String, Object> data);
    }
    //实例化
    private OnItemClickListener onItemClickListener;
    //setter方法，
    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }
}
