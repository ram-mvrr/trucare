package com.trucare.member.mapper;


import com.trucare.member.model.Member;
import com.trucare.document.shared.member.MemberDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface MemberMapper {

    MemberMapper INSTANCE = Mappers.getMapper(MemberMapper.class);

    Member memberDtoToMember(MemberDTO memberDTO);

    MemberDTO memberToMemberDto(Member member);
}
