package control;

public class MainController {

    private WorkerHandler workerHandler;

    public MainController(){
        workerHandler = new WorkerHandler();
        createSomeTestWorkerAndTasks();
    }

    private void createSomeTestWorkerAndTasks(){
        workerHandler.addTaskAndWorker("Franz",1); //
        workerHandler.addTaskAndWorker("Albert",2); //
        workerHandler.addTaskAndWorker("Kalle",3);//
        workerHandler.addTaskAndWorker("Franz",4);//
        workerHandler.addTaskAndWorker("Timmy",5);
        workerHandler.addTaskAndWorker("Claus",6);
        workerHandler.addTaskAndWorker("Albert",7); //
        workerHandler.addTaskAndWorker("Timmy",8);
        workerHandler.addTaskAndWorker("Björn",9);
        workerHandler.addTaskAndWorker("Sönke",10);
        workerHandler.addTaskAndWorker("Sönke",11);
        workerHandler.addTaskAndWorker("Sönke",12);
        workerHandler.addTaskAndWorker("Ulf",13);
        workerHandler.addTaskAndWorker("Kalle",14);//
        workerHandler.addTaskAndWorker("Franz",15);//
        workerHandler.addTaskAndWorker("Claus",16);
        workerHandler.addTaskAndWorker("Zylle",17);
        workerHandler.addTaskAndWorker("Timmy",18);
        workerHandler.addTaskAndWorker("Zylle",19);
        workerHandler.addTaskAndWorker("Albert",20);//
        workerHandler.addTaskAndWorker("Ulf",21);
        workerHandler.addTaskAndWorker("Claus",22);
        workerHandler.addTaskAndWorker("Claus",23);

        //TODO 02: Stellen Sie den resultierenden binären Suchbaum handschriftlich angemessen dar, falls dieser die Arbeiter lexikographisch einfügt. In ihrem Baum müssen die IDs der Aufträge ebenfalls dargestellt werden. Überlegen Sie sich hierzu eine Darstellungsweise.
    }

    public void releaseAllTasks(){
        workerHandler.releaseAllTasksAndShowWorker();
    }
}
