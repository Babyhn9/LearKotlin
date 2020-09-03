package Interfaces
import Models.Product

interface IFactory<Instatiate, InitInfo>{
    fun Create(value : InitInfo): Instatiate
    fun Create() : Instatiate
}