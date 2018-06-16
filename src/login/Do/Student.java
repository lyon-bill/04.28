package login.Do;

public class Student {
	private String ID;
	private String name;
	private String sex;
	private String password;
	private String subject;
	private String age;
	private String loginTime;
	public Student(String iD, String name, String sex, String password, String subject, String age, String LoginTime) {
		super();
		this.ID = iD;
		this.name = name;
		this.sex = sex;
		this.password = password;
		this.subject = subject;
		this.age = age;
		this.loginTime=LoginTime;
	}
	
	public Student() {
		
	}
	public Student(String name, String password, String loginTime) {
		super();
		this.name = name;
		this.password = password;
		this.loginTime = loginTime;
	}

	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(String loginTime) {
		this.loginTime = loginTime;
	}

	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	
}
