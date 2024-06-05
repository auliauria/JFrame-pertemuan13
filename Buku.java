class Buku {
    private int id;
    private String judul;
    private String penulis;
    private String genre;
    private String penerbit;
    private String tanggalTerbit;
    private String tanggalTambah;

    public Buku(int id, String judul, String penulis, String genre, String penerbit, String tanggalTerbit, String tanggalTambah) {
        this.id = id;
        this.judul = judul;
        this.penulis = penulis;
        this.genre = genre;
        this.penerbit = penerbit;
        this.tanggalTerbit = tanggalTerbit;
        this.tanggalTambah = tanggalTambah;
    }

    public int getId() {
        return id;
    }

    public String getJudul() {
        return judul;
    }

    public String getPenulis() {
        return penulis;
    }

    public String getGenre() {
        return genre;
    }

    public String getPenerbit() {
        return penerbit;
    }

    public String getTanggalTerbit() {
        return tanggalTerbit;
    }

    public String getTanggalTambah() {
        return tanggalTambah;
    }
}

