package relationShipJpa;

import javax.persistence.*;

@Entity
public class Member {

    //가급적이면 단방향이 좋아, 어쩔수없을때 양방향 추가해
    @Id @GeneratedValue
    @Column(name = "MEMBER_ID")
    long id;
    String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
