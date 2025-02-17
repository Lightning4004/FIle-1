package AppsDaurUlang;

public class Transaksi {

    private String tanggal;
    private int jumlahBarang;
    private double hargaJual;
    private Costumer costumer;
    private BarangBekas item;
    private double admin;

    public Transaksi(String tanggal, int jumlahBarang, double hargaJual, Costumer costumer, BarangBekas item, double admin) {
        this.tanggal = tanggal; 
        this.jumlahBarang = jumlahBarang;
        this.hargaJual = hargaJual;
        this.costumer = costumer;
        this.item = item;
        this.admin = admin;
    }

    public double getAdmin() {
        return admin;
    }

    public void setAdmin(double admin) {
        this.admin = admin;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public int getJumlahBarang() {
        return jumlahBarang;
    }

    public void setJumlahBarang(int jumlahBarang) {
        this.jumlahBarang = jumlahBarang;
    }

    public double getHargaJual() {
        return hargaJual;
    }

    public void setHargaJual(double hargaJual) {
        this.hargaJual = hargaJual;
    }

    public Costumer getCostumer() {
        return costumer;
    }

    public void setCostumer(Costumer costumer) {
        this.costumer = costumer;
    }

    public BarangBekas getItem() {
        return item;
    }

    public void setItem(BarangBekas item) {
        this.item = item;
    }

    public double totalHarga() {
        return jumlahBarang * hargaJual + admin;
    }
}