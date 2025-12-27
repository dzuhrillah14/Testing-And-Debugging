import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class SalesItemTest {
    private SalesItem item;

    /**
     * Metode ini dijalankan sebelum setiap unit test untuk memastikan 
     * objek pengujian selalu berada dalam kondisi awal (Fixture).
     */
    @Before
    public void setUp() {
        item = new SalesItem("Laptop Gaming", 15000000);
    }

    /**
     * Menguji fungsionalitas penambahan komentar dengan data valid.
     */
    @Test
    public void testAddComment() {
        boolean result = item.addComment("Andra", "Barang mantap!", 5);
        assertTrue("Komentar valid seharusnya berhasil ditambahkan", result);
        assertEquals("Jumlah total komentar harus sesuai", 1, item.getComments().size());
    }

    /**
     * Menguji validasi nilai rating di luar batas yang ditentukan (1-5).
     */
    @Test
    public void testIllegalRating() {
        boolean tooLow = item.addComment("Budi", "Rating 0", 0);
        boolean tooHigh = item.addComment("Citra", "Rating 6", 6);

        assertFalse("Rating di bawah 1 harus ditolak oleh sistem", tooLow);
        assertFalse("Rating di atas 5 harus ditolak oleh sistem", tooHigh);
        assertEquals("Komentar tidak valid tidak boleh masuk ke daftar", 0, item.getComments().size());
    }

    /**
     * Menguji integritas data untuk mencegah penulis yang sama memberikan komentar ganda.
     */
    @Test
    public void testDuplicateAuthor() {
        item.addComment("Dini", "Sangat bagus", 4);
        boolean duplicate = item.addComment("Dini", "Komentar kedua", 5);

        assertFalse("Penulis yang sama tidak diperbolehkan memberikan komentar kedua", duplicate);
        assertEquals("Hanya satu komentar yang boleh tersimpan untuk satu penulis", 1, item.getComments().size());
    }
}
