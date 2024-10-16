package com.arquitectura.triviapp.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.arquitectura.triviapp.Entidades.Historial
import com.arquitectura.triviapp.Vista.HistorialActivity
import com.arquitectura.triviapp.databinding.HistoryEachUserBinding


class HistorialAdapter(
    private val listener: HistorialActivity, private val listUser: List<Historial>,
) :
    RecyclerView.Adapter<HistorialAdapter.HistorialViewHolder>() {

    class HistorialViewHolder(val binding: HistoryEachUserBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistorialViewHolder {
        return HistorialViewHolder(
            HistoryEachUserBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: HistorialViewHolder, position: Int) {
        val curr = listUser[position]

        holder.binding.fecha.setText(curr.fecha)
        holder.binding.puntaje.setText(curr.puntaje.toString())
        holder.binding.categoria.setText(curr.categoria)
        holder.binding.tiempo.setText(curr.tiempo)

    }

    override fun getItemCount(): Int {
        return listUser.size
    }

}