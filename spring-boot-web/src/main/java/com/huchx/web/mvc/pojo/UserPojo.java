package com.huchx.web.mvc.pojo;

import lombok.*;

import java.awt.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public @Data class UserPojo {
    private String name;
    private String age;
    private List<String> roles;
    private Color color;
}
