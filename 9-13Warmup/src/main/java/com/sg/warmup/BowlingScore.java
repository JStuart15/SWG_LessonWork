/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.warmup;

import java.util.List;

/**
 *
 * @author jstuart15
 */
public class BowlingScore {

    public int calculateScore(List<Integer[]> intArray) {
        int totalScore = 0;
        int bonusFrameScore = 0;
        int currentFrameScore = 0;

        intArray.add(0, new Integer[]{0, 0});//add an element so that we don't have to deal with the zero index

        //Frames 1 through penultimate
        for (int frame = 1; frame < intArray.size() - 1; frame++) {
            currentFrameScore = getCurrentFrameScore(intArray, frame);
            bonusFrameScore = getBonusFrameScore(intArray, frame, currentFrameScore);
            totalScore += currentFrameScore;
            totalScore += bonusFrameScore;
        }

        //Last frame 
        int lastFrameIndex = intArray.size() - 1;//-1 to accommodate for the padded array
        int lastFrameCurrentScore = getCurrentFrameScore(intArray, lastFrameIndex);
        int lastFrameBonusScore = getBonusFrameScore(intArray, lastFrameIndex, lastFrameCurrentScore);
        totalScore += lastFrameCurrentScore;
        totalScore += lastFrameBonusScore;
        return totalScore;
    }

    private int getCurrentFrameScore(List<Integer[]> frames, int frame) {
        int currentFrameScore = 0;
        for (int roll = 0; roll < frames.get(frame).length; roll++) {
            currentFrameScore += frames.get(frame)[roll];
        }
        return currentFrameScore;
    }

    private int getBonusFrameScore(List<Integer[]> intArray, int frame, int currentFrameScore) {
        int bonusFrameScore = 0;
        if (frame == 10) {
            //nothing required for bonus in 10th frame; handled in getCurrentFrameScore
        } else {
            if (intArray.get(frame)[0] == 10) {//the current frame has a strike on first roll
                if (intArray.get(frame + 1)[0] == 10) { //frame + 1 has a strike on first roll
                    if (frame == intArray.size() - 2 && frame == 9) { //if penultimate frame & frame 9 get values from the 10th array only
                        bonusFrameScore += intArray.get(frame + 1)[0]
                                + intArray.get(frame + 1)[1];
                    } else {
                        bonusFrameScore = intArray.get(frame + 1)[0]
                                + intArray.get(frame + 2)[0];
                    }
                } else { //add the next two rolls because no strike on frame + 1
                    bonusFrameScore = intArray.get(frame + 1)[0] + intArray.get(frame + 1)[1];
                }

            } else if (currentFrameScore == 10
                    && intArray.get(frame)[0] != 10
                    && intArray.size() - 1 != frame) {//the current frame has 10 total; not strike;
                bonusFrameScore = intArray.get(frame + 1)[0];
            }
        }
        return bonusFrameScore;
    }
}
