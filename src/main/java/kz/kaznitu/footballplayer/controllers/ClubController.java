package kz.kaznitu.footballplayer.controllers;

import kz.kaznitu.footballplayer.models.Club;
import kz.kaznitu.footballplayer.repositories.ClubRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ClubController {

    @Autowired
    ClubRepository clubRepository;

    @RequestMapping(value = "/admin/clubs", method = RequestMethod.GET)
    public String clubList(Model model) {
        model.addAttribute("clubs", clubRepository.findAll());
        model.addAttribute("club", new Club());
        return "admin/clubs";
    }

    @RequestMapping(value = "/admin/saveclub", method = RequestMethod.POST)
    public String saveClub(@ModelAttribute Club club) {
        clubRepository.save(club);
        return "redirect:/admin/clubs";
    }
}
