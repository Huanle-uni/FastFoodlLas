package com.example.fastfood;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ViewHolder>{

    private Context mContext;
    private LayoutInflater mInflater;
    private List<Food> mDates;


    public CartAdapter(Context context, List<Food> dates){
        this.mContext = context;
        this.mInflater = LayoutInflater.from(context);
        this. mDates = dates;

    }


    @Override
    public int getItemCount() {
        return (mDates== null) ? 0 : mDates.size();
    }



    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_car, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Food data = mDates.get(position);
        holder.tv_name.setText(data.name);
        holder.tv_price.setText("$"+data.price);
        holder.tv_num.setText("X"+data.count);
        holder.iv_img.setImageResource(data.img);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener!=null){
                    listener.setOnItemClickListener(position);
                }
            }
        });

    }

    class ViewHolder extends RecyclerView.ViewHolder {

        ImageView iv_img;
        TextView tv_name;
        TextView tv_price;
        TextView tv_num;

        public ViewHolder(View view){
            super(view);
            iv_img = view.findViewById(R.id.iv_img);
            tv_name = view.findViewById(R.id.tv_name);
            tv_price = view.findViewById(R.id.tv_price);
            tv_num = view.findViewById(R.id.tv_num);
        }
    }
    private ItemClickListener listener;

    public interface ItemClickListener{
        void setOnItemClickListener(int position);
    }
}
