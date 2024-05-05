package com.example.lab4_iot_20203651.objetos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lab4_iot_20203651.R;

import java.util.List;

public class ListAdapterGeolo extends RecyclerView.Adapter<ListAdapterGeolo.ViewHolder> {
    private List<Geolocalizacion> nData;
    private LayoutInflater nInflater;
    private Context context;
    final ListAdapterGeolo.OnItemClickListener listener;

    public interface  OnItemClickListener{
        void onItemClick(Geolocalizacion item);
    }

    public ListAdapterGeolo(List<Geolocalizacion> itemList, Context context, ListAdapterGeolo.OnItemClickListener listener) {
        this.nInflater = LayoutInflater.from(context);
        this.context = context;
        this.nData = itemList;
        this.listener = listener;
    }

    @Override
    public int getItemCount(){
        return nData.size();
    }

    @Override
    public ListAdapterGeolo.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = nInflater.inflate(R.layout.listciudades, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ListAdapterGeolo.ViewHolder holder, final int position){
        holder.bindDataSite(nData.get(position));
    }

    public void setItems(List<Geolocalizacion> items) {
        nData = items;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView ciudad, direccion;

        ViewHolder(View itemView){
            super(itemView);
            ciudad = itemView.findViewById(R.id.Ciudad);
            direccion = itemView.findViewById(R.id.directionTextViewSite);


        }

        void bindDataSite(final Geolocalizacion item){
            String fullDirection = "Latitud: " + item.getLatitud() + " Longitud: " + item.getLongitud();
            direccion.setText(fullDirection);
            ciudad.setText(item.getNameCiudad());

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onItemClick(item);
                }
            });

        }
    }

}

