import java.io.*;
import java.util.*;

/**
 * A method to read input file line by line and assign columns to array characteristics
 *
 */

public class Parser {
    Person[] persons;
    public void lineByLine() throws FileNotFoundException {
        this.persons = new Person[FileInfo.numLines()];
        Scanner fileReader = new Scanner(new File("src/input.txt"));
        int i = 0;
        while (fileReader.hasNext()) {
            this.persons[i] = new Person(
            		fileReader.nextInt(),
            		fileReader.nextInt(),
            		fileReader.next(),
            		fileReader.nextInt(),
            		fileReader.nextDouble()
    		);
            i++;
        }
    }

/**
 * A method for analyzing the Person array as desired
 * @return wagePerSchoolYear double
 */

public double analyze() {
	double wagePerSchoolYear = 0;

    for (Person personal : this.persons) {
        if (personal.sex.contains("female")) {
            wagePerSchoolYear+= personal.wage/personal.yearsOfSchooling;
        }
    }
    
    return wagePerSchoolYear;
}
}