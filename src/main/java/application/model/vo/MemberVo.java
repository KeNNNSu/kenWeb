package application.model.vo;

import application.model.data.Person;

/**
 * [MemberVo]
 * 
 * @author cano.su
 * @since 2022/04/30
 */
public class MemberVo {

    private String id;
    private Person person;

    public MemberVo setId(String id) {
        this.id = id;
        return this;
    }

    public MemberVo setPerson(Person person) {
        this.person = person;
        return this;
    }

    public String getId() {
        return id;
    }

    public Person getPerson() {
        return person;
    }

    @Override
    public String toString() {
        return "MemberVo [id=" + id + ", person=" + person + "]";
    }

}
