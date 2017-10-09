public class Patient extends Man
{
	public Card card;
	public HospitalRoom room;
	public Doctor doctor;
	
	Patient()
	{
		System.out.println("Patient");
	}
	public void setCard(Card newCard)
	{
		this.card = newCard;
	}
	public Card getCard()
	{
		return this.card;
	}
	public void setRoom(HospitalRoom newRoom)
	{
		this.room = newRoom;
	}
	public HospitalRoom getRoom()
	{
		return this.room;
	}
	public void setDoctor(Doctor newDoctor)
	{
		this.doctor = newDoctor;
	}
	public Doctor getDoctor()
	{
		return this.doctor;
	}
}