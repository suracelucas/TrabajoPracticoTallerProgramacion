package ar.edu.unlam.marvelmultiplataforma

expect class Platform() {
    val platform: String
}

expect fun initLogger()

expect fun md5(string: String): String