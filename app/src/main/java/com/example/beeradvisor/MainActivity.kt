package com.example.beeradvisor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val findBeer = findViewById<Button>(R.id.find_beer)
        val beerColor = findViewById<Spinner>(R.id.beer_color)
        val color = "${beerColor.selectedItem}"
        val beerList =  getBeers(color.toString())
        val beer = beerList.reduce { acc, s -> acc + '\n' + s  }
        val brand = findViewById<TextView>(R.id.brands)

        findBeer.setOnClickListener{
            brand.text = beer

        }
    }

    fun getBeers(color: String): List<String> {
        return when(color){
            "Light" -> listOf<String>("Jail Pale Ale", "Lager Lite")
            "Amber" -> listOf<String>("Jack Amber", "Red Moose")
            "Brown" -> listOf<String>("Brown Bear Beer", "Bock Brownie")
            else -> listOf("Gout Stout","Dark Daniel")
        }
    }


}