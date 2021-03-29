import java.io.IOException;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Table;
/**
 * @author Rubentxo Contiene métodos relacionados con el PDF.
 * Estoy usando los jar de la librería iText7-Core-7.1.3 y jar de slf4j.
 */
public class OperacionesPDF {

	public void generarPDF(String destino) throws IOException {
		PdfWriter writer = new PdfWriter(destino);
        PdfDocument pdf = new PdfDocument(writer);
        Document document = new Document(pdf);
        
        float[] pointColumnWidths = {150F, 150F, 150F};
        Table table = new Table(pointColumnWidths);
        
        table.addHeaderCell(Constantes.TEXTO_CABECERA_DE_TABLA);
        
        Cell c1 = new Cell();
        c1.add(table.addCell("Holsdsfsa"));
        
        Cell c2 = new Cell();
        c2.add(table.addCell("hello"));
        
        document.add(table);
        
        document.close();
	}
}
