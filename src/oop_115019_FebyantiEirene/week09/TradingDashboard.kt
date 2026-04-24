package oop_115019_FebyantiEirene.week09

// File: TradingDashboard.kt

fun main() {
    val tradeHistory = listOf(
        TradeLog("BTCUSDT", "LONG", 20, 15.5, "CLOSED"),   // Profit, CLOSED
        TradeLog("ETHUSDT", "SHORT", 10, -5.2, "CLOSED"),  // Loss, CLOSED
        TradeLog("BTCUSDT", "LONG", 50, 120.0, "OPEN"),    // Profit, OPEN
        TradeLog("SOLUSDT", "SHORT", 5, -12.0, "OPEN"),    // Loss, OPEN (Koin ke-3)
        TradeLog("ETHUSDT", "LONG", 10, 25.0, "CLOSED"),   // Profit, CLOSED
        TradeLog("BTCUSDT", "SHORT", 25, -45.5, "CLOSED")  // Loss, CLOSED
    )

    println("Berhasil memuat ${tradeHistory.size} data trading.")

    val closedTrades = tradeHistory.filter { it.status == "CLOSED" }
    val winningTrades = closedTrades.filter { it.roe > 0 }
    val losingTrades = closedTrades.filter { it.roe <= 0 }

}