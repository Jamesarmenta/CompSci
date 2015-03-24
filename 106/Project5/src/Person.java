public class Person {
	//Define variables/characteristics from input file
	public int id;
	public int yearsOfSchooling;
    public String sex;
    public int experience;
    public double wage;

    /**
     * A method for assigning characteristics to array
     * 
     * @param id
     * @param yearsOfSchooling
     * @param sex
     * @param experience
     * @param wage
     */
    public Person(int id, int yearsOfSchooling, String sex, int experience, double wage) {
    	//Assign variables/characteristics to Person array
    	this.id = id;
    	this.yearsOfSchooling = yearsOfSchooling;
        this.sex = sex;
        this.experience = experience;
        this.wage = wage;

    }
}