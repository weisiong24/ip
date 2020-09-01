//Matric Number: A0200273X
import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        showWelcomeMessage();
        //String Array of size 100 created to store item list
        String[] itemList = new String[100];
        String line;
        Scanner in = new Scanner(System.in);
        line = in.nextLine();

        Duke numTasks =new Duke();
        int taskCounts=0;
        
        /**
         * When user enter list it will show a list of input saved
         * to do command add a item into the list and mark it as task
         * deadline command set a item with the deadline and mark it as deadline
         * Event command add item as events to do and mark it as event
         * When user enter done it will mark the task as done into the list
         * It will run continuously till bye command is given
         */
        while(!line.equals("bye")){
            for(int i=0;i<100;i++) {
                String[] doneSide = line.split(" ");
                String[] task = line.split(" ");

                if(line.equals("list")) {
                    System.out.print("____________________________________________________________\n");
                    System.out.print("Here are the tasks in your list:\n");
                    System.out.print("____________________________________________________________\n");

                    for(int j=0;j<i;j++) {
                        if(numTasks.getNumTasks()==j+1){
                        Task t = new Task(itemList[j]);
                        t.markAsDone();
                            if(numTasks.getTodoNum()==j+1) {
                                System.out.print(j + 1 + "." + "[" + "T" + "]" + "[" + t.getStatusIcon() + "] " + itemList[j] + "\n");

                            } else if(numTasks.getDeadlineNum()==j+1){
                                System.out.print(j + 1 + "." + "[" + "D" + "]" + "[" + t.getStatusIcon() + "] " + itemList[j] + "\n");

                            } else if(numTasks.getEventNum()==j+1){
                                System.out.print(j + 1 + "." + "[" + "E" + "]" + "[" + t.getStatusIcon() + "] " + itemList[j] + "\n");

                            } else {
                                System.out.print(j + 1 + "." + "[" + " " + "]" + "[" + t.getStatusIcon() + "] " + itemList[j] + "\n");
                            }

                        } else{
                            Task t = new Task(itemList[j]);
                            t.markUndone();
                            if(numTasks.getTodoNum()==j+1) {
                                System.out.print(j + 1 + "." + "[" + "T" + "]" + "[" + t.getStatusIcon() + "] " + itemList[j] + "\n");

                            } else if(numTasks.getDeadlineNum()==j+1){
                                System.out.print(j + 1 + "." + "[" + "D" + "]" + "[" + t.getStatusIcon() + "] " + itemList[j] + "\n");

                            } else if(numTasks.getEventNum()==j+1){
                                System.out.print(j + 1 + "." + "[" + "E" + "]" + "[" + t.getStatusIcon() + "] " + itemList[j] + "\n");

                            } else {
                                System.out.print(j + 1 + "." + "[" + " " + "]" + "[" + t.getStatusIcon() + "] " + itemList[j] + "\n");

                            }
                        }
                    }
                    i-=1;

                    System.out.print("____________________________________________________________\n");

                } else if(doneSide[0].equals("done")){
                    Task t = new Task(itemList[i]);
                    t.markAsDone();
                    int taskNum=Integer.parseInt(doneSide[1]);

                    System.out.print("____________________________________________________________\n");
                    System.out.print("Nice! I've marked this task as done: \n");
                    System.out.print("\t["+t.getStatusIcon()+"] "+itemList[taskNum-1]+"\n");
                    System.out.print("____________________________________________________________\n");
                    numTasks.setNumTasks(taskNum);

                } else if(task[0].equals("todo")){
                    numTasks.setTaskCount(taskCounts+=1);
                    String taskItem= line.substring(5);
                    Todo t = new Todo(taskItem);

                    System.out.print("____________________________________________________________\n");
                    System.out.print("Got it. I've added this task: \n");
                    System.out.print("\t"+t.toString());
                    System.out.print( "Now you have "+numTasks.getTaskCount()+" tasks in the list.");
                    System.out.print("\n____________________________________________________________\n");
                    itemList[i] = taskItem;
                    numTasks.setTodoNum(numTasks.getTaskCount());

                } else if(task[0].equals("deadline")){
                    numTasks.setTaskCount(taskCounts+=1);
                    String taskItem= line.substring(9);
                    Deadline d = new Deadline(taskItem,"");

                    System.out.print("____________________________________________________________\n");
                    System.out.print("Got it. I've added this task: \n");
                    System.out.print("\t"+d.toString());
                    System.out.print( "Now you have "+numTasks.getTaskCount()+" tasks in the list.");
                    System.out.print("\n____________________________________________________________\n");
                    itemList[i] = taskItem;
                    numTasks.setDeadlineNum(numTasks.getTaskCount());

                }
                else if(task[0].equals("event")){
                    numTasks.setTaskCount(taskCounts+=1);
                    String taskItem= line.substring(6);
                    Event e = new Event(taskItem,"");
                    System.out.print("____________________________________________________________\n");
                    System.out.print("Got it. I've added this task: \n");
                    System.out.print("\t"+e.toString());
                    System.out.print( "Now you have "+numTasks.getTaskCount()+" tasks in the list.");
                    System.out.print("\n____________________________________________________________\n");
                    itemList[i] = taskItem;
                    numTasks.setEventNum(numTasks.getTaskCount());
                } else{
                    taskCounts = addItemList(itemList, line, numTasks, taskCounts, i);
                }

                line = in.nextLine();

                if (line.equals("bye")){
                    break;
                }
            }
        }
        showByeMessage();
    }
    //Three methods that are refactored for readability
    private static int addItemList(String[] itemList, String line, Duke numTasks, int taskCounts, int i) {
        itemList[i] = line;
        System.out.print("____________________________________________________________\n");
        System.out.print("added: " + line);
        System.out.print("\n____________________________________________________________\n");
        numTasks.setTaskCount(taskCounts +=1);
        return taskCounts;
    }

    private static void showByeMessage() {
        System.out.print("____________________________________________________________\n");
        System.out.print("Bye. Hope to see you again soon!\n");
        System.out.print("____________________________________________________________\n");
    }

    private static void showWelcomeMessage() {
        String logo = "____________________________________________________________\n"
                + "Hello! I'm Duke \n"
                + "What can I do for you? \n"
                +" _   _  ____  _     _     ____ \n" +
                "| |_| || ===|| |__ | |__ / () \\\n" +
                "|_| |_||____||____||____|\\____/\n"
                + "____________________________________________________________\n";
        System.out.println(logo);
    }

    /**
     * Getter and setter to get task number from done command and send that number to list command
     * Getter and setter for task count to show number of tasks that are entered
     * Getter and setter for the deadline,to do,event number for usage in updating the list
     */
    int taskNumber,taskCount;
    int todoNum, deadlineNum,eventNum;

    int getNumTasks() {

        return taskNumber;
    }

    void setNumTasks(int num) {

        taskNumber = num;
    }

    int getTodoNum() {

        return todoNum;
    }

    void setTodoNum(int n) {

        todoNum = n;
    }
    int getDeadlineNum() {
        return deadlineNum;
    }

    void setDeadlineNum(int d) {

        deadlineNum = d;
    }

    int getEventNum() {

        return eventNum;
    }

    void setEventNum(int e) {

        eventNum = e;
    }

    int getTaskCount() {


        return taskCount;
    }

    void setTaskCount(int t) {

        taskCount = t;
    }
}



