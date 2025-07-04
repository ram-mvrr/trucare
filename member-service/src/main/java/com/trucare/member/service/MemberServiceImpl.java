package com.trucare.member.service;


import com.trucare.member.mapper.MemberMapper;
import com.trucare.member.model.Member;
import com.trucare.member.repository.MemberRepository;
import com.trucare.shared.member.MemberDTO;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;
    private final MemberMapper memberMapper;

    public MemberServiceImpl(MemberRepository memberRepository, MemberMapper memberMapper) {
        this.memberRepository = memberRepository;
        this.memberMapper = memberMapper;
    }

    // Create Member
    @Transactional
    public MemberDTO createMember(MemberDTO memberDTO) {

        String memberId = "M"+ UUID.randomUUID().toString().substring(0,6).toUpperCase();
        if (memberRepository.existsByUsername(memberDTO.getUsername())) {
            throw new RuntimeException("Username already exists.");
        }
        Member member = memberMapper.toDO(memberDTO);
        member.setMemberId(memberId);
        member = memberRepository.save(member);
        return memberMapper.toDTO(member);
    }

    @Override
    @Cacheable(value = "members", key = "#memberId")
    public boolean validateMember(String memberId) {
        System.out.println("Validating member: " + memberId);
        Optional<Member> member = memberRepository.findByMemberId(memberId);
        return memberId !=null && member.isPresent();
    }

    // Get Member by ID
    public MemberDTO getMemberById(Long id) {
        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Member not found with id " + id));
        return memberMapper.toDTO(member);
    }

    @Override
    public MemberDTO getMemberByMemberId(String memberId) {
        Member member = memberRepository.findByMemberId(memberId)
                .orElseThrow(() -> new RuntimeException("Member not found with id"+ memberId) );

        return memberMapper.toDTO(member);
    }


    // Get Member by Username
    public MemberDTO getMemberByUsername(String username) {
        Member member = memberRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Member not found with username " + username));
        return memberMapper.toDTO(member);
    }

    // Get all Members
    public List<MemberDTO> getAllMembers() {
        List<Member> members = memberRepository.findAll();
        return members.stream()
                .map(memberMapper::toDTO)
                .toList();
    }

    // Update Member
    @Transactional
    public MemberDTO updateMember(Long id, MemberDTO memberDTO) {
        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Member not found with id " + id));
        member.setFirstName(memberDTO.getFirstName());
        member.setLastName(memberDTO.getLastName());
        member.setDateOfBirth(memberDTO.getDateOfBirth());
        member.setGender(memberDTO.getGender());
        member.setContactNumber(memberDTO.getContactNumber());
        member.setAddress(memberDTO.getAddress());
        member.setUsername(memberDTO.getUsername());
        member.setDocumentIds(memberDTO.getDocumentIds());

        member = memberRepository.save(member);
        return memberMapper.toDTO(member);
    }

    // Delete Member
    @Transactional
    public void deleteMember(Long id) {
        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Member not found with id " + id));
        memberRepository.delete(member);
    }
}
