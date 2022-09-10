package drake.commands;

import drake.DrakeException;
import drake.Storage;
import drake.TaskList;
import drake.Ui;
import drake.tasks.Task;
import drake.tasks.Todo;

import java.io.IOException;

public class TodoCommand extends CreateTaskCommand {

    public TodoCommand(String fullInput) {
        super(fullInput);
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DrakeException, IOException {
        ui.printLine("I've added this task:");
        Task addedTask = tasks.addTask(new Todo(description));
        ui.printLine(addedTask);
        storage.addTask(addedTask);
        super.execute(tasks, ui, storage);
    }
}