package com.example.asus.demo2;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    //mContext là màn hình
    private Context mContext;
    private ArrayList<Model> mlist;
    private OnItemClickListener listener;

    Adapter(Context context, ArrayList<Model> list) {
        mContext = context;
        mlist = list;
    }

    //tạo người giữ lượt xem
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        //lấy giao diện từ file
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);

        //inflate la lấy từ file (source, parent)
        View view = layoutInflater.inflate(R.layout.rv_item, parent, false);

        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

//    người giữ quan điểm ràng buộc
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        Model massageItem = mlist.get(position);

        ImageView image = holder.item_image;
        TextView name, place, price, rate, local,sale;

        name = holder.item_name;
        place = holder.item_place;
        price = holder.item_price;
        rate = holder.item_rating;
        local = holder.item_local;
        sale = holder.item_sale;

        image.setImageResource(massageItem.getImage());

        name.setText(massageItem.getName());
        place.setText(massageItem.getPlace());
        price.setText(massageItem.getPrice());
        rate.setText(massageItem.getStar());
        local.setText(massageItem.getDistance());
        sale.setText(massageItem.getSale());

        holder.lnlRoot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onItemClick(position);
                }
            }
        });

    }

    @Override
    public int getItemCount() {

        return mlist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView item_image;
        TextView item_name, item_place, item_price, item_rating, item_local,item_sale;
        LinearLayout lnlRoot;

        public ViewHolder(View itemView) {
            super(itemView);
            item_image = itemView.findViewById(R.id.item_image);
            item_name = itemView.findViewById(R.id.item_name);
            item_place = itemView.findViewById(R.id.item_place);
            item_rating = itemView.findViewById(R.id.item_rating);
            item_local = itemView.findViewById(R.id.item_local);
            item_price = itemView.findViewById(R.id.item_price);
            item_sale = itemView.findViewById(R.id.item_sale);
            lnlRoot = itemView.findViewById(R.id.view_detail);

        }
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

}
