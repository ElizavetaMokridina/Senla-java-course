public class Card
{
	public long number;
	public String disease;
	
	Card()
	{
		System.out.println("Card");
	}
	public void getNumber(long newNumber)
	{
		this.number=newNumber;
	}
	public void disease(String newDisease)
	{
		this.disease=newDisease;
	}
	public long setNumber()
	{
		return this.number;
	}
	public String setDisease()
	{
		return this.disease;
	}
}