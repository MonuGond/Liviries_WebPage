package ladiesUniform;

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
 * Servlet implementation class LadiesUniformPdfServlet1
 */
public class LadiesUniformPdfServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LadiesUniformPdfServlet1() {
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
		System.out.println("Yha pr aa rha ...............hai........................");
		response.setContentType("application/pdf");
		System.out.println("Yha pr aa rha ...............hai........................1");
		ServletOutputStream out = response.getOutputStream();
		
		String serialno =request.getParameter("serialno");
		try {
			System.out.println("Yha pr aa rha ...............hai........................2");
			try {
				
				System.out.println("Yha pr aa rha ...............hai........................3");
				Document document = new Document();
				System.out.println("Yha pr aa rha ...............hai........................4");
				PdfWriter.getInstance(document, out);
				document.open();
				System.out.println("Yha pr aa rha ...............hai........................5");
				Image image= Image.getInstance("C:\\Users\\gondm\\eclipse-workspace\\AAI\\src\\main\\webapp\\Screenshot (2).png");
				System.out.println("Yha pr aa rha ...............hai........................6");
				image.setAlignment(Element.ALIGN_CENTER);
				image.scaleToFit(65, 65);
				document.add(image);
				
				Font myFonColor2 = FontFactory.getFont(FontFactory.COURIER, 12, Font.BOLD, BaseColor.BLACK);

				// use for Size table
				Font myFonColor3 = FontFactory.getFont(FontFactory.COURIER, Font.DEFAULTSIZE, BaseColor.BLACK);


				LadiesUniformDao d2 = new LadiesUniformDao();
				ArrayList<LadiesUniformPozo> ladiesspdf = new ArrayList<>();
				//ladiesspdf = d2.getDataFromDao(serialno);
				ladiesspdf = d2.getDataFromDao(serialno);

				Paragraph par2 = new Paragraph();
				Font er = new Font(Font.FontFamily.COURIER, 12, Font.BOLD, BaseColor.BLACK);
				par2.add(new Phrase("O/O THE RED(ER)#UNIFORM MATERIALS FOR MALE OFFICIAL(FOR 3 YEARS)", er));
				par2.setAlignment(Element.ALIGN_CENTER);
				par2.add(new Phrase(Chunk.NEWLINE));
				par2.add(new Phrase(Chunk.NEWLINE));
				document.add(par2);

				PdfPTable table1 = new PdfPTable(8);
				table1.setWidthPercentage(105);
				table1.setWidths(new int[] { 5, 3, 5, 3, 5, 2, 6, 11 });

				for (LadiesUniformPozo p1 : ladiesspdf) {
					
					PdfPCell pdfPCell1 = new PdfPCell(new Paragraph("Book.No.", myFonColor2));
					pdfPCell1.setBorderWidth((float) 1.5);
					PdfPCell pdfPCell2 = new PdfPCell(new Paragraph(" " +p1.getBookno(),myFonColor3));
					pdfPCell2.setBorderWidth((float) 1.5);
					PdfPCell pdfPCell3 = new PdfPCell(new Paragraph("Page No.", myFonColor2));
					pdfPCell3.setBorderWidth((float) 1.5);
					PdfPCell pdfPCell4 = new PdfPCell(new Paragraph(" " +p1.getPgno(),myFonColor3));
					pdfPCell4.setBorderWidth((float) 1.5);
					PdfPCell pdfPCell5 = new PdfPCell(new Paragraph("C/Size", myFonColor2));
					pdfPCell5.setBorderWidth((float) 1.5);
					PdfPCell pdfPCell6 = new PdfPCell(new Paragraph(" " +p1.getG_u_size(),myFonColor3));
					pdfPCell6.setBorderWidth((float) 1.5);
					
					PdfPCell pdfPCell7s = new PdfPCell(new Paragraph("Serial No.", myFonColor2));
					pdfPCell7s.setBorderWidth((float) 1.5);
					PdfPCell pdfPCell8s = new PdfPCell(new Paragraph(" " +p1.getSerialno(),myFonColor3));
					pdfPCell8s.setBorderWidth((float) 1.5);
					
					table1.addCell(pdfPCell1);
					table1.addCell(pdfPCell2);
					table1.addCell(pdfPCell3);
					table1.addCell(pdfPCell4);
					table1.addCell(pdfPCell5);
					table1.addCell(pdfPCell6);
					table1.addCell(pdfPCell7s);
					table1.addCell(pdfPCell8s);
					document.add(table1);
					// document.add(Chunk.NEWLINE);

					PdfPTable table2 = new PdfPTable(2);
					table2.setWidthPercentage(105);
					PdfPCell pdfPCell7 = new PdfPCell(new Paragraph("               EMPLOYEE ID No.", myFonColor2));
					pdfPCell7.setBorderWidthLeft((float) 1.5);
					PdfPCell pdfPCell8 = new PdfPCell(new Paragraph(" " +p1.getEmpno(),myFonColor3));
					pdfPCell8.setBorderWidthRight((float) 1.5);
					PdfPCell pdfPCell9 = new PdfPCell(new Paragraph("               EMPLOYEE NAME", myFonColor2));
					pdfPCell9.setBorderWidthLeft((float) 1.5);
					PdfPCell pdfPCell10 = new PdfPCell(new Paragraph(" " +p1.getEname(),myFonColor3));
					pdfPCell10.setBorderWidthRight((float) 1.5);
					PdfPCell pdfPCell11 = new PdfPCell(new Paragraph("               DESIGNATION", myFonColor2));
					pdfPCell11.setBorderWidthLeft((float) 1.5);
					PdfPCell pdfPCell12 = new PdfPCell(new Paragraph(" " +p1.getDesignation(),myFonColor3));
					pdfPCell12.setBorderWidthRight((float) 1.5);
					PdfPCell pdfPCell13 = new PdfPCell(new Paragraph("                    Date ", myFonColor2));
					pdfPCell13.setBorderWidthLeft((float) 1.5);
					PdfPCell pdfPCell14 = new PdfPCell(new Paragraph(" " +p1.getGdate(), myFonColor3));
					pdfPCell14.setBorderWidthRight((float) 1.5);
					table2.addCell(pdfPCell7);
					table2.addCell(pdfPCell8);
					table2.addCell(pdfPCell9);
					table2.addCell(pdfPCell10);
					table2.addCell(pdfPCell11);
					table2.addCell(pdfPCell12);
					table2.addCell(pdfPCell13);
					table2.addCell(pdfPCell14);
					document.add(table2);
					// document.add(Chunk.NEWLINE);
					
					
					PdfPTable table3 = new PdfPTable(4);
					table3.setWidthPercentage(105);
					table3.setWidths(new int[] { 4, 10, 8, 6 });

					PdfPCell pdfPCells = new PdfPCell(new Paragraph("  Sl.No.", myFonColor2));
					pdfPCells.setBorderWidthLeft((float) 1.5);
					PdfPCell pdfPCellt = new PdfPCell(new Paragraph("      Type of Cloths", myFonColor2));
					//pdfPCellt.setBorderWidthLeft((float) 1.5);
					PdfPCell pdfPCellcp = new PdfPCell(new Paragraph("      Cloth Pcs", myFonColor2));
					//pdfPCellcp.setBorderWidthLeft((float) 1.5);
					PdfPCell pdfPCellr = new PdfPCell(new Paragraph("    Remarks ", myFonColor2));
					pdfPCellr.setBorderWidthRight((float) 1.5);
					
					// ........Shirting Cloth..........
					PdfPCell pdfPCells1 = new PdfPCell(new Paragraph("    1.", myFonColor2));
					pdfPCells1.setBorderWidthLeft((float) 1.5);
					PdfPCell pdfPCellt1 = new PdfPCell(new Paragraph("         Silk Sarees", myFonColor2));
					// pdfPCell2.setBorderWidth((float) 1.5);
					
					PdfPCell pdfPCellcp1 = new PdfPCell(new Paragraph(" " +p1.getS_saree_pcs(),myFonColor3));
					// pdfPCell4.setBorderWidth((float) 1.5);
					
					PdfPCell pdfPCellr1 = new PdfPCell(new Paragraph("      "));
					pdfPCellr1.setBorderWidthRight((float) 1.5);
					
					// ........Pant Cloath
					PdfPCell pdfPCells2 = new PdfPCell(new Paragraph("    2.", myFonColor2));
					pdfPCells2.setBorderWidthLeft((float) 1.5);
					PdfPCell pdfPCellt2 = new PdfPCell(new Paragraph("        Crape Sarees", myFonColor2));
					// pdfPCell2.setBorderWidth((float) 1.5);
					
					PdfPCell pdfPCellcp2 = new PdfPCell(new Paragraph(" " +p1.getC_saree_pcs(),myFonColor3));
					// pdfPCell4.setBorderWidth((float) 1.5);
					
					PdfPCell pdfPCellr2 = new PdfPCell(new Paragraph("      "));
					pdfPCellr2.setBorderWidthRight((float) 1.5);
					
					// ...................Suit Cloth.................
					PdfPCell pdfPCells3 = new PdfPCell(new Paragraph("    3.", myFonColor2));
					pdfPCells3.setBorderWidthLeft((float) 1.5);
					PdfPCell pdfPCellt3 = new PdfPCell(new Paragraph("      Synthetic Sarees", myFonColor2));
					// pdfPCell2.setBorderWidth((float) 1.5);
					
					PdfPCell pdfPCellcp3 = new PdfPCell(new Paragraph(" " +p1.getSyn_saree_pcs(),myFonColor3));
					// pdfPCell4.setBorderWidth((float) 1.5);
					
					PdfPCell pdfPCellr3 = new PdfPCell(new Paragraph("      "));
					pdfPCellr3.setBorderWidthRight((float) 1.5);
					
					
					// ...................Half Sleeve Gents Cardigan.................
					PdfPCell pdfPCells5 = new PdfPCell(new Paragraph("    4.", myFonColor2));
					pdfPCells5.setBorderWidthLeft((float) 1.5);
					PdfPCell pdfPCellt5 = new PdfPCell(new Paragraph("       PullOver(Jersey)", myFonColor2));
					// pdfPCell2.setBorderWidth((float) 1.5);
					
					PdfPCell pdfPCellcp5 = new PdfPCell(new Paragraph(" " +p1.getPullover(),myFonColor3));
					// pdfPCell4.setBorderWidth((float) 1.5);
					
					PdfPCell pdfPCellr5 = new PdfPCell(new Paragraph("      "));
					pdfPCellr5.setBorderWidthRight((float) 1.5);
					// ...................Half Sleeve Gents Cardigan.................
					PdfPCell pdfPCells6 = new PdfPCell(new Paragraph("    5.", myFonColor2));
					pdfPCells6.setBorderWidthLeft((float) 1.5);
					PdfPCell pdfPCellt6 = new PdfPCell(new Paragraph("   Half Sleeve Cardigan", myFonColor2));
					// pdfPCell2.setBorderWidth((float) 1.5);
					
					PdfPCell pdfPCellcp6 = new PdfPCell(new Paragraph(" " +p1.getH_s_cardigan(),myFonColor3));
					// pdfPCell4.setBorderWidth((float) 1.5);
					
					PdfPCell pdfPCellr6 = new PdfPCell(new Paragraph("      "));
					pdfPCellr6.setBorderWidthRight((float) 1.5);
					
					// ..................Nos. of Neck Ties.................
					PdfPCell pdfPCells7 = new PdfPCell(new Paragraph("    6.", myFonColor2));
					pdfPCells7.setBorderWidthLeft((float) 1.5);
					PdfPCell pdfPCellt7 = new PdfPCell(
							new Paragraph("     Ladies Cardigan", myFonColor2));
					// pdfPCell2.setBorderWidth((float) 1.5);
					
					PdfPCell pdfPCellcp7 = new PdfPCell(new Paragraph(" " +p1.getCardigan_pcs(),myFonColor3));
					// pdfPCell4.setBorderWidth((float) 1.5);
					
					PdfPCell pdfPCellr7 = new PdfPCell(new Paragraph("      "));
					pdfPCellr7.setBorderWidthRight((float) 1.5);
					
					// ..................Scarves for Ladies(opt. for male uniform).................
					PdfPCell pdfPCells8 = new PdfPCell(new Paragraph("    7.", myFonColor2));
					pdfPCells8.setBorderWidthLeft((float) 1.5);
					PdfPCell pdfPCellt8 = new PdfPCell(new Paragraph("     Ladies Scarves", myFonColor2));
					// pdfPCell2.setBorderWidth((float) 1.5);
					
					PdfPCell pdfPCellcp8 = new PdfPCell(new Paragraph(" " +p1.getScarves_pcs(),myFonColor3));
					// pdfPCell4.setBorderWidth((float) 1.5);
					
					PdfPCell pdfPCellr8 = new PdfPCell(new Paragraph("      "));
					pdfPCellr8.setBorderWidthRight((float) 1.5);
					
					
					// ..................Fire PullOver.................
					PdfPCell pdfPCells9 = new PdfPCell(new Paragraph("    8.", myFonColor2));
					pdfPCells9.setBorderWidthLeft((float) 1.5);
					pdfPCells9.setBorderWidthBottom((float) 1.5);
					PdfPCell pdfPCellt9 = new PdfPCell(new Paragraph("       Fire PullOver", myFonColor2));
					pdfPCellt9.setBorderWidthBottom((float) 1.5);
					
					PdfPCell pdfPCellcp9 = new PdfPCell(new Paragraph(" " +p1.getF_p_over(),myFonColor3));
					pdfPCellcp9.setBorderWidthBottom((float) 1.5);
					
					PdfPCell pdfPCellr9 = new PdfPCell(new Paragraph("      "));
					pdfPCellr9.setBorderWidthRight((float) 1.5);
					pdfPCellr9.setBorderWidthBottom((float) 1.5);

					table3.addCell(pdfPCells);
					table3.addCell(pdfPCellt);
					
					table3.addCell(pdfPCellcp);
					
					table3.addCell(pdfPCellr);

					table3.addCell(pdfPCells1);
					table3.addCell(pdfPCellt1);
					
					table3.addCell(pdfPCellcp1);
					
					table3.addCell(pdfPCellr1);

					table3.addCell(pdfPCells2);
					table3.addCell(pdfPCellt2);
					
					table3.addCell(pdfPCellcp2);
					
					table3.addCell(pdfPCellr2);

					table3.addCell(pdfPCells3);
					table3.addCell(pdfPCellt3);
					
					table3.addCell(pdfPCellcp3);

					table3.addCell(pdfPCellr3);

					
					table3.addCell(pdfPCells5);
					table3.addCell(pdfPCellt5);
					table3.addCell(pdfPCellcp5);
					table3.addCell(pdfPCellr5);

					table3.addCell(pdfPCells6);
					table3.addCell(pdfPCellt6);
					table3.addCell(pdfPCellcp6);
					table3.addCell(pdfPCellr6);

					table3.addCell(pdfPCells7);
					table3.addCell(pdfPCellt7);
					table3.addCell(pdfPCellcp7);
					table3.addCell(pdfPCellr7);

					table3.addCell(pdfPCells8);
					table3.addCell(pdfPCellt8);
					table3.addCell(pdfPCellcp8);
					table3.addCell(pdfPCellr8);
					
					table3.addCell(pdfPCells9);
					table3.addCell(pdfPCellt9);
					table3.addCell(pdfPCellcp9);
					table3.addCell(pdfPCellr9);
					document.add(table3);

				}
				
				document.add(Chunk.NEWLINE);
				document.add(Chunk.NEWLINE);
				Paragraph par3= new Paragraph();
				par3.add("Employee Signature..............");
				par3.setAlignment(Element.ALIGN_LEFT);
				document.add(par3);
				document.add(Chunk.NEWLINE);
				document.add(Chunk.NEWLINE);
				Paragraph par4= new Paragraph();
				par4.add("Materials Issued by................");
				par4.setAlignment(Element.ALIGN_RIGHT);
				document.add(par4);
				document.add(Chunk.NEWLINE);
				document.add(Chunk.NEWLINE);
				
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
