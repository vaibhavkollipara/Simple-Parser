/**
 * @author Vaibhav Kollipara
 * 
 */
public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileProcessor fileProcessor;
		StringOperations so = new StringOperations();
		if (args.length == 1) {
			fileProcessor = new FileProcessor(args[0]);
			for (String line = fileProcessor.readLineFromFile(); !line
					.equals("-1"); line = fileProcessor.readLineFromFile()) {
				so.parseLine(line);
			}
			System.out.println(so.getMaxRepeatedName());
		} else {
			if (args.length > 1)
				System.out.println("Exception : Too many inputs");
			else
				System.out.println("Exception : No input");
			System.exit(1);
		}

	}

	@Override
	public String toString() {
		return "Driver";
	}
}
