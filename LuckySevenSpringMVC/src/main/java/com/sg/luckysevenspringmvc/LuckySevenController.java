/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.luckysevenspringmvc;

import java.util.Map;
import java.util.Random;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author jstuart15
 */
@Controller
public class LuckySevenController {
    
    @RequestMapping(value="/playLuckySeven", method=RequestMethod.POST)
    public String playLuckySevens(HttpServletRequest request, Map<String, Object> model) {
        
        int rolls = 0;
        int quitRolls = 0;
        int maxDollars = 0;
        int dollars = 0;

        dollars = Integer.parseInt(request.getParameter("dollars"));
        model.put("dollars", dollars);
        
        maxDollars = dollars;

        while (dollars > 0) {
            rolls++;
            int dice1 = rollDie();
            int dice2 = rollDie();
            int sum = dice1 + dice2;

            if (sum == 7) {
                dollars += 4;
            } else {
                dollars -= 1;
            }

            if (dollars > maxDollars) {
                maxDollars = dollars;
                quitRolls = rolls;
            }
        }
        
        model.put("brokeAfter", rolls);
        model.put("quitRolls", quitRolls);
        model.put("maxDollars", maxDollars);
        
        return "result";
    }

    public static int rollDie() {
        Random randNum = new Random();
        int number = randNum.nextInt(6) + 1;
        return number;
    }
}
