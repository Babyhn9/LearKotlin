package Realization.LoadSystems

import Interfaces.ILoadSystem
import Models.Product
import Realization.Factories.ProductFactory
import Singletones.Config
import java.io.File
import java.io.InputStreamReader

class ProductLoadSystem : ILoadSystem<Product>{
    override fun Load(): List<Product> {


        val file = File(Config.Path)
        var reader : InputStreamReader? = null

        if(file.exists()){
            reader = file.reader()
        }else{
            file.createNewFile()
            reader = file.reader()
        }

        val allText = reader.readLines()
        val factory = ProductFactory()
        val productList = mutableListOf<Product>()

        for(line in allText)
        {
            val product = factory.Create(line.trim())

            if(product != Product.Empty)
                productList.add(product)

        }

        return  productList
    }


}