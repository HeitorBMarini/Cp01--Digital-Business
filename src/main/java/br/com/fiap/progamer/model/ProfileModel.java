package br.com.fiap.progamer.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * 
 */
@Entity
@Table(name="TB_PROFILE")
public class ProfileModel {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private String name;
    private String email;
    private String profile;
    private String password;
	private long id;

    // getters and setters

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getProfile() {
        return profile;
    }
    public void setProfile(String profile) {
        this.profile = profile;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    @Override
    public String toString() {
        return "ProfileModel [name=" + name + ", email=" + email + ", profile=" + profile + ", password=" + password + "]";
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
}