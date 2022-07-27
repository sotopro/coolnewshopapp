package com.example.examplenavigationdrawer

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ProductAdapter (
    private val products : List<ProductModel>
        ) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {
            class ProductViewHolder(view: View) : RecyclerView.ViewHolder(view){
                val productName = view.findViewById<TextView>(R.id.product_name)
                val productPrice = view.findViewById<TextView>(R.id.product_price)
                val productImage = view.findViewById<ImageView>(R.id.product_image)
                val productDescription = view.findViewById<TextView>(R.id.product_description)
                fun bindProduct(product: ProductModel){
                    productName.text = product.name
                    productPrice.text = product.price
                    productDescription.text = product.description
                    Glide.with(itemView.context).load(product.image).into(productImage)
                }
            }

            override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
                return ProductViewHolder(
                    LayoutInflater.from(parent.context).inflate(R.layout.product_item, parent, false)
                )
            }

            override fun getItemCount(): Int = products.size

            override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
                holder.bindProduct(products.get(position))
            }
        }