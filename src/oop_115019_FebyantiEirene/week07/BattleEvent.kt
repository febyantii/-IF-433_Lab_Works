package oop_115019_FebyantiEirene.week07

sealed class BattleState {
    data class MonsterEncounter(val monsterName: String) : BattleState()
    data class LootDropped(val item: GameItem) : BattleState()
    object SafeZone : BattleState()
    data class GameOver(val message: String) : BattleState()
}