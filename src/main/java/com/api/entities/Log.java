package com.api.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "log")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Log {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "log_task_id", nullable = false)
    private Integer taskId;

    @Column(name = "text_content")
    private String textContent;

    @Column(name = "date_log", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateLog = new Date();

    @Column(name = "log_order", nullable = false)
    private Integer logOrder;
}
