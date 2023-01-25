package jpql;

import javax.persistence.*;

@Entity
public class JpqlMember {

    @Id @GeneratedValue
    private Long id;
    private String username;
    private int age;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TEAM_ID")
    private JpqlTeam team;

    public void changeTeam(JpqlTeam jpqlTeam){
        this.team = jpqlTeam;
        team.getMember().add(this);
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "JpqlMember{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", age=" + age +
                '}';
    }

    public JpqlTeam getTeam() {
        return team;
    }

    public void setTeam(JpqlTeam team) {
        this.team = team;
    }
}
