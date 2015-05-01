package org.ssig.alpr.oop.what2buy;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class What2Buy {

    /**
     * Questo metodo serve utilizzando dei comandi per gestire una lista della
     * spesa, i comandi sono passati dall'utente sotto forma di linea di comando
     *
     * @param file corrisponde alla lista della spesa su formato binario
     * @param line corrisponde al comando creato dall'utente
     * @throws NoSuchElementException nel caso in cui l'utente utilizza il
     * comando add o rm senza passare il secondo parametro l'applicazione lancia
     * un eccezione richimando l'helper
     *
     * @author Jacky Brücker, Jacopo Fontana
     */
    public static void parseCommand(File file, String line) {
        ArrayList<Item> list = loadList(file);
        Scanner input = new Scanner(line);
        String cmd = input.next();


        switch (cmd) {
            case "ls":
            case "list":
                printList(list);
                break;
            case "add":
                String name = input.next();
                double price = Double.parseDouble(input.next());
                int qty = Integer.parseInt(input.next());
                Item item = new Item(name,price,qty);
                list = addToList(list, item);//AA
                printList(list);//AA, test
                break;
            case "rm":
            case "remove"://AA
                String toRemove = input.next();
                System.out.println("RIMUOVI " + toRemove);
                removeFromList(list, toRemove);
                break;
            default:
                printHelp();
        }
    }

    /**
     * Stampa la guida d'uso. (alb)
     * @author alb
     */
    public static void printHelp() {
        System.out.println("Comandi:");
        System.out.println("add <testo>\tAggiunge un nuovo elemento alla lista.");
        System.out.println("remove <testo>\tRimuove un elemento dalla lista.");
        System.out.println("rm <testo>\tRimuove un elemento dalla lista.");
        System.out.println("list\t\tStampa la lista.");
        System.out.println("ls\t\tStampa la lista.");
        System.out.println("quit\t\tTermina il programma.");
    }


    /**
     * Ritorna una nuova lista con il nuovo prodotto inserito.
     * Il metodo riceve l'array attuale, esegue una copia e la inserisce nel nuovo array il quale avrà una posizione in più.
     *
     * @param list corrisponde all'array attuale
     * @param item corrisponde al prodotto da aggiungere
     * @return Ritorna il nuovo array con all'ultima posizione il nuovo prodotto
     *
     * @author Nicola Agustoni, Patrick Realini
     * @TODO implementare il metodo
     */
    private static ArrayList<Item> addToList(ArrayList<Item> list, Item item) {
        return null;
    }

    /**
     * Stampa il contenuto della lista attuale uno sotto l'altro.
     *
     * @param list corrisponde all'array contenente tutti gli elementi della
     * nostra lista
     *
     * @author Nicola Agustoni, Patrick Realini
     *  @TODO implementare il metodo
     */
    private static void printList(ArrayList<Item> list) {

    }

    /**
     * Questo metodo può sollevare un'eccezione
     *
     * @param file
     * @throws IOException
     * @TODO completare il metodo
     * @author Mattia Tommaso
     * @TODO implementare il metodo
     */
    private static ArrayList<Item> loadList(File file) {
        return null;
    }

    /**
     * prende un array di stringa e il file la salva gli elementi contenuti nell
     * array in un file;
     *
     * @param list array di tutti gli elementi della lista
     * @file è il nome del file da salvare
     *
     * @author Fabio e Martino
     * @TODO implementare il metodo
     */
    public static void saveList(File file, ArrayList<Item> list) throws IOException {

    }


    /**
     * - Il metodo deve prendere in argomento una lista di stringhe e un item -
     * il metodo rimuove un item dalla lista - il confronto non è case sensitive
     * - se l'item da rimuovere non è presente nell'array il ciclo si interrompe
     *
     * @param list ???
     * @param item ???
     * @return ????
     *
     * @author Mattia Edoardo
     *  @TODO implementare il metodo
     */
    public static ArrayList<Item> removeFromList(ArrayList<Item> list, String item) {
        return null;
    }

}
