import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        String logo = "____________________________________________________________\n"
                + "Hello! I'm Duke \n"
                + "What can I do for you? \n"
                + "____________________________________________________________\n";
        System.out.println(logo);

        String line;
        Scanner in = new Scanner(System.in);
        line = in.nextLine();

        while(!line.equals("bye")){
            System.out.print("____________________________________________________________\n"+line);
            System.out.print("\n____________________________________________________________\n");
            line = in.nextLine();
        }
        System.out.print("____________________________________________________________\n");
        System.out.print("Bye. Hope to see you again soon!\n");
        System.out.print("____________________________________________________________\n");
        }
    }


