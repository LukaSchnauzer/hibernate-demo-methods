package es.demo.connection.relations;

import javax.persistence.*;

@Entity
@Table(name = "client_details")
public class ClientDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "web")
    private String web;
    @Column(name = "phone")
    private String phone;
    @Column(name = "comments")
    private String comments;

    public ClientDetails() {
    }

    public ClientDetails(String web, String phone, String comments) {
        this.web = web;
        this.phone = phone;
        this.comments = comments;
    }

    public ClientDetails(int id, String web, String phone, String comments) {
        this.id = id;
        this.web = web;
        this.phone = phone;
        this.comments = comments;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "ClientDetails{" +
                "id=" + id +
                ", web='" + web + '\'' +
                ", phone='" + phone + '\'' +
                ", comments='" + comments + '\'' +
                '}';
    }


}
