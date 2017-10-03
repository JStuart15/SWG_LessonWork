/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.tipcalculator;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author jstuart15
 */
@Controller
public class TipController {
    
    @RequestMapping(value="/calculateTip", method=RequestMethod.POST)
    public String calculateTip(HttpServletRequest request, Map<String, Object> model){
        
        double billAmount = Double.parseDouble(request.getParameter("billAmount"));
        double percent    = Double.parseDouble(request.getParameter("percent"));
        
        double tipAmount  = billAmount * percent / 100;
        double total      = tipAmount + billAmount;
        
        model.put("billAmount", billAmount);
        model.put("percent", percent);
        model.put("tipAmount", tipAmount);
        model.put("total", total);
        
        return "result";
    }
}
