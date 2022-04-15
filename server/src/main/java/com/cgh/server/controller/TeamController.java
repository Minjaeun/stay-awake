package com.cgh.server.controller;

import com.cgh.server.domain.Team;
import com.cgh.server.domain.Member;
import com.cgh.server.service.TeamService;
import com.cgh.server.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/group")
public class TeamController {

    @Autowired
    TeamService teamService;
    @Autowired
    MemberService memberService;

    @GetMapping("")
    public String group(Model model, @AuthenticationPrincipal User user) {

        Team team = new Team();
        Member current = memberService.findByUsername(user.getUsername()).get();
        team.setMember(current);
        current.setTeam(team);



        if (memberService.findByUsername(user.getUsername()).isPresent()) {
            Member member = memberService.findByUsername(user.getUsername()).get();
            if (!teamService.findByMember(member).isEmpty()) {
                model.addAttribute("team", teamService.findByMember(member));
            }
        }
        return "team";
    }

    /*@GetMapping("/{roomId}")
    public String group(@RequestParam Long roomId) {
        return "group";
    }*/

}
