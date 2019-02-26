package com.develop.everest.bookabus;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
public class BusAdapter extends RecyclerView.Adapter<BusAdapter.BusViewHolder>{
    // We define the context of class we are calling recycler view
    private Context mCtx;
    private ArrayList<Bus> BusList;

    // Copy constructor
    public BusAdapter(Context mCtx, ArrayList<Bus> BusList){
        this.mCtx = mCtx;
        this.BusList = BusList;
    }

    // This method will create a view holder
    @Override
    public BusViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.bus_item, parent,false);
        return new BusViewHolder(view);
    }

    // This will set data in view holder according to the position in recycler view
    @Override
    public void onBindViewHolder(BusViewHolder holder, int position) {
        Bus bus = BusList.get(position);
        holder.textSource.setText(bus.getSource());
        holder.textDestination.setText(bus.getDestination());
        holder.textName.setText(bus.getName());
        holder.textDeparture.setText(bus.getDeparture());
        holder.textPrice.setText(String.valueOf(bus.getprice()));
    }


    @Override
    public int getItemCount() {
        return BusList.size();
    }

    // Here we define the view holder for of recycler view
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
