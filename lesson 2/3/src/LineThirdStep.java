
public class LineThirdStep implements ILineStep{
	public Tower buildProductPart() {
		System.out.println("Tower built");
		return new Tower();
	}

}
