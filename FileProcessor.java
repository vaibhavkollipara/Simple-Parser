import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
/*Few lines of code taken from code written by me in the past.*/
public class FileProcessor {
	private String fileName;
	private FileReader fileReader;
	private BufferedReader bufferedReader;

	

	/**
	 * @param filename
	 *            name of the input file
	 */
	public FileProcessor(String filename) {
		setFileName(filename + ".xml");
		try {
			setFileReader(new FileReader(getFileName())); //taken code
			setBufferedReader(new BufferedReader(fileReader)); //taken code
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Cannot Open The File");
			System.out.println(e.getMessage());
			e.printStackTrace();

		}
	}

	// method to read line from a file and return it
	public String readLineFromFile() {
		try {// checks for end of file
			String line;
			if ((line = getBufferedReader().readLine()) != null) {//taken code
				// returns line
				return line;
			} else {// end of file
				getFileReader().close();
				getBufferedReader().close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Cannot read from the file");
			System.out.println(e.getMessage());
			System.exit(1);
		}
		return "-1";
	}
	
	/*Getters and Setters*/
	/**
	 * @return filename
	 */
	private String getFileName() {
		return fileName;
	}

	/**
	 * @param fileName
	 */
	private void setFileName(String fileName) {
		this.fileName = fileName;
	}

	/**
	 * @return fileReader
	 */
	private FileReader getFileReader() {
		return fileReader;
	}

	/**
	 * @param fileReader
	 */
	private void setFileReader(FileReader fileReader) {
		this.fileReader = fileReader;
	}

	/**
	 * @return bufferedReader
	 */
	private BufferedReader getBufferedReader() {
		return bufferedReader;
	}

	/**
	 * @param bufferedReader
	 */
	private void setBufferedReader(BufferedReader bufferedReader) {
		this.bufferedReader = bufferedReader;
	}

	@Override
	public String toString() {
		return "FileProcessor";
	}
}
