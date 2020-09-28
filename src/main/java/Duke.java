//Matric Number: A0200273X

import java.util.Scanner;

public class Duke {

    protected final static int SIZE =100;
    //Main Method of the program to run the commands
    public static void main(String[] args) {

        Ui.printLines();
        Ui.showWelcomeMessage();

        String[] itemList = new String[SIZE];
        String line;
        Scanner in = new Scanner(System.in);
        line = in.nextLine();
        Duke numTasks = new Duke();
        int taskCounts = 0;

        while (!line.equals("bye")) {
            for (int i = 0; i < SIZE; i++) {

                String[] doneSide = line.split(" ");
                String[] task = line.split(" ");

                if (line.equals("list")) {

                    Ui.printLines();
                    System.out.print("Here are the tasks in your list:\n");
                    Ui.printLines();

                    for(int j=0;j<i;j++) {

                        Parser.ListCommand(itemList, numTasks, j);
                    }
                    i -= 1;

                    Ui.printLines();

                } else if (doneSide[0].equals("done")) {

                    Parser.DoneCommand(itemList, numTasks, itemList[i], doneSide[1]);

                } else if (task[0].equals("todo")) {

                    if (!line.substring(4).equals(" ") && !line.substring(3).equals("o")) {

                        taskCounts = TaskList.TodoCommand(itemList, line, numTasks, taskCounts, i);

                    } else {

                        i = Ui.TodoErrorMessage(i);

                    }
                } else if (task[0].equals("deadline")) {

                    if (!line.substring(8).equals(" ") && !line.substring(7).equals("e")) {

                        taskCounts = TaskList.DeadlineCommand(itemList, line, numTasks, taskCounts, i);

                    } else {

                        i = Ui.DeadlineErrorMessage(i);

                    }
                } else if (task[0].equals("event")) {

                    if (!line.substring(5).equals(" ") && !line.substring(4).equals("t")) {

                        taskCounts = TaskList.EventCommand(itemList, line, numTasks, taskCounts, i);


                    } else {

                        i = Ui.EventErrorMessage(i);

                    }
                } else if (task[0].equals("delete")) {

                    if (!line.substring(6).equals(" ") && !line.substring(5).equals("e")) {

                        taskCounts = TaskList.DeleteCommand(itemList, line, numTasks, taskCounts, itemList[i]);

                    } else {

                        i = Ui.DeleteErrorMessage(i);

                    }

                } else {

                    i = Ui.ErrorMessage(i);

                }

                line = in.nextLine();

                if (line.equals("bye")) {

                    break;

                }
            }
        }
        Ui.showByeMessage();
    }
    /**
     * Getter and setter to get task number from done command and send that number to list command
     * Getter and setter for task count to show number of tasks that are entered
     * Getter and setter for the deadline,to do,event number for usage in updating the list
     */
    int taskNumber, taskCount;
    int todoNum, deadlineNum, eventNum;

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