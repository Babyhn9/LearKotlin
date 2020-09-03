package Realization.Factories
import Interfaces.IFactory
import Models.Product

class ProductFactory : IFactory<Product,String> {
    override fun Create(value: String): Product {
        val splited = value.split(" ");

        if(splited.size == 2)
        {
            val leftOper = splited[0];
            val rightOper = splited[1].toIntOrNull();

            if(rightOper == null)
                return Product.Empty;
            else{
                return Product(leftOper, rightOper);
            }

        }else{
            return Product.Empty
        }

    }

    override fun Create(): Product {
        return Product.Empty
    }
}