package AppsDaurUlang;

import java.util.Scanner;

public class AppsMain{

    private static final String VALID_EMAIL = ".*@gmail\\.com";
    private static final String VALID_PASSWORD = "^[a-zA-Z]{4}[a-zA-Z0-9]{3,}$";

    private static int barangCount = 0;
    private static int transaksiCount = 0;

    private static BarangBekas[] barang;
    private static Transaksi[] transaksi;
    private static Owner[] owner;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        barang = new BarangBekas[100];
        transaksi = new Transaksi[100];
        owner = new Owner[100];

        System.out.println(">>>>>>>>>> SELAMAT DATANG DI MY DAUR ULANG <<<<<<<<<<");
        System.out.println();

        String emailUser = null;
        String pwUser = null;
        boolean loginSuccess = false;
        do {
            System.out.println("Silahkan login dengan akun Anda!");
            System.out.println();
            System.out.print("Masukan email Anda\t: ");
            emailUser = in.next();
            System.out.print("Password\t: ");
            pwUser = in.next();

            if (emailUser.matches(VALID_EMAIL) && pwUser.matches(VALID_PASSWORD)) {
                System.out.println("Login Anda berhasil !)");
                loginSuccess = true; // Set loginSuccess menjadi true agar keluar dari loop
            } else {
                System.out.println("Email/password tidak cocok silahkan login ulang!");
            }
        } while(!loginSuccess);

        // Menginisialisasi beberapa barang untuk demonstrasi
        barang[barangCount++] = new Plastik(
                100, new Owner("Benedictus Ditus Atmarestanto", "Jl. Mekarsari No. 12, Jakarta"),1000, 2000, "Plastik");
        barang[barangCount++] = new Besi(
                10, new Owner("Iis Sukmawati", "Jl. Sudirman No. 10, Bandung"), 2000, 3000, 50,"Besi");
        barang[barangCount++] = new Kertas(
                100, new Owner("Maria Regina Nula Lewar", "Jl. Gatot Subroto No. 5, Surabaya"), 500, 5000, false, true, false, "Kertas");
        barang[barangCount++] = new Elektronik(
                10, new Owner("Samuel Jeremiah Hastiawan Serang", "Jl. Diponegoro No. 3, Yogyakarta"), 1000, 10000, true, false, "Elektronik");

        int pilih;
        do {
            System.out.println();
            System.out.println("Menu Utama\n"
                    + "1. Daftar barang bekas\n"
                    + "2. Beli barang bekas\n"
                    + "3. Riwayat Transaksi\n"
                    + "4. Keluar");

            System.out.print("Silahkan pilih menu kami : ");
            pilih = in.nextInt();

            switch (pilih) {
                case 1:
                    daftarBarangBekas(barang);
                    break;
                case 2:
                    beliBarangBekas(in, barang, transaksi);
                    break;
                case 3:
                    riwayatTransaksi(transaksi);
                    break;
                case 4:
                    System.out.println("Terimakasih telah menggunakan layanan aplikasi kami. Have a nice day :)");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
                    break;
            }
        } while (pilih != 4);
    }

    public static boolean isEmpty() {
        return barangCount == 0;
    }

    private static void daftarBarangBekas(BarangBekas[] barang) {
        if (isEmpty()) {
            System.out.println("Tidak ada barang bekas tersedia.");
        } else {
            System.out.println("Jenis barang bekas yang tersedia:");
            for (int i = 0; i < barangCount; i++) {
                if (barang[i] != null) {
                    barang[i].tampilInfo();
                    System.out.println("-----");
                }
            }
        }
    }

   private static void beliBarangBekas(Scanner in, BarangBekas[] barangList, Transaksi[] transaksi) {
        // Menampilkan barang-barang dari pemilik-pemiliknya
        System.out.println("Pilih barang yang ingin Anda beli berdasarkan nomor urut: ");
        int count = 1;
        for (BarangBekas barang : barangList) {
            if (barang != null) {
                System.out.println(count + ". " + barang.getJenis() + " (Pemilik: " + barang.getOwner().getNamaP() + ")");
                count++;
            }
        }
        System.out.print("Pilih: ");
        int pilihan = in.nextInt();

        // Memastikan nomor urut barang yang dipilih valid
        if (pilihan < 1 || pilihan > count - 1 || barangList[pilihan - 1] == null) {
            System.out.println("Nomor urut barang tidak valid.");
            return;
        }

        BarangBekas barang = barangList[pilihan - 1];
        System.out.println("Anda memilih barang:");
        barang.tampilInfo();

        System.out.print("Masukkan jumlah yang ingin dibeli: ");
        int jumlah = in.nextInt();

        double totalHarga = barang.getHarga() * jumlah + barang.getAdmin();

        System.out.println("Total harga: " + totalHarga);
        System.out.println("Melakukan transaksi...");

        // Mengurangi jumlah barang
        barang.kurangiBarang(jumlah);

        
        // Membuat objek Customer (asumsi kelas Customer ada dan memiliki konstruktor yang sesuai)
        System.out.print("Masukkan nama pembeli: ");
        String namaPembeli = in.next();
        System.out.print("Masukkan alamat pembeli: ");
        String alamatPembeli = in.next();
        Costumer pembeli = new Costumer(namaPembeli, alamatPembeli);

        // Membuat objek Transaksi
        Transaksi newTransaksi = new Transaksi("21 Juni 2024", jumlah, barang.getHarga(), pembeli, barang,barang.getAdmin());

        // Menyimpan transaksi ke dalam array transaksi
        for (int i = 0; i < transaksi.length; i++) {
            if (transaksi[i] == null) {
                transaksi[i] = newTransaksi;
                transaksiCount++; // Menambah jumlah transaksi yang tercatat
                break;
            }
        }

        System.out.println("Transaksi berhasil!");
    }


            private static void riwayatTransaksi(Transaksi[] transaksi) {
        if (transaksiCount == 0) {
            System.out.println("Belum ada transaksi yang dilakukan.");
        } else {
            System.out.println("Riwayat Transaksi:");
            for (int i = 0; i < transaksiCount; i++) {
                System.out.println("Tanggal: " + transaksi[i].getTanggal());
                System.out.println("Jumlah Barang: " + transaksi[i].getJumlahBarang());
                System.out.println("Harga Jual: " + transaksi[i].getHargaJual());
                System.out.println("Pembeli: " + transaksi[i].getCostumer().getNama());
                System.out.println("Pemilik: " + transaksi[i].getItem().getOwner().getNamaP());
                System.out.println("Total Harga: " + transaksi[i].totalHarga());
                System.out.println("------");
            }
        }
    }
}