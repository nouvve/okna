package com.example.myapplication;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterListy extends RecyclerView.Adapter<AdapterListy.TaskViewHolder> {
    private final ArrayList<Zadanie> zadania;
    private final OnTaskClickListener przycisk;

    public interface OnTaskClickListener {
        void onTaskClick(int position);
    }

    public AdapterListy(ArrayList<Zadanie> zadania, OnTaskClickListener przycisk) {
        this.zadania = zadania;
        this.przycisk = przycisk;
    }

    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.zadanie, parent, false);
        return new TaskViewHolder(view, przycisk);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {
        Zadanie task = zadania.get(position);
        holder.nazwa.setText(task.getName());
        holder.opis.setText(task.getOpis());
    }

    @Override
    public int getItemCount() {
        return zadania.size();
    }

    public static class TaskViewHolder extends RecyclerView.ViewHolder {
        TextView nazwa, opis;

        public TaskViewHolder(@NonNull View itemView, OnTaskClickListener listener) {
            super(itemView);
            nazwa = itemView.findViewById(R.id.textTaskName);
            opis = itemView.findViewById(R.id.textTaskDescription);

            itemView.setOnClickListener(v -> {
                if (listener != null) {
                    int pozycja = getAdapterPosition();
                    if (pozycja != RecyclerView.NO_POSITION) {
                        listener.onTaskClick(pozycja);
                    }
                }
            });
        }
    }
}