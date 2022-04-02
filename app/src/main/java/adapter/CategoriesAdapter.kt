package adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.abibi.reservation.R
import models.Categories

class CategoriesAdapter ( var context: Context? = null, private val categoriesDataSet: ArrayList<Categories>) :
    RecyclerView.Adapter<CategoriesAdapter.CategoriesViewHolder>(){


    class CategoriesViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var categoriesImage: ImageView? = null
        var categoriesName: TextView? = null

        init {
            // Define click listener for the ViewHolder's View.
            categoriesImage = view.findViewById(R.id.categoriesImageView)
            categoriesName = view.findViewById(R.id.txt_ville)
        }
    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CategoriesAdapter.CategoriesViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.categories_item, parent, false,)
        return CategoriesViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoriesViewHolder, position: Int) {
        holder.categoriesImage!!.setImageResource(categoriesDataSet.get(position).getImageCategories())
        holder.categoriesName!!.setText(categoriesDataSet.get(position).getNameCategories())
    }

    override fun getItemCount() = categoriesDataSet.size
}