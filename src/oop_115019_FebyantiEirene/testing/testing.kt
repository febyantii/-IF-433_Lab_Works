package testing

// =========================================================
// WEEK 7: Special Classes (Enum, Sealed, Data Class)
// =========================================================

// Enum Class: Untuk nilai yang sudah pasti (konstan)
enum class PatientStatus {
    WAITING,
    IN_TREATMENT,
    DISCHARGED
}

// Sealed Class: Untuk membatasi kemungkinan hasil (biasa dipakai untuk status respon/error)
sealed class AnalysisResult {
    data class Success(val accuracy: Double, val diagnosis: String) : AnalysisResult()
    data class Error(val message: String) : AnalysisResult()
}

// Data Class: Kelas khusus untuk menyimpan data dengan ringkas
data class PatientInfo(val name: String, val age: Int, var status: PatientStatus)

// =========================================================
// WEEK 6: Interfaces & Contracts
// =========================================================
interface Diagnosable {
    // "Kontrak" yang memaksa class apapun yang memakai interface ini untuk membuat fungsinya
    fun performDiagnosis(patient: PatientInfo): AnalysisResult
}

// =========================================================
// WEEK 5 & WEEK 3: Abstraction & Encapsulation
// =========================================================
abstract class MedicalSystem(val systemName: String) {

    // Encapsulation (Private): Hanya bisa diakses dari dalam class ini sendiri
    private var accessCount: Int = 0

    // Encapsulation (Protected): Bisa diakses oleh class ini dan class turunannya (anaknya)
    protected fun logAccess() {
        accessCount++
        println("[$systemName] System accessed. Total requests: $accessCount")
    }

    // Abstraction: Fungsi yang belum ada isinya, wajib diisi oleh class turunannya
    abstract fun bootUp()
}

// =========================================================
// WEEK 4 & WEEK 2: Inheritance, Final, Classes & Memory
// =========================================================
open class HealthcareAI(systemName: String, val version: String) : MedicalSystem(systemName) {

    // Classes & Memory (Init): Blok yang langsung jalan saat objek dibuat di memori
    init {
        println("⚙️ Initializing AI Core: $systemName v$version in Memory...")
    }

    // Inheritance & Polymorphism: Mengisi fungsi abstrak dari parent class
    override fun bootUp() {
        logAccess() // Memanggil fungsi protected dari parent
        println("✅ Healthcare AI is ready to receive patient data.")
    }

    // Final: Fungsi ini tidak bisa di-override (dimodifikasi) lagi oleh class anaknya
    final fun shutDown() {
        println("🛑 Shutting down AI securely.")
    }
}

// =========================================================
// WEEK 5: Polymorphism (Menerapkan Inheritance + Interface sekaligus)
// =========================================================
class DiseasePredictor(systemName: String, version: String, val threshold: Double) :
    HealthcareAI(systemName, version), Diagnosable {

    // Polymorphism: Mendefinisikan ulang fungsi dari interface sesuai kebutuhan AI ini
    override fun performDiagnosis(patient: PatientInfo): AnalysisResult {
        logAccess()
        println("🔍 Analyzing data for ${patient.name} (Age: ${patient.age})...")

        // Week 1: Syntax Basics (If-Else)
        return if (threshold >= 0.8) {
            AnalysisResult.Success(95.5, "Indikasi sehat, tetap jaga pola hidup.")
        } else {
            AnalysisResult.Error("Data tidak cukup akurat untuk prediksi.")
        }
    }
}

// =========================================================
// WEEK 1: Kotlin Syntax Basics (Main function, val/var)
// =========================================================
fun main() {
    println("=== Health Hub Gading Serpong ===")

    // 1. Membuat objek dari Data Class
    val patient1 = PatientInfo("Budi", 45, PatientStatus.WAITING)

    // 2. Membuat objek dari Class utama (OOP Instantiation)
    val predictor = DiseasePredictor("Med-AI", "1.0", 0.85)

    // 3. Memanggil fungsi Polymorphism
    predictor.bootUp()

    // 4. Pattern Matching menggunakan 'when' (Syntax Basics tingkat lanjut) untuk menangani Sealed Class
    println("\n-- Memulai Proses --")
    when (val result = predictor.performDiagnosis(patient1)) {
        is AnalysisResult.Success -> {
            println("Hasil: ${result.diagnosis} (Akurasi: ${result.accuracy}%)")
            // Mengubah nilai var di Data Class
            patient1.status = PatientStatus.DISCHARGED
        }
        is AnalysisResult.Error -> {
            println("Error: ${result.message}")
        }
    }

    // 5. Mengecek Enum Class
    println("\nStatus Pasien Sekarang: ${patient1.status}")

    // 6. Memanggil fungsi Final
    predictor.shutDown()
}



