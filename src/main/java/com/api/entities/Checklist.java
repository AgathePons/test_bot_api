package com.api.entities;

import com.api.entities.utilEnum.ChecklistStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@Entity
@Table(name = "checklist")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Checklist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "checklist_id", nullable = false)
    private Integer checklistId;

    @Column(name = "checklist_name", nullable = false)
    private String name;

    @Column(name = "status", nullable = false, columnDefinition = "varchar(10) default 'WAITING'")
    @Enumerated(EnumType.STRING)
    private ChecklistStatus status = ChecklistStatus.WAITING;

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
}
