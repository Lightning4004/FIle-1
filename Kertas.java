package AppsDaurUlang;

public class Kertas extends BarangBekas implements KondisiKertas { // Gita

    private int lembar;
    private double harga;
//    public double HARGA_FINAL = 5000;

    public Kertas(int lembar, Owner owner, double admin, double harga, boolean Jamur, boolean robek, boolean kotor, String jenis) {
        super(owner, admin, harga, jenis);
        this.lembar = lembar;
        this.harga = harga;
        this.jamur = jamur;
        this.robek = robek;
        this.kotor = kotor;
    }
    private boolean jamur, robek, kotor;

    public boolean isJamur() {
        return jamur;
    }

    public void setJamur(boolean jamur) {
        this.jamur = jamur;
    }

    public boolean isRobek() {
        return robek;
    }

    public void setRobek(boolean robek) {
        this.robek = robek;
    }

    public boolean isKotor() {
        return kotor;
    }

    public void setKotor(boolean kotor) {
        this.kotor = kotor;
    }

    public int getLembar() {
        return lembar;
    }

    public void setLembar(int lembar) {
        this.lembar = lembar;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    @Override
    public boolean isBusuk() {
        if (jamur) {
            return true;
        }
        if (robek) {
            return true;
        }
        if (kotor) {
            return true;
        }
        return false; // penyederhanaan if, tanpa else
    }

    @Override
    public void kurangiBarang(int jumlah) {
        if (this.lembar >= lembar) {
            this.lembar -= lembar;
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
        System.out.println("Lembar : " + lembar);
        System.out.println("Jenis Barang : " + getJenis());
    }
}