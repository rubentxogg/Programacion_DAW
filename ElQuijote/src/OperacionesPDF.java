import java.io.IOException;

import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.kernel.colors.DeviceGray;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.UnitValue;
/**
 * @author Rubentxo Contiene m�todos relacionados con el PDF.
 * Estoy usando los jar de la librer�a iText7-Core-7.1.3 y jar de slf4j.
 */
public class OperacionesPDF {

	public void generarPDF(String destino) throws IOException {
        PdfDocument pdfDoc = new PdfDocument(new PdfWriter(destino));
        Document doc = new Document(pdfDoc, PageSize.A4.rotate());

        float[] columnWidths = {1, 5, 5};
        Table table = new Table(UnitValue.createPercentArray(columnWidths));

        PdfFont f = PdfFontFactory.createFont(StandardFonts.HELVETICA);
        Cell cell = new Cell(1, 3)
                .add(new Paragraph("This is a header"))
                .setFont(f)
                .setFontSize(13)
                .setFontColor(DeviceGray.WHITE)
                .setBackgroundColor(DeviceGray.BLACK)
                .setTextAlignment(TextAlignment.CENTER);

        table.addHeaderCell(cell);

        Cell[] header = new Cell[]{
        		new Cell().setBackgroundColor(new DeviceGray(0.75f)).add(new Paragraph("#")),
        		new Cell().setBackgroundColor(new DeviceGray(0.75f)).add(new Paragraph("Key")),
                new Cell().setBackgroundColor(new DeviceGray(0.75f)).add(new Paragraph("Value"))
        };
            
        for(Cell c : header) {
            table.addHeaderCell(c);
        }
        
        for (int counter = 0; counter < 100; counter++) {
            table.addCell(new Cell().setTextAlignment(TextAlignment.CENTER).add(new Paragraph(String.valueOf(counter + 1))));
            table.addCell(new Cell().setTextAlignment(TextAlignment.CENTER).add(new Paragraph("key " + (counter + 1))));
            table.addCell(new Cell().setTextAlignment(TextAlignment.CENTER).add(new Paragraph("value " + (counter + 1))));
        }

        doc.add(table);

        doc.close();
	}
}
