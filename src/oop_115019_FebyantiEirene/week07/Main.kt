package oop_115019_FebyantiEirene.week07

fun main() {
    println("=== TEST SINGLETON ===")
    println("Status: ${DatabaseManager.connectionStatus}")
    DatabaseManager.connect()

    println("\n=== TEST COMPANION OBJECT ===")
    val client = NetworkClient.createClient()
    client.connect()

    println("\n=== TEST REGULAR CLASS ===")
    val reg1 = RegularUser("Alice", 22)
    val reg2 = RegularUser("Alice", 22)
    println(reg1)
    println("Sama? ${reg1 == reg2}")

    println("\n=== TEST DATA CLASS ===")
    val data1 = RegularUser("Alice", 22)
    val data2 = RegularUser("Alice", 22)
    println(data1)
    println("Sama? ${data1 == data2}")

    val data3 = data1.copy(age = 23)
    println("Hasil Copy: $data3")

    val(userName, userAge) = data1
    println("Destructured: $userName berumur $userAge")

    println("\n=== TEST SEALED CLASS ===")
    val response: ApiResponse = ApiResponse.Success("Data berhasil ditarik!")

    val uiMessage = when(response) {
        is ApiResponse.Loading -> "Tampilkan Spinner"
        is ApiResponse.Success -> "Tampilkan ${response.data}"
        is ApiResponse.Error -> "Munculkan alert: ${response.message}"
    }

    println(uiMessage)

    println("\n=== TEST ASSIGNMENT ===")
    GameManager.startGame()
    GameManager.startGame()

    val legendaryChance = ItemRarity.LEGENDARY.dropChance
    println("Peluang mendapatkan item LEGENDARY: $legendaryChance%")

    val starterSword = Weapon.forgeStarterSword()
    println("Senjata Awal Pemain Telah Ditempa!")
    println("Nama Senjata : ${starterSword.item.name}")
    println("Damage       : ${starterSword.item.damage}")
    println("Rarity       : ${starterSword.item.rarity}") // Sesuaikan 'rarity' atau 'itemRarity'
    println("Durability   : ${starterSword.durability}")

    val starterWeapon = Weapon.forgeStarterSword()
    val upgradedItem = starterWeapon.item.copy(
        name = "Pedang Kayu Legendaris (Upgraded)",
        damage = 25
    )

    println("=== SIMULASI UPGRADE & EVENT ===")
    println("Senjata di-upgrade! Damage baru: ${upgradedItem.damage}")

    processEvent(BattleState.SafeZone)
    processEvent(BattleState.MonsterEncounter("Goblin Nakal"))
    processEvent(BattleState.LootDropped(upgradedItem))
    processEvent(BattleState.GameOver("Terkena Jebakan Racun"))

}