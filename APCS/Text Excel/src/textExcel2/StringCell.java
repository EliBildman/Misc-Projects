package textExcel2;

public class StringCell extends Cell
{

	
	public StringCell(String input) {
		super(input);

	}
	
	public String getValue() {
	//	System.out.println(contents.length());
		return contents.substring(1, contents.length() - 1);
	}

	
	public static void main(String[] args) {
		StringCell cell = new StringCell("\"boyyyyyyyyyyyyyyyyyyy\"");
		System.out.print(cell.getValue());
	}
}
