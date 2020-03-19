package ua.com.carservice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

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

    @Column(nullable = false, name = "last_name")
    private String lastName;
    @Column(nullable = false, name = "first_name")
    private String firstName;
    @Column(unique = true,name = "email")
    private String email;
    @Column(unique = true)
    private String password;
    @Column(unique = true)
    private Long number;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Car> cars;

    @ManyToMany
    @JoinTable(name = "goods_bucket",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "goods_id", referencedColumnName = "id")
    )
    private List<Goods> goods;

}
