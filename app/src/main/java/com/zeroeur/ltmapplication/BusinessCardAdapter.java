package com.zeroeur.ltmapplication;

/**
 * Created by Luca on 16/02/2017.
 */

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class BusinessCardAdapter extends RecyclerView.Adapter<BusinessCardAdapter.BusinessCardVH> {

    private ArrayList<BusinessCard> dataSet = new ArrayList<>();
    Context context;
    static final String NAME_KEY = "name_key";
    static final String POSITION_KEY = "position_key";




    public BusinessCardAdapter(Context context){
        this.context = context;
    }


    public void setBusinessCard(BusinessCard bc, int pos){
        dataSet.remove(pos);
        dataSet.add(pos,bc);
    }

    public void addBusinessCard(BusinessCard bc){

        dataSet.add(bc);
        notifyItemInserted(dataSet.size() -1);
    }

    public void setDataSet (ArrayList<BusinessCard> dataSet) {
        this.dataSet = dataSet;
        notifyDataSetChanged();
    }

    @Override
    public BusinessCardAdapter.BusinessCardVH onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_business_card,parent,false);
        return new BusinessCardVH(view);
    }

    @Override
    public void onBindViewHolder(BusinessCardAdapter.BusinessCardVH holder, int position) {

        BusinessCard businessCard = dataSet.get(position);
        holder.nameTv.setText(businessCard.getName());
        holder.emailTv.setText(businessCard.getEmail());
        holder.phoneNumberTv.setText(businessCard.getPhoneNumber());
        holder.courseTv.setText(businessCard.getCourse());
        holder.addressTv.setText(businessCard.getAddress());

    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }


    public class BusinessCardVH extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView nameTv, phoneNumberTv,emailTv, courseTv, addressTv;
        Button infoBtn;

        public BusinessCardVH(View itemView) {
            super(itemView);
            nameTv = (TextView) itemView.findViewById(R.id.business_card_name);
            phoneNumberTv = (TextView) itemView.findViewById(R.id.business_card_phone_number);
            emailTv = (TextView)itemView.findViewById(R.id.business_card_email);
            courseTv = (TextView)itemView.findViewById(R.id.business_card_course);
            addressTv = (TextView)itemView.findViewById(R.id.business_card_address);
            infoBtn = (Button) itemView.findViewById(R.id.business_card_info_btn);
            infoBtn.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            //getAdapterPosition()
            if(view.getId()==R.id.business_card_info_btn){
                Intent intent = new Intent(context,BusinessCardActivity.class);
                intent.putExtra(NAME_KEY,dataSet.get(getAdapterPosition()).getName());
                intent.putExtra(POSITION_KEY,getAdapterPosition());
                ((Activity)context).startActivityForResult(intent,0);
            }

        }
    }
}
