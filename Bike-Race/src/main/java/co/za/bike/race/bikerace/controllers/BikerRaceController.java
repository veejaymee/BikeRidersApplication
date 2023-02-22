package co.za.bike.race.bikerace.controllers;

import co.za.bike.race.bikerace.pojo.BikeRacer;
import co.za.bike.race.bikerace.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class BikerRaceController {

    @Autowired
    ResultService resultService;

    @RequestMapping(path = "/")
    public String getSignleRaceResults(Model model, Long race_id){
        List<BikeRacer> bikeRacerList = resultService.getAllRaceResults();
        System.out.println("result size:" + bikeRacerList.size());
        model.addAttribute("resultList", bikeRacerList);
        return "view";
    }
}
