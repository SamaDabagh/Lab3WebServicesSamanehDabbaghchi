package webHelloREST;

public class University {

	private String name;
	private int yearOfEstablishment;
	private int numOfPrograms;
	
	public University()
	{
		name = "";
		yearOfEstablishment = 0;
		numOfPrograms = 0;	
	}

	public University(String name, int yearOfEstablishment, int numOfPrograms) {
		this.name = name;
		this.yearOfEstablishment = yearOfEstablishment;
		this.numOfPrograms = numOfPrograms;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getYearOfEstablishment() {
		return yearOfEstablishment;
	}

	public void setYearOfEstablishment(int yearOfEstablishment) {
		this.yearOfEstablishment = yearOfEstablishment;
	}

	public int getNumOfPrograms() {
		return numOfPrograms;
	}

	public void setNumOfPrograms(int numOfPrograms) {
		this.numOfPrograms = numOfPrograms;
	}

	@Override
	public String toString() {
		return "University [name=" + name + ", yearOfEstablishment=" + yearOfEstablishment + ", numOfPrograms="
				+ numOfPrograms + "]";
	}

}
