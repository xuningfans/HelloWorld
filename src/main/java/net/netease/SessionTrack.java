package net.netease;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/SessionTrack")
public class SessionTrack extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 如果不存在 session 会话，则创建一个 session 对象
		HttpSession session = request.getSession(true);
		// 获取 session 创建时间
		Date createTime = new Date(session.getCreationTime());
		// 获取该网页的最后一次访问时间
		Date lastAccessTime = new Date(session.getLastAccessedTime());

		String title = "欢迎回来!";
		Integer visitCount = 0;
		String visitCountKey = "visitcount";
		String userIDKey = "userID";
		String userID = "ABCD";

		// 检查网页上是否有新的访问者
		if (session.isNew()) {
			title = "欢迎光临！";
			session.setAttribute(userIDKey, userID);
		} else {
			visitCount = (Integer) session.getAttribute(visitCountKey);
			visitCount++;
			userID = (String) session.getAttribute(userIDKey);
		}
		session.setAttribute(visitCountKey, visitCount);

		// 设置响应内容类型
		ServletOutputStream out = response.getOutputStream();
		StringBuffer sbOut = new StringBuffer();
		sbOut
			.append("<!doctype html public \"-//w3c//dtd html 4.0 ")
			.append("transitional//en\">\n");
		sbOut
			.append("<html>\n")
			.append("<head><title>").append(title).append("</title></head>\n")
			.append("<body bgcolor=\"#f0f0f0\">\n")
			.append("<h1 align=\"center\">").append(title).append("</h1>\n")
			.append( "<h2 align=\"center\">Session 信息</h2>\n")
			.append("<table border=\"1\" align=\"center\">\n")
			.append("<tr bgcolor=\"#949494\">\n")
			.append("  <th>Session 信息</th><th>值</th></tr>\n" )
			.append("<tr>\n")
			.append("  <td>id</td>\n" )
			.append("  <td>").append(session.getId()).append("</td></tr>\n")
			.append("<tr>\n")
			.append("  <td>Creation Time</td>\n")
			.append("  <td>")
			.append(createTime)
			.append("  </td></tr>\n")
			.append("<tr>\n")
			.append("  <td>Time of Last Access</td>\n")
			.append("  <td>" )
			.append(lastAccessTime)
			.append("  </td></tr>\n")
			.append("<tr>\n")
			.append("  <td>User ID</td>\n")
			.append("  <td>" ).append(userID)
			.append("  </td></tr>\n")
			.append("<tr>\n")
			.append("  <td>Number of visits</td>\n")
			.append("  <td>" ).append(visitCount).append("</td></tr>\n")
			.append("</table>\n")
			.append("<form action=\"DeleteCookies\" method=\"POST\" align=\"center\">")
			.append("<input type=\"submit\" value=\"清除Session\" />")
			.append("<form/>")
			.append("</body></html>");
		out.write(sbOut.toString().getBytes());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
