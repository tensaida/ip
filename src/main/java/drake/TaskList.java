package drake;

import java.util.ArrayList;
import java.util.List;

import drake.tasks.Task;

/**
 * Represents a list of tasks.
 */
public class TaskList {

    private final List<Task> list;

    /**
     * Constructor. Loads the task list from a list of Tasks.
     *
     * @param list The initial task list.
     */
    public TaskList(List<Task> list) {
        this.list = list;
    }

    /**
     * Constructor. Initialises the task list with an empty list.
     */
    public TaskList() {
        list = new ArrayList<>();
    }

    /**
     * Checks if the given task number is valid.
     *
     * @param taskNumber The given task number.
     * @return Whether the task number is valid.
     */
    public boolean isValidTaskNumber(int taskNumber) {
        return taskNumber >= 1 && taskNumber <= list.size();
    }

    /**
     * Marks the task with the given task number as done.
     *
     * @param taskNumber The given task number.
     */
    public void markAsDone(int taskNumber) {
        list.get(taskNumber - 1).markAsDone();
    }

    /**
     * Gets the String representation of the task with the given task number.
     *
     * @param taskNumber The given task number.
     * @return The String representation of the requested task.
     */
    public String getTaskToString(int taskNumber) {
        return list.get(taskNumber - 1).toString();
    }

    /**
     * Marks the task with the given task number as not done.
     *
     * @param taskNumber The given task number.
     */
    public void markAsNotDone(int taskNumber) {
        list.get(taskNumber - 1).markAsNotDone();
    }

    /**
     * Removes the task with the given task number from the task list.
     *
     * @param taskNumber The given task number.
     */
    public void removeTask(int taskNumber) {
        list.remove(taskNumber - 1);
    }

    /**
     * Gets the String representation of the size of the task list in a sentence.
     *
     * @return A sentence with the size of the task list.
     */
    public String getSizeToString() {
        return "You now have " + list.size() + " tasks in the list";
    }

    /**
     * Adds the given task to the task list.
     *
     * @param task The given task.
     * @return The task added to the task list.
     */
    public Task addTask(Task task) {
        list.add(task);
        return task;
    }

    /**
     * Filters the task list and returns the tasks that match the given search keywords.
     * @param searchKeywords The given search keywords.
     * @return The tasks that match the given search keywords.
     */
    public TaskList filter(List<String> searchKeywords) {
        TaskList result = new TaskList(new ArrayList<>());

        for (Task task : list) {
            if (task.isMatch(searchKeywords)) {
                result.addTask(task);
            }
        }

        return result;
    }
}
