package ua.com.carservice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ua.com.carservice.entity.enums.Color;

import javax.persistence.*;
import java.util.Set;

@Builder
@Entity
@Table(name = "car")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "firm")
    private String firm;
    @Column(nullable = false)
    private String model;
    @Column(nullable = false)
    private int year;
    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private Color color;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

}
