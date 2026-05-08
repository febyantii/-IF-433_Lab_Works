package oop_001_johnthor.week10

class WalletRepository<T> {
    private val items = mutableListOf<T>()

    fun add(item: T) {
        items.add(item)
    }

    fun getAll(): List<T> {
        return items
    }

    // Tambahkan metode ini di dalam class WalletRepository
    fun findItem(predicate: (T) -> Boolean): T? {
        return items.find(predicate)
    }
}

