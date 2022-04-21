package com.cloudlibrary.board.infrastructure.query.http.feign.service;

import com.cloudlibrary.board.infrastructure.query.http.feign.client.AdminClient;
import com.cloudlibrary.board.infrastructure.query.http.feign.response.AdminResponse;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class FeignAdminService {

    private final AdminClient adminClient;

    public FeignAdminService(AdminClient adminClient) {
        this.adminClient = adminClient;
    }

    public Long getAdminInfo(Long adminId) {

        Optional<AdminResponse> result = adminClient.getAdminRequest(adminId);

        return result.get().getAdminId();
    }

}
