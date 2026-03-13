package oop_115019_FebyantiEirene.week06

interface SmartDevice {
    var id: String
    var name: String
}

interface Switchable {
    fun turnOn()
    fun turnOff()
}

interface Recordable {
    fun startRecord()
    fun stopRecord() {
        println("Perekaman dihentikan dan disimpan ke Cloud.")
    }
}