
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
    ArrayList<Contatto> rubricaArray;
    //---------

    Rubrica(String nome){
        this.nome = nome;
        this.rubricaArray = new ArrayList<>();
    }

    public static Rubrica rubrica = new Rubrica("rubrica"); //oggetto che rappresenta la rubrica
    public static final String FILE = "./rubrica.txt"; //file dove vengono salvati i contatti

    /**
     * Metodo che stampa tutti i contatti
     * 
     * @param void
     * @return void
     */
    public static void stampaContatti(){
        System.out.println(rubrica.nome.toUpperCase());
        for (int i = 0; i < rubrica.rubricaArray.size(); i++){
            Contatto contatto = rubrica.rubricaArray.get(i);
            System.out.println((i + 1) + ") " + contatto.nome + ": [" + contatto.numero + "]");
        }
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
    public static boolean leggi(){
        try{
            File file = new File(FILE);
            Scanner lettore = new Scanner(file);
            while (lettore.hasNextLine()){
                String nome = lettore.nextLine();
                String numero = lettore.nextLine();
                importaContatti(nome, numero);
            }
            lettore.close();
        } 
        catch (FileNotFoundException e){
            return false;
        }
        return true;
    }

    /**
     * Metodo che importa i contatti nella rubrica
     * 
     * @param String il nome del contatto
     * @param String il numero del contatto
     * @return void
     */
    public static void importaContatti(String nome, String numero){
        Contatto contatto = new Contatto(null, null); //creo l'oggetto del contatto
        contatto.nome = nome;
        contatto.numero = numero;
        rubrica.rubricaArray.add(contatto);
    }
}