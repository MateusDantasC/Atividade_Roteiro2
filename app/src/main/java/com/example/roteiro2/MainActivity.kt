package com.example.roteiro2

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class MainActivity : AppCompatActivity() {

    private lateinit var novoNomeEditText: EditText
    private lateinit var adicionarNomeBotao: Button
    private lateinit var removerNomeBotao: Button
    private lateinit var nomesListView: ListView
    private lateinit var nomesAdapter: ArrayAdapter<String>
    private val listaNomes = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        novoNomeEditText = findViewById(R.id.novoNomeEditText)
        adicionarNomeBotao = findViewById(R.id.adicionarNomeButton)
        removerNomeBotao = findViewById(R.id.removerNomeButton)
        nomesListView = findViewById(R.id.nomesListView)

        // Inicializar o ArrayAdapter para vincular a lista ao ListView
        nomesAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listaNomes)
        nomesListView.adapter = nomesAdapter

        // Adicionar um nome à lista ao clicar no botão "Adicionar"
        adicionarNomeBotao.setOnClickListener {
            val novoNome = novoNomeEditText.text.toString().trim()
            if (novoNome.isNotEmpty()) {
                listaNomes.add(novoNome)
                nomesAdapter.notifyDataSetChanged()
                novoNomeEditText.text.clear()
            } else {
                Toast.makeText(this, getString(R.string.msg_digite_nome), Toast.LENGTH_SHORT).show()
            }
        }

        removerNomeBotao.setOnClickListener {
            if (listaNomes.isNotEmpty()) {
                listaNomes.removeAt(listaNomes.size - 1)
                nomesAdapter.notifyDataSetChanged()
            } else {
                Toast.makeText(
                    this,
                    getString(R.string.msg_lista_vazia),
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_principal, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.ItemConfiguracao -> {
                Toast.makeText(
                    this@MainActivity,
                    getString(R.string.msg_configuracao_selecionada),
                    Toast.LENGTH_LONG
                ).show()
            }
            R.id.ItemSobre -> {
                Toast.makeText(
                    this@MainActivity,
                    getString(R.string.msg_sobre_selecionado),
                    Toast.LENGTH_LONG
                ).show()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}












