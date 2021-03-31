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
 * @author Rubentxo Contiene métodos relacionados con el PDF.
 * Estoy usando los jar de la librería iText7-Core-7.1.3 y jar de slf4j.
 */
public class OperacionesPDF {

	/**
	 * Método que genera un documento PDF de las palabras a buscar junto con su número de apariciones.
	 * @param destino Ruta de destino donde se creará el PDF.
	 * @param textoCabecera Texto que aparecerá en la cabecera de la tabla.
	 * @throws IOException
	 */
	public void generarPDF(String destino, String textoCabecera) throws IOException {
        PdfDocument pdfDoc = new PdfDocument(new PdfWriter(destino));
        
        try(Document doc = new Document(pdfDoc, PageSize.A4.rotate());){
        	float[] columnWidths = {1, 5};
            Table table = new Table(UnitValue.createPercentArray(columnWidths));

            PdfFont f = PdfFontFactory.createFont(StandardFonts.HELVETICA);
            
            tituloTabla(table, f, textoCabecera);
            cabeceraPalabrasNumApariciones(table);
            resultadosPalabrasNumApariciones(table);
            doc.add(table);
            System.out.println("\nPDF generado con éxito.");
        }
	}

	/**
	 * Genera un array con las palabras a buscar y otro con su respectivo número de apariciones y
	 * crea una celda para cada palabra y contador correspondiente.
	 * @param table
	 * @throws IOException
	 */
	private void resultadosPalabrasNumApariciones(Table table) throws IOException {
		String[] palabras = new OperacionesFicheros().guardarPalabras(Constantes.FICHERO_PALABRAS_A_BUSCAR);
        String[] contadores = new OperacionesFicheros().conversorArrayIntToArrayString();
        
        for (int i = 0; i < palabras.length; i++) {
            table.addCell(new Cell().setTextAlignment(TextAlignment.CENTER).add(new Paragraph(palabras[i])));
            table.addCell(new Cell().setTextAlignment(TextAlignment.CENTER).add(new Paragraph(contadores[i])));
        }
	}

	/**
	 * Éste método genera la cabecera de la tabla (palabras y número de apariciones).
	 * @param table
	 */
	private void cabeceraPalabrasNumApariciones(Table table) {
		Cell[] header = new Cell[]{
        		new Cell().setBackgroundColor(new DeviceGray(0.75f)).add(new Paragraph(Constantes.TEXTO_CABECERA_TABLA_PALABRAS)),
        		new Cell().setBackgroundColor(new DeviceGray(0.75f)).add(new Paragraph(Constantes.TEXTO_CABECERA_TABLA_NUMERO_APARICIONES)),
        };
            
        for(Cell c : header) {
            table.addHeaderCell(c).setTextAlignment(TextAlignment.CENTER);
        }
	}

	/**
	 * Método que añade el título de la tabla.
	 * @param table
	 * @param f Fuente que se va a utilizar.
	 * @param textoCabecera Título de la tabla.
	 */
	private void tituloTabla(Table table, PdfFont f, String textoCabecera) {
		Cell cell = new Cell(1, 3)
                .add(new Paragraph(textoCabecera))
                .setFont(f)
                .setFontSize(13)
                .setFontColor(DeviceGray.WHITE)
                .setBackgroundColor(DeviceGray.BLACK)
                .setTextAlignment(TextAlignment.CENTER);

        table.addHeaderCell(cell);
	}
}
