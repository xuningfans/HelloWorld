package net.netease;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private boolean isMultipart;
	private String filePath;
	private int maxFileSize = 1024 * 1024 * 100;
	private int maxMemSize = 1024 * 512;
	private File file;

	@Override
	public void init() {
		// 获取文件将被存储的位置
		filePath = getServletContext().getInitParameter("file-upload");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 检查我们有一个文件上传请求
		isMultipart = ServletFileUpload.isMultipartContent(request);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		if (!isMultipart) {
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Servlet upload</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<p>No file uploaded</p>");
			out.println("</body>");
			out.println("</html>");
			return;
		}
		DiskFileItemFactory factory = new DiskFileItemFactory();
		// 文件大小的最大值将被存储在内存中
		factory.setSizeThreshold(maxMemSize);
		// Location to save data that is larger than maxMemSize.
		factory.setRepository(new File("C:\\temp"));
		
		// 创建一个新的文件上传处理程序
		ServletFileUpload upload = new ServletFileUpload(factory);
		// 允许上传的文件大小最大值
		upload.setSizeMax(maxFileSize);
		try {
			// 解析请求，获取文件项
			List fileItems = upload.parseRequest(request);
			
			// 处理上传的文件项
			Iterator i = fileItems.iterator();

			out.println("<html>");
			out.println("<head>");
			out.println("<title>Servlet upload</title>");
			out.println("</head>");
			out.println("<body>");
			while( i.hasNext() ){
				FileItem fi = (FileItem) i.next();
				if( !fi.isFormField()){
					// 获取上传文件的参数
					String fieldName = fi.getFieldName();
					String fileName = fi.getName();
					String contentType = fi.getContentType();
					boolean isInMemory = fi.isInMemory();
					long sizeInBytes = fi.getSize();
					
					// 写入文件
					if( fileName.lastIndexOf("\\") >=0 ){
						file = new File( filePath + 
								fileName.substring(fileName.lastIndexOf("\\")));
					} else {
						file = new File ( filePath+
								fileName.substring(fileName.lastIndexOf("\\")+1));
					}
					fi.write( file );
					out.print("Uploaded FileName: " + fileName + "<br>");
				}
			}
			out.println("</body>");
			out.println("</html>");
			
		} catch(Exception e){
			System.out.println(e);
			throw new RuntimeException(e);
		}
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		throw new ServletException("GET method used with" +
			getClass().getName()+ ": POST method required.");
	}

}
