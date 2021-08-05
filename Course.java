package oopproject;

public class Course {

	public String CourseName,CourseCode;
	public int CreditHour;
	
	public Course(String CourseCode,String CourseName,  int CreditHour) {
	
		this.CourseName = CourseName;
		this.CourseCode = CourseCode;
		this.CreditHour = CreditHour;
	}

	public String getCourseName() {
		return CourseName;
	}

	public void setCourseName(String CourseName) {
		this.CourseName = CourseName;
	}

	public String getCourseCode() {
		return CourseCode;
	}

	public void setCourseCode(String CourseCode) {
		this.CourseCode = CourseCode;
	}

	public int getCreditHour() {
		return CreditHour;
	}

	public void setCreditHour(int CreditHour) {
		this.CreditHour = CreditHour;
	}
	


	
}
