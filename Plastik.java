package AppsDaurUlang;

public class Plastik extends BarangBekas { // Ditus

    private int jumlah;
//    public double HARGA_FINAL = 7000;
    private double harga;

    public Plastik(int jumlah, Owner owner, double admin, double harga, String jenis) {
        super(owner, admin, harga, jenis);
        this.harga = harga;
        this.jumlah = jumlah;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    @Override
    public void kurangiBarang(int jumlah) {
        if (this.jumlah >= jumlah) {
            this.jumlah -= jumlah;
        } else {
            System.out.println("Stok barang kurang!");
        }
    }

    @Override
    public void tampilInfo() {
        System.out.println("Pemilik : " + getOwner().getNamaP());
        System.out.println("Alamat : " + getOwner().getAlamat());
        System.out.println("Biaya Admin : " + getAdmin());
        System.out.println("Harga : " + getHarga());
        System.out.println("Jumlah : " + jumlah);
        System.out.println("Jenis Barang : " + getJenis());
    }
}