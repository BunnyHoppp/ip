package potong.command;

import potong.Storage;
import potong.TaskList;
import potong.Ui;
import potong.exceptions.IllegalInputPotongException;
import potong.task.DeadlineTask;
import potong.task.EventTask;
import potong.task.ToDoTask;

/**
 * Represents the add command for adding tasks into the list of tasks.
 */
public class AddCommand extends Command {

    /**
     * Represents the different types of add commands present. (3 types: To do tasks, Deadline tasks, Event tasks)
     */
    public enum Type {
        TODO,
        DEADLINE,
        EVENT
    }

    private final Type type;
    private String task;
    private String deadline;
    private String eventStart;
    private String eventEnd;

    /**
     * Initialises an add command, to be executed later.
     *
     * @param command Details of the command. (Task description, deadlines, and durations)
     * @param type Type of the command. (To do, deadline, event)
     */
    public AddCommand(String command, Type type) {
        super(command);
        this.type = type;
        switch (type) {
        case TODO -> this.task = command;
        case DEADLINE -> {
            String[] arr = command.split("/");
            this.task = arr[0].strip();
            this.deadline = arr[1].substring(3);
        }
        case EVENT -> {
            String[] arr = command.split("/");
            this.task = arr[0].strip();
            this.eventStart = arr[1].substring(5).strip();
            this.eventEnd = arr[2].substring(3).strip();
        }
        default -> {
            break;
        }
        }
    }

    /**
     * Executes the add command based on the type of add.
     *
     * @param tasks List of tasks in the program.
     * @param storage Storage class for loading and saving data.
     * @param ui Ui class for printing outputs.
     * @return String output.
     */
    @Override
    public String execute(TaskList tasks, Storage storage, Ui ui) {
        try {
            assert tasks != null;
            switch (this.type) {
            case TODO -> {
                return tasks.addTask(new ToDoTask(this.task));
            }
            case DEADLINE -> {
                return tasks.addTask(new DeadlineTask(this.task, this.deadline));
            }
            case EVENT -> {
                return tasks.addTask(new EventTask(this.task, this.eventStart, this.eventEnd));
            }
            default -> {
                return "";
            }
            }
        } catch (IllegalInputPotongException e) {
            return e.getMessage();
        }
    }
}
