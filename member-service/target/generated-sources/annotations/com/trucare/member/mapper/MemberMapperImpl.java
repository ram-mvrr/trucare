package com.trucare.member.mapper;

import com.trucare.member.model.Member;
import com.trucare.shared.member.MemberDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-03-13T16:43:34+0530",
    comments = "version: 1.6.2, compiler: javac, environment: Java 17.0.10 (Oracle Corporation)"
)
@Component
public class MemberMapperImpl implements MemberMapper {

    @Override
    public Member toDO(MemberDTO memberDTO) {
        if ( memberDTO == null ) {
            return null;
        }

        Member member = new Member();

        member.setId( memberDTO.getId() );
        member.setUsername( memberDTO.getUsername() );
        member.setFirstName( memberDTO.getFirstName() );
        member.setLastName( memberDTO.getLastName() );
        member.setDateOfBirth( memberDTO.getDateOfBirth() );
        member.setGender( memberDTO.getGender() );
        member.setContactNumber( memberDTO.getContactNumber() );
        member.setAddress( memberDTO.getAddress() );
        List<Long> list = memberDTO.getDocumentIds();
        if ( list != null ) {
            member.setDocumentIds( new ArrayList<Long>( list ) );
        }

        return member;
    }

    @Override
    public MemberDTO toDTO(Member member) {
        if ( member == null ) {
            return null;
        }

        MemberDTO memberDTO = new MemberDTO();

        memberDTO.setId( member.getId() );
        memberDTO.setUsername( member.getUsername() );
        memberDTO.setFirstName( member.getFirstName() );
        memberDTO.setLastName( member.getLastName() );
        memberDTO.setDateOfBirth( member.getDateOfBirth() );
        memberDTO.setGender( member.getGender() );
        memberDTO.setContactNumber( member.getContactNumber() );
        memberDTO.setAddress( member.getAddress() );
        List<Long> list = member.getDocumentIds();
        if ( list != null ) {
            memberDTO.setDocumentIds( new ArrayList<Long>( list ) );
        }

        return memberDTO;
    }
}
