package domain.model.dto;

import java.util.Optional;

/**
 * [會員]
 * 
 * @author cano.su
 * @since 2022/04/30
 */
public class Member {

    /** ID */
    private Long id;
    /** 名字 */
    private String name;
    /** E-mail */
    private String email;
    /** 行動電話 */
    private String phone;

    public Member setId(Long id) {
        this.id = id;
        return this;
    }

    public Member setName(String name) {
        this.name = name;
        return this;
    }

    public Member setEmail(String email) {
        this.email = email;
        return this;
    }

    public Member setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Optional<String> getEmail() {
        return Optional.ofNullable(email);
    }

    public Optional<String> getPhone() {
        return Optional.ofNullable(phone);
    }

    @Override
    public String toString() {
        return "Member [id=" + id + ", name=" + name + ", email=" + email + ", phone=" + phone + "]";
    }

}
