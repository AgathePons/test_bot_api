package com.api.dto;

import com.api.entities.Log;
import com.api.entities.utilEnum.TaskStatus;
import lombok.*;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
public class TaskWithLogDto extends TaskDto {
    private List<LogDto> logs;
}
