package com.cloudlibrary.board.infrastructure.feign.client;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "admin-service", url = "ecs-alb-167470959.us-east-1.elb.amazonaws.com/v1")
public interface AdminClient {

    /**
     * TODO @RequestHeader 추가하기
     * 게시글 작성한 admin 정보 가져오기
     */

    @GetMapping("/admin/{adminId}")
    String getAdminInfo(@PathVariable("adminId") Long adminId);
}
