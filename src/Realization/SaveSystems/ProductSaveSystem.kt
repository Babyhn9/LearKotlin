package Realization.SaveSystems

import Interfaces.ISaveSystem
import Models.Product
import Singletones.Config
import java.io.File

class ProductSaveSystem : ISaveSystem<Product> {
    override fun Save(elements: List<Product>) {
        var  finalString = ""
        val file = File(Config.Path)
        val writer = file.writer()

        elements.forEach {el -> finalString +="${el.Name} ${el.Count}\n"}
        writer.write(finalString)
        writer.close()
    }
}