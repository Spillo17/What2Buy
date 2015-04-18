/*
 * The MIT License
 *
 * Copyright 2015 SGT1B SSIG.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package org.ssig.alpr.what2buy;

import java.io.File;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 *
 * @author SGT1A
 */
public class What2Buy {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        File file = new File("lista.dat");

        boolean quit = false;
        Scanner input = new Scanner(System.in);

        while (!quit) {
            System.out.print("> ");

            String line = input.nextLine();
            if (line.equals("quit")) {
                quit = true;
            } else {
                parseCommand(file, line);
            }
        }
    }

    /**
     * Questo metodo serve utilizzando dei comandi per gestire una lista della
     * spesa, i comandi sono passati dall'utente sotto forma di linea di comando
     *
     * @param file corrisponde alla lista della spesa su formato binario
     * @param line corrisponde al comando creato dall'utente
     * @throws NoSuchElementException nel caso in cui l'utente utilizza il
     * comando add o rm senza passare il secondo parametro l'applicazione lancia
     * un eccezione richimando l'helper
     */
    public static void parseCommand(File file, String line) {

        try {
            // String[] list = loadList(file);
            String[] list = {"lista", "di", "test", "caricami", "dal", "file"};//AA
            Scanner input = new Scanner(line);
            String cmd = input.next();
            String item = "";

            switch (cmd) {
                case "ls":
                case "list":
                    printList(list);
                    break;
                case "add":
                    item = input.next();
                    list = addToList(list, item);//AA
                    printList(list);//AA, test
                    break;
                case "rm":
                case "remove"://AA
                    item = input.next();
                    System.out.println("RIMUOVI " + item);
                    //removeFromList(list, item);
                    break;
                default:
                    printHelp();

            }
        } catch (NoSuchElementException e) {
            
            printHelp();//AA
        }

    }

    /**
     * Ritorna nuova lista modificata con il nuovo prodotto. Ricevo l'array, lo
     * copio e lo inserisco in quello nuovo in cui avrà una posizione libera in
     * più
     *
     * @param list corrisponde all'array attuale
     * @param item corrisponde al prodotto da aggiungere
     * @return Ritorna il nuovo array con all'ultima posizione il nuovo prodotto
     */
    public static String[] addToList(String[] list, String item) {
        String[] addToList = new String[list.length + 1];
        for (int i = 0; i < list.length; i++) {
            addToList[i] = list[i];
        }
        addToList[addToList.length - 1] = item;
        return addToList;
    }

    /**
     * Stampa il contenuto della lista attuale uno sotto l'altro.
     *
     * @param list corrisponde all'array contenente tutti gli elementi della
     * nostra lista
     */
    public static void printList(String[] list) {
        for (int i = 0; i < list.length; i++) {
            System.out.println("- " + list[i]);
        }
    }

    /**
     * Stampa la guida d'uso. (alb)
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

}
