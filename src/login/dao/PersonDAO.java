package login.dao;

import login.Do.Person;

public interface PersonDAO {
	public boolean addPerson(Person per);

	public boolean DeletePerson(Person pername);

	public boolean UpdatePerson(Person per,String currentname);

	public Person GetPersonByname(Person id);

}
