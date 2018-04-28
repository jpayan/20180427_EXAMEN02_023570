package ConcreteCommands;

import Commands.Task;

public class BendMetal extends Task {
    public BendMetal(int id) {
        super(id);
        this.complexity = 4;
    }

    public void bendMetal() {
        System.out.println("Metal has been bent.");
        this.completeTask();
    }

    @Override
    public void execute() {
        this.bendMetal();
    }
}
