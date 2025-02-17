package AppsDaurUlang;

public abstract class BarangBekas { // Ditus

    private Owner owner;
    protected double admin;
    private double harga;
    private String jenis; // tambahan atribut
    private int jumlah; // tambahan atribut

    public BarangBekas(Owner owner, double admin, double harga, String jenis) {
        this.owner = owner;
        this.admin = admin;
        this.harga = harga;
        this.jenis = jenis;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public double getAdmin() {
        return admin;
    }

    public void setAdmin(double admin) {
        this.admin = admin;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public abstract void kurangiBarang(int jumlah);

    public abstract void tampilInfo();
    
}