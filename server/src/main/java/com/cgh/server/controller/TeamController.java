package com.cgh.server.controller;

import com.cgh.server.domain.Member;
import com.cgh.server.service.MemberService;
import com.cgh.server.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @GetMapping("")
    public String loadInfo(@RequestParam Long roomId, Model model) {
         //TODO: 팀 정보 로딩 구현
        return "team_info";
    }

    @PostMapping("/{roomId")
    public String createGroup(@RequestParam Long roomId) {
        //TODO: 팀 생성 구현
        return "group";
    }

}
