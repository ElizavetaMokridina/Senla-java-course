
public class Test {
	public static void main(String[] s) {
		LineFirstStep lineFirstStep= new LineFirstStep();
		LineSecondStep lineSecondStep = new LineSecondStep();
		LineThirdStep lineThirdStep = new LineThirdStep();
		AssemblyLine assemblyLine = new AssemblyLine(lineFirstStep, lineSecondStep, lineThirdStep);
		Product product = new Product();
		assemblyLine.assembleProduct(product);
	
	}

}
