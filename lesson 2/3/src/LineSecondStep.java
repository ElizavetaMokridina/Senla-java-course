
public class LineSecondStep implements ILineStep{
	public Engine buildProductPart(){
		System.out.println("Engine built");
		return new Engine();
	}

}
