import kotlinx.cinterop.*
import platform.windows.*

@OptIn(ExperimentalForeignApi::class)
fun getWindowsVersion(): String {
    memScoped {
        val osVersionInfo = alloc<OSVERSIONINFOW>()
        osVersionInfo.dwOSVersionInfoSize = sizeOf<OSVERSIONINFOW>().convert()

        if (GetVersionExW(osVersionInfo.ptr) != 0) {
            return "Windows Version: ${osVersionInfo.dwMajorVersion}.${osVersionInfo.dwMinorVersion}, Build: ${osVersionInfo.dwBuildNumber}"
        } else {
            return "Failed to get Windows version"
        }
    }
}

actual fun getPlatform(): Platform = object : Platform {
    override val name: String = getWindowsVersion()
}