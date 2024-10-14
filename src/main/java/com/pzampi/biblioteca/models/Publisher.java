package com.pzampi.biblioteca.models;

import java.io.Serializable;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_publishers")
public class Publisher implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String address;
    @Lob
    private String about;

    @OneToMany(mappedBy = "publisher")
    private Set<Book> published;

    @OneToMany(mappedBy = "publisher")
    private Set<Author> authors;

    public Publisher() {
    }

    public Publisher(Long id, String name, String address, String about) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.about = about;
    }

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public Set<Book> getPublished() {
        return published;
    }

    
    public Set<Author> getAuthors() {
        return authors;
    }

    public Integer publishedTitles(){
        return published.size();
    }

    public Integer authorPub(){
        return authors.size();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Publisher other = (Publisher) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Publisher [id=" + id + ", name=" + name + ", address=" + address + ", about=" + about + ", published="
                + published + "]";
    }

}
