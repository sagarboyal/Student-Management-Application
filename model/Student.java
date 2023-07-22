package model;

public class Student {
	private int studentId;
	private String studentName;
	private String studentPhNumber;
	private String studentCity;
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(String studentName, String studentPhNumber, String studentCity) {
		super();
		this.studentName = studentName;
		this.studentPhNumber = studentPhNumber;
		this.studentCity = studentCity;
	}
	
	public Student(int studentId, String studentName, String studentPhNumber, String studentCity) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentPhNumber = studentPhNumber;
		this.studentCity = studentCity;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentPhNumber() {
		return studentPhNumber;
	}

	public void setStudentPhNumber(String studentPhNumber) {
		this.studentPhNumber = studentPhNumber;
	}

	public String getStudentCity() {
		return studentCity;
	}

	public void setStudentCity(String studentCity) {
		this.studentCity = studentCity;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + ", studentPhNumber="
				+ studentPhNumber + ", studentCity=" + studentCity + "]";
	}
	
	
}
