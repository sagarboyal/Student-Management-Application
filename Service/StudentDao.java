package Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connection.Cn;
import model.Student;

public class StudentDao{
	public Connection connection;
	
	public StudentDao() throws Exception{
		// TODO Auto-generated constructor stub
			connection  = Cn.createConnection();
	}
	public void close() throws Exception {
		connection.close();
	}
	
	public boolean insertStudent(Student student) throws SQLException{
		String query = "insert into students (name, mobile_number, city) values (?, ?, ?)";
        PreparedStatement pStatement = connection.prepareStatement(query);
        pStatement.setString(1, student.getStudentName());
        pStatement.setString(2, student.getStudentPhNumber());
        pStatement.setString(3, student.getStudentCity());
        int rowsInserted = pStatement.executeUpdate();
        if (rowsInserted > 0) {
          return true;
        }
        return false;
	}
	
	public boolean updateStudent(int studentId,String name, String phone, String city) throws SQLException{
		String query = "update students set name = ?, phone_number = ?, city = ? where id = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, name);
		preparedStatement.setString(2, phone);
		preparedStatement.setString(3, city);
		preparedStatement.setInt(4, studentId);
		preparedStatement.executeUpdate();
		return true;
	}
	public boolean updateStudentCity(int studentId, String city) throws SQLException{
		String query = "update students set city = ? where id = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, city);
		preparedStatement.setInt(2, studentId);
		preparedStatement.executeUpdate();
		return true;
	}
	public boolean updateStudentName(int studentId, String name) throws SQLException{
		String query = "update students set name = ? where id = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, name);
		preparedStatement.setInt(2, studentId);
		preparedStatement.executeUpdate();
		return true;
	}
	public boolean updateStudentPhone(int studentId, String phone) throws SQLException{
		String query = "update students set phone_number = ? where id = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, phone);
		preparedStatement.setInt(2, studentId);
		preparedStatement.executeUpdate();
		return true;
	}
	public boolean deleteStudent(int studentId) throws SQLException{
		String query = "delete from students where id = ?";
        PreparedStatement pStatement = connection.prepareStatement(query);
        pStatement.setInt(1, studentId);
        int rowsDeleted = pStatement.executeUpdate();
        if (rowsDeleted > 0) {
          return true;
        }
        return false;
	}
	public List<Student> viewAllStudent() throws SQLException{
		List<Student> record = new ArrayList<>();
		String Query = "select * from students";
		
		Statement st = connection.createStatement();
		ResultSet set = st.executeQuery(Query);
		
		while(set.next()) {
			record.add(new Student(set.getInt(1), set.getString(2), set.getString(3), set.getString(4)));
		}
		return record;
	}
	public Student viewStudent(int studentId) throws SQLException{
		Student student = null;
        String query = "select * from students where id = ?";
        PreparedStatement pStatement = connection.prepareStatement(query);
        pStatement.setInt(1, studentId);
        ResultSet resultSet = pStatement.executeQuery();
        while (resultSet.next()) {
          student = new Student();
          student.setStudentId(resultSet.getInt("id"));
          student.setStudentName(resultSet.getString("name"));
          student.setStudentPhNumber(resultSet.getString("mobile_number"));
          student.setStudentCity(resultSet.getString("city"));
        }
        return student;
	}
}
