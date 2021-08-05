package oopproject;

public class Student {
	public String firstname,LastName,Gender,Adress,PhoneNum;
	public int Id;

	public Student(int Id,String firstname, String LastName, String Gender, String Adress, String PhoneNum) {
		
		this.firstname = firstname;
		this.LastName = LastName;
		this.Gender = Gender;
		this.Adress = Adress;
		this.Id = Id;
		this.PhoneNum = PhoneNum;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String LastName) {
		this.LastName = LastName;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String Gender) {
		this.Gender = Gender;
	}

	public String getAdress() {
		return Adress;
	}

	public void setAdress(String Adress) {
		this.Adress = Adress;
	}

	public int getId() {
		return Id;
	}

	public void setId( int Id) {
		this.Id = Id;
	}

	public String getPhoneNum() {
		return PhoneNum;
	}

	public void setPhoneNum(String PhoneNum) {
		this.PhoneNum = PhoneNum;
	}
	
}
