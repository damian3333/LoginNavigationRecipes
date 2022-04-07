package com.ort.recyclerlist_apprecetas.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.ort.recyclerlist_apprecetas.R
import com.ort.recyclerlist_apprecetas.entities.Recipe

class RecipesAdapter (var RecipeList : MutableList<Recipe>,
                      var onClick :(Int) -> Unit

) : RecyclerView.Adapter<RecipesAdapter.RecipeHolder>(){


    class RecipeHolder (v : View) : RecyclerView.ViewHolder(v) {
            private var view: View
            init {
                this.view = v
            }
        fun setTitle (title : String){
            var txtTitle : TextView = view.findViewById(R.id.txtName)
            txtTitle.text = title
        }

        fun getCard () : CardView {
            return view.findViewById(R.id.card)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.item_recipe,parent,false)
        return (RecipeHolder(view))
    }

    override fun onBindViewHolder(holder: RecipeHolder, position: Int) {
        holder.setTitle(RecipeList[position].name)
        holder.getCard().setOnClickListener(){

        }
    }

    override fun getItemCount(): Int {
        return RecipeList.size
    }
}