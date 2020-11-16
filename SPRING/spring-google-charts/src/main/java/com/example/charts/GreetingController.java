package com.example.charts;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;
import java.util.TreeMap;

@Controller
public class GreetingController {

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name = "isik", required = false, defaultValue = "World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }

    @GetMapping("/chart")
    public String getPieChart(Model model) {
        Map<Integer, Integer> graphData = new TreeMap<>();
        graphData.put(140, 45);
        graphData.put(141, 22);
        graphData.put(142, 30);
        graphData.put(143, 35);
        model.addAttribute("chartData", graphData);
        return "linechart";
    }

}