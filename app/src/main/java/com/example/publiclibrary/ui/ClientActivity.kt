package com.example.publiclibrary.ui

import android.app.Dialog
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import com.example.publiclibrary.R
import com.example.publiclibrary.core.createDialog
import com.example.publiclibrary.core.createProgressDialog
import com.example.publiclibrary.core.hideSoftKeyboard
import com.example.publiclibrary.databinding.ActivityClientBinding
import com.example.publiclibrary.databinding.LayoutClientAddBinding
import com.example.publiclibrary.presentation.ClientViewModel
import com.example.publiclibrary.ui.adapter.ClientListAdapter
import org.json.JSONObject
import org.koin.androidx.viewmodel.ext.android.viewModel


class ClientActivity : AppCompatActivity(), SearchView.OnQueryTextListener {

    private val dialog by lazy { createProgressDialog()}
    private val viewModel by viewModel<ClientViewModel>()
    private val adapter by lazy { ClientListAdapter() }
    private val binding by lazy { ActivityClientBinding.inflate(layoutInflater)}



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setSupportActionBar(binding.clientToolbar)
        binding.rvClient.adapter = adapter
        viewModel.getAllClients()

        viewModel.clients.observe(this){
            when (it){
                ClientViewModel.State.Loading -> dialog.show()
                is ClientViewModel.State.Error -> {
                    createDialog{
                        setMessage(it.error.message)
                    }.show()
                    dialog.dismiss()
                }
                is ClientViewModel.State.Success -> {
                    dialog.dismiss()
                    adapter.submitList(it.list)
                    adapter.onItemClick = { client ->
                        createDialog(){
                            setMessage(client.toString()).create().show()
                        }
                    }
                    }
                }
        }



        binding.fabClient.setOnClickListener {
            val dialogpop = Dialog(this)
            val bindingpop by lazy { LayoutClientAddBinding.inflate(layoutInflater) }
            dialogpop.setContentView(bindingpop.root)

            bindingpop.vClose.setOnClickListener {
                dialogpop.dismiss()
            }
            bindingpop.btAddClient.setOnClickListener{
                val name : EditText = bindingpop.etxtName
                val cpf : EditText = bindingpop.etxtCpf
                val cep : EditText = bindingpop.etxtCep

                val cpfAdd = cpf.getText().toString()
                val nameAdd = name.getText().toString()
                val cepAdd = cep.getText().toString()

                val jsonEndereco = JSONObject()
                jsonEndereco.put("cep", cepAdd)

                val jsonAddFinal = JSONObject()
                jsonAddFinal.put("cpf", cpfAdd)
                jsonAddFinal.put("name", nameAdd)
                jsonAddFinal.put("endereco", jsonEndereco)


                viewModel.addClientUseCase(jsonAddFinal)
                bindingpop.root.hideSoftKeyboard()
            }
            dialogpop.show()
        }

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_client, menu)
        val searchView = menu.findItem(R.id.action_search).actionView as SearchView
        searchView.setOnQueryTextListener(this)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        query?.let { viewModel.getClientList(query) }
        binding.root.hideSoftKeyboard()
        return true
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        Log.e(TAG, "onQueryTextChange: " + newText)
        return false
    }

    companion object{
        private const val TAG = "TAG"
    }


}