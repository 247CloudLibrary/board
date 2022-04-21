package com.cloudlibrary.board.infrastructure.query.http.feign.response;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class AdminResponse{

    private Long adminId;
    private String adminName;
    private String libraryName;

}
