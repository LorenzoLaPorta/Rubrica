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
public class Main{

    public static Scanner scanner = new Scanner(System.in); //scanner in grado di prendere input

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
     * Metodo che stampa il menu
     * @param void
     * @return void
     */
    public static void stampaMenu(){
        System.out.println("-------------------------------");
        System.out.println("0) Esci");
        System.out.println("1) Crea un contatto");
        System.out.println("2) Visualizza tutti i contatti");
        System.out.println("3) Cerca un contatto per nome");
        System.out.println("4) Cerca un contatto per numero");
        System.out.println("5) Modifica un contatto");
        System.out.println("6) Rimuovi un contatto");
        System.out.println("7) Salva i contatti");
        System.out.println("-------------------------------");
    }
    public static void main(String[] args) {
        Rubrica.leggi(); //importo i contatti dal file
        String scelta;
        do {
            stampaMenu();
            scelta = inserisciString("Inserisci la tua scelta");
            switch (scelta){
                case "0":
                    break;
                case "1":
                    if (Contatto.creaContatto()){
                        System.out.println("Contatto creato con successo");
                    } 
                    else{
                        System.out.println("Errore nella creazione del contatto");
                    }
                    break;
                case "2":
                    Rubrica.stampaContatti();
                    break;
                case "3":
                    int posizione = Contatto.ricercaPerNome();
                    if (posizione != -1){
                        System.out.println("Contatto trovato nella " + (posizione + 1) + "' posizione");
                    } 
                    else{
                        System.out.println("Contatto non trovato");
                    }
                    break;
                case "4":
                    posizione = Contatto.ricercaPerNumero();
                    if (posizione != -1){
                        System.out.println("Contatto trovato nella " + (posizione + 1) + "' posizione");
                    } 
                    else{
                        System.out.println("Contatto non trovato");
                    }
                    break;
                case "5":
                    if (Contatto.modificaContatto()){
                        System.out.println("Contatto modificato con successo");
                    } 
                    else{
                        System.out.println("Errore nella modifica del contatto");
                    }
                    break;
                case "6":
                    if (Contatto.rimuoviContatto()){
                        System.out.println("Contatto rimosso con successo");
                    } 
                    else{
                        System.out.println("Errore nella rimozione del contatto");
                    }
                    break;
                case "7":
                    if (Rubrica.salva()){
                        System.out.println("Contatti salvati con successo");
                    } 
                    else{
                        System.out.println("Errore nel salvataggio dei contatti");
                    }
                    break;
                default:
                    System.out.println("Scelta non valida, riprova");
            }
        } while (!scelta.equals("0"));
    }
}