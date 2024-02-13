package br.com.api.vo;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@JsonPropertyOrder({"id", "firstName", "lastName", "address", "gender"})
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PersonVO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;

    private String firstName;

    private String lastName;

    private String address;

    private String gender;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public int hashCode() {
        return Objects.hash(address, firstName, gender, id, lastName);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        PersonVO other = (PersonVO) obj;
        return Objects.equals(address, other.address) && Objects.equals(firstName, other.firstName)
                && Objects.equals(gender, other.gender) && Objects.equals(id, other.id)
                && Objects.equals(lastName, other.lastName);
    }

}
