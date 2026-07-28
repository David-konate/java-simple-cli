import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalDateTime; 
import java.time.format.DateTimeFormatter;
import java.time.Instant;

public class Cli {

    // The main method is the entry point of the program. Rules regarding the main method:
    //     - public: so the JVM can access it from "outside"
    //     - static: so it can be called without creating an object (class scoped)
    //     - void: it doesn't return a value (aka procedure)
    //     - main: the required method name
    //     - String[] args: so it can receive command-line arguments
    public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in); // Listen to the standard input (console)
		System.out.print("> "); // Prompt
		while (true) { // Infinite loop
			String command = scanner.nextLine(); // Get input from console as a string
			String output = ""; // A variable named output of type String
			String commandPart[] = command.split(" ");
			if (command.equals("exit")) {
				break; // Forces exit of the while loop
			} else if (command.equals("date")){
				output = LocalDate.now().toString();
			} else if(command.equals("time")){
				output = Instant.now().toString();
			} else if(command.equals("datetime")){
				String dateTime = LocalDateTime.now().toString();
				output = dateTime;
			} else if(command.equals("useraccount")){
				String name =  System.getProperty("user.name");
				output = name;
			} else if(command.equals("userhome")){
				String userHome = System.getProperty("user.home");
				output = userHome;
			} else if (command.equals("os")){
				String os = System.getProperty("os.name");
				String version = System.getProperty("sun.arch.data.model");
				output = os + " (" + version + ")";
			} else if (commandPart[0].equals("printenv")){
				if(commandPart.length > 1){
				String env = System.getenv(command.replace("printenv ",""));
				output = env;
				} else {
					output = "";
				}
			} else if(commandPart[0].equals("echo")){
				output = command.replace ("echo","");
			}
			 else {
				// String concatenation
				output = "Command '" + command + "' not found.";
			}
			System.out.println(output); // Print with new line (ln)
			System.out.print("> "); // Prompt
		}
		scanner.close(); // Best practice, always close a stream when no more needed
		System.out.println("Bye!");
    }

}



