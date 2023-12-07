package assignments.assignment11;


public class Applicant implements Comparable<Applicant>{
    private String firstName;
    private String lastName;
    private double gpa;


    public Applicant(String firstName, String lastName, double gpa){
        this.firstName = firstName;
        this.lastName = lastName;
        this.gpa = gpa;
    }

    // compare gpa between Applicants
    @Override
    public int compareTo(Applicant other){
        return Double.compare(gpa, other.gpa);
    }
    
    @Override
    public String toString(){
        return "[" + firstName + " " + lastName + " " + gpa + "]";
    }

    public String getName(){
        return firstName + " " + lastName;
    }
}
