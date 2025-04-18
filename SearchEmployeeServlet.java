public class SearchEmployeeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String empId = req.getParameter("empId");
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        try {
            Connection con = DBUtil.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM employee WHERE id=?");
            ps.setInt(1, Integer.parseInt(empId));
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                out.println("<h3>Employee Found:</h3>");
                out.println("ID: " + rs.getInt("id") + "<br/>");
                out.println("Name: " + rs.getString("name") + "<br/>");
                out.println("Dept: " + rs.getString("department") + "<br/>");
            } else {
                out.println("Employee not found.");
            }
        } catch (Exception e) {
            out.println("Error: " + e.getMessage());
        }
    }
}
