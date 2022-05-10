package control;

import model.BinarySearchTree;
import model.Task;
import model.Worker;

import java.util.Locale;
import java.util.Random;


public class WorkerHandler {

    private BinarySearchTree<Worker> allWorker;
    Random random;
    String[] alphabet;

    public WorkerHandler(){
        allWorker = new BinarySearchTree<>();
        random = new Random();
        alphabet = new String[26];
        alphabet[0] = "a";
        alphabet[1] = "b";
        alphabet[2] = "c";
        alphabet[3] = "d";
        alphabet[4] = "e";
        alphabet[5] = "f";
        alphabet[6] = "g";
        alphabet[7] = "H";
        alphabet[8] = "i";
        alphabet[9] = "j";
        alphabet[10] = "k";
        alphabet[11] = "l";
        alphabet[12] = "m";
        alphabet[13] = "n";
        alphabet[14] = "o";
        alphabet[15] = "p";
        alphabet[16] = "q";
        alphabet[17] = "r";
        alphabet[18] = "s";
        alphabet[19] = "t";
        alphabet[20] = "u";
        alphabet[21] = "v";
        alphabet[22] = "w";
        alphabet[23] = "x";
        alphabet[24] = "y";
        alphabet[25] = "z";
    }

    /**
     * Diese Methode fügt einen Auftrag mit entsprechender id zum entsprechenden Arbeiter in die Warteschlange hinzu.
     * Falls der Arbeiter nicht existiert, so wird er zunächst erstellt und dem Baum hinzugefügt.
     * @param name
     * @param id
     */
    public void addTaskAndWorker(String name, int id){
        //TODO 03: Setzen Sie die Methode gemäß obiger Beschreibung um.
        Worker worker = new Worker(name);
        if(allWorker.search(worker) == null){
            worker.addTask(id);
            allWorker.insert(worker);
        }else{
            allWorker.search(worker).addTask(id);
        }
    }

    /**
     * Diese Methode entfernt alle Arbeitsaufträge aus dem Baum.
     * Dabei werden alle Arbeitsaufträge sortiert nach ihrem Arbeiter als großer, vollständiger String in der Systemkonsole ausgegeben.
     * Nach Aufruf dieser Methode befinden sich alle Arbeiter immernoch im Baum, jedoch hat keiner mehr einen Arbeitsauftrag.
     */
    public void releaseAllTasksAndShowWorker(){
        addTaskAndWorker(200);
        wholeTaskAmount();
        wholeWorkerCompetence();
        System.out.println(releaseAllTasksAndShowWorker(allWorker));
        workHard();
    }

    public void addTaskAndWorker(int number){
        for (int i = 0; i < number;i++){
            String name = "";
            for (int j = 0; j < 5;j++){
                if(j == 0){
                    name += alphabet[random.nextInt(25)].toUpperCase();
                }
                name += alphabet[random.nextInt(25)];
            }
            addTaskAndWorker(name,i+24);
        }
    }

    /**
     * Rekursive Methode, die am Ende einen String liefert. Dieser hat folgenden Aufbau: 1.Name:1.id-2.id-3.id#2.Name:1.id-2.id#3.Name:1.id etc.
     * Die Namen sind alphabetisch sortiert.
     * Nach Aufruf dieser Methode befindet sich kein Auftrag mehr im Baum. Die Arbeiter werden nicht gelöscht.
     * @param tree
     * @return String bestehend aus Arbeiternamen und deren IDs.
     */
    private String releaseAllTasksAndShowWorker(BinarySearchTree<Worker> tree){
        String output = "";
        //TODO 04a: Stellen Sie handschriftlich die gewünschte Ausgabe gemäß des vorhanden Baums dar (siehe MainController ab Zeile 13). Hierbei genügen die ersten drei Arbeiter und ihre IDs, die von dieser Methode ausgegeben werden.
        //TODO 04b: Setzen Sie anschließend diese Methode gemäß obiger Beschreibung um.
        if(!tree.isEmpty()) {
            output = tree.getContent().getName() + ":";
            while (tree.getContent().hasTask()) {
                output = output + tree.getContent().completeTask().getID() + ".";
            }
            output = output + "\n";

            return releaseAllTasksAndShowWorker(tree.getLeftTree()) + output + releaseAllTasksAndShowWorker(tree.getRightTree());
        }
        return "";
    }


    public void wholeTaskAmount(){
        System.out.println("Gesamter Arbeitsaufwandt: " + wholeTaskAmount(allWorker));
    }

    public int wholeTaskAmount(BinarySearchTree<Worker> worker){
        if(!worker.isEmpty()){
            return worker.getContent().getWorkLoad() + wholeTaskAmount(worker.getLeftTree()) + wholeTaskAmount(worker.getRightTree());
        }
        return 0;
    }

    public void wholeWorkerCompetence(){
        System.out.println("Gesamte Kompetenz der Arbeiter: " + wholeWorkerCompetence(allWorker));
    }

    public int wholeWorkerCompetence(BinarySearchTree<Worker> worker){
        if(!worker.isEmpty()){
            return worker.getContent().getCompetence() + wholeWorkerCompetence(worker.getLeftTree()) + wholeWorkerCompetence(worker.getRightTree());
        }
        return 0;
    }

    public void workHard(){
        System.out.println("Fertige Aufgaben: " + workHard(allWorker));

    }

    public String workHard(BinarySearchTree<Worker> worker){
        String result = "";
        if(!worker.isEmpty()){
            if(worker.getContent().getCompetence() > worker.getContent().getCurrentTaskgrade() && worker.getContent().hasTask()){

                worker.getContent().setCompetence(worker.getContent().getCompetence()-worker.getContent().getCurrentTaskgrade());
                result += "" + worker.getContent().completeTask().getID();
            }
            return result + ", " + workHard(worker.getLeftTree()) + workHard(worker.getRightTree());
        }
        return "";
    }
}
