package model;

//TODO 01: Setze das Interface um. Finde heraus, was der Suchschlüssel eines jeden Worker-Objekts ist.
public class Worker implements ComparableContent<Worker>{
    private String name;
    private Queue<Task> allTasks;
    private int competence;

    public Worker(String name){
        this.name = name;
        allTasks = new Queue<>();
        competence = (int) (Math.random() * 15) + 5;
    }

    public String getName(){
        return name;
    }

    public void addTask(int id){
        allTasks.enqueue(new Task(id));
    }

    public Task completeTask(){
        Task t = allTasks.front();
        allTasks.dequeue();
        return t;
    }

    public boolean hasTask(){
        return !allTasks.isEmpty();
    }

    public int getCompetence() {
        return competence;
    }

    public void setCompetence(int competence) {
        this.competence = competence;
    }

    public int getCurrentTaskgrade(){
        if(!allTasks.isEmpty()) {
            return allTasks.front().getTaskGrade();
        }else{
            return 0;
        }
    }

    public int getWorkLoad(){
        int result = 0;
        Queue<Task> help = new Queue<>();
        while(!allTasks.isEmpty()){
            help.enqueue(allTasks.front());
            result += allTasks.front().getTaskGrade();
            allTasks.dequeue();
        }
        while(!help.isEmpty()){
            allTasks.enqueue(help.front());
            help.dequeue();
        }
        return result;
    }

    @Override
    public boolean isGreater(Worker pContent) {
        if(pContent.getName().compareTo(name) < 0){
            return true;
        }
        return false;
    }

    @Override
    public boolean isEqual(Worker pContent) {
        if(pContent.getName().equals(name)){
            return true;
        }
        return false;
    }

    @Override
    public boolean isLess(Worker pContent) {
        if(pContent.getName().compareTo(name) > 0){
            return true;
        }
        return false;
    }
}
