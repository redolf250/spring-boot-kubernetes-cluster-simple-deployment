package com.redolf.kubernetes.response;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class Message {
    private int productId;
    private int statusCode;
    private String body;
    private Date dateStamp;
}
