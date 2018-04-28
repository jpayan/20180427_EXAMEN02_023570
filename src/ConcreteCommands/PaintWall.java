package ConcreteCommands;

import Commands.Task;

public class PaintWall extends Task {
    public PaintWall(int id) {
        super(id);
        this.complexity = 2;
    }

    public void paintWall() {
        System.out.println("Wall has been painted.");
        this.completeTask();
    }

    @Override
    public void execute() {
        this.paintWall();
    }
}