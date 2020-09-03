package Interfaces

import Models.Product

interface IRepository<T> {
    fun Contains(product : T) : Boolean
    fun Add(product: T)
    fun Find(name: String) : T
    fun GetAll() : List<T>
    fun Save()
    fun Load()
}