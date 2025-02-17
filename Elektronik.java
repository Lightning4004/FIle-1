package AppsDaurUlang;

public class Elektronik extends BarangBekas implements KondisiElektronik { // Samuel

    private int banyak;
    private double harga;
    private boolean hidup, mati;

    public Elektronik(int banyak, Owner owner, double admin, double harga, boolean hidup, boolean mati, String jenis) {
        super(owner, admin, harga, jenis);
        this.banyak = banyak;
        this.harga = harga;
        this.hidup = hidup;
        this.mati = mati;
    }

    public int getBanyak() {
        return banyak;
    }

    public void setBanyak(int banyak) {
        this.banyak = banyak;
    }

    public boolean isHidup() {
        return hidup;
    }

    public void setHidup(boolean hidup) {
        this.hidup = hidup;
    }

    public boolean isMati() {
        return mati;
    }

    public void setMati(boolean mati) {
        this.mati = mati;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    @Override
    public String kondisi() {
        if (hidup) {
            return "Barang ini masih berfungsi dengan baik, bisa dijual lebih mahal";
        } else {
            return "Barang ini sudah rusak, buang saja";
        }

    }

    @Override
    public void kurangiBarang(int banyak) {
        if (this.banyak >= banyak) {
            this.banyak -= banyak;
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
        System.out.println("Jumlah Elektronik : " + banyak);
        System.out.println("Jenis Barang : " + getJenis());
        System.out.println("Kondisi : "+ kondisi());
    }
}