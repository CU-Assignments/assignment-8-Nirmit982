import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class EmployeeServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        try {
            Connection con = DBUtil.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM employee");
            out.println("<h2>Employee List</h2><ul>");
            while (rs.next()) {
                out.println("<li>" + rs.getInt("id") + " - " + rs.getString("name") + " - " + rs.getString("department") + "</li>");
            }
            out.println("</ul>");
        } catch (Exception e) {
            out.println("Error: " + e.getMessage());
        }
    }
}
