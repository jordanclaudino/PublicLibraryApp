package com.example.publiclibrary.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.publiclibrary.data.model.Client
import com.example.publiclibrary.databinding.RepoClientBinding

class ClientListAdapter : ListAdapter<Client, ClientListAdapter.ViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = RepoClientBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, positition: Int) {
        holder.bind(getItem(positition))
    }

    var onItemClick: ((Client) -> Unit)? = null

    var cpfClient : String? = null

    inner class ViewHolder(private val binding: RepoClientBinding) :
            RecyclerView.ViewHolder(binding.root){

                fun bind(item: Client){
                    binding.tvClientCod.text = item.cpf
                    binding.tvClientName.text = item.nome
                    binding.mcvCliente.setOnClickListener{
                        cpfClient = item.cpf
                        onItemClick?.invoke(item)
                    }
                }
            }
}

class DiffCallback : DiffUtil.ItemCallback<Client>(){
    override fun areItemsTheSame(oldItem: Client, newItem: Client) = oldItem == newItem
    override fun areContentsTheSame(oldItem: Client, newItem: Client) = oldItem.cpf == newItem.cpf

}