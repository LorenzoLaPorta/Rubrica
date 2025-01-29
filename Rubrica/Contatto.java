
import java.util.ArrayList;

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
    8) rimozione di un contatto
*/
public class Contatto{
    //ATTRIBUTI
    String numero;
    String nome;
    //---------
    
    Contatto(String numero, String nome){
        this.numero = numero;
        this.nome = nome;
    }

    /**
     * Override del metodo toString per scrivere il nome e il numero di telefono in un file
     * 
     * @param void
     * @return il nome e il numero di telefono in una stringa
     */
    @Override
    public String toString(){
        return this.nome + "\n" + this.numero;
    }
    /**
     * Metodo che verifica se un numero di telefono contiene effettivamente solo numeri
     * 
     * @param Contatto il contatto corrente
     * @return true se il numero contiene effettivamente solo numeri, altrimenti false
     */
    public static boolean isNumerico(String numeroInserito){
        char[] numero = numeroInserito.toCharArray();
        for (int i = 0; i < numero.length; i++){
            if (numero[i] < 48 || numero[i] > 57){
                return false;
            }
        }
        return true;
    }
    /**
     * 
     */
    public static boolean isUnico(String nomeInserito, String numeroInserito){
        ArrayList <Contatto> rubrica = Rubrica.rubrica.rubricaArray;
        for (int i = 0; i < rubrica.size(); i++){
            String nomeCorrente = rubrica.get(i).nome;
            String numeroCorrente = rubrica.get(i).numero;
            //se uno tra nome inserito e numero inserito e' uguale a uno dei rispettivi nomi e numeri correnti
            if (nomeInserito.equals(nomeCorrente) || numeroInserito.equals(numeroCorrente)){
                return false;
            }
        }
        return true;
    }
    /**
     * Metodo che crea un contatto
     * 
     * @param void
     * @return true se l'inserimento e' avvenuto correttamente, altrimenti false
     */
    public static boolean creaContatto(){
        Contatto contatto = new Contatto(null, null); //creo l'oggetto del contatto
        String nome = Main.inserisciString("Inserisci il nome del contatto");
        String numero = Main.inserisciString("Inserisci il numero del contatto");
        if (isNumerico(numero) && isUnico(nome, numero)){
            contatto.nome = nome;
            contatto.numero = numero;
            //aggiungo il contatto alla rubrica
            Rubrica.rubrica.rubricaArray.add(contatto);
        }
        else{
            //ritorno "falso" se il numero non e' composto solo da numeri o il contatto non e' unico
            return false;
        }
        return true;
    }

    /**
     * Metodo che cerca un contatto per nome
     * 
     * @param void
     * @return l'indice del contatto se lo trova, altrimenti -1
     */
    public static int ricercaPerNome(){
        String nome = Main.inserisciString("Inserisci il nome del contatto");
        ArrayList<Contatto> arrayList = Rubrica.rubrica.rubricaArray;
        for (int i = 0; i < arrayList.size(); i++){
            //se il nome e' uguale a quello inserito
            if (arrayList.get(i).nome.equals(nome)){
                //ritorno l'indice del contatto
                return i;
            }
        }
        //ritorno -1 se non trovo il contatto
        return -1;
    }

    /**
     * Metodo che cerca un contatto per numero
     * 
     * @param void
     * @return l'indice del contatto se lo trova, altrimenti -1
     */
    public static int ricercaPerNumero(){
        String numero = Main.inserisciString("Inserisci il numero del contatto");
        ArrayList<Contatto> arrayList = Rubrica.rubrica.rubricaArray;
        for (int i = 0; i < arrayList.size(); i++){
            //se il numero e' uguale a quello inserito
            if (arrayList.get(i).numero.equals(numero)){
                //ritorno l'indice del contatto
                return i;
            }
        }
        //ritorno -1 se non trovo il contatto
        return -1;
    }

    /**
     * Metodo che modifica un contatto
     * 
     * @param void
     * @return true se la modifica e' avvenuta correttamente, altrimenti false
     */
    public static boolean modificaContatto(){
        int indice = ricercaPerNome();
        if (indice != -1){
            Contatto contatto = Rubrica.rubrica.rubricaArray.get(indice);
            String nome = Main.inserisciString("Inserisci il nuovo nome del contatto, se non vuoi modificarlo premi invio");
            String numero = Main.inserisciString("Inserisci il nuovo numero del contatto, se non vuoi modificarlo premi invio");
            if (!nome.equals("")){
                contatto.nome = nome;
            }
            if (!numero.equals("")){
                if (isNumerico(numero)){
                    contatto.numero = numero;
                }
                else{
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    /**
     * Metodo che rimuove un contatto
     * 
     * @param void
     * @return true se la rimozione e' avvenuta correttamente, altrimenti false
     */
    public static boolean rimuoviContatto(){
        int indice = ricercaPerNome();
        if (indice != -1){
            Rubrica.rubrica.rubricaArray.remove(indice); //rimuovo il contatto
            return true;
        }
        return false;
    }
}