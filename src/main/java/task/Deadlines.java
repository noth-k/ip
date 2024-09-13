package task;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Represents a deadline task.
 * A deadline task has a description and a deadline date/time by which the task must be completed.
 */
public class Deadlines extends Task {
    private final LocalDateTime deadline;

    /**
     * Constructs a Deadlines task with the specified description and deadline.
     *
     * @param description The description of the task.
     * @param deadline    The deadline by which the task must be completed.
     */
    public Deadlines(String description, LocalDateTime deadline) {
        super(description + " (by: " + formatDate(deadline) + ")", TaskType.DEADLINE);
        this.deadline = deadline;
    }

    /**
     * Returns the task type of this task.
     *
     * @return A string representing the task type, which is "D" for deadline tasks.
     */
    @Override
    public String getTaskType() {
        return "D";
    }

    /**
     * Returns a string representation of the task suitable for saving to a file.
     *
     * @return A formatted string representing the task for file storage.
     */
    @Override
    public String toFileString() {
        int index = description.indexOf("(by:");
        return String.format("D | %d | %s | %s", isDone ? 1 : 0, description.substring(0, index).trim(), localDateTimeString(deadline));
    }
}