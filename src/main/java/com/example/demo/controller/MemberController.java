package com.example.demo.controller;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Member;
import com.example.demo.service.MemberService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {
    
    private final MemberService memberService;

    @GetMapping("/{memberId}")
    public ResponseEntity<?> getMemberInfo(@PathVariable("memberId") Long memberId) {
        return ResponseEntity.ok(memberService.getMemberInfo(memberId));
    }

    @PostMapping("")
    public ResponseEntity<?> joinMember(@RequestBody Map<String, String> memberInfo) {
        Member member = new Member();
        member.setName(memberInfo.get("name"));
        memberService.joinMember(member);
        return ResponseEntity.ok("Successfully joined");
    }

    @PutMapping("")
    public ResponseEntity<?> updateMember(@RequestBody Map<String, String> memberInfo) {
        Member member = new Member();
        member.setId(Long.parseLong(memberInfo.get("id")));
        member.setName(memberInfo.get("name"));
        memberService.updateMember(member, member.getId());
        return ResponseEntity.ok("Successfully edited");
    }

    @DeleteMapping("/{memberId}")
    public ResponseEntity<?> deleteMember(@PathVariable("memberId") Long memberId) {
        memberService.removeMember(memberId);
        return ResponseEntity.ok("Susccessfully deleted");
    }
}
