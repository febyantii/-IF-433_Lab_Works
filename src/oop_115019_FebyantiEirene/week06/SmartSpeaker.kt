package oop_115019_FebyantiEirene.week06

class SmartSpeaker(override val id: String, override val name: String) : SmartDevice, Switchable {
    override fun turnOn() {
        println("Speaker $name turned on")
    }
    override fun turnOff() {
        println("Speaker $name turned off")
    }
    fun playMusic(song: String) {
        println("Memutar lagu $song dari Spotify")
    }
}