// Studi Kasus Akhir: Arsitektur "Health Hub Gading Serpong"
//
// Konteks Cerita:
// Rumah Sakit "Health Hub Gading Serpong" sedang melakukan digitalisasi dengan membangun asisten kecerdasan buatan (AI) terpusat. Sistem ini bertujuan untuk melakukan skrining kesehatan awal berdasarkan data pasien sebelum mereka bertemu dengan dokter. Kamu ditunjuk sebagai Lead Backend Developer untuk merancang fondasi kode sistem ini menggunakan arsitektur Object-Oriented Programming (OOP) di Kotlin yang ketat dan aman.
//
// Spesifikasi Kebutuhan Sistem (Tugas Programmer):
//
// 1. Manajemen Data Pasien (Fokus: Special Classes)
// - Sistem butuh melacak status antrean pasien. Buatlah sebuah Enum Class bernama PatientStatus yang memiliki tiga nilai pasti: WAITING, IN_TREATMENT, dan DISCHARGED.
// - Buatlah sebuah Data Class bernama PatientInfo untuk menyimpan identitas pasien. Class ini wajib mencatat name (String), age (Int), dan status (PatientStatus). Status pasien harus bisa diubah sewaktu-waktu.
// - Hasil diagnosa dari AI bisa berupa keberhasilan atau kegagalan (misalnya karena data kurang). Buatlah sebuah Sealed Class bernama AnalysisResult yang memiliki dua kemungkinan turunan:
//   * Success: Menyimpan tingkat accuracy (Double) dan pesan diagnosis (String).
//   * Error: Menyimpan pesan message (String) mengapa diagnosa gagal.
//
// 2. Standarisasi Fitur Diagnosa (Fokus: Interfaces)
// - Setiap alat medis pintar di rumah sakit ini harus punya fitur diagnosa. Buatlah sebuah Interface bernama Diagnosable yang bertindak sebagai kontrak kerja. Interface ini wajib memiliki fungsi performDiagnosis yang menerima input PatientInfo dan mengembalikan nilai berupa AnalysisResult.
//
// 3. Keamanan & Template Sistem Inti (Fokus: Abstraction & Encapsulation)
// - Buatlah sebuah Abstract Class bernama MedicalSystem. Class ini menerima parameter systemName.
// - Demi keamanan, sistem harus mencatat berapa kali ia diakses, tapi data ini tidak boleh diubah sembarangan dari luar. Buatlah variabel accessCount yang bersifat Private.
// - Sediakan sebuah fungsi logAccess() dengan hak akses Protected (hanya bisa dipanggil oleh class keturunannya) yang akan menambah nilai accessCount dan mencetak log ke layar.
// - Buat sebuah fungsi abstrak bernama bootUp() yang nantinya wajib diimplementasikan oleh setiap sistem spesifik.
//
// 4. Kerangka Dasar Mesin AI (Fokus: Inheritance, Init, & Final)
// - Sistem AI adalah salah satu jenis dari sistem medis. Buat class HealthcareAI yang mewarisi (inherit) class MedicalSystem. Class ini menerima parameter systemName dan tambahan parameter version. Karena class ini nantinya akan diturunkan lagi, pastikan class ini bersifat Open.
// - Saat AI ini diciptakan di memori, ia harus otomatis mencetak pesan "Initializing AI Core..." (Gunakan blok Init).
// - Implementasikan fungsi bootUp() dari parent-nya. Saat booting, AI harus memanggil fungsi logAccess().
// - Buat sebuah fungsi shutDown() untuk mematikan AI. Karena prosedur mematikan mesin sangat krusial dan tidak boleh dimodifikasi oleh programmer lain di masa depan, kunci fungsi ini dengan keyword Final.
//
// 5. Model Prediksi Spesifik (Fokus: Polymorphism)
// - Buat class utamanya, yaitu DiseasePredictor yang mewarisi HealthcareAI sekaligus mengimplementasikan interface Diagnosable. Class ini butuh satu parameter unik: threshold (Double) sebagai batas ambang akurasi.
// - Lakukan override pada fungsi performDiagnosis(). Logikanya:
//   * Saat dipanggil, sistem harus mencatat aksesnya (logAccess()).
//   * Gunakan pengkondisian (If-Else). Jika threshold lebih dari atau sama dengan 0.8, kembalikan hasil AnalysisResult.Success dengan akurasi 95.5 dan pesan "Indikasi sehat".
//   * Jika di bawah itu, kembalikan AnalysisResult.Error dengan pesan "Data tidak cukup akurat".
//
// 6. Simulasi Eksekusi (Fokus: Syntax Basics)
// - Di dalam fungsi main(), buat satu objek pasien.
// - Buat satu objek dari DiseasePredictor.
// - Nyalakan sistemnya, jalankan diagnosa pada pasien tersebut, dan gunakan pattern matching (when) untuk mengecek apakah hasilnya Success atau Error.
// - Jika sukses, ubah status antrean pasien menjadi DISCHARGED. Terakhir, matikan sistem.