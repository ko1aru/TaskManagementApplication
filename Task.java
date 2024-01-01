import java.util.*;

class Task {
	private String title;
	private Boolean isCompleted;
	
	public Task(String title, Boolean isCompleted) {
		this.title = title;
		this.isCompleted = isCompleted;
	}

	public String getTitle() {
		return title;
	}

	public Boolean getIsCompleted() {
		return isCompleted;
	}
	
	public void completeTask() {
		this.isCompleted = true;
	}
}

class TaskManager {
	private List<Task> tasks;
	
	public TaskManager() {										//initializing List
		this.tasks = new ArrayList<>();
	}
	
	public void addTask(Task task) {							//method to add a task to the list
		this.tasks.add(task);
		System.out.println("Task added successfully. \n");
	}
	
	public String completeTask(String title) {					//method to complete a task
		for(Task t : tasks) {
			if(title.equals(t.getTitle())) {					//checks the title of all the tasks in the list
				if(!t.getIsCompleted()) {						//checks if the task is already completed
					t.completeTask();							//completes the task if it is not completed
					return "Task completed.";
				} else {
					return "Task already completed.";			//returns this if task is already completed
				}
			}	
		}
		return "Task not found!";								//return this when the task's title is not found in the list
	}

	public List<Task> getTasks() {
		return tasks;
	}
}