package com.company.models;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Loggerr {
    private String reference;
    private Boolean scam;
    private String[] rules;
}
