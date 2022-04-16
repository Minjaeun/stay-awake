package com.cgh.server.controller;

import com.cgh.server.domain.Member;
import com.cgh.server.domain.Team;
import com.cgh.server.service.MemberService;
import com.cgh.server.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/team")
public class TeamController {

    @Autowired
    TeamService teamService;
    @Autowired
    MemberService memberService;

    @GetMapping("")
    public String group(Model model, @AuthenticationPrincipal User user) {
        if (memberService.findByUsername(user.getUsername()).isPresent()) {
            Member member = memberService.findByUsername(user.getUsername()).get();
            if (!teamService.findByMember(member).isEmpty()) {
                model.addAttribute("team", teamService.findByMember(member));
            }
        }
        return "team";
    }

    @GetMapping("/create")
    public String createTeam(Model model) {
        model.addAttribute("team", new Team());
        return "team_create";
    }

    @PostMapping("/create")
    public String create(Team team, @AuthenticationPrincipal User user) {
        if (memberService.findByUsername(user.getUsername()).isPresent()) {
            team.setMember(memberService.findByUsername(user.getUsername()).get());
        }
        teamService.save(team);
        return "redirect:/team";
    }

    @GetMapping("/{id}")
    public String loadInfo(@PathVariable("id") String id, Model model) {
        model.addAttribute("team", teamService.findById(id).get());
        return "team_info";
    }

}
