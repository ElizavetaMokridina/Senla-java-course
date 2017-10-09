
public class AssemblyLine implements IAssemblyLine{
	
	public LineFirstStep lineFirstStep;
	public LineSecondStep lineSecondStep;
	public LineThirdStep lineThirdStep;
	
	AssemblyLine(LineFirstStep lineFirstStep,LineSecondStep lineSecondStep,LineThirdStep lineThirdStep ){
		this.lineFirstStep= lineFirstStep;
		this.lineSecondStep = lineSecondStep;
	    this.lineThirdStep = lineThirdStep;
		System.out.println("Assembly line created");
	}
	public IProduct assembleProduct(IProduct product) {
		
		Body body = lineFirstStep.buildProductPart();
		Engine engine =lineSecondStep.buildProductPart();
		Tower tower = lineThirdStep.buildProductPart();
		
		product.installFirstPart(body);
		product.installSecondPart(engine);
		product.installThirdPart(tower);
		
		System.out.println("Tank created");
		return product;
	}
}
