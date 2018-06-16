package login.dao;

import login.Do.Student;

public interface StudentDAO {
	public boolean addStudent(Student stu);

	public boolean DeleteStudnet(Student stuID);

	public boolean UpdateStudent(Student stu);

	public Student GetStudentByID(String id);
}
