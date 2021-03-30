import java.io.IOException;

import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.List;
import com.itextpdf.layout.element.ListItem;
import com.itextpdf.layout.element.Paragraph;

public class Prueba {

	public static void main(String[] args) throws IOException {
		new Prueba().creaPdf("C:\\Users\\20207\\Documents\\pruebapdfrubentxo.pdf");
	}
	
	public void creaPdf(String destino) throws IOException {
		
        PdfWriter writer = new PdfWriter(destino);
        
        PdfDocument pdf = new PdfDocument(writer);
        
        Document document = new Document(pdf);
        
        PdfFont font = PdfFontFactory.createFont(StandardFonts.HELVETICA);
        
        document.add(new Paragraph("iText es :").setFont(font));
        
        List list = new List()
                .setSymbolIndent(12)
                .setListSymbol("\u2022")
                .setFont(font);
        
        list.add(new ListItem("Never gonna give you up"))
        .add(new ListItem("Never gonna let you down"))
        .add(new ListItem("Never gonna run around and desert you"))
        .add(new ListItem("Never gonna make you cry"))
        .add(new ListItem("Never gonna say goodbye"))
        .add(new ListItem("Never gonna tell a lie and hurt you"));
        
        document.add(list);

        document.close();
	}
}
