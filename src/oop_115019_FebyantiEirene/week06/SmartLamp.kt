package oop_115019_FebyantiEirene.week06

class SmartLamp(override val id: String, override val name: String) : SmartDevice, Switchable {
    override fun turnOn() {
        println("SmartLamp $name turned on")
    }
    override fun turnOff() {
        println("SmartLamp $name turned off")
    }
}