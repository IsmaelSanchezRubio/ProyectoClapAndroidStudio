package com.ismaelsanchez.estasilistas.ListaZonas;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ismaelsanchez.estasilistas.R;

import java.util.List;

public class RecyclerViewAdaptador
        extends RecyclerView.Adapter<RecyclerViewAdaptador.ViewHolder>
        implements View.OnClickListener {


    public static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView nombre;
        ImageView fotoZona;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nombre=(TextView) itemView.findViewById(R.id.tvZona);
            fotoZona=(ImageView) itemView.findViewById(R.id.imageViewZona);
        }
    }
    public List<Zona> zonaList;
    private View.OnClickListener listener;

    public void setOnClickListener(View.OnClickListener listener){
        this.listener=listener;
    }
    @Override
    public void onClick(View view) {
        if(listener!=null){
            listener.onClick(view);
        }
    }

    public RecyclerViewAdaptador(List<Zona> zonaList) {
        this.zonaList = zonaList;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.itemzona,parent,false);
        ViewHolder viewHolder= new ViewHolder(view);

        view.setOnClickListener(this);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.nombre.setText(zonaList.get(position).getNombre());
        holder.fotoZona.setImageResource(zonaList.get(position).getFotoZona());
    }

    @Override
    public int getItemCount() {
        return zonaList.size();
    }
}