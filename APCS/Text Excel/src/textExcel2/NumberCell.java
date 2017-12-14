package textExcel2;

public class NumberCell extends Cell
{
	
	double number;
	
	public NumberCell(String input) {
		super(input);
		number = Double.parseDouble(input);
		
	}
	
	public String getValue() {
		return number + "";
	}

	public static void main(String[] args) {
		NumberCell yam = new NumberCell("5");
		System.out.println(yam.getValue());
	}

}
