import java.util.Random;

public class Main {
	public static void main(String[] arg) {
		Random random= new Random();
		
		int[] array=new int[3];
		int firstDigit;
		int secondDigit;
		for(int i=0;i<3;i++)
		{
			array[i]=random.nextInt(900)+100;
			System.out.println(array[i]);
			firstDigit=array[i]/100;
			secondDigit=array[i]/10%10;		
			System.out.println("sum = "+(firstDigit+secondDigit));
		}
	}

}
