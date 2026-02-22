class Restaurant {

    private String[] namaMakanan;
    private double[] hargaMakanan;
    private int[] stok;
    private int jumlahMenu;

    public Restaurant() {
        namaMakanan = new String[10];
        hargaMakanan = new double[10];
        stok = new int[10];
        jumlahMenu = 0;
    }

    public String getNama(int index) {
        return namaMakanan[index];
    }
    public double getHarga(int index) {
        return hargaMakanan[index];
    }
    public int getStok(int index) {
        return stok[index];
    }

    public void setStok(int index, int stokBaru) {
        if (stokBaru >= 0) {
            stok[index] = stokBaru;
        } else {
            System.out.println("Stok tidak boleh negatif!");
        }
    }

    public void tambahMenu(String nama, double harga, int stokAwal) {
        if (stokAwal < 0) {
            System.out.println("Stok tidak boleh negatif!");
            return;
        }
        if (jumlahMenu >= namaMakanan.length) {
            System.out.println("Menu sudah penuh!");
            return;
        }
        namaMakanan[jumlahMenu] = nama;
        hargaMakanan[jumlahMenu] = harga;
        stok[jumlahMenu] = stokAwal;
        jumlahMenu++;
    }

    public void tampilMenu() {
        for (int i = 0; i < jumlahMenu; i++) {
            System.out.println(i + ". " + namaMakanan[i] + " | Harga: Rp." + hargaMakanan[i] + " | Stok: " + stok[i]
            );
        }
    }

    public void pesanMenu(int index, int jumlah) {
        if (index < 0 || index >= jumlahMenu) {
            System.out.println("Menu tidak ditemukan!");
            return;
        }
        if (jumlah <= 0) {
            System.out.println("Jumlah pesanan tidak valid!");
            return;
        }
        if (stok[index] >= jumlah) {
            stok[index] -= jumlah;
            System.out.println("Pesanan berhasil memesan " + namaMakanan[index]);
        } else {
            System.out.println("Stok tidak mencukupi!");
        }
    }
}