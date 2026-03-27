package oop_115019_FebyantiEirene.week07

fun processEvent(event: BattleState) {
    when (event) {
        is BattleState.MonsterEncounter -> {
            // Smart Cast: Mengakses properti monsterName
            println("Awas! Kamu bertemu dengan monster: ${event.monsterName}")
        }

        is BattleState.LootDropped -> {
            // Destructuring: Mengambil data dari properti item (GameItem)
            val item = event.item
            println("Hoki! Monster menjatuhkan [${item.rarity}] ${item.name} (Damage: ${item.damage})")
        }

        BattleState.SafeZone -> {
            // Karena SafeZone adalah 'object', tidak perlu menggunakan 'is'
            println("Kamu berada di Area Aman. Waktunya beristirahat.")
        }

        is BattleState.GameOver -> {
            println("=== GAME OVER ===")
            println("Pesan: ${event.message}")
        }
    }
}