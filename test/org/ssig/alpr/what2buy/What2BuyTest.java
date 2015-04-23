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

import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author andreaalbertini
 */
public class What2BuyTest {

    @Test
    public void test_add_100_elementi() {
        String[] expected = new String[0];
        String[] before = new String[0];
        for (int i = 0; i < 100; i++) {
            expected = Arrays.copyOf(expected, i + 1);
            expected[i] = "item" + i;
            String[] after = What2Buy.addToList(before, new String(expected[i]));

            for (int j = 0; j < expected.length; j++) {
                assertTrue("Dopo l'inserimento la lista deve essere integra exp: " + Arrays.toString(expected) + " actual: " + Arrays.toString(after), expected[j].equals(after[j]));

            }
            before = after;
        }
    }

    @Test
    public void testSaveList() throws Exception {
    }

    @Test
    public void testLoadList() throws Exception {
    }

    /**
     * Prova a rimuovere l'unico elemento presente nella lista.
     */
    @Test
    public void test_remove_unico_elemento() {
        String[] expected = new String[0];
        String[] before = {"item1"};
        String[] after = What2Buy.removeFromList(before, "item1");
        assertArrayEquals(expected, after);
    }

    /**
     * Prova a rimuovere un elemento da una lista vuota.
     */
    @Test
    public void test_remove_da_lista_vuota() {
        String[] expected = new String[0];
        String[] before = new String[0];
        String[] after = What2Buy.removeFromList(before, "item1");
        assertArrayEquals(expected, after);
    }

    /**
     * Prova a rimuovere un elemento che nella lista non è presente.
     */
    @Test
    public void test_remove_di_un_elemento_inesistente() {
        String[] expected = {"item1", "item2", "item3"};
        String[] before = {"item1", "item2", "item3"};
        String[] after = What2Buy.removeFromList(before, "item4");
        assertArrayEquals(
                "dopo la rimozione di un elemento inesistente la lista deve essere inalterata exp: "
                + Arrays.toString(expected)
                + " actual: " + Arrays.toString(after),
                expected,
                after
        );
    }

    /**
     * Prova a rimuovere un elemento fornendo il nome corretto ma con il caso dei
     * caratteri diverso dall'originale.
     */
    @Test
    public void test_remove_di_un_elemento_case_sensitive() {
        String[] expected = {"item1", "item3"};
        String[] before = {"item1", "item2", "item3"};
        String[] after = What2Buy.removeFromList(before, "iTeM4");
        assertArrayEquals(
                "dopo la rimozione di un elemento la lista deve essere cambiata exp: "
                + Arrays.toString(expected)
                + " actual: " + Arrays.toString(after),
                expected,
                after
        );
    }

    /**
     * Rimuove ripetutamente il primo elemento della lista.
     */
    @Test
    public void test_remove_100_elementi_dalla_testa() {
        String[] expected = new String[100];
        String[] before = new String[100];
        //preparo array
        for (int i = 0; i < 100; i++) {
            expected[i] = new String("item" + i);
            before[i] = new String("item" + i);
        }
        for (int i = 0; i < 100; i++) {
            String[] after = What2Buy.removeFromList(before, new String(expected[0]));
            expected = Arrays.copyOfRange(expected, 1, expected.length);
            for (int j = 0; j < expected.length; j++) {
                assertTrue(j + " Dopo la rimozione la lista deve essere integra exp: " + Arrays.toString(expected) + " actual: " + Arrays.toString(after), expected[j].equals(after[j]));
            }
            before = after;
        }
    }

    /**
     * Rimuove ripetutamente il l'ultimo elemento della lista.
     */
    @Test
    public void test_remove_100_elementi_dalla_coda() {
        String[] expected = new String[100];
        String[] before = new String[100];
        //preparo array
        for (int i = 0; i < 100; i++) {
            expected[i] = new String("item" + i);
            before[i] = new String("item" + i);
        }

        for (int i = 99; i >= 0; i--) {
            String[] after = What2Buy.removeFromList(before, new String(expected[i]));
            expected = Arrays.copyOfRange(expected, 0, expected.length - 1);
            for (int j = 0; j < expected.length; j++) {
                assertTrue(j + " Dopo la rimozione la lista deve essere integra exp: " + Arrays.toString(expected) + " actual: " + Arrays.toString(after), expected[j].equals(after[j]));
            }
            before = after;
        }
    }
}
