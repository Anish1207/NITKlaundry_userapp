package com.example.nitklaundry.userapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;




     //Adapter accepts the View & Model
    //View is the layout that is to be inflated in recycler view rows.
    //Model is passed to the adapter from the calleing activity.
    //Here Model is the arraylist of orders.
public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.ListHolder> {


    private List<OrderItems> listdata;
    private LayoutInflater inflater;
    private Ongoing_Adapter.ItemClickCallback itemclickcallback;
    Context c;


    public HistoryAdapter( List< OrderItems > listdata,Context c)
    {
        this.inflater=LayoutInflater.from(c);
        this.listdata=listdata;
        this.c=c;

    }

    public interface ItemClickCallback
    {
        void onItemClick(int p);
    }

    public void setItemClickCallback(final HistoryAdapter.ItemClickCallback itemclickcallback)
    {
        this.itemclickcallback= (Ongoing_Adapter.ItemClickCallback) itemclickcallback;

    }

    @Override
    public HistoryAdapter.ListHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.ongoing_order, parent, false);
        return new HistoryAdapter.ListHolder(view);
    }

    //Binds the data to the view
    @Override
    public void onBindViewHolder(ListHolder holder, int position) {

        OrderItems item=listdata.get(position);
        String uid= item.getUserId();

        holder.topQty.setText(String.valueOf(item.getShirts()));
        holder.lowerQty.setText(String.valueOf(item.getLowers()));
        holder.bedsheetQty.setText(String.valueOf(item.getBedsheets()));
        holder.otherQty.setText(String.valueOf(item.getOthers()));
        holder.totalQ.setText(String.valueOf(item.getTotalQTY()));
        holder.totalP.setText(String.valueOf(item.getTotalPrice()));
        holder.whenPlaced.setText(item.getWhenPlaced());
        holder.pickupdate.setText(item.getPickupDate());
        holder.pickuptime.setText(item.getPickupTime());
        holder.typeoforder.setText(item.getTypeOfOrders());

    }



    //Returns the total count of OrderItems objets in the arraylist
    @Override
    public int getItemCount()
    {
        return listdata.size();
    }


    public class ListHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


        private TextView topQty;
        private TextView lowerQty;
        private TextView bedsheetQty;
        private TextView otherQty;
        private TextView totalQ;
        private TextView totalP;
        private TextView whenPlaced;
        private TextView pickupdate;
        private TextView pickuptime;
        private TextView typeoforder;

        private View container;

        public ListHolder(View iView) {
            super(iView);
            topQty = (TextView) iView.findViewById(R.id.topQty);
            lowerQty = (TextView) iView.findViewById(R.id.lowerQty);
            bedsheetQty = (TextView) iView.findViewById(R.id.bedsheetQty);
            otherQty = (TextView) iView.findViewById(R.id.otherQty);
            totalQ = (TextView) iView.findViewById(R.id.totalQ);
            totalP = (TextView) iView.findViewById(R.id.totalP);
            whenPlaced = (TextView) iView.findViewById(R.id.whenPlaced);
            pickupdate = (TextView) iView.findViewById(R.id.pickupdate);
            pickuptime = (TextView) iView.findViewById(R.id.pickuptime);
            typeoforder = (TextView) iView.findViewById(R.id.typeoforder);

            container = iView.findViewById(R.id.container_item_ongoing);
            container.setOnClickListener(this);
        }

        //Hnadles the onClick Events.
        @Override
        public void onClick(View view) {

            if (view.getId() == R.id.container_item_ongoing) {
                itemclickcallback.onItemClick(getAdapterPosition());
            }


        }
    }



}
