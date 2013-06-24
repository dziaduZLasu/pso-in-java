/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.wieckowp.pso.logic;

import java.util.List;
import pl.wieckowp.pso.managers.PsoParamsManager;

/**
 *
 * @author wieckowp
 */
public class Pso {

    private Swarm s;
    private PsoParamsManager p;

    public Pso(PsoParamsManager p) {
        this.p = p;
        this.s = new Swarm(p);
    }

    public List<Double> getMinimum() {

        // Poruszam rojem odpowiednia ilosc razy - iteracje
        for (int i = 0; i < p.getIterations(); i++) {
            s.moveSwarm();
           
        }

        return s.getSwarmBestPosition();
    }
}
