package com.example.eventerbeta;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Serch on 6/23/2017.
 */

public class AdaptadorRvDetailed extends RecyclerView.Adapter<AdaptadorRvDetailed.EventoDetailedViewHolder>{

    List<EventoDetailed> listaEvento;
    Context context;

    public AdaptadorRvDetailed(List<EventoDetailed> listaEvento, Context context) {
        this.listaEvento = listaEvento;
        this.context = context;
    }

    @Override
    public EventoDetailedViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_detailed, parent, false);
        EventoDetailedViewHolder eventoDetailedViewHolder = new EventoDetailedViewHolder(v);

        return eventoDetailedViewHolder;
    }

    @Override
    public void onBindViewHolder(EventoDetailedViewHolder holder, int position) {
        holder.imagenEvento.setImageResource(listaEvento.get(position).getImagenEvento());
        holder.nombreEvento.setText(listaEvento.get(position).getNombreEvento());
        holder.fechaEvento.setText(listaEvento.get(position).getFechaEvento());
        holder.imagenDestacados.setImageResource(R.drawable.ic_menu_destacados);
        holder.imagenFavoritos.setImageResource(R.drawable.ic_menu_favoritos);
        holder.imagenCategoria1.setImageResource(R.drawable.ic_menu_camera);
        holder.imagenCategoria2.setImageResource(R.drawable.ic_menu_ciencia);
    }

    @Override
    public int getItemCount() {
        return listaEvento.size();
    }

    public static class EventoDetailedViewHolder extends RecyclerView.ViewHolder {

        ImageView imagenEvento;
        TextView nombreEvento;
        TextView fechaEvento;
        ImageView imagenFavoritos;
        ImageView imagenDestacados;
        ImageView imagenCategoria1;
        ImageView imagenCategoria2;

        public EventoDetailedViewHolder(View itemView) {
            super(itemView);
            imagenEvento = (ImageView)itemView.findViewById(R.id.imagenDetailed);
            nombreEvento = (TextView)itemView.findViewById(R.id.tvNombreEvento);
            fechaEvento = (TextView)itemView.findViewById(R.id.tvFecha);
            imagenFavoritos = (ImageView)itemView.findViewById(R.id.imageFavoritos);
            imagenDestacados = (ImageView)itemView.findViewById(R.id.imageDestacados);
            imagenCategoria1 = (ImageView)itemView.findViewById(R.id.imageCategoria1);
            imagenCategoria2 = (ImageView)itemView.findViewById(R.id.imageCategoria2);
        }
    }
}
