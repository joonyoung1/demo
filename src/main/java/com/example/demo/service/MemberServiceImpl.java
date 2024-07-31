package com.example.demo.service;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Member;
import com.example.demo.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberServiceImpl implements MemberService{
    
    private final MemberRepository memberRepository;

    @Override
    @Transactional
    public void joinMember(Member member) {
        memberRepository.save(member);
    }

    @Override
    @CachePut(value = "Member", key = "#memberId", cacheManager = "cacheManager")
    @Transactional
    public Member updateMember(Member member, Long memberId) {
        return memberRepository.save(member);
    }

    @Override
    @Cacheable(value = "Member", key = "#memberId", cacheManager = "cacheManager", unless = "#result == null")
    public Member getMemberInfo(Long memberId) {
        return memberRepository.findOne(memberId);
    }

    @Override
    @CacheEvict(value = "Member", key = "#memberId", cacheManager = "cacheManager")
    @Transactional
    public void removeMember(Long memberId) {
        Member member = memberRepository.findOne(memberId);
        memberRepository.remove(member);
    }
}
