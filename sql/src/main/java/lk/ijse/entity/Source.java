package lk.ijse.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.awt.font.ShapeGraphicAttribute;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Source {
    private int id;
    private String name;
    private String address;
}
