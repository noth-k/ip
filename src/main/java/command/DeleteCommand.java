package command;

import exceptions.BuddyException;
import storage.Storage;
import task.Task;
import task.TaskList;
import ui.Ui;

/**
 * Represents a command to delete a task from the task list.
 */
public class DeleteCommand extends Command {

    private final int taskIndex;

    /**
     * Constructs a DeleteCommand with the specified index of the task to be deleted.
     *
     * @param taskIndex The index of the task to be deleted.
     */
    public DeleteCommand(int taskIndex) {
        this.taskIndex = taskIndex;
    }

    /**
     * Executes the delete command to remove a task from the task list.
     *
     * @param tasks   The TaskList object containing the current list of tasks.
     * @param ui      The Ui object for interacting with the user.
     * @param storage The Storage object for saving tasks to the storage file.
     * @throws BuddyException If the task index is invalid (i.e., no task exists at the given index).
     */
    @Override
    public String execute(TaskList tasks, Ui ui, Storage storage) throws BuddyException {

        Task t = tasks.getTasks().get(taskIndex);
        tasks.deleteTask(taskIndex);
        System.out.println(taskIndex);
        storage.save(tasks.getTasks());
        return ui.displayDeleteTask(t, tasks);
    }

    /**
     * Indicates whether this command should cause the program to exit.
     *
     * @return false, as the delete command does not cause the program to exit.
     */
    @Override
    public boolean isExit() {
        return false;
    }
}