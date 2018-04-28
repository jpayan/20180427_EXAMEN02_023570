package ConcreteCommands;

import Commands.Task;

public class CutWood extends Task {
    public CutWood(int id) {
        super(id);
        this.complexity = 2;
    }

    public void cutWood() {
        System.out.println("Wood has ben cut.");
        this.completeTask();
    }

    @Override
    public void execute() {
        this.cutWood();
    }
}
