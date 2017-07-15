package com.example.eventerbeta;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

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
        holder.nombreEvento.setText(listaEvento.get(position).getNombreEvento());
        holder.fechaEvento.setText(listaEvento.get(position).getFechaEvento());
        holder.organizer.setText(listaEvento.get(position).getOrganizer());
        holder.imagenDestacados.setImageResource(R.drawable.ic_menu_destacados);
        holder.imagenFavoritos.setImageResource(R.drawable.ic_menu_favoritos);
        setCategory1(holder, position);
        setCategory2(holder, position);

        Picasso.with(context).load(listaEvento.get(position).getImagenEvento())
                .error(R.drawable.ic_menu_favoritos)                       //este carga otra imagen, cuando hay error en la primera
                .transform(new CircleTransformation())           //esta linea redondea la imagen
                .placeholder(R.mipmap.ic_launcher)         //este pone imagen antes de cargar la imagen buena
                .into(holder.imagenEvento);
    }

    @Override
    public int getItemCount() {
        return listaEvento.size();
    }

    public static class EventoDetailedViewHolder extends RecyclerView.ViewHolder {

        ImageView imagenEvento;
        TextView nombreEvento;
        TextView fechaEvento;
        TextView organizer;
        ImageView imagenFavoritos;
        ImageView imagenDestacados;
        ImageView imagenCategoria1;
        ImageView imagenCategoria2;

        public EventoDetailedViewHolder(View itemView) {
            super(itemView);
            imagenEvento = (ImageView)itemView.findViewById(R.id.imagenDetailed);
            nombreEvento = (TextView)itemView.findViewById(R.id.tvNombreEvento);
            fechaEvento = (TextView)itemView.findViewById(R.id.tvFecha);
            organizer = (TextView)itemView.findViewById(R.id.tvOrganizer);
            imagenFavoritos = (ImageView)itemView.findViewById(R.id.imageFavoritos);
            imagenDestacados = (ImageView)itemView.findViewById(R.id.imageDestacados);
            imagenCategoria1 = (ImageView)itemView.findViewById(R.id.imageCategoria1);
            imagenCategoria2 = (ImageView)itemView.findViewById(R.id.imageCategoria2);
        }
    }

    public void setCategory1 (EventoDetailedViewHolder holder, int position) {
        int category1 = listaEvento.get(position).getCategoria1();
        if (category1 == 2) {
            holder.imagenCategoria1.setImageResource(R.drawable.ic_menu_cultura);
        } else if (category1 == 3) {
            holder.imagenCategoria1.setImageResource(R.mipmap.ic_menu_theater);
        } else if (category1 == 4) {
            holder.imagenCategoria1.setImageResource(R.drawable.ic_menu_arte);
        } else if (category1 == 5) {
            holder.imagenCategoria1.setImageResource(R.drawable.ic_menu_camera);
        }
    }

    public void setCategory2 (EventoDetailedViewHolder holder, int position) {
        int category2 = listaEvento.get(position).getCategoria2();
        if(category2 == 2) {
            holder.imagenCategoria2.setImageResource(R.drawable.ic_menu_cultura);
        } else if (category2 == 3){
            holder.imagenCategoria2.setImageResource(R.mipmap.ic_menu_theater);
        } else if (category2 == 4){
            holder.imagenCategoria2.setImageResource(R.drawable.ic_menu_arte);
        } else if (category2 == 5){
            holder.imagenCategoria2.setImageResource(R.drawable.ic_menu_camera);
        }
    }
}
