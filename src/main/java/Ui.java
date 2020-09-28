public class Ui {
    //Method to print lines for user interfaces
    static void printLines() {

        System.out.print("____________________________________________________________\n");

    }
    //Method to show a Welcome message in the beginning of the app
    static void showWelcomeMessage() {

        Storage.writeFile(Storage.Dir,"\n");
        System.out.print("Tasks saved previously: \n");
        Storage.retrieveFile(Storage.Dir);
        String logo = "____________________________________________________________\n"
                + "Hello! I'm Duke \n"
                + "What can I do for you? \n"
                + " _   _  ____  _     _     ____ \n" +
                "| |_| || ===|| |__ | |__ / () \\\n" +
                "|_| |_||____||____||____|\\____/\n"
                + "____________________________________________________________\n";
        System.out.println(logo);

    }
    //Method to display goodbye message when bye command is entered
    static void showByeMessage() {

        System.out.print("____________________________________________________________\n");
        System.out.print("Bye. Hope to see you again soon!\n");
        System.out.print("____________________________________________________________\n");

    }
    //Method to display an error message when task is not entered after to do command
    public static int TodoErrorMessage(int i) {
        try {

            i -= 1;
            throw new DukeException();

        } catch (DukeException e) {

            printLines();
            System.out.print("☹ OOPS!!! The description of a todo cannot be empty.\n");
            printLines();

        }
        return i;
    }
    //Method to display an error message when task is not entered after deadline command
    public static int DeadlineErrorMessage(int i) {
        try {

            i -= 1;
            throw new DukeException();

        } catch (DukeException e) {

            printLines();
            System.out.print("☹ OOPS!!! The description of a deadline cannot be empty.\n");
            printLines();
        }
        return i;
    }
    //Method to display an error message when task is not entered after event command
    public static int EventErrorMessage(int i) {
        try {

            i -= 1;
            throw new DukeException();
        } catch (DukeException e) {

            printLines();
            System.out.print("☹ OOPS!!! The description of a event cannot be empty.\n");
            printLines();

        }
        return i;
    }
    //Method to display an error message when index of the task to be deleted after delete command is empty
    public static int DeleteErrorMessage(int i) {
        try {

            i -= 1;
            throw new DukeException();

        } catch (DukeException e) {

            printLines();
            System.out.print("☹ OOPS!!! The delete number command cannot be empty.\n");
            printLines();


        }
        return i;
    }
    //Method to display an error message when other command not recognised is entered
    public static int ErrorMessage(int i) {
        try {

            i -= 1;
            throw new DukeException();

        } catch (DukeException n) {

            printLines();
            System.out.print("☹ OOPS!!! I'm sorry, but I don't know what that means :-(\n");
            printLines();

        }
        return i;
    }
}
