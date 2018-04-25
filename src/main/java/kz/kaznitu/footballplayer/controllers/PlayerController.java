package kz.kaznitu.footballplayer.controllers;

import kz.kaznitu.footballplayer.models.Club;
import kz.kaznitu.footballplayer.models.Player;
import kz.kaznitu.footballplayer.repositories.ClubRepository;
import kz.kaznitu.footballplayer.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PlayerController {
    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private ClubRepository clubRepository;

    @RequestMapping(value = "/admin/players", method = RequestMethod.GET)
    public String playersList(Model model){
        model.addAttribute("players", playerRepository.findAll());
        model.addAttribute("clubs", clubRepository.findAll());
        return "admin/players";
    }

    @RequestMapping(value = "/admin/addplayer",method = RequestMethod.POST)
    public String addPlayer(@RequestParam Long clubIId,
                            @RequestParam String firstName,
                            @RequestParam String lastName,
                            Model model) {
        Club club = clubRepository.findOne(clubIId);
        Player newPlayer = new Player();
        newPlayer.setClub(club);
        newPlayer.setFirstName(firstName);
        newPlayer.setLastName(lastName);
        playerRepository.save(newPlayer);

        return "redirect:/admin/players";
    }

    @RequestMapping(value = "/admin/remove", method = RequestMethod.GET)
    public String remove(@RequestParam("id") Long id){
        playerRepository.delete(id);
        return "redirect:/admin/players";
    }

}
