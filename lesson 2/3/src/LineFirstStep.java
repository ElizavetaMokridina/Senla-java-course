
public class LineFirstStep implements ILineStep{
	public Body buildProductPart() {
		System.out.println("Body built");
		return new Body();
	}
}
