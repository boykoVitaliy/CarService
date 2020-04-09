package ua.com.carservice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Builder
@Entity
@Table(name="users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false)
    private String firstName;
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String password;
    @Column(unique = true)
    private Long number;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Car> cars;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "goods_bucket",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "goods_id", referencedColumnName = "id")
    )
    private List<Goods> goods;

    @ManyToMany
    @JoinTable(name = "service",
            joinColumns = @JoinColumn(name = "id_user", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "id_staff", referencedColumnName = "id")
    )
    private List<Staff> staffs;

    @ManyToMany
    @JoinTable(name = "service",
            joinColumns = @JoinColumn(name = "id_user", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "id_inspection", referencedColumnName = "id")
    )
    private List<Inspection> inspections;

}
