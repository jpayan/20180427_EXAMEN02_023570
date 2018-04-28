package ConcreteCommands;

import Commands.Task;

public class ChargeBattery extends Task {
    public ChargeBattery(int id) {
        super(id);
        this.complexity = 1;
    }

    public void chargeBattery() {
        System.out.println("Battery has been charged.");
        this.completeTask();
    }

    @Override
    public void execute() {
        this.chargeBattery();
    }
}