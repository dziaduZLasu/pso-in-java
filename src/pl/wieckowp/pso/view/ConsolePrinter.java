/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.wieckowp.pso.view;

import java.util.List;
import pl.wieckowp.pso.managers.PsoParamsManager;

/**
 *
 * @author artur
 */
public class ConsolePrinter {

    public static void printResults(List<Double> wynikPSO, PsoParamsManager p) {
        System.out.println("Testowana funkcja to: " + p.getFunction());
        for (int i = 0; i < wynikPSO.size(); i++) {
            // wypisuje wspolrzedne
            System.out.println("Wspolrzedna nr:" + i + " = " + wynikPSO.get(i));
        }
        // wypisuje znalezione minimum
        System.out.println("Zakladane minimum funkcji w tym pkt = " + p.getFunction().functionEvaluation(wynikPSO));
    }
}
