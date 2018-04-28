package Client;

import Commands.Task;
import ConcreteCommands.CutWood;
import Enums.RobotType;
import Factory.RobotFactory;
import Invoker.Robot;

import java.util.ArrayList;

public class Client {
    public static ArrayList<Task> tasks = new ArrayList<>();
    public static int completedTasks = 0;

    public static void main(String[] args)  {
        RobotFactory robotFactory = new RobotFactory();
        ArrayList<Robot> robots = new ArrayList<Robot>(){{
            add(robotFactory.makeRobot(RobotType.SMALL));
            add(robotFactory.makeRobot(RobotType.MEDIUM));
            add(robotFactory.makeRobot(RobotType.LARGE));
        }};

        for(int i = 0; i < 20; i++) {
            tasks.add(new CutWood(i));
        }

        for (Robot robot : robots) {
            new Thread(robot::doTasks).start();
        }
    }

    public static void incrementCompletedTasks() {
        completedTasks++;
    }
}
