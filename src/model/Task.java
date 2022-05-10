package model;

public class Task {
    private int id;
    private int taskGrade;

    public Task(int id){
        this.id = id;
        taskGrade = (int) (Math.random() * 480) + 20;
    }

    public int getID(){
        return id;
    }

    public int getTaskGrade() {
        return taskGrade;
    }

    public void setTaskGrade(int taskGrade) {
        this.taskGrade = taskGrade;
    }
}
