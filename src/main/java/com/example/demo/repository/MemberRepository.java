package com.example.demo.repository;

import com.example.demo.model.Member;

public interface MemberRepository {
    Member save(Member member);
    Member findOne(Long memberId);
    void remove(Member member);
}
