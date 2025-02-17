package AppsDaurUlang;

public class Besi extends BarangBekas { // Iis

    private double beratBesi;
    private int jumlah;
//    public double HARGA = 10000;
    private double harga;

    public Besi(int jumlah, Owner owner, double admin, double harga, double beratBesi,  String jenis) {
        super(owner, admin, harga, jenis);
        this.beratBesi = beratBesi;
        this.jumlah = jumlah;
        this.harga = harga;
    }

    public double getBeratBesi() {
        return beratBesi;
    }

    public void setBeratBesi(double beratBesi) {
        this.beratBesi = beratBesi;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    @Override
    public void kurangiBarang(int jumlah) {
        double beratPengurangan = jumlah;
        if (this.beratBesi >= beratPengurangan) {
            this.beratBesi -= beratPengurangan;
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
        System.out.println("Berat Besi : " + beratBesi);
        System.out.println("Jenis Barang : " + getJenis());
    }
}