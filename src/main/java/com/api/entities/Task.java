package com.api.entities;

import com.api.entities.utilEnum.TaskStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "task")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "logs")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "task_id", nullable = false)
    private Integer taskId;

    @Column(name = "task_name", nullable = false, unique = true)
    private String name;

    @Column(name = "status", nullable = false, columnDefinition = "varchar(10) default 'WAITING'")
    @Enumerated(EnumType.STRING)
    private TaskStatus status = TaskStatus.WAITING;

    @Column(name = "run_time", nullable = false, columnDefinition = "TIME DEFAULT '10:00:00'")
    @Temporal(TemporalType.TIME)
    private LocalTime runTime = LocalTime.of(10, 0, 0);

    @Column(name = "last_run")
    @Temporal(TemporalType.DATE)
    private Date lastRun;

    @Column(name = "displayed", nullable = false)
    private Boolean displayed = false;

    @Column(name = "playable", nullable = false)
    private Boolean playable = false;

    @OneToMany(mappedBy = "task", cascade = CascadeType.ALL)
    @Builder.Default
    private Set<Log> logs = new HashSet<>();
}
