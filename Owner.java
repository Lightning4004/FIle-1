package AppsDaurUlang;

public class Owner {

    private String namaOwner;
    private String alamat;
//    private Owner owner;

    public Owner(String namaOwner, String alamat) {
        this.namaOwner = namaOwner;
        this.alamat = alamat;
    }

  //  public Owner getOwner() {
    //    return owner;
    //}

    //public void setOwner(Owner owner) {
      //  this.owner = owner;
    //}

    public String getNamaP() {
        return namaOwner;
    }

    public void setNamaP(String namaP) {
        this.namaOwner = namaP;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
}