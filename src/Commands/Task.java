package Commands;

import Enums.TaskState;

public abstract class Task implements Command {
    public int id;
    public int complexity;
    public TaskState state;

    public Task(int id) {
        this.id = id;
        this.state = TaskState.UNCOMPLETE;
    }

    public void completeTask() {
        this.state = TaskState.COMPLETE;
    }

    public int getComplexity() {
        return complexity;
    }

    public int getId() {
        return id;
    }
}
