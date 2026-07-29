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
			String commandPart[] = command.split(" ",2);
			String commandName = commandPart[0];
			String arguments;
			if (commandPart.length > 1) {
    				arguments = commandPart[1];
			} else {
    				arguments = "";
			}
			if (commandName.equals("exit")) {
				break; // Forces exit of the while loop
			} else if (commandName.equals("date")){
				output = LocalDate.now().toString();
			} else if(commandName.equals("time")){
				output = Instant.now().toString();
			} else if(command.equals("datetime")){
				String dateTime = LocalDateTime.now().toString();
				output = dateTime;
			} else if(commandName.equals("useraccount")){
				String name =  System.getProperty("user.name");
				output = name;
			} else if(commandName.equals("userhome")){
				String userHome = System.getProperty("user.home");
				output = userHome;
			} else if (commandName.equals("os")){
				String os = System.getProperty("os.name");
				String version = System.getProperty("os.version");
				output = os + " (" + version + ")";
			} else if (commandName.equals("printenv")){
				if(arguments != ""){
				String env = System.getenv(arguments);
				if(env != null){
					output = env;
				} else {
					output= "";
				}
			} else {
				output = arguments;
			}
			} else if(commandName.equals("echo")){
				output = arguments;
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



