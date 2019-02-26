package com.develop.everest.bookabus;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
public class BusAdapter extends RecyclerView.Adapter<BusAdapter.BusViewHolder>{
    private Context mCtx;
    private ArrayList<Bus> BusList;
    public BusAdapter(Context mCtx, ArrayList<Bus> BusList){
        this.mCtx = mCtx;
        this.BusList = BusList;
    }
    public BusViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.bus_item, parent,false);
        return new BusViewHolder(view);
    }
    public void onBindViewHolder(BusViewHolder holder, int position) {
        Bus bus = BusList.get(position);
        holder.textSource.setText(bus.getSource());
        holder.textDestination.setText(bus.getDestination());
        holder.textName.setText(bus.getName());
        holder.textDeparture.setText(bus.getDeparture());
        holder.textPrice.setText(String.valueOf(bus.getprice()));
    }
    public int getItemCount() {
        return BusList.size();
    }
    public class BusViewHolder extends RecyclerView.ViewHolder{
        TextView textSource, textDestination, textName, textDeparture, textPrice;
        public BusViewHolder (View itemView) {
            super(itemView);
            textSource = (TextView) itemView.findViewById(R.id.Source);
            textDestination =(TextView) itemView.findViewById(R.id.Destination);
            textName =(TextView) itemView.findViewById(R.id.BusName);
            textDeparture =(TextView) itemView.findViewById(R.id.Timestamp);
            textPrice =(TextView) itemView.findViewById(R.id.Price);
        }
    }
}
