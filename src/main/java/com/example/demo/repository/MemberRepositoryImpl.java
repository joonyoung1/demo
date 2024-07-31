package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Member;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepository {
    private final EntityManager entityManager;

    @Override
    public Member save(Member member) {
        if (member.getId() == null) {
            entityManager.persist(member);
        } else {
            Member findMember = entityManager.find(Member.class, member.getId());
            findMember.setName(member.getName());
        }

        return member;
    }

    @Override
    public Member findOne(Long memberId) {
        return entityManager.find(Member.class, memberId);
    }

    @Override
    public void remove(Member member) {
        entityManager.remove(member);
    }
}
