package com.api.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "merge_item")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MergeItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "parent_id", unique = true)
    private Integer parentId;

    @Column(name = "number_owned", nullable = false, columnDefinition = "integer default 0")
    private Integer numberOwned;

    @Column(name = "is_root")
    private boolean isRoot;
}
