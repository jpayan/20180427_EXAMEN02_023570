package Factory;

import Commands.Task;
import ConcreteCommands.CutWood;
import Enums.RobotType;
import Invoker.Robot;

public class RobotFactory {

    public Robot makeRobot(RobotType robotType) {
        switch (robotType) {
            case SMALL:
                return new Robot(1, 150);
            case MEDIUM:
                return new Robot(2, 100);
            case LARGE:
                return new Robot(4, 50);
            default:
                return new Robot(1, 150);
        }
    }
}
