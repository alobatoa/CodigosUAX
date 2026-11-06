package com.example.login.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.login.R
import com.example.login.databinding.ItemProductBinding
import com.example.login.model.Product
import com.google.android.material.snackbar.Snackbar

class ProductAdapter(var list: List<Product>, var context: Context) :
    RecyclerView.Adapter<ProductAdapter.MyHolder>() {

    inner class MyHolder(var binding: ItemProductBinding) :
        RecyclerView.ViewHolder(binding.root)

    // crea el patron para poder replicarlo x veces
    override fun onCreateViewHolder(
        p0: ViewGroup,
        p1: Int
    ): MyHolder {
        val binding: ItemProductBinding = ItemProductBinding
            .inflate(LayoutInflater.from(context), p0, false)
        return MyHolder(binding)
    }

    // junta lo grafico (holder) con el elemento que toque en la lista
    override fun onBindViewHolder(
        holder: MyHolder,
        position: Int
    ) {
        // val product: Product = list.get(position)
        val product: Product = list[position]
        holder.binding.textTitleProduct.text = product.title
        holder.binding.textPriceProduct.text = product.price.toString()
        Glide.with(context).load(product.image)
            .placeholder(R.drawable.imgdefault)
            .into(holder.binding.imageProduct)
        holder.binding.btnBuy.setOnClickListener {
            Snackbar.make(
                holder.binding.root, "El stock del producto es ${product.stock}",
                Snackbar.LENGTH_LONG
            ).show()
        }

    }

    // el numero de items a renederizar en la lista completa
    override fun getItemCount(): Int {
        return list.size
    }


}