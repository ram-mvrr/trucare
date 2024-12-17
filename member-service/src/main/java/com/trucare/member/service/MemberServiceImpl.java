package com.trucare.member.service;


import com.trucare.member.mapper.MemberMapper;
import com.trucare.member.model.Member;
import com.trucare.member.repository.MemberRepository;
import com.trucare.document.shared.member.MemberDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;
    private final MemberMapper memberMapper;

    @Autowired
    public MemberServiceImpl(MemberRepository memberRepository, MemberMapper memberMapper) {
        this.memberRepository = memberRepository;
        this.memberMapper = memberMapper;
    }

    // Create Member
    @Transactional
    public MemberDTO createMember(MemberDTO memberDTO) {
        if (memberRepository.existsByUsername(memberDTO.getUsername())) {
            throw new RuntimeException("Username already exists.");
        }
        Member member = memberMapper.memberDtoToMember(memberDTO);
        member = memberRepository.save(member);
        return memberMapper.memberToMemberDto(member);
    }

    // Get Member by ID
    public MemberDTO getMemberById(Long id) {
        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Member not found with id " + id));
        return memberMapper.memberToMemberDto(member);
    }

    // Get Member by Username
    public MemberDTO getMemberByUsername(String username) {
        Member member = memberRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Member not found with username " + username));
        return memberMapper.memberToMemberDto(member);
    }

    // Get all Members
    public List<MemberDTO> getAllMembers() {
        List<Member> members = memberRepository.findAll();
        return members.stream()
                .map(memberMapper::memberToMemberDto)
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
        return memberMapper.memberToMemberDto(member);
    }

    // Delete Member
    @Transactional
    public void deleteMember(Long id) {
        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Member not found with id " + id));
        memberRepository.delete(member);
    }
}
