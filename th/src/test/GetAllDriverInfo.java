package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.JSONHelper;
import util.JsonTrans;

import bean.DriverInfo;
import bean.UserInfoNew;

public class GetAllDriverInfo extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public GetAllDriverInfo() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		// �õ�������ݿ��connection
		ConnectJDBC connectJDBC = new ConnectJDBC();
		Connection conn = connectJDBC.getConnection();
		try {
			List<UserInfoNew> list = getAllDiriver(conn);
			String jsonString = JsonTrans.transListToJson(list);
			out.println(jsonString);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.flush();
		out.close();
	}

	// �õ�����˾��ĳ�������ϵ�绰,����һ��list�б�
	public List<UserInfoNew> getAllDiriver(java.sql.Connection conn)
			throws SQLException {
		// ����һ��statement����
		Statement statement = conn.createStatement();
		String selectDriver = "select * from user_info";
		ResultSet resultSet = statement.executeQuery(selectDriver);
		List<UserInfoNew> driverList = new ArrayList<UserInfoNew>();
		// ������ݿ�ķ��ؽ��
		while (resultSet.next()) {
			String name = resultSet.getString("user_name");
			String tel = resultSet.getString("user_tel");
			UserInfoNew userInfoNew = new UserInfoNew(name, tel);
			driverList.add(userInfoNew);
		}
		return driverList;
	}

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the POST method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

	/**
	 * Initialization of the servlet. <br>
	 * 
	 * @throws ServletException
	 *             if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
