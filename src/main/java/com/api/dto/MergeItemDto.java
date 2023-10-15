package com.api.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MergeItemDto {
    private Long id;
    private String name;
    private Integer parentId;
    private Integer numberOwned;
    private boolean isRoot;
}
