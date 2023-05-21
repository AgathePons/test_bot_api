package com.api.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LogDto {
    private Long id;
    private Integer logTaskId;
    private String textContent;
    private Date dateLog;
    private Integer logOrder;
}
