package com.example.login.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.login.adapter.ProductAdapter

import com.example.login.databinding.ActivityHomeBinding
import com.example.login.model.Product
import com.example.login.model.User


class HomeActivity : AppCompatActivity() {


    private lateinit var binding: ActivityHomeBinding

    // private var currentUserName: String? = null
    private lateinit var currentUserName: User
    private lateinit var adapterProduct: ProductAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        instances()
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // currentUserName = intent.getStringExtra("user_name")
        currentUserName = intent.getSerializableExtra("user") as User
        if (currentUserName.profile == "Administrador") {
            binding.textUser.text = "Bienvenido jefazo"
        } else {
            binding.textUser.text = "Bienvenido ${currentUserName.mail ?: "Invitado"}"
        }
        initGUI()

    }

    private fun initGUI() {
        binding.recyclerProducts.adapter = adapterProduct;
        if (resources.configuration.orientation == 1) {
            binding.recyclerProducts.layoutManager =
                LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        } else {
            binding.recyclerProducts.layoutManager =
                GridLayoutManager(this, 2, LinearLayoutManager.VERTICAL, false)
        }
        // linear -> de arriba abajo o izq a der
        // grid -> de arriba abajo o izq a der, indicando el nº de columnas

    }

    private fun instances() {
        val list = arrayListOf<Product>(
            Product(
                1,
                "Producto1",
                10.99,
                5,
                "Description1",
                "https://m.media-amazon.com/images/I/91sgnwA+xKL._AC_UY1000_.jpg"
            ), Product(
                2,
                "Producto2",
                20.99,
                10,
                "Description2",
                "https://store.fcbarcelona.com/cdn/shop/files/Lamine_PDP.jpg?v=1782848417&width=1664"
            ), Product(
                3,
                "Producto3",
                30.99,
                10,
                "Description2",
                "https://store.fcbarcelona.com/cdn/shop/files/Lamine_PDP.jpg?v=1782848417&width=1664"
            ), Product(
                4,
                "Producto4",
                30.99,
                10,
                "Description2",
                "https://store.fcbarcelona.com/cdn/shop/files/Lamine_PDP.jpg?v=1782848417&width=1664"
            ), Product(
                5,
                "Producto2",
                50.99,
                10,
                "Description5",
                "https://store.fcbarcelona.com/cdn/shop/files/Lamine_PDP.jpg?v=1782848417&width=1664"
            ), Product(
                6,
                "Producto6",
                60.99,
                10,
                "Description6",
                "https://shop.rfef.es/cdn/shop/files/OYARZABAL-21-HOME-FRONT.png?v=1762343876&width=2000"
            )
        )
        adapterProduct = ProductAdapter(list, this)
    }

    private fun actions() {

    }
}