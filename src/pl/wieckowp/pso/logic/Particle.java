/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.wieckowp.pso.logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import pl.wieckowp.pso.managers.PsoParamsManager;

/**
 *
 * @author wieckowp
 */
public class Particle {

    private Random random;
    private Double lastParticleBestEval;
    private PsoParamsManager psoParams;
    private List<Double> currentPosition;
    private List<Double> acceleration;
    private List<Double> lastBestPosition;

    // getter - lastBestEval
    public Double getlastParticleBestEval() {
        return lastParticleBestEval;
    }

    // getter - currentPosition
    public List<Double> getCurrentPosition() {
        return currentPosition;
    }

    private Double randBeet(Double min, Double max) {
        return min + random.nextDouble() * (max - min);
    }

    // konstruktor - createParticle
    public Particle(PsoParamsManager psoParams) {
        this.random = new Random();
        this.psoParams = psoParams;

        double accelInitDiffAbs = Math.abs(psoParams.getPsoMaxPerVecElem() - psoParams.getPsoMinPerVecElem());
        double negDiff = -1.0 * accelInitDiffAbs;
        double posDiff = accelInitDiffAbs;
        currentPosition = new ArrayList<Double>(psoParams.getDimension());
        acceleration = new ArrayList<Double>(psoParams.getDimension());
        //lastBestPosition = new ArrayList<Double>(psoParams.getDimension());

        for (int i = 0; i < psoParams.getDimension(); i++) {

            /*
             * Pozycja : Wektor pozycji - rozmiar zależny od wymiarowości zadania;
             * Inicjalizowany liczbami pseudolosowymi o rozkładzie jednorodnym od zadanej wartości minimalnej do maksymalnej.
             * Jednakże, jeżeli coś wiemy na temat optymalizowanego zadania możemy przyjąć liczby bliskie zakładanemu optimum.
             */
            this.currentPosition.add(randBeet(psoParams.getPsoMinPerVecElem(), psoParams.getPsoMaxPerVecElem()));

            /*
             * Przyśpieszenie: Wektor przyśpieszenia -rozmiar zależny od wymiarowości zadania;
             * Inicjalizowany liczbami pseudolosowymi o rozkładzie jednorodnym od ujemnej różnicy zadanej wartości maksymalnej i minimalnej,
             * do dodatniej wartości takiej różnicy .
             * Każdy element wektoru odnosi się do prędkości dla wymiaru n, gdzie n jest numerem elementu w wektorze.
             */
            this.acceleration.add(randBeet(negDiff, posDiff));
        }
        /*
         * Najlepsza pozycja: Wektor najlepszej pozycji - rozmiar zależny od wymiarowości zadania;
         * Inicjalizowany wektorem pozycji przy tworzeniu cząsteczki.
         * Jego wartość zostaje zmieniona, gdy cząsteczka znalazła lepiej oceniane położenie.
         * Wektor ten staje się później jednym z dwóch atraktorów cząsteczki.
         */
        lastBestPosition = new ArrayList<Double>(this.currentPosition);
        this.lastParticleBestEval = psoParams.getFunction().functionEvaluation(currentPosition);
    }

    // funkcja - moveParticle
    public void moveParticle(List<Double> swarmLastBestPos) {
        for (int i = 0; i < psoParams.getDimension(); i++) {

            Double accel;
            accel = this.psoParams.getOmegaValue() * this.acceleration.get(i)
                    + this.psoParams.getFiParticle() * randBeet(0.0, 1.0)
                    * (this.lastBestPosition.get(i) - this.currentPosition.get(i))
                    + this.psoParams.getFiSwarm() * randBeet(0.0, 1.0)
                    + (swarmLastBestPos.get(i) - this.currentPosition.get(i));

            this.acceleration.set(i, accel);
            // przestawiam na i-ta skladowa
            this.currentPosition.set(i, this.currentPosition.get(i) + this.acceleration.get(i));
        }
    }

    public Integer checkParticleLastBestPos() {
        Integer retVal = 0;
        Double newPosEval = this.psoParams.getFunction().functionEvaluation(currentPosition);

        if (newPosEval < this.lastParticleBestEval) {
            this.lastParticleBestEval = newPosEval;
            this.lastBestPosition = new ArrayList<Double>(this.currentPosition);
            retVal = 1;
        }
        return retVal;
    }

    public List<Double> getLastBestPosition() {
        return lastBestPosition;
    }
}
