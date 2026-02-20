package oop_115019_FebyantiEirene.week03

class Employee(val name: String) {
    var salary: Int = 0
        set(value) {
            println("Mencoba set gaji ke: $value")
            //Kode ini berbahaya: memanggil setter di dalam setter
            this.salary = value
        }
}