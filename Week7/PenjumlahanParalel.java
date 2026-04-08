import java.util.Scanner;

// Class Worker untuk melakukan tugas pembagian jumlah
class HitungWorker extends Thread {
    private int startNum;
    private int endNum;
    private long hasilParsial = 0;

    public HitungWorker(String name, int startNum, int endNum) {
        super(name);
        this.startNum = startNum;
        this.endNum = endNum;
    }

    @Override
    public void run() {
        for (int i = startNum; i <= endNum; i++) {
            hasilParsial += i;
        }
        System.out.println(getName() + ": Mengerjakan penjumlahan " + startNum + " - " + endNum + " | Hasil parsial = " + hasilParsial);
    }

    public long getHasilParsial() {
        return hasilParsial;
    }
}

public class PenjumlahanParalel {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Masukkan Jumlah Thread: ");
        int jumlahThread = input.nextInt();
        
        System.out.print("Masukkan Angka Akhir: ");
        int angkaAkhir = input.nextInt();
        
        HitungWorker[] workers = new HitungWorker[jumlahThread];
        int rentang = angkaAkhir / jumlahThread;
        int sisa = angkaAkhir % jumlahThread;
        
        int mulai = 1;
        
        // 1. Membagi Tugas (Divide)
        for (int i = 0; i < jumlahThread; i++) {
            int akhir = mulai + rentang - 1;
            
            // Jika ini thread terakhir, berikan sisa angkanya (jika pembagian tidak bulat)
            if (i == jumlahThread - 1) {
                akhir += sisa;
            }
            
            workers[i] = new HitungWorker("Thread " + (i + 1), mulai, akhir);
            workers[i].start(); // Mulai eksekusi
            
            mulai = akhir + 1; // Setel titik mulai untuk thread berikutnya
        }
        
        long hasilAkhir = 0;
        
        // 2. Menunggu & Menggabungkan (Conquer & Synchronize)
        try {
            for (int i = 0; i < jumlahThread; i++) {
                workers[i].join(); // Thread utama menunggu setiap worker selesai 
                hasilAkhir += workers[i].getHasilParsial(); // Tambahkan hasil parsial dengan aman
            }
        } catch (InterruptedException e) {
            System.out.println("Proses dihentikan!");
        }
        
        System.out.println("-------------------------------------------------");
        System.out.println("HASIL AKHIR PENJUMLAHAN KESELURUHAN: " + hasilAkhir);
        
        input.close();
    }
}