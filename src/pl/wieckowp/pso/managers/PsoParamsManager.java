/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.wieckowp.pso.managers;

import pl.wieckowp.pso.logic.FunctionInterface;

/**
 *
 * @author wieckowp
 */
// klasa odpowiedzialna za trzymanie parametrow roju/algorytmu
public class PsoParamsManager {

    // parametry takie jak wymiary, ilosc iteracji, wartosc omega, itp.
    private Integer dimension;
    private Integer iterations;
    private Integer particlesNumber;
    private Double omegaValue;
    private Double fiParticle;
    private Double fiSwarm;
    private Double psoMaxPerVecElem;
    private Double psoMinPerVecElem;
    private FunctionInterface function;

    // metody dostepowe - get
    public Integer getDimension() {
        return dimension;
    }

    public Integer getIterations() {
        return iterations;
    }

    public Integer getParticlesNumber() {
        return particlesNumber;
    }

    public Double getOmegaValue() {
        return omegaValue;
    }

    public Double getFiParticle() {
        return fiParticle;
    }

    public Double getFiSwarm() {
        return fiSwarm;
    }

    public Double getPsoMaxPerVecElem() {
        return psoMaxPerVecElem;
    }

    public Double getPsoMinPerVecElem() {
        return psoMinPerVecElem;
    }

    public FunctionInterface getFunction() {
        return function;
    }

    // metody dostepowe - set
    public void setDimension(Integer dimension) {
        this.dimension = dimension;
    }

    public void setIterations(Integer iterations) {
        this.iterations = iterations;
    }

    public void setParticlesNumber(Integer particlesNumber) {
        this.particlesNumber = particlesNumber;
    }

    public void setOmegaValue(Double omegaValue) {
        this.omegaValue = omegaValue;
    }

    public void setFiParticle(Double fiParticle) {
        this.fiParticle = fiParticle;
    }

    public void setFiSwarm(Double fiSwarm) {
        this.fiSwarm = fiSwarm;
    }

    public void setPsoMaxPerVecElem(Double psoMaxPerVecElem) {
        this.psoMaxPerVecElem = psoMaxPerVecElem;
    }

    public void setPsoMinPerVecElem(Double psoMinPerVecElem) {
        this.psoMinPerVecElem = psoMinPerVecElem;
    }

    public void setFunction(FunctionInterface function) {
        this.function = function;
    }

    // funkcja ktora wyswietla na konsoli parametry zeby sprawdzic czy sa one poprawnie ladowane
    // obecnie funkcja nie jest nigdzie uzywana
    public void printResultsForTestPurposes(PsoParamsManager p) {
        System.out.println(p.getDimension());
        System.out.println(p.getFiParticle());
        System.out.println(p.getFiSwarm());
        System.out.println(p.getIterations());
        System.out.println(p.getOmegaValue());
        System.out.println(p.getParticlesNumber());
        System.out.println(p.getPsoMaxPerVecElem());
        System.out.println(p.getPsoMinPerVecElem());
        System.out.println(p.getFunction());
    }

}