package jpql;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class JpqlTeam {

    @Id @GeneratedValue
    private Long id;
    private String name;

    @OneToMany(mappedBy = "jpqlteam")
    private List<JpqlMember> members = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<JpqlMember> getMember() {
        return members;
    }

    public void setMember(List<JpqlMember> member) {
        this.members = member;
    }
}
