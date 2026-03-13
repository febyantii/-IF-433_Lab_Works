package oop_115019_FebyantiEirene.week06

class SmartCCTV(override val id: String, override val name: String) : SmartDevice, Switchable, Recordable {
    override fun turnOn() {
        println("SmartCCTV $name turned on")
        startRecord()
    }

    override fun turnOff() {
        println("SmartCCTV $name turned off")
    }

    override fun startRecord() {
        println("SmartCCTV $name started record")
    }
}