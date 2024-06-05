import java.util.ArrayList;
import java.util.List;

class BukuManager {
    private List<Buku> daftarBuku;

    public BukuManager() {
        this.daftarBuku = new ArrayList<>();
    }

    public void tambahBuku(Buku buku) {
        daftarBuku.add(buku);
    }

    public List<Buku> getDaftarBuku() {
        return daftarBuku;
    }
}
