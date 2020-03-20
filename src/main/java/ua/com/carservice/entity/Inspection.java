package ua.com.carservice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "goods")
public class Inspection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private Double price;
    @Column(nullable = false)
    private String support;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "inspections")
    private List<User> user;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "inspections")
    private List<Staff> staffs;


}
