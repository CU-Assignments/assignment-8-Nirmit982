import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class SaveAttendanceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        String studentId = req.getParameter("studentId");
        String date = req.getParameter("date");
        String status = req.getParameter("status");
        try {
            Connection con = DBUtil.getConnection();
            PreparedStatement ps = con.prepareStatement("INSERT INTO attendance (student_id, date, status) VALUES (?, ?, ?)");
            ps.setString(1, studentId);
            ps.setString(2, date);
            ps.setString(3, status);
            ps.executeUpdate();
            res.sendRedirect("success.jsp");
        } catch (Exception e) {
            PrintWriter out = res.getWriter();
            out.println("Error: " + e.getMessage());
        }
    }
}
