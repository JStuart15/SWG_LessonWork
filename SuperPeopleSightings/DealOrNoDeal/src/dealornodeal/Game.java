/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dealornodeal;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 *
 * @author Hayden
 */
public class Game {

    public double roundNumber;
    public Map<Integer, Case> cases;
    Random rng = new Random();

    public Game() {
        roundNumber = 1;
        cases = generateCases();
    }

    public double getRoundNumber() {
        return roundNumber;
    }

    public void setRoundNumber(double roundNumber) {
        this.roundNumber = roundNumber;
    }

    public Map<Integer, Case> getCases() {
        return cases;
    }

    public void setCases(Map<Integer, Case> cases) {
        this.cases = cases;
    }

    public Random getRng() {
        return rng;
    }

    public void setRng(Random rng) {
        this.rng = rng;
    }

    public BigDecimal makeOffer() {
        BigDecimal offer = new BigDecimal("0");
        BigDecimal multiplier = new BigDecimal(roundNumber / 10);
        BigDecimal[] sum = {new BigDecimal("0")};

        cases.forEach((k, v) -> {
            sum[0] = sum[0].add(v.value.getCashValue());
        });

        offer = sum[0].multiply(multiplier);

        return offer;
    }

    public Map<Integer, Case> generateCases() {

        ArrayList<Case> toFill = new ArrayList<>();
        ArrayList<Integer> caseIDs = new ArrayList<>();

        for (int i = 1; i < 27; i++) {
            caseIDs.add(i);
        }

        for (CaseValue cv : CaseValue.values()) {
            int randomIndex = rng.nextInt(caseIDs.size());
            Case toAdd = new Case(caseIDs.get(randomIndex), cv);
            caseIDs.remove(randomIndex);
            toFill.add(toAdd);
        }
        Map<Integer, Case> boardCases = new HashMap<>();
        for (Case case1 : toFill) {
            boardCases.put(case1.getId(), case1);
        }
        return boardCases;
    }
}
