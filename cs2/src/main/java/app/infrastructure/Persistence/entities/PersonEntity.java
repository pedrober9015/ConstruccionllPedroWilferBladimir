package app.infrastructure.persistence.entities;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;

import java.time.LocalDate;

/*
 * Clase base para entidades de personas.
 * Sus atributos son heredados por otras entidades.
 */
@MappedSuperclass
public abstract class PersonEntity {

    // NOMBRE
    @Column(name = "first_name", nullable = false, length = 100)
    private String firstName;

    // APELLIDO
    @Column(name = "last_name", nullable = false, length = 100)
    private String lastName;

    // CORREO ELECTRONICO
    @Column(name = "email", nullable = false, unique = true, length = 150)
    private String email;

    // TELEFONO
    @Column(name = "phone_number", length = 20)
    private String phoneNumber;

    // FECHA DE NACIMIENTO
    @Column(name = "birth_date")
    private LocalDate birthDate;

    // DIRECCION
    @Column(name = "address", length = 255)
    private String address;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}