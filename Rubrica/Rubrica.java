
import java.io.File;
import java.io.FileNotFoundException;
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
    6) ricerca di un contatto per nome e numero di telefono
    7) modifica di un contatto
    8) rimozione di un contatto
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

    /**
     * Salva i contatti aggiunti su un altro file
     * 
     * @param void
     * @return true se il salvataggio e' andato a buon fine, altrimenti false
     */
    public static boolean salva(){
        try{
            FileWriter scrittura = new FileWriter(FILE);
            ArrayList<Contatto> arrayList = rubrica.rubricaArray;
            for (int i = 0; i < arrayList.size(); i++) {
                Contatto oggetto = arrayList.get(i);
                scrittura.write(oggetto.toString() + "\n");
            }
            scrittura.close();
        }
        catch (IOException e){
            return false;
        }
        return true;
    }  

    /**
     * Legge il contenuto del file
     * 
     * @param void
     * @return il testo letto, se non trova il file ritorna un errore
     */
    public static Contatto leggi(){
        try{
            File file = new File(FILE);
            Scanner lettore = new Scanner(file);
            while (lettore.hasNextLine()){
                Contatto contatto = new Contatto(null, null); //creo l'oggetto del contatto
                contatto.nome = lettore.nextLine();
                contatto.numero = lettore.nextLine();
            }
            lettore.close();
        } 
        catch (FileNotFoundException e){
            return null;
        }
        return ;
    }

    public static boolean importaContatti(){
        
        contatto.nome = Rubrica.inserisciString("Inserisci il nome del contatto");
        String numero = Rubrica.inserisciString("Inserisci il numero del contatto");
        if (isNumerico(numero)){
            contatto.numero = numero;
            //aggiungo il contatto alla rubrica
            Rubrica.rubrica.rubricaArray.add(contatto);
        }
        else{
            //ritorno "falso" se il numero non e' composto solo da numeri
            return false;
        }
        return true;
    }
}