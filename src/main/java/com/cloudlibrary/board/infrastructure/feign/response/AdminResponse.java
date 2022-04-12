package com.cloudlibrary.board.infrastructure.feign.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AdminResponse{

    private Long adminId;
    private String adminName;
    private String libraryName;

}
