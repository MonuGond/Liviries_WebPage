package receiptOtherAirport;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
;

/**
 * Servlet implementation class ReceiptOtherAirportPdfServlet
 */
public class ReceiptOtherAirportPdfServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReceiptOtherAirportPdfServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				// String fileName = new SimpleDateFormat("yyyyMMddHHmmss'.pdf'").format(new
				// Date());
		response.setContentType("application/pdf");

		ServletOutputStream out = response.getOutputStream();

		String t_receiver = request.getParameter("t_receiver");
		String t_airportname = request.getParameter("t_airportname");
		String t_airportaddress = request.getParameter("t_airportaddress");

		String f_sender = request.getParameter("f_sender");
		String f_airportname = request.getParameter("f_airportname");
		String f_airportaddress = request.getParameter("f_airportaddress");

		// int issue_vr_no = Integer.parseInt(request.getParameter("issue_vr_no"));
		String issue_vr_no = request.getParameter("issue_vr_no");

		try {

			try {

				Document document = new Document(PageSize.A4);
				PdfWriter.getInstance(document, out);

				System.out.println("Pdf start to created................step1");

				document.open();

				Image image = Image.getInstance(
						"C:\\Users\\gondm\\eclipse-workspace\\AAI\\src\\main\\webapp\\Airports_Authority_of_India.png");
				image.setAlignment(Element.ALIGN_CENTER);
				image.scaleToFit(65, 65);
				document.add(image);

				Paragraph par1 = new Paragraph();
				Font fonttitulo = new Font(Font.FontFamily.HELVETICA, 8, Font.BOLD, BaseColor.BLUE);
				par1.add(new Phrase("AIRPORT AUTHORITY OF INDIA", fonttitulo));
				par1.setAlignment(Element.ALIGN_CENTER);
				// par1.add(new Phrase(Chunk.NEWLINE));
				document.add(par1);

				Paragraph par3 = new Paragraph();
				Font er1 = new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.BOLDITALIC, BaseColor.BLUE);
				par3.add(new Phrase("RECEIPT AND ISSUE VOUCHER", er1));
				par3.setAlignment(Element.ALIGN_CENTER);
				par3.add(new Phrase(Chunk.NEWLINE));
				par3.add(new Phrase(Chunk.NEWLINE));// it is used for new line
				document.add(par3);
//....................................................................................................................
			/*	SenderReceiverDao d3 = new SenderReceiverDao();
				ArrayList<SenderReceiverPozo> srpdf = new ArrayList<>();
				srpdf = d3.getpdfdataFromSenderReceiver(t_receiver);*/

//....................................................................................................................
				// yha pr location ko fetch kiya jaa rha
				/*LocationOtherAirport1Dao d = new LocationOtherAirport1Dao();
				ArrayList<LocationOtherAirport1Pozo> loapdf = new ArrayList<>();
				loapdf = d.getPdfDataFromDao(t_airportname);
				System.out.println("Pdf start to created................step2");*/
//.....................................................................................................................
				// yha pr ReceiptOtherAirport1Dao ko call kiya jaa rha
				ReceiptOtherAirport1Dao d1 = new ReceiptOtherAirport1Dao();
				ArrayList<ReceiptOtherAirport1Pozo> roapdf = new ArrayList<>();
				roapdf = d1.getPdfDataFromReceiptOther(issue_vr_no);

				System.out.println("Pdf start to created................step3");
//.............................................................................................................			
				// yha pr ReceiptOtherAirport2Dao
				ReceiptOtherAirport2Dao d2 = new ReceiptOtherAirport2Dao();
				ArrayList<ReceiptOtherAirport2Pozo> roa2pdf = new ArrayList<>();
				roa2pdf = d2.getPdfDataFromReceiptOther2(issue_vr_no);
				System.out.println("Pdf start to created....................step4");
//..................................................................................................................

				// here font color and size declared by create object
				// myFonColor,myFonColor1,myFonColor2
				Font myFonColor = FontFactory.getFont(FontFactory.TIMES_ROMAN, 13, Font.BOLD, BaseColor.BLUE);
				Font myFonColor1 = FontFactory.getFont(FontFactory.TIMES_ROMAN, 13, Font.BOLD, BaseColor.RED);
				// use for heading define
				Font myFonColor2 = FontFactory.getFont(FontFactory.TIMES_ROMAN, 13, Font.BOLD, BaseColor.BLACK);
				// use for Size table
				Font myFonColor3 = FontFactory.getFont(FontFactory.COURIER, Font.DEFAULTSIZE, BaseColor.BLACK);
//......................................................................................................................

				// Create Table object, Here 4 specify the no. of columns

				PdfPTable pdfPTable = new PdfPTable(2);
				pdfPTable.setWidthPercentage(90);// here set width of table by percentage

				for (ReceiptOtherAirport1Pozo l2 : roapdf) {
					PdfPCell pdfPCell1 = new PdfPCell(new Paragraph(" To\n " + l2.getT_receiver() + "\n" + " "
							+ l2.getT_airportname() + "\n" + " " + l2.getT_airportaddress(), myFonColor));
					pdfPCell1.setBorderWidth((float) 1.5);

					PdfPCell pdfPCell2 = new PdfPCell(new Paragraph(" From\n" + l2.getF_sender() + " \n"
							+ l2.getF_airportname() + " \n" + l2.getF_airportaddress(), myFonColor));
					pdfPCell2.setBorderWidth((float) 1.5);

					pdfPTable.addCell(pdfPCell1);
					pdfPTable.addCell(pdfPCell2);

				}

				/*
				 * for(SenderReceiverPozo sr: srpdf) { PdfPCell pdfPCell1 = new PdfPCell(new
				 * Paragraph(" To\n " +sr.getT_receiver(), myFonColor));
				 * pdfPCell1.setBorderWidth((float) 1.5); }
				 * 
				 * for (LocationOtherAirport1Pozo p : loapdf) {
				 * 
				 * System.out.
				 * println("Pdf Created.......Location retrieve from database to servlet"); //
				 * Create cells PdfPCell pdfPCell1 = new PdfPCell(new Paragraph(" To\n " + "\n"
				 * + " " + p.getAirportname() + "\n" + " " + p.getAirportaddress(),myFonColor));
				 * pdfPCell1.setBorderWidth((float) 1.5);
				 * 
				 * PdfPCell pdfPCell2 = new PdfPCell(new Paragraph(" From\n" +
				 * " The RED(ER),AAI\n" + " Liveries Store Sec. NSCBI Airport\n" +
				 * " Kolkata-700052",myFonColor)); pdfPCell2.setBorderWidth((float) 1.5);
				 * 
				 * 
				 * // Add cells to table pdfPTable.addCell(pdfPCell1);
				 * pdfPTable.addCell(pdfPCell2); }
				 */
				document.add(pdfPTable);
				// document.add(Chunk.NEWLINE);

				// Create Table object, Here 6 specify the no. of columns
				PdfPTable pdfPTable1 = new PdfPTable(6);
				pdfPTable1.setWidths(new int[] { 5, 9, 7, 6, 7, 7 });// here we set each column width
				pdfPTable1.setWidthPercentage(107);// here width declare

				for (ReceiptOtherAirport1Pozo p1 : roapdf) {
					// Create cells
					PdfPCell pdfPCell11 = new PdfPCell(new Paragraph(" I/Vr No : ", myFonColor1));
					// pdfPCell11.setBackgroundColor(BaseColor.BLUE);

					pdfPCell11.setBorderWidth((float) 1.5);
					PdfPCell pdfPCell22 = new PdfPCell(new Paragraph("   " + p1.getIssue_vr_no(), myFonColor1));
					// pdfPCell22.setBackgroundColor(BaseColor.BLUE);
					pdfPCell22.setBorderWidth((float) 1.5);
					PdfPCell pdfPCell33 = new PdfPCell(new Paragraph("     Date :", myFonColor1));
					// pdfPCell33.setBackgroundColor(BaseColor.BLUE);
					pdfPCell33.setBorderWidth((float) 1.5);
					PdfPCell pdfPCell44 = new PdfPCell(new Paragraph(" " + p1.getIssue_date().toString(), myFonColor1));
					// pdfPCell44.setBackgroundColor(BaseColor.BLUE);
					pdfPCell44.setBorderWidth((float) 1.5);
					PdfPCell pdfPCell55 = new PdfPCell(new Paragraph("   "));
					// pdfPCell55.setBackgroundColor(BaseColor.BLUE);
					pdfPCell55.setBorderWidth((float) 1.5);
					PdfPCell pdfPCell66 = new PdfPCell(new Paragraph("For 3 Year".toUpperCase(), myFonColor1));
					// pdfPCell66.setBackgroundColor(BaseColor.BLUE);
					pdfPCell66.setBorderWidth((float) 1.5);
					// }

					// Type Declaration
					PdfPCell pdfPCell77 = new PdfPCell(new Paragraph("    Sl.No.", myFonColor2));
					pdfPCell77.setBorderWidthLeft((float) 1.5);
					PdfPCell pdfPCell88 = new PdfPCell(new Paragraph(" Types Of Cloths ", myFonColor2));
					PdfPCell pdfPCell99 = new PdfPCell(new Paragraph(" Cloth Meters", myFonColor2));
					PdfPCell pdfPCell100 = new PdfPCell(new Paragraph("    Cloth Pcs", myFonColor2));
					PdfPCell pdfPCell111 = new PdfPCell(new Paragraph("  Total(Mtrs)", myFonColor2));
					PdfPCell pdfPCell112 = new PdfPCell(new Paragraph("    Remarks", myFonColor2));
					pdfPCell112.setBorderWidthRight((float) 1.5);
					// Shirting Cloth
					PdfPCell pdfPCells1 = new PdfPCell(new Paragraph("   1.", myFonColor3));
					pdfPCells1.setBorderWidthLeft((float) 1.5);
					PdfPCell pdfPCells2 = new PdfPCell(new Paragraph("   Shirting ", myFonColor3));
					PdfPCell pdfPCells3 = new PdfPCell(new Paragraph(" "));
					pdfPCells3.setColspan(2);
					PdfPTable nestedTable= new PdfPTable(2);
					nestedTable.setWidthPercentage(100);
					nestedTable.setWidths(new int[] {6,5});
					nestedTable.addCell(new PdfPCell(new Phrase(" "+p1.getShirting1_cloth_mtrs(),myFonColor3)));
					nestedTable.addCell(new PdfPCell(new Phrase(" "+p1.getShirting1_cloth_pcs(),myFonColor3)));
					nestedTable.addCell(new PdfPCell(new Phrase(" "+p1.getShirting2_cloth_mtrs(),myFonColor3)));
					nestedTable.addCell(new PdfPCell(new Phrase(" "+p1.getShirting2_cloth_pcs(),myFonColor3)));
					pdfPCells3.addElement(nestedTable);
					//PdfPCell pdfPCells4 = new PdfPCell(new Paragraph(" " + p1.getShirting_cloth_pcs(), myFonColor3));
					PdfPCell pdfPCells5 = new PdfPCell(new Paragraph(" " + p1.getShirting_cloth_qnt(), myFonColor2));
					PdfPCell pdfPCells6 = new PdfPCell(new Paragraph("" + p1.getShirting_cloth_remarks(), myFonColor3));
					pdfPCells6.setBorderWidthRight((float) 1.5);
					// Paint Cloth
					PdfPCell pdfPCellp1 = new PdfPCell(new Paragraph("   2.", myFonColor3));
					pdfPCellp1.setBorderWidthLeft((float) 1.5);
					PdfPCell pdfPCellp2 = new PdfPCell(new Paragraph("     Pant ", myFonColor3));
					PdfPCell pdfPCellp3 = new PdfPCell(new Paragraph(" "));
					pdfPCellp3.setColspan(2);
					PdfPTable nestedTable1= new PdfPTable(2);
					nestedTable1.setWidthPercentage(100);
					nestedTable1.setWidths(new int[] {6,5});
					nestedTable1.addCell(new PdfPCell(new Phrase(" "+p1.getPaint1_cloth_mtrs(),myFonColor3)));
					nestedTable1.addCell(new PdfPCell(new Phrase(" "+p1.getPaint1_cloth_pcs(),myFonColor3)));
					nestedTable1.addCell(new PdfPCell(new Phrase(" "+p1.getPaint2_cloth_mtrs(),myFonColor3)));
					nestedTable1.addCell(new PdfPCell(new Phrase(" "+p1.getPaint2_cloth_pcs(),myFonColor3)));
					pdfPCellp3.addElement(nestedTable);
					//PdfPCell pdfPCellp4 = new PdfPCell(new Paragraph(" " + p1.getPaint_cloth_pcs(), myFonColor3));
					PdfPCell pdfPCellp5 = new PdfPCell(new Paragraph(" " + p1.getPaint_cloth_qtn(), myFonColor2));
					PdfPCell pdfPCellp6 = new PdfPCell(new Paragraph("" + p1.getPaint_cloth_remarks(), myFonColor3));
					pdfPCellp6.setBorderWidthRight((float) 1.5);
					// Suit Cloth
					PdfPCell pdfPCellsu1 = new PdfPCell(new Paragraph("   3.", myFonColor3));
					pdfPCellsu1.setBorderWidthLeft((float) 1.5);
					PdfPCell pdfPCellsu2 = new PdfPCell(new Paragraph("     Suit ", myFonColor3));
					PdfPCell pdfPCellsu3 = new PdfPCell(new Paragraph(" ", myFonColor3));
					pdfPCellsu3.setColspan(2);
					PdfPTable nestedTable2 = new PdfPTable(2);
					nestedTable2.setWidthPercentage(100);
					nestedTable2.setWidths(new int[] {6,5});
					nestedTable2.addCell(new PdfPCell(new Phrase(" "+p1.getSuit1_cloth_mtrs(),myFonColor3)));
					nestedTable2.addCell(new PdfPCell(new Phrase(" "+p1.getSuit1_cloth_pcs(),myFonColor3)));
					nestedTable2.addCell(new PdfPCell(new Phrase(" "+p1.getSuit2_cloth_mtrs(),myFonColor3)));
					nestedTable2.addCell(new PdfPCell(new Phrase(" "+p1.getSuit2_cloth_pcs(),myFonColor3)));
					pdfPCellsu3.addElement(nestedTable2);
					//PdfPCell pdfPCellsu4 = new PdfPCell(new Paragraph(" " + p1.getSuit_cloth_pcs(), myFonColor3));
					PdfPCell pdfPCellsu5 = new PdfPCell(new Paragraph(" " + p1.getSuit_cloth_qtn(), myFonColor2));
					PdfPCell pdfPCellsu6 = new PdfPCell(new Paragraph("" + p1.getSuit_cloth_remarks(), myFonColor3));
					pdfPCellsu6.setBorderWidthRight((float) 1.5);
					// Blazer Cloth
					PdfPCell pdfPCellbl1 = new PdfPCell(new Paragraph("   4.", myFonColor3));
					pdfPCellbl1.setBorderWidthLeft((float) 1.5);
					PdfPCell pdfPCellbl2 = new PdfPCell(new Paragraph("    Blazer ", myFonColor3));
					PdfPCell pdfPCellbl3 = new PdfPCell(new Paragraph(" ", myFonColor3));
					pdfPCellbl3.setColspan(2);
					PdfPTable nestedTable3 = new PdfPTable(2);
					nestedTable3.setWidthPercentage(100);
					nestedTable3.setWidths(new int[] {6,5});
					nestedTable3.addCell(new Phrase(" "+p1.getBlaizer1_cloth_mtrs(),myFonColor3));
					nestedTable3.addCell(new Phrase(" "+p1.getBlaizer1_cloth_pcs(),myFonColor3));
					nestedTable3.addCell(new Phrase(" "+p1.getBlaizer2_cloth_mtrs(),myFonColor3));
					nestedTable3.addCell(new Phrase(" "+p1.getBlaizer2_cloth_pcs(),myFonColor3));
					pdfPCellbl3.addElement(nestedTable3);
					//PdfPCell pdfPCellbl4 = new PdfPCell(new Paragraph(" " + p1.getBlaizer_cloth_pcs(), myFonColor3));
					PdfPCell pdfPCellbl5 = new PdfPCell(new Paragraph(" " + p1.getBlaizer_cloth_qtn(), myFonColor2));
					PdfPCell pdfPCellbl6 = new PdfPCell(new Paragraph("" + p1.getBlaizer_cloth_remarks(), myFonColor3));
					pdfPCellbl6.setBorderWidthRight((float) 1.5);
					// Sarees With Blouse
					PdfPCell pdfPCellsa1 = new PdfPCell(new Paragraph("  "));
					pdfPCellsa1.setBorderWidthLeft((float) 1.5);
					PdfPCell pdfPCellsa2 = new PdfPCell(new Paragraph("Sarees With Blouse", myFonColor2));
					PdfPCell pdfPCellsa3 = new PdfPCell(new Paragraph(" PCS ", myFonColor2));
					PdfPCell pdfPCellsa4 = new PdfPCell(new Paragraph("  "));
					PdfPCell pdfPCellsa5 = new PdfPCell(new Paragraph("  Total(Pcs) ", myFonColor2));
					PdfPCell pdfPCellsa6 = new PdfPCell(new Paragraph("     Remarks ", myFonColor2));
					pdfPCellsa6.setBorderWidthRight((float) 1.5);
					// Silk Sarees
					PdfPCell pdfPCellsi1 = new PdfPCell(new Paragraph("   5.", myFonColor3));
					pdfPCellsi1.setBorderWidthLeft((float) 1.5);
					PdfPCell pdfPCellsi2 = new PdfPCell(new Paragraph("     Silk ", myFonColor3));
					PdfPCell pdfPCellsi3 = new PdfPCell(new Paragraph(" " + p1.getSilk_saree_pcs(), myFonColor3));
					PdfPCell pdfPCellsi4 = new PdfPCell(new Paragraph("  "));
					PdfPCell pdfPCellsi5 = new PdfPCell(new Paragraph("  " + p1.getSilk_saree_qtn(), myFonColor2));
					PdfPCell pdfPCellsi6 = new PdfPCell(new Paragraph("" + p1.getSilk_saree_remark(), myFonColor3));
					pdfPCellsi6.setBorderWidthRight((float) 1.5);
					// Crape Sarees
					PdfPCell pdfPCellcr1 = new PdfPCell(new Paragraph("   6.", myFonColor3));
					pdfPCellcr1.setBorderWidthLeft((float) 1.5);
					PdfPCell pdfPCellcr2 = new PdfPCell(new Paragraph("     Crape ", myFonColor3));
					PdfPCell pdfPCellcr3 = new PdfPCell(new Paragraph(" " + p1.getCrape_saree_pcs(), myFonColor3));
					PdfPCell pdfPCellcr4 = new PdfPCell(new Paragraph("  "));
					PdfPCell pdfPCellcr5 = new PdfPCell(new Paragraph(" " + p1.getCrape_saree_qtn(), myFonColor2));
					PdfPCell pdfPCellcr6 = new PdfPCell(new Paragraph("" + p1.getCrape_saree_remark(), myFonColor3));
					pdfPCellcr6.setBorderWidthRight((float) 1.5);
					// Synthetic Sarees
					PdfPCell pdfPCellsyn1 = new PdfPCell(new Paragraph("   7.", myFonColor3));
					pdfPCellsyn1.setBorderWidthLeft((float) 1.5);
					PdfPCell pdfPCellsyn2 = new PdfPCell(new Paragraph("   Synthetic ", myFonColor3));
					PdfPCell pdfPCellsyn3 = new PdfPCell(new Paragraph(" " + p1.getSynthetic_saree_pcs(), myFonColor3));
					PdfPCell pdfPCellsyn4 = new PdfPCell(new Paragraph("  "));
					PdfPCell pdfPCellsyn5 = new PdfPCell(new Paragraph(" " + p1.getSynthetic_saree_qtn(), myFonColor2));
					PdfPCell pdfPCellsyn6 = new PdfPCell(
							new Paragraph("" + p1.getSynthetic_saree_remark(), myFonColor3));
					pdfPCellsyn6.setBorderWidthRight((float) 1.5);
					// Nos. of Neck Ties.
					PdfPCell pdfPCelltie1 = new PdfPCell(new Paragraph("   8.", myFonColor3));
					pdfPCelltie1.setBorderWidthLeft((float) 1.5);
					PdfPCell pdfPCelltie2 = new PdfPCell(new Paragraph("   Neck Ties", myFonColor3));
					PdfPCell pdfPCelltie3 = new PdfPCell(new Paragraph(" " + p1.getNeck_tie_pcs(), myFonColor3));
					PdfPCell pdfPCelltie4 = new PdfPCell(new Paragraph(" "));
					PdfPCell pdfPCelltie5 = new PdfPCell(new Paragraph(" " + p1.getNeck_tie_qtn(), myFonColor2));
					PdfPCell pdfPCelltie6 = new PdfPCell(new Paragraph("" + p1.getNeck_tie_remark(), myFonColor3));
					pdfPCelltie6.setBorderWidthRight((float) 1.5);

					// Scarves for Ladies(opt. for male uniform)
					PdfPCell pdfPCellscarve1 = new PdfPCell(new Paragraph("   9.", myFonColor3));
					pdfPCellscarve1.setBorderWidthLeft((float) 1.5);
					PdfPCell pdfPCellscarve2 = new PdfPCell(
							new Paragraph(" Scarves for Ladies(opt.for male) ", myFonColor3));
					PdfPCell pdfPCellscarve3 = new PdfPCell(new Paragraph(" " + p1.getScarves_pcs(), myFonColor3));
					PdfPCell pdfPCellscarve4 = new PdfPCell(new Paragraph(" "));
					PdfPCell pdfPCellscarve5 = new PdfPCell(new Paragraph(" " + p1.getScarves_qtn(), myFonColor2));
					PdfPCell pdfPCellscarve6 = new PdfPCell(new Paragraph("" + p1.getScarves_remark(), myFonColor3));
					pdfPCellscarve6.setBorderWidthRight((float) 1.5);

					// Add cells to table
					pdfPTable1.addCell(pdfPCell11);
					pdfPTable1.addCell(pdfPCell22);
					pdfPTable1.addCell(pdfPCell33);
					pdfPTable1.addCell(pdfPCell44);
					pdfPTable1.addCell(pdfPCell55);
					pdfPTable1.addCell(pdfPCell66);
					// Type Declaration
					pdfPTable1.addCell(pdfPCell77);
					pdfPTable1.addCell(pdfPCell88);
					pdfPTable1.addCell(pdfPCell99);
					pdfPTable1.addCell(pdfPCell100);
					pdfPTable1.addCell(pdfPCell111);
					pdfPTable1.addCell(pdfPCell112);
					// Shirting Cloth
					pdfPTable1.addCell(pdfPCells1);
					pdfPTable1.addCell(pdfPCells2);
					pdfPTable1.addCell(pdfPCells3);
					//pdfPTable1.addCell(pdfPCells4);
					pdfPTable1.addCell(pdfPCells5);
					pdfPTable1.addCell(pdfPCells6);
					// Paint Cloth
					pdfPTable1.addCell(pdfPCellp1);
					pdfPTable1.addCell(pdfPCellp2);
					pdfPTable1.addCell(pdfPCellp3);
					//pdfPTable1.addCell(pdfPCellp4);
					pdfPTable1.addCell(pdfPCellp5);
					pdfPTable1.addCell(pdfPCellp6);
					// Suit Cloth
					pdfPTable1.addCell(pdfPCellsu1);
					pdfPTable1.addCell(pdfPCellsu2);
					pdfPTable1.addCell(pdfPCellsu3);
					//pdfPTable1.addCell(pdfPCellsu4);
					pdfPTable1.addCell(pdfPCellsu5);
					pdfPTable1.addCell(pdfPCellsu6);
					// Blazer Cloth
					pdfPTable1.addCell(pdfPCellbl1);
					pdfPTable1.addCell(pdfPCellbl2);
					pdfPTable1.addCell(pdfPCellbl3);
					//pdfPTable1.addCell(pdfPCellbl4);
					pdfPTable1.addCell(pdfPCellbl5);
					pdfPTable1.addCell(pdfPCellbl6);
					// Sarees With Blouse
					pdfPTable1.addCell(pdfPCellsa1);
					pdfPTable1.addCell(pdfPCellsa2);
					pdfPTable1.addCell(pdfPCellsa3);
					pdfPTable1.addCell(pdfPCellsa4);
					pdfPTable1.addCell(pdfPCellsa5);
					pdfPTable1.addCell(pdfPCellsa6);
					// Silk Sarees
					pdfPTable1.addCell(pdfPCellsi1);
					pdfPTable1.addCell(pdfPCellsi2);
					pdfPTable1.addCell(pdfPCellsi3);
					pdfPTable1.addCell(pdfPCellsi4);
					pdfPTable1.addCell(pdfPCellsi5);
					pdfPTable1.addCell(pdfPCellsi6);
					// Crape Sarees
					pdfPTable1.addCell(pdfPCellcr1);
					pdfPTable1.addCell(pdfPCellcr2);
					pdfPTable1.addCell(pdfPCellcr3);
					pdfPTable1.addCell(pdfPCellcr4);
					pdfPTable1.addCell(pdfPCellcr5);
					pdfPTable1.addCell(pdfPCellcr6);
					// Synthetic Sarees
					pdfPTable1.addCell(pdfPCellsyn1);
					pdfPTable1.addCell(pdfPCellsyn2);
					pdfPTable1.addCell(pdfPCellsyn3);
					pdfPTable1.addCell(pdfPCellsyn4);
					pdfPTable1.addCell(pdfPCellsyn5);
					pdfPTable1.addCell(pdfPCellsyn6);
					// tie
					pdfPTable1.addCell(pdfPCelltie1);
					pdfPTable1.addCell(pdfPCelltie2);
					pdfPTable1.addCell(pdfPCelltie3);
					pdfPTable1.addCell(pdfPCelltie4);
					pdfPTable1.addCell(pdfPCelltie5);
					pdfPTable1.addCell(pdfPCelltie6);
					// Scarves for Ladies(opt. for male uniform)
					pdfPTable1.addCell(pdfPCellscarve1);
					pdfPTable1.addCell(pdfPCellscarve2);
					pdfPTable1.addCell(pdfPCellscarve3);
					pdfPTable1.addCell(pdfPCellscarve4);
					pdfPTable1.addCell(pdfPCellscarve5);
					pdfPTable1.addCell(pdfPCellscarve6);
				}
				// Add content to the document using Table objects.
				document.add(pdfPTable1);

				// ...................Size Table Start
				// here............................................
				PdfPTable pdftable3 = new PdfPTable(5);
				pdftable3.setWidthPercentage(107);
				pdftable3.setWidths(new float[] { (float) 11.6, (float) 9.6, (float) 8.4, (float) 9.6, (float) 8.2 });

				// ..............10.Half Sleeve For Gents Cardigan.......................
				PdfPCell pdfcellhalf2 = new PdfPCell(
						new Paragraph("10.Half Sleeve Gents Cardigan (No.of Pcs)", myFonColor2));
				pdfcellhalf2.setBorderWidthLeft((float) 1.5);
				PdfPCell pdfcellhalf4 = new PdfPCell(new Paragraph("11.PullOver(Jersey)(No.of Pcs)", myFonColor2));
				PdfPCell pdfcellhalf6 = new PdfPCell(new Paragraph("12.Fire Pull Over(No.of Pcs)", myFonColor2));
				PdfPCell pdfcellhalf7 = new PdfPCell(new Paragraph("13.Ladies Cardigan (No.of Pcs)", myFonColor2));
				// PdfPCell pdfcellhalf8 = new PdfPCell(new Paragraph(" "));
				PdfPCell pdfcellhalf9 = new PdfPCell(new Paragraph("    Remarks ", myFonColor2));
				pdfcellhalf9.setBorderWidthRight((float) 1.5);

				pdftable3.addCell(pdfcellhalf2);
				pdftable3.addCell(pdfcellhalf4);
				pdftable3.addCell(pdfcellhalf6);
				pdftable3.addCell(pdfcellhalf7);
				// pdftable3.addCell(pdfcellhalf8);
				pdftable3.addCell(pdfcellhalf9);

				document.add(pdftable3);

				// ...............size table.....................
				PdfPTable pdftablesize = new PdfPTable(5);
				pdftablesize.setWidthPercentage(107);
				pdftablesize
						.setWidths(new float[] { (float) 11.6, (float) 9.6, (float) 8.4, (float) 9.6, (float) 8.2 });

				for (ReceiptOtherAirport2Pozo p2 : roa2pdf) {

					// ................ 10.Half Sleeve For Gents
					// Cardigan.............................
					PdfPCell pdfcell32 = new PdfPCell(new Paragraph("(32 Size):" + p2.getH1_32_size(), myFonColor3));
					pdfcell32.setBorderWidthLeft((float) 1.5);
					PdfPCell pdfcell32a = new PdfPCell(new Paragraph(":" + p2.getP1_32_size(), myFonColor3));
					PdfPCell pdfcell32b = new PdfPCell(new Paragraph(":" + p2.getF1_32_size(), myFonColor3));
					PdfPCell pdfcell32c = new PdfPCell(new Paragraph(":" + p2.getLc1_32_size(), myFonColor3));
					// PdfPCell pdfcell32d = new PdfPCell(new Paragraph(" "));
					PdfPCell pdfcell32e = new PdfPCell(new Paragraph(":" + p2.getRemarks_32_size(), myFonColor3));
					pdfcell32e.setBorderWidthRight((float) 1.5);

					// ................Size 34..........................
					PdfPCell pdfcell34 = new PdfPCell(new Paragraph("(34 Size):" + p2.getH2_34_size(), myFonColor3));
					pdfcell34.setBorderWidthLeft((float) 1.5);
					PdfPCell pdfcell34a = new PdfPCell(new Paragraph(":" + p2.getP2_34_size(), myFonColor3));
					PdfPCell pdfcell34b = new PdfPCell(new Paragraph(":" + p2.getF2_34_size(), myFonColor3));
					PdfPCell pdfcell34c = new PdfPCell(new Paragraph(":" + p2.getLc2_34_size(), myFonColor3));
					// PdfPCell pdfcell34d = new PdfPCell(new Paragraph(" "));
					PdfPCell pdfcell34e = new PdfPCell(new Paragraph(":" + p2.getRemarks_34_size(), myFonColor3));
					pdfcell34e.setBorderWidthRight((float) 1.5);
					// ................Size 36.........................................
					PdfPCell pdfcell36 = new PdfPCell(new Paragraph("(36 Size):" + p2.getH3_36_size(), myFonColor3));
					pdfcell36.setBorderWidthLeft((float) 1.5);
					PdfPCell pdfcell36a = new PdfPCell(new Paragraph(":" + p2.getP3_36_size(), myFonColor3));
					PdfPCell pdfcell36b = new PdfPCell(new Paragraph(":" + p2.getF3_36_size(), myFonColor3));
					PdfPCell pdfcell36c = new PdfPCell(new Paragraph(":" + p2.getLc3_36_size(), myFonColor3));
					// PdfPCell pdfcell36d = new PdfPCell(new Paragraph(" "));
					PdfPCell pdfcell36e = new PdfPCell(new Paragraph(":" + p2.getRemarks_36_size(), myFonColor3));
					pdfcell36e.setBorderWidthRight((float) 1.5);
					// ................Size 38...................................................
					PdfPCell pdfcell38 = new PdfPCell(new Paragraph("(38 Size):" + p2.getH4_38_size(), myFonColor3));
					pdfcell38.setBorderWidthLeft((float) 1.5);
					PdfPCell pdfcell38a = new PdfPCell(new Paragraph(":" + p2.getP4_38_size(), myFonColor3));
					PdfPCell pdfcell38b = new PdfPCell(new Paragraph(":" + p2.getF4_38_size(), myFonColor3));
					PdfPCell pdfcell38c = new PdfPCell(new Paragraph(":" + p2.getLc4_38_size(), myFonColor3));
					// PdfPCell pdfcell38d = new PdfPCell(new Paragraph(" "));
					PdfPCell pdfcell38e = new PdfPCell(new Paragraph(":" + p2.getRemarks_38_size(), myFonColor3));
					pdfcell38e.setBorderWidthRight((float) 1.5);
					// ..............Size
					// 40.............................................................
					PdfPCell pdfcell40 = new PdfPCell(new Paragraph("(40 Size):" + p2.getH5_40_size(), myFonColor3));
					pdfcell40.setBorderWidthLeft((float) 1.5);
					PdfPCell pdfcell40a = new PdfPCell(new Paragraph(":" + p2.getP5_40_size(), myFonColor3));
					PdfPCell pdfcell40b = new PdfPCell(new Paragraph(":" + p2.getF5_40_size(), myFonColor3));
					PdfPCell pdfcell40c = new PdfPCell(new Paragraph(":" + p2.getLc5_40_size(), myFonColor3));
					// PdfPCell pdfcell40d = new PdfPCell(new Paragraph(" "));
					PdfPCell pdfcell40e = new PdfPCell(new Paragraph(":" + p2.getRemarks_40_size(), myFonColor3));
					pdfcell40e.setBorderWidthRight((float) 1.5);
					// ...............Size 42.....................................................
					PdfPCell pdfcell42 = new PdfPCell(new Paragraph("(42 Size):" + p2.getH6_42_size(), myFonColor3));
					pdfcell42.setBorderWidthLeft((float) 1.5);
					PdfPCell pdfcell42a = new PdfPCell(new Paragraph(":" + p2.getP6_42_size(), myFonColor3));
					PdfPCell pdfcell42b = new PdfPCell(new Paragraph(":" + p2.getF6_42_size(), myFonColor3));
					PdfPCell pdfcell42c = new PdfPCell(new Paragraph(":" + p2.getLc6_42_size(), myFonColor3));
					// PdfPCell pdfcell42d = new PdfPCell(new Paragraph(" " ));
					PdfPCell pdfcell42e = new PdfPCell(new Paragraph(":" + p2.getRemarks_42_size(), myFonColor3));
					pdfcell42e.setBorderWidthRight((float) 1.5);
					// .............Size
					// 44.............................................................
					PdfPCell pdfcell44 = new PdfPCell(new Paragraph("(44 Size):" + p2.getH7_44_size(), myFonColor3));
					pdfcell44.setBorderWidthLeft((float) 1.5);
					PdfPCell pdfcell44a = new PdfPCell(new Paragraph(":" + p2.getP7_44_size(), myFonColor3));
					PdfPCell pdfcell44b = new PdfPCell(new Paragraph(":" + p2.getF7_44_size(), myFonColor3));
					PdfPCell pdfcell44c = new PdfPCell(new Paragraph(":" + p2.getLc7_44_size(), myFonColor3));
					// PdfPCell pdfcell44d = new PdfPCell(new Paragraph(" "));
					PdfPCell pdfcell44e = new PdfPCell(new Paragraph(":" + p2.getRemarks_44_size(), myFonColor3));
					pdfcell44e.setBorderWidthRight((float) 1.5);
					// .....................Size
					// 46.........................................................
					PdfPCell pdfcell46 = new PdfPCell(new Paragraph("(46 Size):" + p2.getH8_46_size(), myFonColor3));
					pdfcell46.setBorderWidthLeft((float) 1.5);
					PdfPCell pdfcell46a = new PdfPCell(new Paragraph(":" + p2.getP8_46_size(), myFonColor3));
					PdfPCell pdfcell46b = new PdfPCell(new Paragraph(":" + p2.getF8_46_size(), myFonColor3));
					PdfPCell pdfcell46c = new PdfPCell(new Paragraph(":" + p2.getLc8_46_size(), myFonColor3));
					// PdfPCell pdfcell46d = new PdfPCell(new Paragraph(" "));
					PdfPCell pdfcell46e = new PdfPCell(new Paragraph(":" + p2.getRemarks_46_size(), myFonColor3));
					pdfcell46e.setBorderWidthRight((float) 1.5);
					// ..........................Size
					// 48.........................................................
					PdfPCell pdfcell48 = new PdfPCell(new Paragraph("(48 Size):" + p2.getH9_48_size(), myFonColor3));
					pdfcell48.setBorderWidthLeft((float) 1.5);
					PdfPCell pdfcell48a = new PdfPCell(new Paragraph(":" + p2.getP9_48_size(), myFonColor3));
					PdfPCell pdfcell48b = new PdfPCell(new Paragraph(":" + p2.getF9_48_size(), myFonColor3));
					PdfPCell pdfcell48c = new PdfPCell(new Paragraph(":" + p2.getLc9_48_size(), myFonColor3));
					// PdfPCell pdfcell48d = new PdfPCell(new Paragraph(" "));
					PdfPCell pdfcell48e = new PdfPCell(new Paragraph(":" + p2.getRemarks_48_size(), myFonColor3));
					pdfcell48e.setBorderWidthRight((float) 1.5);
					// .....................Total
					// Size..............................................................
					PdfPCell pdfcelltotalh_s_g_c_qty = new PdfPCell(
							new Paragraph("Total Pcs :" + p2.getTotal_h_s_g_c_qtny(), myFonColor2));
					pdfcelltotalh_s_g_c_qty.setBorderWidthBottom((float) 1.5);
					pdfcelltotalh_s_g_c_qty.setBorderWidthLeft((float) 1.5);
					PdfPCell pdfcelltotalp_o_qty = new PdfPCell(
							new Paragraph(":" + p2.getTotal_p_o_qtny(), myFonColor2));
					pdfcelltotalp_o_qty.setBorderWidthBottom((float) 1.5);
					PdfPCell pdfcelltotalf_p_o_qty = new PdfPCell(
							new Paragraph(":" + p2.getTotal_f_p_o_qtny(), myFonColor2));
					pdfcelltotalf_p_o_qty.setBorderWidthBottom((float) 1.5);
					PdfPCell pdfcelltotal_l_c_qty = new PdfPCell(
							new Paragraph(":" + p2.getTotal_l_c_qtny(), myFonColor2));
					pdfcelltotal_l_c_qty.setBorderWidthBottom((float) 1.5);
					// PdfPCell pdfcelltotalblank = new PdfPCell(new Paragraph(" "));
					// pdfcelltotalblank.setBorderWidthBottom((float) 1.5);
					PdfPCell pdfcelltotalremarks = new PdfPCell(
							new Paragraph(":" + p2.getTotal_remarks(), myFonColor2));
					pdfcelltotalremarks.setBorderWidthBottom((float) 1.5);
					pdfcelltotalremarks.setBorderWidthRight((float) 1.5);

					// ...................................Adding Data Into
					// Table.............................
					// .........size 32...............
					pdftablesize.addCell(pdfcell32);
					pdftablesize.addCell(pdfcell32a);
					pdftablesize.addCell(pdfcell32b);
					pdftablesize.addCell(pdfcell32c);
					// pdftablesize.addCell(pdfcell32d);
					pdftablesize.addCell(pdfcell32e);
					// ............size 34..............
					pdftablesize.addCell(pdfcell34);
					pdftablesize.addCell(pdfcell34a);
					pdftablesize.addCell(pdfcell34b);
					pdftablesize.addCell(pdfcell34c);
					// pdftablesize.addCell(pdfcell34d);
					pdftablesize.addCell(pdfcell34e);
					// ............size 36..............
					pdftablesize.addCell(pdfcell36);
					pdftablesize.addCell(pdfcell36a);
					pdftablesize.addCell(pdfcell36b);
					pdftablesize.addCell(pdfcell36c);
					// pdftablesize.addCell(pdfcell36d);
					pdftablesize.addCell(pdfcell36e);
					// ............size 38..............
					pdftablesize.addCell(pdfcell38);
					pdftablesize.addCell(pdfcell38a);
					pdftablesize.addCell(pdfcell38b);
					pdftablesize.addCell(pdfcell38c);
					// pdftablesize.addCell(pdfcell38d);
					pdftablesize.addCell(pdfcell38e);
					// ............size 40..............
					pdftablesize.addCell(pdfcell40);
					pdftablesize.addCell(pdfcell40a);
					pdftablesize.addCell(pdfcell40b);
					pdftablesize.addCell(pdfcell40c);
					// pdftablesize.addCell(pdfcell40d);
					pdftablesize.addCell(pdfcell40e);
					// ............size 42..............
					pdftablesize.addCell(pdfcell42);
					pdftablesize.addCell(pdfcell42a);
					pdftablesize.addCell(pdfcell42b);
					pdftablesize.addCell(pdfcell42c);
					// pdftablesize.addCell(pdfcell42d);
					pdftablesize.addCell(pdfcell42e);
					// ............size 44..............
					pdftablesize.addCell(pdfcell44);
					pdftablesize.addCell(pdfcell44a);
					pdftablesize.addCell(pdfcell44b);
					pdftablesize.addCell(pdfcell44c);
					// pdftablesize.addCell(pdfcell44d);
					pdftablesize.addCell(pdfcell44e);
					// ............size 46..............
					pdftablesize.addCell(pdfcell46);
					pdftablesize.addCell(pdfcell46a);
					pdftablesize.addCell(pdfcell46b);
					pdftablesize.addCell(pdfcell46c);
					// pdftablesize.addCell(pdfcell46d);
					pdftablesize.addCell(pdfcell46e);
					// ............size 48..............
					pdftablesize.addCell(pdfcell48);
					pdftablesize.addCell(pdfcell48a);
					pdftablesize.addCell(pdfcell48b);
					pdftablesize.addCell(pdfcell48c);
					// pdftablesize.addCell(pdfcell48d);
					pdftablesize.addCell(pdfcell48e);
					// ..............Total Size.........
					pdftablesize.addCell(pdfcelltotalh_s_g_c_qty);
					pdftablesize.addCell(pdfcelltotalp_o_qty);
					pdftablesize.addCell(pdfcelltotalf_p_o_qty);
					pdftablesize.addCell(pdfcelltotal_l_c_qty);
					// pdftablesize.addCell(pdfcelltotalblank);
					pdftablesize.addCell(pdfcelltotalremarks);

				}
				document.add(pdftablesize);
				document.add(Chunk.NEWLINE);

				// Create Table object, Here 12 specify the no. of columns
				/*
				 * PdfPTable pdfPTable2 = new PdfPTable(12); pdfPTable2.setWidthPercentage(100);
				 * pdfPTable2.setWidths(new int[]{ 3,10,6,6,6,6,6,6,6,6,6,6}); System.out.
				 * println("Here table type 3 Start..................................."); // 10.
				 * Half Sleeve For Gents Cardigan for (ReceiptOtherAirport2Pozo p2 : roa2pdf) {
				 * PdfPCell pdfPCell1e = new PdfPCell(new Paragraph("10")); PdfPCell pdfPCell2e
				 * = new PdfPCell(new Paragraph("Half Sleeve Cardigan(Gents)")); PdfPCell
				 * pdfPCell3e = new PdfPCell(new Paragraph("32 Size : "+ p2.getH1_32_size()));
				 * PdfPCell pdfPCell4e = new PdfPCell(new Paragraph("34 Size : "+
				 * p2.getH2_34_size())); PdfPCell pdfPCell5e = new PdfPCell(new
				 * Paragraph("36 Size : "+ p2.getH3_36_size())); PdfPCell pdfPCell6e = new
				 * PdfPCell(new Paragraph("38 Size : "+ p2.getH4_38_size())); PdfPCell
				 * pdfPCell7e = new PdfPCell(new Paragraph("40 Size : "+ p2.getH5_40_size()));
				 * PdfPCell pdfPCell8e = new PdfPCell(new Paragraph("42 Size : "+
				 * p2.getH6_42_size())); PdfPCell pdfPCell9e = new PdfPCell(new
				 * Paragraph("44 Size : "+ p2.getH7_44_size())); PdfPCell pdfPCell10e = new
				 * PdfPCell(new Paragraph("46 Size : "+ p2.getH8_46_size())); PdfPCell
				 * pdfPCell11e = new PdfPCell(new Paragraph("48 Size : "+ p2.getH9_48_size()));
				 * PdfPCell pdfPCell12e = new PdfPCell(new Paragraph("Total : "+
				 * p2.getTotal_h_s_g_c_qtny())); // PdfPCell pdfPCell13e = new PdfPCell(new
				 * Paragraph("Remarks : "+ p2.getRemarks_32_size()));
				 * 
				 * pdfPTable2.addCell(pdfPCell1e); pdfPTable2.addCell(pdfPCell2e);
				 * pdfPTable2.addCell(pdfPCell3e); pdfPTable2.addCell(pdfPCell4e);
				 * pdfPTable2.addCell(pdfPCell5e); pdfPTable2.addCell(pdfPCell6e);
				 * pdfPTable2.addCell(pdfPCell7e); pdfPTable2.addCell(pdfPCell8e);
				 * pdfPTable2.addCell(pdfPCell9e); pdfPTable2.addCell(pdfPCell10e);
				 * pdfPTable2.addCell(pdfPCell11e); pdfPTable2.addCell(pdfPCell12e); //
				 * pdfPTable2.addCell(pdfPCell13e);
				 * 
				 * //.......Pull Over(JERSEY)............. PdfPCell pdfPCell1p = new
				 * PdfPCell(new Paragraph("11")); PdfPCell pdfPCell2p = new PdfPCell(new
				 * Paragraph(" Pull Over(Jersey)")); PdfPCell pdfPCell3p = new PdfPCell(new
				 * Paragraph("32 Size : "+ p2.getP1_32_size())); PdfPCell pdfPCell4p = new
				 * PdfPCell(new Paragraph("34 Size : "+ p2.getP2_34_size())); PdfPCell
				 * pdfPCell5p = new PdfPCell(new Paragraph("36 Size : "+ p2.getP3_36_size()));
				 * PdfPCell pdfPCell6p = new PdfPCell(new Paragraph("38 Size : "+
				 * p2.getP4_38_size())); PdfPCell pdfPCell7p = new PdfPCell(new
				 * Paragraph("40 Size : "+ p2.getP5_40_size())); PdfPCell pdfPCell8p = new
				 * PdfPCell(new Paragraph("42 Size : "+ p2.getP6_42_size())); PdfPCell
				 * pdfPCell9p = new PdfPCell(new Paragraph("44 Size : "+ p2.getP7_44_size()));
				 * PdfPCell pdfPCell10p = new PdfPCell(new Paragraph("46 Size : "+
				 * p2.getP8_46_size())); PdfPCell pdfPCell11p = new PdfPCell(new
				 * Paragraph("48 Size : "+ p2.getP9_48_size())); PdfPCell pdfPCell12p = new
				 * PdfPCell(new Paragraph("Total : "+ p2.getTotal_p_o_qtny())); // PdfPCell
				 * pdfPCell13p = new PdfPCell(new Paragraph("Remarks : "+
				 * p2.getRemarks_34_size()));
				 * 
				 * pdfPTable2.addCell(pdfPCell1p); pdfPTable2.addCell(pdfPCell2p);
				 * pdfPTable2.addCell(pdfPCell3p); pdfPTable2.addCell(pdfPCell4p);
				 * pdfPTable2.addCell(pdfPCell5p); pdfPTable2.addCell(pdfPCell6p);
				 * pdfPTable2.addCell(pdfPCell7p); pdfPTable2.addCell(pdfPCell8p);
				 * pdfPTable2.addCell(pdfPCell9p); pdfPTable2.addCell(pdfPCell10p);
				 * pdfPTable2.addCell(pdfPCell11p); pdfPTable2.addCell(pdfPCell12p); //
				 * pdfPTable2.addCell(pdfPCell13p);
				 * 
				 * //........ Fire Pull Over .......................
				 * 
				 * PdfPCell pdfPCell1f = new PdfPCell(new Paragraph("12")); PdfPCell pdfPCell2f
				 * = new PdfPCell(new Paragraph(" Fire Pull Over ")); PdfPCell pdfPCell3f = new
				 * PdfPCell(new Paragraph("32 Size : "+ p2.getF1_32_size())); PdfPCell
				 * pdfPCell4f = new PdfPCell(new Paragraph("34 Size : "+ p2.getF2_34_size()));
				 * PdfPCell pdfPCell5f = new PdfPCell(new Paragraph("36 Size : "+
				 * p2.getF3_36_size())); PdfPCell pdfPCell6f = new PdfPCell(new
				 * Paragraph("38 Size : "+ p2.getF4_38_size())); PdfPCell pdfPCell7f = new
				 * PdfPCell(new Paragraph("40 Size : "+ p2.getF5_40_size())); PdfPCell
				 * pdfPCell8f = new PdfPCell(new Paragraph("42 Size : "+ p2.getF6_42_size()));
				 * PdfPCell pdfPCell9f = new PdfPCell(new Paragraph("44 Size : "+
				 * p2.getF7_44_size())); PdfPCell pdfPCell10f = new PdfPCell(new
				 * Paragraph("46 Size : "+ p2.getF8_46_size())); PdfPCell pdfPCell11f = new
				 * PdfPCell(new Paragraph("48 Size : "+ p2.getF9_48_size())); PdfPCell
				 * pdfPCell12f = new PdfPCell(new Paragraph("Total : "+
				 * p2.getTotal_f_p_o_qtny())); // PdfPCell pdfPCell13f = new PdfPCell(new
				 * Paragraph("Remarks : "+ p2.getRemarks_36_size()));
				 * 
				 * pdfPTable2.addCell(pdfPCell1f); pdfPTable2.addCell(pdfPCell2f);
				 * pdfPTable2.addCell(pdfPCell3f); pdfPTable2.addCell(pdfPCell4f);
				 * pdfPTable2.addCell(pdfPCell5f); pdfPTable2.addCell(pdfPCell6f);
				 * pdfPTable2.addCell(pdfPCell7f); pdfPTable2.addCell(pdfPCell8f);
				 * pdfPTable2.addCell(pdfPCell9f); pdfPTable2.addCell(pdfPCell10f);
				 * pdfPTable2.addCell(pdfPCell11f); pdfPTable2.addCell(pdfPCell12f);
				 * 
				 * //....... Ladies Cardigan ....................
				 * 
				 * PdfPCell pdfPCell1lc = new PdfPCell(new Paragraph("13")); PdfPCell
				 * pdfPCell2lc = new PdfPCell(new Paragraph("Ladies Cardigan ")); PdfPCell
				 * pdfPCell3lc = new PdfPCell(new Paragraph("(32 Size) : "+
				 * p2.getLc1_32_size())); PdfPCell pdfPCell4lc = new PdfPCell(new
				 * Paragraph("(34 Size) : "+ p2.getLc2_34_size())); PdfPCell pdfPCell5lc = new
				 * PdfPCell(new Paragraph("(36 Size) : "+ p2.getLc3_36_size())); PdfPCell
				 * pdfPCell6lc = new PdfPCell(new Paragraph("(38 Size) : "+
				 * p2.getLc4_38_size())); PdfPCell pdfPCell7lc = new PdfPCell(new
				 * Paragraph("(40 Size) : "+ p2.getLc5_40_size())); PdfPCell pdfPCell8lc = new
				 * PdfPCell(new Paragraph("(42 Size) : "+ p2.getLc6_42_size())); PdfPCell
				 * pdfPCell9lc = new PdfPCell(new Paragraph("(44 Size) : "+
				 * p2.getLc7_44_size())); PdfPCell pdfPCell10lc = new PdfPCell(new
				 * Paragraph("(46 Size) : "+ p2.getLc8_46_size())); PdfPCell pdfPCell11lc = new
				 * PdfPCell(new Paragraph("(48 Size) : "+ p2.getLc9_48_size())); PdfPCell
				 * pdfPCell12lc = new PdfPCell(new Paragraph("(Total) : "+
				 * p2.getTotal_l_c_qtny()));
				 * 
				 * pdfPTable2.addCell(pdfPCell1lc); pdfPTable2.addCell(pdfPCell2lc);
				 * pdfPTable2.addCell(pdfPCell3lc); pdfPTable2.addCell(pdfPCell4lc);
				 * pdfPTable2.addCell(pdfPCell5lc); pdfPTable2.addCell(pdfPCell6lc);
				 * pdfPTable2.addCell(pdfPCell7lc); pdfPTable2.addCell(pdfPCell8lc);
				 * pdfPTable2.addCell(pdfPCell9lc); pdfPTable2.addCell(pdfPCell10lc);
				 * pdfPTable2.addCell(pdfPCell11lc); pdfPTable2.addCell(pdfPCell12lc);
				 * 
				 * }
				 * 
				 * document.add(pdfPTable2); document.add(Chunk.NEWLINE);
				 */

				// Paragraph add here
				Paragraph par2 = new Paragraph();
				Font agm = new Font(Font.FontFamily.HELVETICA, 8, Font.BOLD, BaseColor.BLACK);
				par2.add(new Phrase("\n" + "Asst. Gen. Mgr. (CNS/Store)\r\n" + "Liveries Store \r\n"
						+ "For RED(ER), NSCBI Airport, Kol.\r\n" + "", agm));
				par2.setAlignment(Element.ALIGN_BOTTOM);
				par2.setAlignment(Element.ALIGN_RIGHT);
				// par2.add(new Phrase(Chunk.NEWLINE));
				document.add(par2);
				document.add(new Paragraph(new Date().toString()));

				document.close();

			} catch (Exception e) {
				// TODO: handle exception
				e.getMessage();
			}

		} finally

		{
			// TODO: handle finally clause
			out.close();
		}
				
	}

}
