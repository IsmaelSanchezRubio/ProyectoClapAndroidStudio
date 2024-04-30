package com.ismaelsanchez.estasilistas.ListaVias;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ismaelsanchez.estasilistas.ListaZonas.Zona;
import com.ismaelsanchez.estasilistas.R;

import java.util.List;

public class RecyclerViewAdaptadorVia extends RecyclerView.Adapter<RecyclerViewAdaptadorVia.ViewHolder> {
    public static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView nombre;
        ImageView fotoVia;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nombre=(TextView) itemView.findViewById(R.id.tvZona);
            fotoVia=(ImageView) itemView.findViewById(R.id.imageViewVia);
        }
    }
    public List<Via> viaList;

    public RecyclerViewAdaptadorVia(List<Via> zonaList) {
        this.viaList = viaList;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.itemvia,parent,false);
        ViewHolder viewHolder= new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.nombre.setText(viaList.get(position).getNombre());
        holder.fotoVia.setImageResource(viaList.get(position).getFotoVia());
    }

    @Override
    public int getItemCount() {
        return viaList.size();
    }
}