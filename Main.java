import java.util.*;

public class Main {
	static TaskManager tm = new TaskManager();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		try {
			mainLoop: while(true) {
				System.out.println("--------------------------------------------------- \n"   //Main Menu
						+ "Enter a option:");
				System.out.println("1. Display the tasks \n"
						+ "2. Add a task \n"
						+ "3. Complete a task \n"
						+ "4. Exit \n"
						+ "---------------------------------------------------");
				int option = sc.nextInt();
				switch(option) {
				case 1:
					displayTasks();
					break;
					
				case 2:
					System.out.println("Enter the task name:");
					sc.nextLine();
					String titleToAdd = sc.nextLine();
					
					Task taskToAdd= new Task(titleToAdd, false);
					
					tm.addTask(taskToAdd);
					break;
					
				case 3:
					System.out.println("Enter the task name:");
					sc.nextLine();
					String titleToRemove = sc.nextLine();
					
					System.out.println(tm.completeTask(titleToRemove));
					break;
					
				case 4:
					System.out.println("\n\nTHANK YOU FOR USING TASK MANAGEMENT APPLICATION :D");
					break mainLoop;
					
				default:
					System.out.println("Please enter a valid response!");
				}
			}
			
		} catch(InputMismatchException e) {
			System.out.println("Invalid Input. Please enter a valid response!");		//catching exception if the input is other than a number
		}
	}
	
	static void displayTasks() {
		System.out.println("\n***************************");
		System.out.print("Name           Status \n");					//column names
		List<Task> tasks = tm.getTasks();
		for(Task t1 : tasks) {
			System.out.print(t1.getTitle());
			for(int i=0; i<15-t1.getTitle().length(); i++) {			//calculating the space needed by subtracting the length of the name from '15'
				System.out.print(" ");									//for good formatting and better readability
			}
			
			if(!t1.getIsCompleted()) {									//prints whether the task is completed or still running
				System.out.print("Running");
			} else {
				System.out.print("Completed");
			}
			
			System.out.println();
		}
		System.out.println("***************************");
	}
}