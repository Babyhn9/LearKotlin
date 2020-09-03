import Interfaces.*
import Models.Product
import Realization.Factories.ProductFactory
import Realization.InputSystems.ConsoleInputSystem
import Realization.LoadSystems.ProductLoadSystem
import Realization.Repositories.ProductRepository
import Realization.SaveSystems.ProductSaveSystem
import Singletones.Config

fun main(args : Array<String>) {

    Config.Init("file.txt")

    val inputSystem : IInputSystem = ConsoleInputSystem()
    val saveSystem : ISaveSystem<Product> = ProductSaveSystem()
    val loadSystem : ILoadSystem<Product> = ProductLoadSystem()
    val factory : IFactory<Product,String> = ProductFactory()
    val productRepository : IRepository<Product> = ProductRepository(saveSystem,loadSystem)

    productRepository.Load()

    while (true)
    {
            val inputResult = inputSystem.ReadLine()

            if(inputResult == "*")
                    break

            val product = factory.Create(inputResult)
            productRepository.Add(product)
    }

    val all =  productRepository.GetAll()

    productRepository.Save()

    all.forEach{ el -> println("${el.Name}-${el.Count}")}
    }

