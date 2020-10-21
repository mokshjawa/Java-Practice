/*
Each task goes through three different stages:

L0 → L1 → L2

These stages are sequential, i.e. a task must follow the exact ordering. 

A task is only “complete” when it reaches the L2 stage and work is finished on the L2 stage

Note: 
- Each worker can only work on one task stage at a time (i.e  Task X L1 can only have 1 worker at one time)
- Each task stage can only have one worker working on it at a time.
- A worker can only work on a task if the worker has never worked on that task before. 
- For now, assume each worker takes 1 min. We may change this later.

Write a system that runs until all tasks are completed. Tasks should be greedily assigned to any available workers.

On every timestamp where activity happens: Print out the timestamp, print when a task is assigned to a worker, and print when that worker completes the assignment. At the end, print out the total number of time taken to complete the simulation. 

Do not worry about runtime, we are looking for correctness.


Sample input 1: 
tasks = [Task('A')]
workers = [Worker('X'), Worker('Y'), Worker('Z')]

Sample output 1:
0
Assigning X to Task A for L0
1
Worker X finished Task A for L0
Assigning Y to Task A for L1
2
Worker Y finished Task A for L1
Assigning Z to Task A for L2
3
Worker Z finished Task A for L2
Total time taken: 3 min


 */

import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class Solution {
  public static void main(String[] args) {
    List<Worker> workers = new ArrayList<>();
    List<Task> tasks = new ArrayList<>();
    
    tasks.add(new Task("A"));
    tasks.add(new Task("B"));
    tasks.add(new Task("C"));
    tasks.add(new Task("D"));
    workers.add(new Worker("X"));
    workers.add(new Worker("Y"));
    workers.add(new Worker("Z"));
    
    simulateTasks(workers, tasks);
  }
  
  enum TaskStage {
    NOT_STARTED, L0, L1, L2, COMPLETED
  }
  
  public static class Task {
    String taskName;
    Solution.TaskStage stage = Solution.TaskStage.NOT_STARTED;
    // if assignedWork = null, no one is currently assigned
    Worker assignedWorker = null;
    Set<Worker> pastWorkers = new HashSet<>();
    
    public Task(String name) {
      taskName = name;
    }
    
    public boolean isNotStarted() {
      return stage == Solution.TaskStage.NOT_STARTED;
    }
    
    public boolean isCompleted() {
      return stage == Solution.TaskStage.COMPLETED;
    }
    
    public void assignTask(Worker worker) {
      worker.currentTask = this;
      assignedWorker = worker;
      if (stage == Solution.TaskStage.NOT_STARTED) {
        stage = Solution.TaskStage.L0;
      }
      else if (stage == Solution.TaskStage.L0) {
        stage = Solution.TaskStage.L1;
      }
      else if (stage == Solution.TaskStage.L1) {
        stage = Solution.TaskStage.L2;
      }
      else if (stage == Solution.TaskStage.L2) {
        stage = Solution.TaskStage.COMPLETED;
      }
      
      System.out.println("Assigning " + worker.workerName + " to Task " + taskName + " for " + stage.toString());
    }
  }
  
  static class Worker {
    String workerName;
    // if currentNull = null, no task is currently assigned
    Solution.Task currentTask;
    
    public Worker(String name) {
      workerName = name;
    }
    
    public boolean isAvailable() {
      return currentTask == null;
    }
  }
  
  public static void simulateTasks(List<Worker> workers, List<Task> tasks) {
    List<Task> todo = new ArrayList<Task>(tasks);
    int time = 0;
    
    while (!todo.isEmpty()) {
      System.out.println(time);
      
      // finishing tasks
      for (Iterator<Task> itr = todo.iterator(); itr.hasNext();) {
        Task task = itr.next();
        
        if (task.stage == Solution.TaskStage.L2) {
          // last stage
          System.out.println("Worker " + task.assignedWorker.workerName + " finished Task " + task.taskName + " for " + task.stage.toString());
          task.stage = Solution.TaskStage.COMPLETED;
          
          task.assignedWorker.currentTask = null;
          task.assignedWorker = null;
          itr.remove();
          if (!itr.hasNext()) {
            time--;
            break;
          }
        }
        else {
          // any other stage or not assigned
          if (!task.isNotStarted() && task.assignedWorker != null) {
            // task has been started
            System.out.println("Worker " + task.assignedWorker.workerName + " finished Task " + task.taskName + " for " + task.stage.toString());
            task.pastWorkers.add(task.assignedWorker);
            task.assignedWorker.currentTask = null;
            task.assignedWorker = null;
          }
        }
      }
      
      // assigning tasks
      for (Iterator<Task> itr = todo.iterator(); itr.hasNext();) {
        Task task = itr.next();
        
        for (Worker worker : workers) {
            if (!task.pastWorkers.contains(worker) && worker.isAvailable()) {
              // assign task to worker
              task.assignTask(worker);
              break;
            }
        }
        
      }
      
      time++;
    }
    
    System.out.println("Total time taken: " + time + " min");

    return;
  }
}
