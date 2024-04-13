package packingVoucher;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
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
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * Servlet implementation class PackingVoucherPdfServlet
 */
public class PackingVoucherPdfServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PackingVoucherPdfServlet() {
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
		response.setContentType("application/pdf");
		ServletOutputStream out = response.getOutputStream();
		String n_a_consignee = request.getParameter("n_a_consignee");
		String issuevoucherno=request.getParameter("issuevoucherno");
		//int issuevoucherno = Integer.parseInt(request.getParameter("issuevoucherno"));

		try {

			try {
				Document document = new Document();
				PdfWriter.getInstance(document, out);

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
				par1.add(new Phrase(Chunk.NEWLINE));
				// par1.add(new Phrase(Chunk.NEWLINE));
				document.add(par1);

				/*
				 * Paragraph par2 = new Paragraph(); Font er = new
				 * Font(Font.FontFamily.HELVETICA, 15, Font.BOLD, BaseColor.BLUE); par2.add(new
				 * Phrase("EASTERN REGION, NSCBI AIRPORT KOLKATA - 52", er));
				 * par2.setAlignment(Element.ALIGN_CENTER); par2.add(new Phrase(Chunk.NEWLINE));
				 * // par2.add(new Phrase(Chunk.NEWLINE)); document.add(par2);
				 */

				Paragraph par3 = new Paragraph();
				Font er1 = new Font(Font.FontFamily.HELVETICA, 15, Font.ITALIC, BaseColor.BLUE);
				par3.add(new Phrase("PACKING SLIP", er1));
				par3.setAlignment(Element.ALIGN_CENTER);
				par3.add(new Phrase(Chunk.NEWLINE));
				// par3.add(new Phrase(Chunk.NEWLINE));
				document.add(par3);
//.........................................................................................................
				PackingVoucher1Dao d1 = new PackingVoucher1Dao();
				ArrayList<PackingVoucher1Pozo> packingpdf = new ArrayList<>();
				packingpdf = d1.getPdfDataFromDao(issuevoucherno);
				for (PackingVoucher1Pozo p : packingpdf) {
					System.out.println(p.getIssuevoucherno());
				}
				System.out.println("Pdf Start to create ..............");
//...............................................................................................................
				PackingVoucher2Dao d2 = new PackingVoucher2Dao();
				ArrayList<PackingVoucher2Pozo> packing2pdf = new ArrayList<>();
				packing2pdf = d2.getDataFromDao2(issuevoucherno);

				// here font color and size declared by create object
				// myFonColor,myFonColor1,myFonColor2
				// Font myFonColor = FontFactory.getFont(FontFactory.TIMES_ROMAN, 13, Font.BOLD,
				// BaseColor.BLUE);
				 Font myFonColor1 = FontFactory.getFont(FontFactory.TIMES_ROMAN, 13, Font.BOLD, BaseColor.RED);
				// use for heading define
				Font myFonColor2 = FontFactory.getFont(FontFactory.TIMES_ROMAN, 13, Font.BOLD, BaseColor.BLACK);

				// use for Size table
				Font myFonColor3 = FontFactory.getFont(FontFactory.COURIER, Font.DEFAULTSIZE, BaseColor.BLACK);

				PdfPTable pdfPTable = new PdfPTable(6);
				pdfPTable.setWidths(new int[] { 4, 9, 7, 6, 7, 7 });// here we set each column width
				pdfPTable.setWidthPercentage(107);// here width declare

				for (PackingVoucher1Pozo p1 : packingpdf) {

					Paragraph par4 = new Paragraph("Name and Address of Consignee  :  " + p1.getN_a_consignee(),
							myFonColor2);
					document.add(par4);
					Paragraph par5 = new Paragraph("Our Reference                                :  " + p1.getOurreference(), myFonColor2);
					document.add(par5);
					Paragraph par6 = new Paragraph("Issue Voucher No                           :  " + p1.getIssuevoucherno(), myFonColor1);
					document.add(par6);
					Paragraph par7 = new Paragraph("Issue Date                                        :  " + p1.getPdate().toString(), myFonColor1);
					par7.add(new Phrase(Chunk.NEWLINE));
					par7.add(new Phrase(Chunk.NEWLINE));
					document.add(par7);

					// Create cells
					PdfPCell pdfPCell1 = new PdfPCell(new Paragraph("  Sl.No.", myFonColor2));
					pdfPCell1.setBorderWidth((float) 1.5);
					PdfPCell pdfPCell2 = new PdfPCell(new Paragraph("    Types Of Cloth", myFonColor2));
					pdfPCell2.setBorderWidth((float) 1.5);
					PdfPCell pdfPCell3 = new PdfPCell(new Paragraph(" Cloth Meters ", myFonColor2));
					pdfPCell3.setBorderWidth((float) 1.5);
					PdfPCell pdfPCell4 = new PdfPCell(new Paragraph("  Cloth Pcs", myFonColor2));
					pdfPCell4.setBorderWidth((float) 1.5);
					PdfPCell pdfPCell5 = new PdfPCell(new Paragraph("  Total(Mtrs)", myFonColor2));
					pdfPCell5.setBorderWidth((float) 1.5);
					PdfPCell pdfPCell6 = new PdfPCell(new Paragraph("     Remarks ", myFonColor2));
					pdfPCell6.setBorderWidth((float) 1.5);

					// ..........Shirting...................
					PdfPCell pdfPCell1s = new PdfPCell(new Paragraph("  1.", myFonColor3));
					pdfPCell1s.setBorderWidthLeft((float) 1.5);
					PdfPCell pdfPCell2s = new PdfPCell(new Paragraph(" Shirting Cloth", myFonColor3));
					PdfPCell pdfPCell3s = new PdfPCell(new Paragraph(" "));
					pdfPCell3s.setColspan(2);
					PdfPTable nestedTable = new PdfPTable(2);
					nestedTable.setWidthPercentage(100);
					nestedTable.setWidths(new int[] { 6, 5 });
					nestedTable.addCell(new PdfPCell(new Phrase(" " + p1.getShirting1_cloth_mtrs(), myFonColor3)));
					nestedTable.addCell(new PdfPCell(new Phrase(" " + p1.getShirting1_cloth_pcs(), myFonColor3)));
					nestedTable.addCell(new PdfPCell(new Phrase(" " + p1.getShirting2_cloth_mtrs(), myFonColor3)));
					nestedTable.addCell(new PdfPCell(new Phrase(" " + p1.getShirting2_cloth_pcs(), myFonColor3)));
					pdfPCell3s.addElement(nestedTable);
					PdfPCell pdfPCell4s = new PdfPCell(new Paragraph(" " + p1.getShirting_cloth_qnt(), myFonColor2));
					PdfPCell pdfPCell5s = new PdfPCell(
							new Paragraph(" " + p1.getShirting_cloth_remarks(), myFonColor3));
					pdfPCell5s.setBorderWidthRight((float) 1.5);
					// PdfPCell pdfPCell6a = new PdfPCell(new Paragraph("........ "));

					// ..........Pant...................
					PdfPCell pdfPCell1p = new PdfPCell(new Paragraph("  2.", myFonColor3));
					pdfPCell1p.setBorderWidthLeft((float) 1.5);
					PdfPCell pdfPCell2p = new PdfPCell(new Paragraph("  Pant Cloth", myFonColor3));
					PdfPCell pdfPCell3p = new PdfPCell(new Paragraph(" ", myFonColor3));
					pdfPCell3p.setColspan(2);
					PdfPTable nestedTable1 = new PdfPTable(2);
					nestedTable1.setWidthPercentage(100);
					nestedTable1.setWidths(new int[] { 6, 5 });
					nestedTable1.addCell(new PdfPCell(new Phrase(" " + p1.getPaint1_cloth_mtrs(), myFonColor3)));
					nestedTable1.addCell(new PdfPCell(new Phrase(" " + p1.getPaint1_cloth_pcs(), myFonColor3)));
					nestedTable1.addCell(new PdfPCell(new Phrase(" " + p1.getPaint2_cloth_mtrs(), myFonColor3)));
					nestedTable1.addCell(new PdfPCell(new Phrase(" " + p1.getPaint2_cloth_pcs(), myFonColor3)));
					pdfPCell3p.addElement(nestedTable1);
					PdfPCell pdfPCell4p = new PdfPCell(new Paragraph(" " + p1.getPaint_cloth_qtn(), myFonColor2));
					PdfPCell pdfPCell5p = new PdfPCell(new Paragraph(" " + p1.getPaint_cloth_remarks(), myFonColor3));
					pdfPCell5p.setBorderWidthRight((float) 1.5);
					// ..........Suit...................
					PdfPCell pdfPCell1su = new PdfPCell(new Paragraph("  3.", myFonColor3));
					pdfPCell1su.setBorderWidthLeft((float) 1.5);
					PdfPCell pdfPCell2su = new PdfPCell(new Paragraph("  Suit Cloth", myFonColor3));
					PdfPCell pdfPCell3su = new PdfPCell(new Paragraph(" ", myFonColor3));
					pdfPCell3su.setColspan(2);
					PdfPTable nestedTable2 = new PdfPTable(2);
					nestedTable2.setWidthPercentage(100);
					nestedTable2.setWidths(new int[] { 6, 5 });
					nestedTable2.addCell(new PdfPCell(new Phrase(" " + p1.getSuit1_cloth_mtrs(), myFonColor3)));
					nestedTable2.addCell(new PdfPCell(new Phrase(" " + p1.getSuit1_cloth_pcs(), myFonColor3)));
					nestedTable2.addCell(new PdfPCell(new Phrase(" " + p1.getSuit2_cloth_mtrs(), myFonColor3)));
					nestedTable2.addCell(new PdfPCell(new Phrase(" " + p1.getSuit2_cloth_pcs(), myFonColor3)));
					pdfPCell3su.addElement(nestedTable2);
					PdfPCell pdfPCell4su = new PdfPCell(new Paragraph(" " + p1.getSuit_cloth_qtn(), myFonColor2));
					PdfPCell pdfPCell5su = new PdfPCell(new Paragraph(" " + p1.getSuit_cloth_remarks(), myFonColor3));
					pdfPCell5su.setBorderWidthRight((float) 1.5);
					// ..........Blazer Cloth...................
					PdfPCell pdfPCell1blz = new PdfPCell(new Paragraph("  4.", myFonColor3));
					pdfPCell1blz.setBorderWidthLeft((float) 1.5);
					PdfPCell pdfPCell2blz = new PdfPCell(new Paragraph("  Blazer Cloth", myFonColor3));
					PdfPCell pdfPCell3blz = new PdfPCell(new Paragraph(" ", myFonColor3));
					pdfPCell3blz.setColspan(2);
					PdfPTable nestedTable3 = new PdfPTable(2);
					nestedTable3.setWidthPercentage(100);
					nestedTable3.setWidths(new int[] { 6, 5 });
					nestedTable3.addCell(new PdfPCell(new Phrase(" " + p1.getBlaizer1_cloth_mtrs(), myFonColor3)));
					nestedTable3.addCell(new PdfPCell(new Phrase(" " + p1.getBlaizer1_cloth_pcs(), myFonColor3)));
					nestedTable3.addCell(new PdfPCell(new Phrase(" " + p1.getBlaizer2_cloth_mtrs(), myFonColor3)));
					nestedTable3.addCell(new PdfPCell(new Phrase(" " + p1.getBlaizer2_cloth_pcs(), myFonColor3)));
					pdfPCell3blz.addElement(nestedTable3);
					PdfPCell pdfPCell4blz = new PdfPCell(new Paragraph(" " + p1.getBlaizer_cloth_qtn(), myFonColor2));
					PdfPCell pdfPCell5blz = new PdfPCell(
							new Paragraph(" " + p1.getBlaizer_cloth_remarks(), myFonColor3));
					pdfPCell5blz.setBorderWidthRight((float) 1.5);

					// Sarees With Blouse
					PdfPCell pdfPCellsa1 = new PdfPCell(new Paragraph("  "));
					pdfPCellsa1.setBorderWidthLeft((float) 1.5);
					PdfPCell pdfPCellsa2 = new PdfPCell(new Paragraph("Sarees With Blouse", myFonColor2));
					PdfPCell pdfPCellsa3 = new PdfPCell(new Paragraph(" PCS ", myFonColor2));
					PdfPCell pdfPCellsa4 = new PdfPCell(new Paragraph("  "));
					PdfPCell pdfPCellsa5 = new PdfPCell(new Paragraph("  Total(PCS) ",myFonColor2));
					PdfPCell pdfPCellsa6 = new PdfPCell(new Paragraph("     Remarks ",myFonColor2));
					pdfPCellsa6.setBorderWidthRight((float) 1.5);

					// Silk Sarees
					PdfPCell pdfPCellsi1 = new PdfPCell(new Paragraph("  5.", myFonColor3));
					pdfPCellsi1.setBorderWidthLeft((float) 1.5);
					PdfPCell pdfPCellsi2 = new PdfPCell(new Paragraph("  Silk Sarees", myFonColor3));
					PdfPCell pdfPCellsi3 = new PdfPCell(new Paragraph(" " + p1.getSilk_saree_pcs(), myFonColor3));
					PdfPCell pdfPCellsi4 = new PdfPCell(new Paragraph("  "));
					PdfPCell pdfPCellsi5 = new PdfPCell(new Paragraph(" " + p1.getSilk_saree_qtn(), myFonColor2));
					PdfPCell pdfPCellsi6 = new PdfPCell(new Paragraph(" " + p1.getSilk_saree_remark(), myFonColor3));
					pdfPCellsi6.setBorderWidthRight((float) 1.5);

					// Crape Sarees
					PdfPCell pdfPCellcr1 = new PdfPCell(new Paragraph("  6.", myFonColor3));
					pdfPCellcr1.setBorderWidthLeft((float) 1.5);
					PdfPCell pdfPCellcr2 = new PdfPCell(new Paragraph("  Crape Sarees", myFonColor3));
					PdfPCell pdfPCellcr3 = new PdfPCell(new Paragraph(" " + p1.getCrape_saree_pcs(), myFonColor3));
					PdfPCell pdfPCellcr4 = new PdfPCell(new Paragraph(" "));
					PdfPCell pdfPCellcr5 = new PdfPCell(new Paragraph(" " + p1.getCrape_saree_qtn(), myFonColor2));
					PdfPCell pdfPCellcr6 = new PdfPCell(new Paragraph(" " + p1.getCrape_saree_remark(), myFonColor3));
					pdfPCellcr6.setBorderWidthRight((float) 1.5);

					// Synthetic Sarees
					PdfPCell pdfPCellsy1 = new PdfPCell(new Paragraph("  7.", myFonColor3));
					pdfPCellsy1.setBorderWidthLeft((float) 1.5);
					PdfPCell pdfPCellsy2 = new PdfPCell(new Paragraph("Synthetic Sarees", myFonColor3));
					PdfPCell pdfPCellsy3 = new PdfPCell(new Paragraph(" " +p1.getSynthetic_saree_pcs(), myFonColor3));
					PdfPCell pdfPCellsy4 = new PdfPCell(new Paragraph(" "));
					PdfPCell pdfPCellsy5 = new PdfPCell(new Paragraph(" " +p1.getSynthetic_saree_qtn(), myFonColor2));
					PdfPCell pdfPCellsy6 = new PdfPCell(new Paragraph(" " +p1.getSynthetic_saree_remark(), myFonColor3));
					pdfPCellsy6.setBorderWidthRight((float) 1.5);

					// Nos. of Neck Ties.
					PdfPCell pdfPCelltie1 = new PdfPCell(new Paragraph("  8.", myFonColor3));
					pdfPCelltie1.setBorderWidthLeft((float) 1.5);
					PdfPCell pdfPCelltie2 = new PdfPCell(new Paragraph("   Neck Ties", myFonColor3));
					PdfPCell pdfPCelltie3 = new PdfPCell(new Paragraph(" " +p1.getNeck_tie_pcs(), myFonColor3));
					PdfPCell pdfPCelltie4 = new PdfPCell(new Paragraph("  "));
					PdfPCell pdfPCelltie5 = new PdfPCell(new Paragraph(" " +p1.getNeck_tie_qtn(), myFonColor2));
					PdfPCell pdfPCelltie6 = new PdfPCell(new Paragraph(" " +p1.getNeck_tie_remark(), myFonColor3));
					pdfPCelltie6.setBorderWidthRight((float) 1.5);

					// Scarves for Ladies(opt. for male uniform)
					PdfPCell pdfPCellScarve1 = new PdfPCell(new Paragraph("  9.", myFonColor3));
					pdfPCellScarve1.setBorderWidthLeft((float) 1.5);
					PdfPCell pdfPCellScarve2 = new PdfPCell(new Paragraph("Ladies Scarves(male uniform)", myFonColor3));
					PdfPCell pdfPCellScarve3 = new PdfPCell(new Paragraph(" " +p1.getScarves_pcs(), myFonColor3));
					PdfPCell pdfPCellScarve4 = new PdfPCell(new Paragraph("  "));
					PdfPCell pdfPCellScarve5 = new PdfPCell(new Paragraph(" " +p1.getScarves_qtn(), myFonColor2));
					PdfPCell pdfPCellScarve6 = new PdfPCell(new Paragraph(" " +p1.getScarves_remark() , myFonColor3));
					pdfPCellScarve6.setBorderWidthRight((float) 1.5);
					// Add cells to table
					pdfPTable.addCell(pdfPCell1);
					pdfPTable.addCell(pdfPCell2);
					pdfPTable.addCell(pdfPCell3);
					pdfPTable.addCell(pdfPCell4);
					pdfPTable.addCell(pdfPCell5);
					pdfPTable.addCell(pdfPCell6);

					// ..........Shirting...................
					pdfPTable.addCell(pdfPCell1s);
					pdfPTable.addCell(pdfPCell2s);
					pdfPTable.addCell(pdfPCell3s);
					pdfPTable.addCell(pdfPCell4s);
					pdfPTable.addCell(pdfPCell5s);
					// ..........Pant...................
					pdfPTable.addCell(pdfPCell1p);
					pdfPTable.addCell(pdfPCell2p);
					pdfPTable.addCell(pdfPCell3p);
					pdfPTable.addCell(pdfPCell4p);
					pdfPTable.addCell(pdfPCell5p);
					// ..........Pant...................
					pdfPTable.addCell(pdfPCell1su);
					pdfPTable.addCell(pdfPCell2su);
					pdfPTable.addCell(pdfPCell3su);
					pdfPTable.addCell(pdfPCell4su);
					pdfPTable.addCell(pdfPCell5su);
					// ..........Blaizer...................
					pdfPTable.addCell(pdfPCell1blz);
					pdfPTable.addCell(pdfPCell2blz);
					pdfPTable.addCell(pdfPCell3blz);
					pdfPTable.addCell(pdfPCell4blz);
					pdfPTable.addCell(pdfPCell5blz);
					// Sarees With Blouse
					pdfPTable.addCell(pdfPCellsa1);
					pdfPTable.addCell(pdfPCellsa2);
					pdfPTable.addCell(pdfPCellsa3);
					pdfPTable.addCell(pdfPCellsa4);
					pdfPTable.addCell(pdfPCellsa5);
					pdfPTable.addCell(pdfPCellsa6);
					// Silk Sarees
					pdfPTable.addCell(pdfPCellsi1);
					pdfPTable.addCell(pdfPCellsi2);
					pdfPTable.addCell(pdfPCellsi3);
					pdfPTable.addCell(pdfPCellsi4);
					pdfPTable.addCell(pdfPCellsi5);
					pdfPTable.addCell(pdfPCellsi6);
					// Crape Sarees
					pdfPTable.addCell(pdfPCellcr1);
					pdfPTable.addCell(pdfPCellcr2);
					pdfPTable.addCell(pdfPCellcr3);
					pdfPTable.addCell(pdfPCellcr4);
					pdfPTable.addCell(pdfPCellcr5);
					pdfPTable.addCell(pdfPCellcr6);
					// Synthetic Sarees
					pdfPTable.addCell(pdfPCellsy1);
					pdfPTable.addCell(pdfPCellsy2);
					pdfPTable.addCell(pdfPCellsy3);
					pdfPTable.addCell(pdfPCellsy4);
					pdfPTable.addCell(pdfPCellsy5);
					pdfPTable.addCell(pdfPCellsy6);
					// Nos. of Neck Ties.
					pdfPTable.addCell(pdfPCelltie1);
					pdfPTable.addCell(pdfPCelltie2);
					pdfPTable.addCell(pdfPCelltie3);
					pdfPTable.addCell(pdfPCelltie4);
					pdfPTable.addCell(pdfPCelltie5);
					pdfPTable.addCell(pdfPCelltie6);
					// Scarves
					pdfPTable.addCell(pdfPCellScarve1);
					pdfPTable.addCell(pdfPCellScarve2);
					pdfPTable.addCell(pdfPCellScarve3);
					pdfPTable.addCell(pdfPCellScarve4);
					pdfPTable.addCell(pdfPCellScarve5);
					pdfPTable.addCell(pdfPCellScarve6);
				}
				// Add content to the document using Table objects.
				document.add(pdfPTable);

				// ...................Size Table Start
				// here............................................
				PdfPTable pdftable3 = new PdfPTable(5);
				pdftable3.setWidthPercentage(107);
				pdftable3.setWidths(new float[]{(float) 11.6,(float) 9.6, (float) 8.4, (float) 9.6, (float) 8.2});

				// ..............10.Half Sleeve For Gents Cardigan.......................
				PdfPCell pdfcellhalf2 = new PdfPCell(new Paragraph("10.Half Sleeve Gents Cardigan (No.of Pcs)", myFonColor2));
				pdfcellhalf2.setBorderWidthLeft((float) 1.5);
				PdfPCell pdfcellhalf4 = new PdfPCell(new Paragraph("11.PullOver(Jersey)(No.of Pcs)", myFonColor2));
				PdfPCell pdfcellhalf6 = new PdfPCell(new Paragraph("12.Fire Pull Over(No.of Pcs)", myFonColor2));
				PdfPCell pdfcellhalf7 = new PdfPCell(new Paragraph("13.Ladies Cardigan (No.of Pcs)", myFonColor2));
				// PdfPCell pdfcellhalf8 = new PdfPCell(new Paragraph(" "));
				PdfPCell pdfcellhalf9 = new PdfPCell(new Paragraph("     Remarks ", myFonColor2));
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
				pdftablesize.setWidths(new float[]{(float) 11.6,(float) 9.6, (float) 8.4, (float) 9.6, (float) 8.2});
				for (PackingVoucher2Pozo p2 : packing2pdf) {

					// ................ 10.Half Sleeve For Gents
					// Cardigan.............................
					PdfPCell pdfcell32 = new PdfPCell(
							new Paragraph("(32 Size):" + p2.getH1_32_size(), myFonColor3));
					pdfcell32.setBorderWidthLeft((float) 1.5);
					PdfPCell pdfcell32a = new PdfPCell(new Paragraph(":" + p2.getP1_32_size(), myFonColor3));
					PdfPCell pdfcell32b = new PdfPCell(new Paragraph(":" + p2.getF1_32_size(), myFonColor3));
					PdfPCell pdfcell32c = new PdfPCell(new Paragraph(":" + p2.getLc1_32_size(), myFonColor3));
					// PdfPCell pdfcell32d = new PdfPCell(new Paragraph(" "));
					PdfPCell pdfcell32e = new PdfPCell(new Paragraph(":" + p2.getRemarks_32_size(), myFonColor3));
					pdfcell32e.setBorderWidthRight((float) 1.5);

					// ................Size 34..........................
					PdfPCell pdfcell34 = new PdfPCell(
							new Paragraph("(34 Size):" + p2.getH2_34_size(), myFonColor3));
					pdfcell34.setBorderWidthLeft((float) 1.5);
					PdfPCell pdfcell34a = new PdfPCell(new Paragraph(":" + p2.getP2_34_size(), myFonColor3));
					PdfPCell pdfcell34b = new PdfPCell(new Paragraph(":" + p2.getF2_34_size(), myFonColor3));
					PdfPCell pdfcell34c = new PdfPCell(new Paragraph(":" + p2.getLc2_34_size(), myFonColor3));
					// PdfPCell pdfcell34d = new PdfPCell(new Paragraph(" "));
					PdfPCell pdfcell34e = new PdfPCell(new Paragraph(":" + p2.getRemarks_34_size(), myFonColor3));
					pdfcell34e.setBorderWidthRight((float) 1.5);
					// ................Size 36.........................................
					PdfPCell pdfcell36 = new PdfPCell(
							new Paragraph("(36 Size):" + p2.getH3_36_size(), myFonColor3));
					pdfcell36.setBorderWidthLeft((float) 1.5);
					PdfPCell pdfcell36a = new PdfPCell(new Paragraph(":" + p2.getP3_36_size(), myFonColor3));
					PdfPCell pdfcell36b = new PdfPCell(new Paragraph(":" + p2.getF3_36_size(), myFonColor3));
					PdfPCell pdfcell36c = new PdfPCell(new Paragraph(":" + p2.getLc3_36_size(), myFonColor3));
					// PdfPCell pdfcell36d = new PdfPCell(new Paragraph(" "));
					PdfPCell pdfcell36e = new PdfPCell(new Paragraph(":" + p2.getRemarks_36_size(), myFonColor3));
					pdfcell36e.setBorderWidthRight((float) 1.5);
					// ................Size 38...................................................
					PdfPCell pdfcell38 = new PdfPCell(
							new Paragraph("(38 Size):" + p2.getH4_38_size(), myFonColor3));
					pdfcell38.setBorderWidthLeft((float) 1.5);
					PdfPCell pdfcell38a = new PdfPCell(new Paragraph(":" + p2.getP4_38_size(), myFonColor3));
					PdfPCell pdfcell38b = new PdfPCell(new Paragraph(":" + p2.getF4_38_size(), myFonColor3));
					PdfPCell pdfcell38c = new PdfPCell(new Paragraph(":" + p2.getLc4_38_size(), myFonColor3));
					// PdfPCell pdfcell38d = new PdfPCell(new Paragraph(" "));
					PdfPCell pdfcell38e = new PdfPCell(new Paragraph(":" + p2.getRemarks_38_size(), myFonColor3));
					pdfcell38e.setBorderWidthRight((float) 1.5);
					// ..............Size
					// 40.............................................................
					PdfPCell pdfcell40 = new PdfPCell(
							new Paragraph("(40 Size):" + p2.getH5_40_size(), myFonColor3));
					pdfcell40.setBorderWidthLeft((float) 1.5);
					PdfPCell pdfcell40a = new PdfPCell(new Paragraph(":" + p2.getP5_40_size(), myFonColor3));
					PdfPCell pdfcell40b = new PdfPCell(new Paragraph(":" + p2.getF5_40_size(), myFonColor3));
					PdfPCell pdfcell40c = new PdfPCell(new Paragraph(":" + p2.getLc5_40_size(), myFonColor3));
					// PdfPCell pdfcell40d = new PdfPCell(new Paragraph(" "));
					PdfPCell pdfcell40e = new PdfPCell(new Paragraph(":" + p2.getRemarks_40_size(), myFonColor3));
					pdfcell40e.setBorderWidthRight((float) 1.5);
					// ...............Size 42.....................................................
					PdfPCell pdfcell42 = new PdfPCell(
							new Paragraph("(42 Size):" + p2.getH6_42_size(), myFonColor3));
					pdfcell42.setBorderWidthLeft((float) 1.5);
					PdfPCell pdfcell42a = new PdfPCell(new Paragraph(":" + p2.getP6_42_size(), myFonColor3));
					PdfPCell pdfcell42b = new PdfPCell(new Paragraph(":" + p2.getF6_42_size(), myFonColor3));
					PdfPCell pdfcell42c = new PdfPCell(new Paragraph(":" + p2.getLc6_42_size(), myFonColor3));
					// PdfPCell pdfcell42d = new PdfPCell(new Paragraph(" " ));
					PdfPCell pdfcell42e = new PdfPCell(new Paragraph(":" + p2.getRemarks_42_size(), myFonColor3));
					pdfcell42e.setBorderWidthRight((float) 1.5);
					// .............Size
					// 44.............................................................
					PdfPCell pdfcell44 = new PdfPCell(
							new Paragraph("(44 Size):" + p2.getH7_44_size(), myFonColor3));
					pdfcell44.setBorderWidthLeft((float) 1.5);
					PdfPCell pdfcell44a = new PdfPCell(new Paragraph(":" + p2.getP7_44_size(), myFonColor3));
					PdfPCell pdfcell44b = new PdfPCell(new Paragraph(":" + p2.getF7_44_size(), myFonColor3));
					PdfPCell pdfcell44c = new PdfPCell(new Paragraph(":" + p2.getLc7_44_size(), myFonColor3));
					// PdfPCell pdfcell44d = new PdfPCell(new Paragraph(" "));
					PdfPCell pdfcell44e = new PdfPCell(new Paragraph(":" + p2.getRemarks_44_size(), myFonColor3));
					pdfcell44e.setBorderWidthRight((float) 1.5);
					// .....................Size
					// 46.........................................................
					PdfPCell pdfcell46 = new PdfPCell(
							new Paragraph("(46 Size):" + p2.getH8_46_size(), myFonColor3));
					pdfcell46.setBorderWidthLeft((float) 1.5);
					PdfPCell pdfcell46a = new PdfPCell(new Paragraph(":" + p2.getP8_46_size(), myFonColor3));
					PdfPCell pdfcell46b = new PdfPCell(new Paragraph(":" + p2.getF8_46_size(), myFonColor3));
					PdfPCell pdfcell46c = new PdfPCell(new Paragraph(":" + p2.getLc8_46_size(), myFonColor3));
					// PdfPCell pdfcell46d = new PdfPCell(new Paragraph(" "));
					PdfPCell pdfcell46e = new PdfPCell(new Paragraph(":" + p2.getRemarks_46_size(), myFonColor3));
					pdfcell46e.setBorderWidthRight((float) 1.5);
					// ..........................Size
					// 48.........................................................
					PdfPCell pdfcell48 = new PdfPCell(
							new Paragraph("(48 Size):" + p2.getH9_48_size(), myFonColor3));
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
				//document.add(Chunk.NEWLINE);
				// Paragraph add here
				Paragraph par = new Paragraph();
				Font agm = new Font(Font.FontFamily.HELVETICA, 8, Font.BOLD, BaseColor.BLACK);
				par.add(new Phrase("\n" + "Asst. Gen. Mgr. (CNS/Store)\r\n" + "Liveries Store \r\n"
						+ "For RED(ER), NSCBI Airport, Kol.\r\n" + "", agm));
				par.setAlignment(Element.ALIGN_BOTTOM);
				par.setAlignment(Element.ALIGN_RIGHT);
				// par2.add(new Phrase(Chunk.NEWLINE));
				document.add(par);
				document.add(new Paragraph(new Date().toString()));

				document.close();

			} catch (Exception e) {
				// TODO: handle exception
				e.getMessage();
			}

		} finally {
			// TODO: handle finally clause
			out.close();
		}

	}

}
