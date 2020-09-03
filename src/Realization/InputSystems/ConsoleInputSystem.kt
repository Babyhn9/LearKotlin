package Realization.InputSystems

import Interfaces.IInputSystem

class ConsoleInputSystem : IInputSystem {
    override fun ReadLine(): String
    {
        val result = readLine()

        if(result == null)
            return "";
        else
            return result;
    }

}