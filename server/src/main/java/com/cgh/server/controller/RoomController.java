package com.cgh.server.controller;

import com.cgh.server.domain.Member;
import com.cgh.server.domain.Record;
import com.cgh.server.domain.Subject;
import com.cgh.server.service.MemberService;
import com.cgh.server.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/room")
public class RoomController {

    @Autowired
    MemberService memberService;
    @Autowired
    SubjectService subjectService;

    @GetMapping("")
    public String selectSubject(Model model, @AuthenticationPrincipal User user) {
        Member member = memberService.findByUsername(user.getUsername()).get();
        model.addAttribute("member", member);

        return "subject";
    }

    @GetMapping("/create")
    public String createSubject(Model model) {
        model.addAttribute("subject", new Subject());
        return "subject_create";
    }

    @PostMapping("/create")
    public String create(Subject subject, @AuthenticationPrincipal User user) {
        Member member;
        if (memberService.findByUsername(user.getUsername()).isPresent()) {
            member = memberService.findByUsername(user.getUsername()).get();
            member.addSubject(subject);
            memberService.save(member);
        }
        return "redirect:/room";
    }

    @GetMapping("/{id}")
    public String enterRoom(@PathVariable("id") Long id, Model model) {
        Record record = new Record();
        record.setSubject(subjectService.findById(id).get());
        model.addAttribute("record", record);

        return "room";
    }
}
