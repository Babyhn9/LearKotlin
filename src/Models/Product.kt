package Models

data class Product(var Name: String, var Count : Int)
{
    companion object{
        val Empty = Product("", 0);
    }
    override fun equals(other: Any?): Boolean {

        if(other is Product)
            return Name == other.Name;

        return super.equals(other)
    }
}