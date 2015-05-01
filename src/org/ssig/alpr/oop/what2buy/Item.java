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

package org.ssig.alpr.oop.what2buy;


public class Item {


    public String name;

    private double price;

    private int qty;

    /**
     * Costruttore della classe Item la quale rappresenta un singolo elemento della lista della spesa
     *
     * @param name
     * @param price
     * @param qty
     */
    public Item(String name, double price, int qty) {
        this.name = name;
        this.price = price;
        this.qty = qty;
    }

    /**
     * Ritorna il nome dell'articolo
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Imposta il nome dell'articolo
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Ritorna il prezzo di un dato articolo
     *
     * @return double
     */
    public double getPrice() {
        return price;
    }

    /**
     * Imposta il prezzo di un dato articolo
     * @param price
     *
     * @TODO decidere in caso sia negativo cosa fare
     */
    public void setPrice(double price) {
        if(price > 0) {
            this.price = price;
        }else{

        }
    }

    /**
     * Ritorna la quantita di un dato articolo
     *
     * @return int qty
     */
    public int getQty() {
        return qty;
    }

    /**
     * Imposta la quantita di un dato articolo
     *
     * @param qty
     *
     * @TODO decidere in caso sia negativo cosa fare
     */
    public void setQty(int qty) {
        if(qty > 0) {
            this.qty = qty;
        }else{

        }
    }

    /**
     * @return stringa contenente gli attributi dell'oggetto in forma leggibile
     */
    @Override
    public String toString() {
        return this.qty + " x " + this.name + " - " + this.qty * this.price;
    }
}

