import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "organization")
public class Organization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;
    // @GeneratedValue(generator = "potato")

    // @GenericGenerator(name = "potato", strategy = "increment")


    // @JoinColumn(name = "organization_id")

    @OneToMany(mappedBy = "organization")
    private Set<Priority> priorities;

//    @Column(name="name")
//
//    public void addPriority(Priority priority) {
//        if (priorities == null) {
//            priorities = new HashSet<Priority>();
//        }
//        priorities.add(priority);
//        priority.setOrganization(this);
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Set<Priority> getPriorities() {
        return this.priorities;
    }

    public void setPriorities(Set<Priority> priorities) {
        this.priorities = priorities;
    }
}
