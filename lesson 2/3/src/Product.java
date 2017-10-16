
public class Product implements IProduct{
	public IProductPart body;
	public IProductPart engine;
	public IProductPart tower;
	public void installFirstPart(IProductPart productPart) {
		this.body = productPart;
		System.out.println("Body installed");
	}
	public void installSecondPart(IProductPart productPart) {
		this.engine = productPart;
		System.out.println("Engine installed");
	}
	public void installThirdPart(IProductPart productPart) {
		this.tower = productPart;
		System.out.println("Tower installed");
	}

}
