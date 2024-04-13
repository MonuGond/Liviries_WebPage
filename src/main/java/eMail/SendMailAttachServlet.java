package eMail;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Servlet implementation class SendMailAttachServlet
 */

//Declaration of file size...
@MultipartConfig(fileSizeThreshold = 1024*1024*2,//2MB  file
maxFileSize = 1024*1024*10,//10MB
maxRequestSize= 1024*1024*50)//50MB




public class SendMailAttachServlet extends HttpServlet {
	
	// Here Adding host, port, user=user, emailId, password=pass
	private String host;
	private String port;
	private String user;
	private String pass;
	// read SMTP server setting from web.xml file
	public void init() {
		ServletContext context= getServletContext();
		host=context.getInitParameter("host");
		port=context.getInitParameter("pass");
		user=context.getInitParameter("user");
		pass=context.getInitParameter("pass");
	}
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendMailAttachServlet() {
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
		List<File> uploadedFiles = saveUploadedFiles(request);
		String receipient = request.getParameter("receipient");
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		String resultMessage = "";
		try {
			EmailUtility.sendEmailWithAttachment(host, port, user, pass,
					receipient, subject, content, uploadedFiles);
			resultMessage = " E-Mail sent successfully........";
			
		} catch (Exception ex) {
			// TODO: handle exception
			ex.printStackTrace();
			resultMessage = "There were an error : "+ex.getMessage();
		}finally {
			deleteUploadFiles(uploadedFiles);
			request.setAttribute("message", resultMessage);
			getServletContext().getRequestDispatcher("/Result.jsp").forward(request, response);
		}
	}

	 /**
     * Deletes all uploaded files, should be called after the e-mail was sent.
     */
	
	 private void deleteUploadFiles(List<File> uploadedFiles) {
		// TODO Auto-generated method stub
		 if(uploadedFiles!=null && uploadedFiles.size()>0) {
			 for(File aFile : uploadedFiles) {
				 aFile.delete();
			 }
		 }
		
	}

	/**
     * Saves files uploaded from the client and return a list of these files
     * which will be attached to the e-mail message.
	 * @throws ServletException 
	 * @throws IOException 
     */
	private List<File> saveUploadedFiles(HttpServletRequest request) throws IOException, ServletException {
		// TODO Auto-generated method stub
		List<File> listFiles = new ArrayList<File>();
		byte[] buffer = new byte[4096];
		int bytesReads = -1;
		Collection<Part> multiparts = request.getParts();
		if(multiparts.size()>0) {
			for(Part part : request.getParts()){
				//create a file to be saved
				//String fileName = "C:\\Users\\User\\EclipseGeneratedPdf";
				String fileName = "C:\\Users\\gondm";//filename in date form
				System.out.println("saveFile: "+fileName);
				fileName = extractFileName(part);//here extractFile Name method is call
				if(fileName == null || fileName.equals("")) {
					//not attached part
					continue;
				}
				File saveFile = new File(fileName);
				System.out.println("saveFile : "+saveFile.getAbsolutePath());
				FileOutputStream outputstream = new FileOutputStream(saveFile);
				//save upload file
				InputStream inputstream= part.getInputStream();
				while((bytesReads = inputstream.read(buffer)) != -1) {
					outputstream.write(buffer, 0, bytesReads);
				}
				outputstream.close();
				inputstream.close();
				listFiles.add(saveFile);
				System.out.println("here mail attachment servlet run.....C:\\Users\\gond\\Desktop........");
			}
		}
		return listFiles;
	}
	
	/**
     * Retrieves file name of a upload part from its HTTP header
     */

	private String extractFileName(Part part) {
		// TODO Auto-generated method stub
		String contentDisp = part.getHeader("content-disposition");
		String[] items = contentDisp.split(";");
		for(String s: items) {
			if(s.trim().startsWith("filename")) {
				return s.substring(s.indexOf("=") + 2, s.length() - 1);
			}
		}
		return null;
	}

}
