package ConcreteCommands;

import Commands.Task;

public class EatCereal extends Task {
    public EatCereal(int id) {
        super(id);
        this.complexity = 1;
    }

    public void eatCereal() {
        System.out.println("Cereal has been eaten.");
        this.completeTask();
    }

    @Override
    public void execute() {
        this.eatCereal();
    }
}