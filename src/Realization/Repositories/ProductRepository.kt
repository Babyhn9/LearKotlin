package Realization.Repositories

import Interfaces.ILoadSystem
import Interfaces.IRepository
import Interfaces.ISaveSystem
import Models.Product

class ProductRepository(var SaveSystem: ISaveSystem<Product>, var LoadSystem: ILoadSystem<Product>) : IRepository<Product> {

    private var products = mutableListOf<Product>()

    override fun Contains(product: Product): Boolean = products.contains(product);

    override fun Add(product: Product) {

        if(product != Product.Empty)
        {
            var findedProduct = Find(product.Name)

            if(findedProduct != Product.Empty)
                findedProduct.Count += product.Count
            else
                products.add(product)
        }
    }

    override fun Find(name: String): Product {
        val product = products.findLast { el -> el.Name == name}

        if(product != null)
            return  product
        else
            return  Product.Empty;
    }

    override fun GetAll(): List<Product> = products

    override fun Save() {
        SaveSystem.Save(products)
    }

    override fun Load() {
        products = LoadSystem.Load() as MutableList<Product>
    }


}