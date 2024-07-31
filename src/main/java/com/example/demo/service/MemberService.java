package com.example.demo.service;

import com.example.demo.model.Member;

public interface MemberService {
    void joinMember(Member member);
    Member updateMember(Member member, Long memberId);
    Member getMemberInfo(Long memberId);
    void removeMember(Long memberId);
}
