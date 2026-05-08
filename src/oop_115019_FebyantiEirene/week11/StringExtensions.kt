package oop_001_johnthor.week11

// Extension function dengan receiver 'this'
fun String.addGreeting(): String {
    return "Hello, $this"
}

// Extension function dengan parameter
fun String.repeatTimes(n: Int): String {
    return this.repeat(n)
}

// Extension function pada tipe nullable (String?) untuk menangani null secara aman
fun String?.isNullOrEmptyCustom(): Boolean {
    // 'this' bisa bernilai null, jadi harus ditangani
    return this == null || this.isEmpty()
}