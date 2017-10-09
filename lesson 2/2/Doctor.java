public class Doctor extends Man
{
	public String position;
	
	Doctor()
	{
		System.out.println("Doctor");
	}
	public void setPosition(String newPosition)
	{
		this.position = newPosition;
	}
	public String getPosition()
	{
		return this.position;
	}
}