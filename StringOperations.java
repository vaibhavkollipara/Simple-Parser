import java.util.HashMap;
import java.util.Map;

public class StringOperations {

	// hashmap to store names as key and count as value
	private HashMap<String, Integer> names = new HashMap<String, Integer>();

	/*
	 * parse the input line and retrieve name values and add them to HashMap
	 */
	/**
	 * @param line from the file
	 */
	public void parseLine(String line) {
		String name;
		// checks whether "<xs:element name" exists in input line
		if (line.contains("<xs:element name")) {
			/*
			 * found the index of (name=") in line and added 6, the obtained
			 * index would be the index of first letter of the name, substring
			 * from this index till end is taken
			 */
			name = line.substring((line.indexOf("name=\"") + 6));
			/*
			 * the first index of (") is found, the substring from index 0 till
			 * the index of " would be the name value
			 */
			name = name.substring(0, name.indexOf("\""));
			// obtained name is returned
			addName(name);
		}

	}

	// add a new name or increments count
	/**
	 * @param name
	 */
	public void addName(String name) {
		if (names.containsKey(name)) {
			// incrementing count of existing name
			names.put(name, names.get(name) + 1);
		} else {
			// adding new name
			names.put(name, 1);
		}
	}

	/**
	 * @return the most frequent Name
	 */
	public String getMaxRepeatedName() {
		int max = -1;
		String frequentName = "";
		for (Map.Entry<String, Integer> name : names.entrySet()) {
			if (max == -1) {
				max = name.getValue();
			} else {
				if (name.getValue() > max) {
					max = name.getValue();
				}
			}
		}

		for (Map.Entry<String, Integer> name : names.entrySet()) {
			if (name.getValue() == max) {
				frequentName = "The most frequently occurring element is "
						+ name.getKey() + ".It appears " + name.getValue()
						+ " times";
				break;
			}
		}
		names.clear();
		return frequentName;

	}

	@Override
	public String toString() {
		return "StringOperations";
	}

}
