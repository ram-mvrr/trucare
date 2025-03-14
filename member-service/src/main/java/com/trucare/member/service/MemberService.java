package com.trucare.member.service;

import com.trucare.shared.member.MemberDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MemberService {

    // Create Member
    MemberDTO createMember(MemberDTO memberDTO);

    // Validate Member
    boolean validateMember(String memberId);

    // Get Member by ID
    MemberDTO getMemberById(Long id);

    // Get Member by Username
    MemberDTO getMemberByUsername(String memberId);

    // Get all Members
    List<MemberDTO> getAllMembers();

    // Update Member
    MemberDTO updateMember(Long id, MemberDTO memberDTO);

    // Delete Member
    void deleteMember(Long id);
}

