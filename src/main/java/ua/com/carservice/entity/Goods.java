package ua.com.carservice.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Goods {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Double price;
    @Column(nullable = false)
    private String firm;
    @Column(nullable = false)
    private String category;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "goods")
    private List<User> user;


}
