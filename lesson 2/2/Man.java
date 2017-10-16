public class Man
{
	public String name;
	public String surname;
	
	Man()
	{
		System.out.println("Man");
	}
	public void setName(String newName)
	{
		this.name=newName;
	}
	public void setSurname(String newSurname)
	{
		this.surname=newSurname;
	}
	public String getName()
	{
		return this.name;
	}
	public String getSurname()
	{
		return this.surname;
	}
}