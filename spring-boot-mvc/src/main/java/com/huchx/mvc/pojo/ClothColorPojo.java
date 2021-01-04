package com.huchx.mvc.pojo;

import javafx.scene.paint.Color;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
public @Data class ClothColorPojo implements Serializable {
    private Color color;

}
