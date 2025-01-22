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
     * Metodo che verifica se un numero di telefono contiene effettivamente solo numeri
     * 
     * @param Contatto il contatto corrente
     * @return true se il numero contiene effettivamente solo numeri, altrimenti false
     */
    public static boolean isNumerico(String numeroInserito){
        char[] numero = numeroInserito.toCharArray();
        for (int i = 0; i < numero.length; i++){
            if (numero[i] < 48 && numero[i] > 57){
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