package Singletones
object Config {

    var Path : String = ""
    private  var IsInited = false;

    fun Init(path: String){
        if(!IsInited)
        {
            Path = path
        }
    }



}