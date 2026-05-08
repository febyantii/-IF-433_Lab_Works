package oop_115019_FebyantiEirene.week11

fun main() {
    // Siapkan penampung perangkat
    val homeDevices = mutableListOf<SmartDevice>()

    val lamp = SmartDevice("Philips WiZ Living Room", "Lighting").apply {
        isOnline = true
        powerLoad = 12
    }.also {
        homeDevices.add(it)
    }

    SmartDevice("Ezviz Outdoor", "Camera").apply {
        isOnline = true
        powerLoad = 5
    }.also {
        println("(LOG) Kamera terhubung")
        homeDevices.add(it)
    }

    val acUnit = run {
        val device = SmartDevice("Daikin Inverter (Kabel 3x2.5)", "HVAC", false, 800)
        device // Return objek ini
    }
    homeDevices.add(acUnit)

    // Menambah alat pakan peliharaan
    homeDevices.add(SmartDevice("Picolo's Auto Feeder", "Pet Care", true, 10))

    val searchResult = homeDevices.find { it.category == "Camera" }

    // Eksekusi diagnosis hanya jika searchResult tidak null
    searchResult?.let {
        println("Hasil Pencarian: ${it.diagnose()}")
    }

    println("\n=== SMART HOME DASHBOARD SUMMARY ===")
    with(homeDevices) {
        println("Total Perangkat: ${this.size}")
        this.forEach { device ->
            println(device.diagnose())
        }
    }
}