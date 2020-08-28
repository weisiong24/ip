//Matric Number: A0200273x
import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        String logo = "____________________________________________________________\n"
                + "Hello! I'm Duke \n"
                + "What can I do for you? \n"
                +" _   _  ____  _     _     ____ \n" +
                "| |_| || ===|| |__ | |__ / () \\\n" +
                "|_| |_||____||____||____|\\____/\n"
                + "____________________________________________________________\n";
        System.out.println(logo);
        //String Array of size 100 created to store item list
        String[] itemList = new String[100];
        String line;
        Scanner in = new Scanner(System.in);
        line = in.nextLine();

        Duke numTasks =new Duke();
        /**
         * When user enter list it will show a list of input saved
         * When user enter done it will mark the task as done into the list
         * It will run continuously till bye command is given
         */
        while(!line.equals("bye")){

            for(int i=0;i<100;i++) {
                String[] doneSide = line.split(" ");

                if(line.equals("list")) {
                    System.out.print("____________________________________________________________\n");
                    System.out.print("Here are the tasks in your list:\n");
                    System.out.print("____________________________________________________________\n");

                    for(int j=0;j<i;j++) {
                        if(numTasks.getNumTasks()==j+1){
                        Task t = new Task(itemList[j]);
                        t.markAsDone();
                        System.out.print(j + 1 + "."+"["+t.getStatusIcon() +"] "+ itemList[j] + "\n");
                        } else{
                        Task t = new Task(itemList[j]);
                        t.marknotDone();
                        System.out.print(j + 1 + "."+"["+t.getStatusIcon()+"] " + itemList[j] + "\n");
                            i-=j;
                        }
                    }

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
                } else {
                    itemList[i] = line;
                    System.out.print("____________________________________________________________\n");
                    System.out.print("added: " + line);
                    System.out.print("\n____________________________________________________________\n");
                }
                line = in.nextLine();
                if (line.equals("bye")){
                    break;
                }
            }
        }
        System.out.print("____________________________________________________________\n");
        System.out.print("Bye. Hope to see you again soon!\n");
        System.out.print("____________________________________________________________\n");
    }
    //Getter and setter to get task number from done command and send that number to list command
    int taskNumber;

    int getNumTasks() {
        return taskNumber;
    }

    void setNumTasks(int num) {
        taskNumber = num;
    }
}



