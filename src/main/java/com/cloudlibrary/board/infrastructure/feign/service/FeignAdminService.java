package com.cloudlibrary.board.infrastructure.feign.service;

import com.cloudlibrary.board.infrastructure.feign.client.AdminClient;
import com.cloudlibrary.board.infrastructure.feign.response.AdminResponse;
import org.json.JSONObject;
import org.springframework.stereotype.Service;


@Service
public class FeignAdminService {

    private final AdminClient adminClient;

    public FeignAdminService(AdminClient adminClient) {
        this.adminClient = adminClient;
    }

    public AdminResponse getAdmin() {
        String adminInfo = adminClient.getAdminInfo(1L);

        JSONObject adminObject = new JSONObject(adminInfo);
        JSONObject data = adminObject.getJSONObject("data");

        return AdminResponse.builder()
                .adminId(data.getLong("adminId"))
                .adminName(data.getString("adminName"))
                .libraryName(data.getString("libraryName"))
                .build();
    }

}
