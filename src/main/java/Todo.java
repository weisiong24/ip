//Matric Number: A0200273X
public class Todo extends Task {

    public Todo(String description) {
        super(description);
    }

    //Override Methods when to do class is called
    @Override
    public void markAsDone() {
        this.isDone = true;
    }

    @Override
    public String toString() {
        return "[T]" +"["+getStatusIcon()+"] "+ description+"\n" ;
    }

}