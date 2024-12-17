package com.trucare.member.service;

import com.trucare.document.shared.member.MemberDTO;
import java.util.List;

public interface MemberService {

    // Create Member
    MemberDTO createMember(MemberDTO memberDTO);

    // Get Member by ID
    MemberDTO getMemberById(Long id);

    // Get Member by Username
    MemberDTO getMemberByUsername(String username);

    // Get all Members
    List<MemberDTO> getAllMembers();

    // Update Member
    MemberDTO updateMember(Long id, MemberDTO memberDTO);

    // Delete Member
    void deleteMember(Long id);
}

