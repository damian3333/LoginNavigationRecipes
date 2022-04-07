package com.ort.recyclerlist_apprecetas.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.ort.recyclerlist_apprecetas.R
import com.ort.recyclerlist_apprecetas.adapters.RecipesAdapter
import com.ort.recyclerlist_apprecetas.entities.Recipe
import com.ort.recyclerlist_apprecetas.viewmodel.RecetasViewModel
import android.view.View as View

class RecipesFragment : Fragment() {

    companion object {
        fun newInstance() = RecipesFragment()
    }
        lateinit var v: View
        lateinit var RecyclerRecipe : RecyclerView

    private lateinit var viewModel: RecetasViewModel
    private lateinit var adapter : RecipesAdapter
    private var recipeList: MutableList<Recipe> = mutableListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v = inflater.inflate(R.layout.recipes_fragment, container, false)
        RecyclerRecipe  = v.findViewById(R.id.recyclerRecipe)

        recipeList.add(Recipe("receta1","descripcion","url1"))
        recipeList.add(Recipe("receta2","descripcion","url1"))
        recipeList.add(Recipe("receta3","descripcion","url1"))
        recipeList.add(Recipe("receta4","descripcion","url1"))
        recipeList.add(Recipe("receta5","descripcion","url1"))
        recipeList.add(Recipe("receta6","descripcion","url1"))
        recipeList.add(Recipe("receta7","descripcion","url1"))



        return v
    }

    override fun onStart(){
        super.onStart()
        RecyclerRecipe.setHasFixedSize(true)
        RecyclerRecipe.layoutManager = LinearLayoutManager(context)
        adapter = RecipesAdapter(recipeList){ position ->

            Snackbar.make(v,position.toString(),Snackbar.LENGTH_SHORT).show()
        }
        RecyclerRecipe.adapter = adapter    //se renderiza aca la lista
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(RecetasViewModel::class.java)
        // TODO: Use the ViewModel
    }

}