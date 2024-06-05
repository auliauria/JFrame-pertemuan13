import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BukuApp extends JFrame {
    private BukuManager bukuManager;
    private JTextField idField, judulField, penulisField, genreField, penerbitField, tanggalTerbitField;
    private JTable bukuTable;
    private DefaultTableModel tableModel;

    public BukuApp() {
        bukuManager = new BukuManager();
        setTitle("Buku Management");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel untuk input buku
        JPanel inputPanel = new JPanel(new GridLayout(7, 2));

        inputPanel.add(new JLabel("ID:"));
        idField = new JTextField();
        inputPanel.add(idField);

        inputPanel.add(new JLabel("Judul:"));
        judulField = new JTextField();
        inputPanel.add(judulField);

        inputPanel.add(new JLabel("Penulis:"));
        penulisField = new JTextField();
        inputPanel.add(penulisField);

        inputPanel.add(new JLabel("Genre:"));
        genreField = new JTextField();
        inputPanel.add(genreField);

        inputPanel.add(new JLabel("Penerbit:"));
        penerbitField = new JTextField();
        inputPanel.add(penerbitField);

        inputPanel.add(new JLabel("Tanggal Terbit (dd/MM/yyyy):"));
        tanggalTerbitField = new JTextField();
        inputPanel.add(tanggalTerbitField);

        JButton addButton = new JButton("Tambah Buku");
        inputPanel.add(addButton);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tambahBuku();
            }
        });

        add(inputPanel, BorderLayout.NORTH);

        // Tabel untuk menampilkan daftar buku
        tableModel = new DefaultTableModel();
        tableModel.addColumn("ID");
        tableModel.addColumn("Judul");
        tableModel.addColumn("Penulis");
        tableModel.addColumn("Genre");
        tableModel.addColumn("Penerbit");
        tableModel.addColumn("Tanggal Terbit");
        tableModel.addColumn("Tanggal Tambah");

        bukuTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(bukuTable);
        add(scrollPane, BorderLayout.CENTER);

        setVisible(true);
    }

    private void tambahBuku() {
        try {
            int id = Integer.parseInt(idField.getText());
            String judul = judulField.getText();
            String penulis = penulisField.getText();
            String genre = genreField.getText();
            String penerbit = penerbitField.getText();
            String tanggalTerbit = tanggalTerbitField.getText();
            String tanggalTambah = new SimpleDateFormat("dd/MM/yyyy").format(new Date());

            Buku buku = new Buku(id, judul, penulis, genre, penerbit, tanggalTerbit, tanggalTambah);
            bukuManager.tambahBuku(buku);
            tampilkanDaftarBuku();
            resetForm();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }

    private void tampilkanDaftarBuku() {
        tableModel.setRowCount(0);
        for (Buku buku : bukuManager.getDaftarBuku()) {
            tableModel.addRow(new Object[]{
                    buku.getId(),
                    buku.getJudul(),
                    buku.getPenulis(),
                    buku.getGenre(),
                    buku.getPenerbit(),
                    buku.getTanggalTerbit(),
                    buku.getTanggalTambah()
            });
        }
    }

    private void resetForm() {
        idField.setText("");
        judulField.setText("");
        penulisField.setText("");
        genreField.setText("");
        penerbitField.setText("");
        tanggalTerbitField.setText("");
    }

    public static void main(String[] args) {
        new BukuApp();
    }
}
