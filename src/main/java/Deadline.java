//Matric Number: A0200273X
public class Deadline extends Task {

    protected String by;

    //Using the parent class for the description
    public Deadline(String description, String by) {
        super(description);
        this.by = by;
    }

    //Override Methods when to do class is called
    @Override
    public String toString() {
        return "[D]" +"["+getStatusIcon()+"] "+ description+"\n" ;
    }
}