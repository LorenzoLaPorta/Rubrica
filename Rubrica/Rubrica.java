
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/*
Lorenzo La Porta, 4°MCIF

In questo programma integro:
    1) creazione di una rubrica telefonica
    2) lettura e scrittura su file
    3) memorizzazione di nome e numero di telefono
    4) creazione di un contatto
    5) visualizzazione di tutti i contatti
    6) ricerca di un contattto per nome e numero di telefono
    7) modifica di un contatto
*/
public class Rubrica{
    //ATTRIBUTI
    String nome;
    ArrayList<Contatto> rubricaArray = new ArrayList<>();
    //---------

    Rubrica(String nome, ArrayList<Contatto> rubricaArray){
        this.nome = nome;
        this.rubricaArray = rubricaArray;
    }

    public static Scanner scanner = new Scanner(System.in); //scanner in grado di prendere input
    public static Rubrica rubrica = new Rubrica(null, null); //oggetto che rappresenta la rubrica
    public static final String FILE = "./rubrica.txt";
    
    /**
     * Metodo che prende input di tipo String
     * 
     * @param String il messaggio da stampare prima dell'input
     * @return l'input
     */
    public static String inserisciString(String messaggio){
        System.out.println(messaggio);
        return scanner.nextLine();
    }
    /**
     * Metodo che prende input di tipo int
     * 
     * @param String il messaggio da stampare prima dell'input
     * @return l'input
     */
    public static int inserisciInt(String messaggio){
        System.out.println(messaggio);
        int input = scanner.nextInt();
        scanner.nextLine();
        return input;
    }


    public static void salva(){
        try{
            FileWriter scrittura = new FileWriter(FILE);
            scrittura.write("Files in Java might be tricky, but it is fun enough!");
            scrittura.close();
        }
        catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        System.out.println("Successfully wrote to the file.");
    }  
}