public class Test
{
	public static void main(String[] s)
	{
		Man man = new Man();
		Patient patient = new Patient();
		Doctor doctor = new Doctor();
		HospitalRoom room = new HospitalRoom();
		Card card = new Card();
		
		patient.setCard(card);
		patient.setDoctor(doctor);
		patient.setRoom(room);
		
		patient.setName("Ivanov");
		patient.setSurname("Ivan");
		
		doctor.setName("Petr");
		doctor.setSurname("Petrovich");
		doctor.setPosition("therapist");
		

		
		System.out.println(patient.getName());
		System.out.println(patient.getSurname());
		 
		Doctor newDoctor = patient.getDoctor();
		
		System.out.println(newDoctor.getName());
		System.out.println(newDoctor.getSurname());
		System.out.println(newDoctor.getPosition());
	};
}