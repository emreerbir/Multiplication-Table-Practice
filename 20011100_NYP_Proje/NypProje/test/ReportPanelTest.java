import javax.swing.table.DefaultTableModel;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import nypproje.ReportPanel;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class ReportPanelTest {

    private ReportPanel reportPanel;

    @Before
    public void setup() {
        reportPanel = new ReportPanel();
    }

    @Test
    public void testSaveReportListToCsv() throws IOException {
        // Verileri içeren bir örnek liste oluştur
        List<String[]> reportList = new ArrayList<>();
        String[] row1 = {"1", "Çocuk 1", "Kod 1", "100", "80", "20", "2023-06-09"};
        String[] row2 = {"2", "Çocuk 2", "Kod 2", "90", "70", "20", "2023-06-10"};
        reportList.add(row1);
        reportList.add(row2);
        reportPanel.setReportList(reportList);

        // CSV dosyasını kaydetme metodunu çağır
        reportPanel.saveReportListToCsv(0);

        // Dosyanın başarıyla kaydedildiğini doğrula
        // Test dosyasının varlığını ve içeriğini kontrol etmek için gerekli adımları ekleyebilirsiniz
        // Bu örnek sadece metodu çağırmayı ve hata fırlatmadığını doğrulamaktadır.
    }

    @Test
    public void testUpdateTable() {
        // Verileri içeren bir örnek liste oluştur
        List<String[]> reportList = new ArrayList<>();
        String[] row1 = {"1", "Çocuk 1", "Kod 1", "100", "80", "20", "2023-06-09"};
        String[] row2 = {"2", "Çocuk 2", "Kod 2", "90", "70", "20", "2023-06-10"};
        reportList.add(row1);
        reportList.add(row2);
        reportPanel.setReportList(reportList);

        // Tabloyu güncelle
        reportPanel.updateTable();

        // Güncellenen tablonun doğru bir şekilde ayarlandığını doğrula
        DefaultTableModel model = (DefaultTableModel) reportPanel.getReportTable().getModel();
        assertEquals(2, model.getRowCount());
        assertEquals(7, model.getColumnCount());
        assertEquals("Çocuk 1", model.getValueAt(0, 1));
        assertEquals("Kod 1", model.getValueAt(0, 2));
        // Diğer hücrelerin doğruluğunu doğrulayın
    }
}
