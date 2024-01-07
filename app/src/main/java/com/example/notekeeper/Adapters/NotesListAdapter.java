package com.example.notekeeper.Adapters;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.notekeeper.Models.Notes;
import com.example.notekeeper.NotesClickListener;
import com.example.notekeeper.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NotesListAdapter extends RecyclerView.Adapter<NotesViewHolder>{

    Context context;
    List<Notes> list;
    NotesClickListener listener;

    public NotesListAdapter(Context context, List<Notes> list, NotesClickListener listener) {
        this.context = context;
        this.list = list;
        this.listener = listener;
    }

    @NonNull
    @Override
    public NotesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new NotesViewHolder(LayoutInflater.from(context).inflate(R.layout.notes_list, parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull NotesViewHolder holder, int position) {
        holder.textView_title.setText(list.get(position).getTitle());
        holder.textView_title.setSelected(true);

        holder.textView_notes.setText(list.get(position).getNotes());

        holder.textView_dates.setText(list.get(position).getDate());
        holder.textView_dates.setSelected(true);

        if (list.get(position).isPinned()){
            holder.imageview_pin.setImageResource(R.drawable.ic_pin);
        }else{
            holder.imageview_pin.setImageResource(0);
        }
        int colour_code=getRandomColour();
        holder.notes_container.setCardBackgroundColor(holder.itemView.getResources().getColor(colour_code, null));

        holder.notes_container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(list.get(holder.getAdapterPosition()));
            }
        });

        holder.notes_container.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                listener.onLongClick(list.get(holder.getAdapterPosition()), holder.notes_container);
                return true;
            }
        });
    }

    private int getRandomColour() {
        List<Integer> colourCodes=new ArrayList<>();

        colourCodes.add(R.color.Colour1);
        colourCodes.add(R.color.Colour2);
        colourCodes.add(R.color.Colour3);
        colourCodes.add(R.color.Colour4);
        colourCodes.add(R.color.Colour5);
        colourCodes.add(R.color.Colour6);
        colourCodes.add(R.color.Colour7);
        colourCodes.add(R.color.Colour8);
        colourCodes.add(R.color.Colour9);
        colourCodes.add(R.color.Colour10);

        Random random= new Random();
        int random_color=random.nextInt(colourCodes.size());
        return colourCodes.get(random_color);
    }

    @Override
    public int getItemCount() {
        return list.size() ;
    }

    public void filteredList(List<Notes> filterdList){
        list=filterdList;
        notifyDataSetChanged();
    }
}

class NotesViewHolder extends RecyclerView.ViewHolder{

    CardView notes_container;
    TextView textView_title, textView_notes, textView_dates;
    ImageView imageview_pin;
    public NotesViewHolder(@NonNull View itemView) {
        super(itemView);
        notes_container=itemView.findViewById(R.id.notes_container);
        textView_title=itemView.findViewById(R.id.textView_title);
        textView_notes=itemView.findViewById(R.id.textView_notes);
        textView_dates=itemView.findViewById(R.id.textView_dates);
        imageview_pin=itemView.findViewById(R.id.imageview_pin);
    }
}
