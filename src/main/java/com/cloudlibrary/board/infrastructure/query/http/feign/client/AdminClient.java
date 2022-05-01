package com.cloudlibrary.board.infrastructure.query.http.feign.client;


import com.cloudlibrary.board.infrastructure.configuration.FeignClientConfiguration;
import com.cloudlibrary.board.infrastructure.query.http.feign.response.AdminResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient(name = "admin-api",
            url = "${feign.admin-api.url",
            configuration = {FeignClientConfiguration.class})
public interface AdminClient {

    /**
     * TODO @RequestHeader 추가하기
     * 게시글 작성한 admin 정보 가져오기
     */

    @GetMapping("/admin/{adminId}")
    Optional<AdminResponse> getAdminRequest(@PathVariable("adminId") Long adminId);

}