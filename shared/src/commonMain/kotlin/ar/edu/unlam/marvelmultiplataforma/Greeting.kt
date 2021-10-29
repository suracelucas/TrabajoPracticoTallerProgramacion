package ar.edu.unlam.marvelmultiplataforma

class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }
}