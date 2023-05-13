package com.api.dto;

import com.api.entities.utilEnum.TaskStatus;
import lombok.*;

import java.time.LocalTime;
import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TaskDto {
    private Long id;
    private Integer taskId;
    private String name;
    private TaskStatus status;
    private LocalTime runTime;
    private Date lastRun;
    private Boolean displayed;
    private Boolean playable;
}
