package AppsDaurUlang;

public class Costumer { // Iis

    //private Costumer costumer;
    private String nama;
    private String alamat;

    public Costumer(String nama, String alamat) {
        this.nama = nama;
        this.alamat = alamat;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

 //   public Costumer getCostumer() {
   //     return costumer;
    //}

    //public void setCostumer(Costumer costumer) {
   //     this.costumer = costumer;
    //}

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
}