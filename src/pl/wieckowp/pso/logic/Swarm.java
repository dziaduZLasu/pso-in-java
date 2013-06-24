/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.wieckowp.pso.logic;

import java.util.ArrayList;
import java.util.List;
import pl.wieckowp.pso.managers.PsoParamsManager;

/**
 *
 * @author wieckowp
 */
public class Swarm {

    private Double lastSwarmBestEval;
    private PsoParamsManager psoParams;
    private List<Particle> particles;
    private List<Double> swarmBestPosition;

    // getter - lastSwarmBestEval
    public Double getLastSwarmBestEval() {
        return lastSwarmBestEval;
    }

    // getter - SwarmBestPosition
    public List<Double> getSwarmBestPosition() {
        return swarmBestPosition;
    }

    // konstruktor - createSwarm
    public Swarm(PsoParamsManager psoParams) {
        this.psoParams = psoParams;
        swarmBestPosition = new ArrayList<Double>(psoParams.getDimension());
        particles = new ArrayList<Particle>(psoParams.getParticlesNumber());
        for (int i = 0; i < psoParams.getParticlesNumber(); i++) {
            // tworze czasteczki w roju       
            this.particles.add(new Particle(psoParams));
            // this.particles.set(i, new Particle(psoParams));

            if (i == 0) {
                this.swarmBestPosition = new ArrayList<Double>(particles.get(0).getCurrentPosition());
                //this.swarmBestPosition.set(i, particles.get(i).getCurrentPosition());
                // z Particle.java
                //this.currentPosition.set(i, randBeet(psoParams.getPsoMinPerVecElem(), psoParams.getPsoMaxPerVecElem()));
            }
        }
        // obliczam watość funkcji żeby potem nie wykonywać tego kosztownego obliczenia za każdym razem
        this.lastSwarmBestEval = psoParams.getFunction().functionEvaluation(swarmBestPosition);

    }

    public void moveSwarm() {
        for (int i = 0; i < psoParams.getParticlesNumber(); i++) {
            // public void moveParticle(List<Double> swarmLastBestPos)
            particles.get(i).moveParticle(this.getSwarmBestPosition());

            if ((particles.get(i).checkParticleLastBestPos()) == 1) {
                checkSwarmLastBestPos(particles.get(i));
            }
        }
    }

    private void checkSwarmLastBestPos(Particle p) {
        if (p.getlastParticleBestEval() < this.getLastSwarmBestEval()) {
            this.lastSwarmBestEval = p.getlastParticleBestEval();
            this.swarmBestPosition = new ArrayList<Double>(p.getLastBestPosition());
        }
    }
}
