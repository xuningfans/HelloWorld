package net.netease;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Base64;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//导入必需的 java 库

//扩展 HttpServlet 类
public class HelloForm extends HttpServlet {
	private static final long serialVersionUID = 7699862742011630453L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Base64Coder base64coder = new Base64Coder();
		String str2;
		System.out.println(str2 = base64coder.BASE64EnCoder("abc"));
		System.out.println(base64coder.BASE64DeCoder(str2));
		String first_name = request.getParameter("first_name");
		String last_name = request.getParameter("last_name");
		Cookie[] cookies = request.getCookies();
		if ( cookies==null && (first_name!=null && last_name!=null )) {
			first_name = first_name.trim();
			last_name = last_name.trim();
			if( first_name!="" && last_name!="" ){
				
				// 为名字和姓氏创建 Cookies
				last_name = base64coder.BASE64EnCoder(last_name);
				first_name = base64coder.BASE64EnCoder(first_name);
				Cookie firstName = new Cookie("first_name", first_name);
				Cookie lastName = new Cookie("last_name", last_name);
				System.out.println(1);
				// 为两个 Cookies 设置过期日期为 24 小时后
				firstName.setMaxAge(60 * 1);
				lastName.setMaxAge(60 * 1);
				firstName.setPath("/");
				lastName.setPath("/");
				System.out.println(1);
				// 在响应头中添加两个 Cookies
				response.addCookie(firstName);
				response.addCookie(lastName);
				System.out.println(1);
			}
		} else if ( cookies != null ){
			for( int i=0; i<cookies.length; i++ ) {
				if("first_name".equals(cookies[i].getName())){
					first_name = cookies[i].getValue();
				}
				if("last_name".equals(cookies[i].getName())){
					last_name = cookies[i].getValue();
				}
			}
		}

		first_name = base64coder.BASE64DeCoder(first_name);
		last_name = base64coder.BASE64DeCoder(last_name);
		/*
		 * // 设置响应内容类型 response.setCharacterEncoding("UTF-8");
		 * response.setContentType("text/html;charset=UTF-8");
		 */
		PrintWriter out = response.getWriter();
		String title = "设置 Cookies 实例";
		StringBuffer docType = new StringBuffer();
		docType
			.append("<!doctype html public \">\n")
			.append("<html>\n" )
			.append("<head><title>")
			.append(title)
			.append("</title></head>\n")
			.append("<body bgcolor=\"#f0f0f0\">\n")
			.append("<h1 align=\"center\">")
			.append(title)
			.append("</h1>\n")
			.append("<ul>\n")
			.append("  <li><b>名字</b>：").append(first_name).append("\n")
			.append("  <li><b>姓氏</b>：").append(last_name).append("\n").append("人")
			.append("</ul>\n")
			.append("</body>")
			.append("</html>");
		out.write(docType.toString());
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

class Base64Coder {
	Base64.Encoder encoder = Base64.getEncoder();
	Base64.Decoder decoder = Base64.getDecoder();
	
	public String BASE64EnCoder(String str) throws UnsupportedEncodingException {
		byte[] b = null;
		String s = null;
		/* md5编码
		MessageDigest md = MessageDigest.getInstance("md5");
		byte[] md5 = md.digest(str.getBytes());*/
	
		//base64解码	
		try {
			b = encoder.encode(str.getBytes("UTF-8"));
			s = new String(b,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}
		return s;
	}
	
	public String BASE64DeCoder(String str) {
		byte[] b = null;
		String s = null;
		/* md5编码
			MessageDigest md = MessageDigest.getInstance("md5");
			byte[] md5 = md.digest(str.getBytes());*/
		
		//base64解码	
		try {
			b = decoder.decode(str.getBytes("UTF-8"));
			s = new String(b,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}
		return s;
	}
}
