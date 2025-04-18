<html>
<head><title>Attendance Form</title></head>
<body>
  <h2>Student Attendance</h2>
  <form action="saveAttendance" method="post">
    Student ID: <input type="text" name="studentId"/><br/>
    Date: <input type="date" name="date"/><br/>
    Status: 
    <select name="status">
      <option value="Present">Present</option>
      <option value="Absent">Absent</option>
    </select><br/>
    <input type="submit" value="Submit"/>
  </form>
</body>
</html>
