package login.Do;

public class Person {
	private Integer age;
	private String sex;
	private String address;
	private Integer tel;
	private String email;
	private String graduateSchool;
	private String highestEducation;
	private String major;
	
	public Person(Integer age, String sex, String address, Integer tel, String email, String graduateSchool,
			String highestEducation, String major) {
		super();
		this.age = age;
		this.sex = sex;
		this.address = address;
		this.tel = tel;
		this.email = email;
		this.graduateSchool = graduateSchool;
		this.highestEducation = highestEducation;
		this.major = major;
	}

	public Integer getAge() {
		return age;
	}
	
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getTel() {
		return tel;
	}

	public void setTel(Integer tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGraduateSchool() {
		return graduateSchool;
	}

	public void setGraduateSchool(String graduateSchool) {
		this.graduateSchool = graduateSchool;
	}

	public String getHighestEducation() {
		return highestEducation;
	}

	public void setHighestEducation(String highestEducation) {
		this.highestEducation = highestEducation;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

}
