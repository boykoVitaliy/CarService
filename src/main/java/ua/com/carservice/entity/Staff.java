package ua.com.carservice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ua.com.carservice.entity.enums.Position;

import javax.persistence.*;
import java.util.List;

@Table(name = "staff")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Staff {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false,name = "salary")
    private Double salary;
    @Column(nullable = false,name = "first_name")
    private String firstName;
    @Column(nullable = false,name = "last_name")
    private String lastName;

    @Enumerated(value =EnumType.STRING )
    private Position position;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "staffs")
    private List<User> user;


    @ManyToMany
    @JoinTable(name = "service",
            joinColumns = @JoinColumn(name = "id_staff", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "id_inspection", referencedColumnName = "id")
    )
    private List<Inspection> inspections;

}
