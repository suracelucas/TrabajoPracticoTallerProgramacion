package ar.edu.unlam.marvelmultiplataforma

import io.github.aakira.napier.DebugAntilog
import io.github.aakira.napier.Napier

actual class Platform actual constructor() {
    actual val platform: String = "Android ${android.os.Build.VERSION.SDK_INT}"
}

actual fun initLogger(){
    Napier.base(DebugAntilog())
}