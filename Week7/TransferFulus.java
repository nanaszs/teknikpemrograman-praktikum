class Account {
    int balance = 150;
}

public class TransferFulus {
    public static void main(String[] args) throws InterruptedException {
        Account acc1 = new Account();
        Account acc2 = new Account();

        // Thread 1: Menjumlahkan/ transfer fulus dari acc1 ke acc2
        Thread t1 = new Thread(() -> {
            synchronized (acc1) { // Mengunci acc1 pertama agar thread lain tidak bisa memodifikasinya
                System.out.println("Thread 1: Mengunci acc1, sebelum mengunci acc2");
                try { Thread.sleep(100); } catch (Exception e) {} // Memerlukan Exception karena sleep bisa terkena InterruptedException jika dipaksa berhenti

                synchronized (acc2) { // Mengunci acc2 untuk mulai transfer
                    System.out.println("Thread 1: Berhasil mengunci acc1 dan acc2, mentransfer acc1 ke acc2.");
                    acc2.balance += acc1.balance;
                }
            }
        });

        // Thread 2: Menjumlahkan/ transfer fulus dari acc2 ke acc1
        Thread t2 = new Thread(() -> {
            // SOLUSI: Ubah urutan penguncian agar SAMA dengan Thread 1 (acc1 dulu, baru acc2)
            synchronized (acc1) { // Mengunci acc1 dahulu untuk mencegah Deadlock
                System.out.println("Thread 2: Mengunci acc1, sebelum mengunci acc2...");
                try { Thread.sleep(100); } catch (Exception e) {}

                synchronized (acc2) { // Mengunci acc2 untuk mulai transfer
                    System.out.println("Thread 2: Berhasil mengunci acc1 dan acc2, mentransfer acc2 ke acc1.");
                    acc1.balance += acc2.balance;
                }
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("--- HASIL AKHIR ---");
        System.out.println("Saldo Akhir acc1: " + acc1.balance);
        System.out.println("Saldo Akhir acc2: " + acc2.balance);
    }
}