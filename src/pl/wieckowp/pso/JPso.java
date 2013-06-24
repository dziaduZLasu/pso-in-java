package pl.wieckowp.pso;

import java.util.List;
import pl.wieckowp.pso.functions.Parabol;
import pl.wieckowp.pso.managers.PsoParamsManager;
import pl.wieckowp.pso.logic.Pso;
import pl.wieckowp.pso.view.ConsolePrinter;

/**
 *
 * @author wieckowp
 */
public class JPso {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        PsoParamsManager p = new PsoParamsManager();
        p.setParticlesNumber(10);
        p.setFiParticle(0.01);
        p.setFiSwarm(0.9);
        p.setOmegaValue(0.7);
        p.setPsoMaxPerVecElem(52.2);
        p.setPsoMinPerVecElem(2.2);
        p.setIterations(100);
        p.setDimension(3);
        Parabol par = new Parabol();
        p.setFunction(par);

        Pso pso = new Pso(p);
        List<Double> wynikPSO = pso.getMinimum();
        ConsolePrinter.printResults(wynikPSO, p);
    }

}
