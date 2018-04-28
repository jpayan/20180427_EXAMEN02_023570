package Invoker;

import Client.Client;
import Commands.Task;
import Enums.TaskState;

import java.util.ArrayList;
import java.util.UUID;
import java.util.concurrent.locks.ReentrantLock;

public class Robot {
    public String id;
    public int capacity;
    public int efficiency;
    public ArrayList<Task> tasks;

    private ReentrantLock lock;

    public Robot(int capacity, int efficiency) {
        this.id = UUID.randomUUID().toString();
        this.capacity = capacity;
        this.efficiency = efficiency;
        this.lock = new ReentrantLock();
        this.tasks = new ArrayList<>();
    }

    public void takeTask() {
        this.tasks.add(Client.tasks.stream().filter(task -> task.state == TaskState.UNCOMPLETE).findFirst().get());
        System.out.println(String.format("Robot %s has taken a task.", this.id));
    }

    public void takeTasks() {
        while(this.tasks.size() < this.capacity) {
            lock.lock();
            try {
                this.takeTask();
            } finally {
                lock.unlock();
            }
        }
    }

    public void removeTask(Task task) {
        this.tasks.remove(task);
    }

    public void doTask(Task task) throws InterruptedException {
        Thread.sleep(efficiency * task.getComplexity());
        task.execute();
        this.log(task);
        this.removeTask(task);
    }

    public void doTasks() {
        while(Client.completedTasks < Client.tasks.size()) {
            this.takeTasks();
            if (this.tasks.size() > 0) {
                for (Task task : this.tasks) {
                    new Thread(() -> {
                        try {
                            doTask(task);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }).start();
                }
            }
        }
    }

    public void log(Task task) {
        System.out.println(String.format("Logged Task with id: %d", task.getId()));
    }
}
