package com.trucare.shared.client;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "member-service", url="http://localhost:8080/api/members") // Eureka service name or API Gateway route
public interface MemberClient {

    @GetMapping("/validate/{memberId}")
    Boolean validateMember(@PathVariable("memberId") String memberId);
}
