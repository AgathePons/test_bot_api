package com.api.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ConfigDto {
    private Long id;
    private String name;
    private String value;
}
