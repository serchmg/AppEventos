package com.example.eventerbeta;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Serch on 6/21/2017.
 */

public class AdaptadorRv extends RecyclerView.Adapter<AdaptadorRv.EventoViewHolder> {

    List<Evento> listaEvento;
    Context context;

    public AdaptadorRv(List<Evento> listaEvento, Context context) {
        this.listaEvento = listaEvento;
        this.context = context;
    }

    @Override
    public EventoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_basic, parent, false);
        EventoViewHolder eventoViewHolder = new EventoViewHolder(v);

        return eventoViewHolder;
    }

    @Override
    public void onBindViewHolder(EventoViewHolder holder, int position) {
        holder.imagenEvento.setImageResource(listaEvento.get(position).getImagenEvento());
        holder.nombreEvento.setText(listaEvento.get(position).getNombreEvento());
        holder.fecha.setText(listaEvento.get(position).getFecha());

        //Con esta cosa hacemos que la figura este redonda, no usar xml para esto, usar imagenes png
        Picasso.with(context).load(listaEvento.get(position).getImagenEvento()) //este carga la imagen, aqui se pega el link de la imagen
                .error(R.drawable.ic_menu_favoritos)                       //este carga otra imagen, cuando hay error en la primera
                .transform(new CircleTransformation())           //esta linea redondea la imagen
                .placeholder(R.mipmap.one_piece)         //este pone imagen antes de cargar la imagen buena
                .into(holder.imagenEvento);                      //aqui le ponen la imagen
    }

    @Override
    public int getItemCount() {
        return listaEvento.size();
    }

    public static class EventoViewHolder extends RecyclerView.ViewHolder {

        ImageView imagenEvento;
        TextView nombreEvento;
        TextView fecha;

        public EventoViewHolder(View itemView) {
            super(itemView);
            imagenEvento = (ImageView)itemView.findViewById(R.id.imagen);
            nombreEvento = (TextView)itemView.findViewById(R.id.tvNombreEvento);
            fecha = (TextView)itemView.findViewById(R.id.tvFecha);
        }
    }
}
