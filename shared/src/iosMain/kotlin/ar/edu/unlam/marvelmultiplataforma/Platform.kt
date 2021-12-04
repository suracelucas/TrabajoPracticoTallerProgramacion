package ar.edu.unlam.marvelmultiplataforma

import io.github.aakira.napier.DebugAntilog
import io.github.aakira.napier.Napier
import platform.UIKit.UIDevice

actual class Platform actual constructor() {
    actual val platform: String = UIDevice.currentDevice.systemName() + " " + UIDevice.currentDevice.systemVersion
}

actual fun initLogger(){
    Napier.base(DebugAntilog())
}

actual fun md5(string: String): String {
    return ""
}