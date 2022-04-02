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
import models.Destination

class DestinationAdapter(var context: Context? = null, private val destinationDataSet: ArrayList<Destination>):
    RecyclerView.Adapter<DestinationAdapter.DestinationViewHolder>() {

    class DestinationViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var note: TextView? = null
        var txtBafou: TextView? = null
        var txtIndo: TextView? = null
        var prix: TextView? = null
        var periode: TextView? = null

        init {
            // Define click listener for the ViewHolder's View.
            note = view.findViewById(R.id.txt_note)
            txtBafou = view.findViewById(R.id.txt_bafoussam)
            txtIndo = view.findViewById(R.id.txtIndonesia)
            prix = view.findViewById(R.id.txt_prix)
            periode = view.findViewById(R.id.txt_periode)
        }
    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DestinationAdapter.DestinationViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.destination_item, parent, false,)
        return DestinationViewHolder(view)
    }

    override fun onBindViewHolder(holder: DestinationAdapter.DestinationViewHolder, position: Int) {
        holder.note!!.setText(destinationDataSet.get(position).getNote())
        holder.txtBafou!!.setText(destinationDataSet.get(position).getTxtBafou())
        holder.txtIndo!!.setText(destinationDataSet.get(position).getTxtIndo())
        holder.prix!!.setText(destinationDataSet.get(position).getPrix())
        holder.periode!!.setText(destinationDataSet.get(position).getPeriode())
    }

    override fun getItemCount() = destinationDataSet.size
}