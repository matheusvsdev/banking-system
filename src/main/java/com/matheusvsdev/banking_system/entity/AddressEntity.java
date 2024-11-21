package com.matheusvsdev.banking_system.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "tb_address")
public class AddressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String zipCode;

    @Enumerated(EnumType.STRING)
    private State state;

    private String city;

    private String district;

    private String street;

    private String number;

    private String complement;

    public AddressEntity() {
    }

    public AddressEntity(Long id, String zipCode, State state, String city, String district, String street, String number, String complement) {
        this.id = id;
        this.zipCode = zipCode;
        this.state = state;
        this.city = city;
        this.district = district;
        this.street = street;
        this.number = number;
        this.complement = complement;
    }

    public Long getId() {
        return id;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public enum State {
        AC("Acre"),
        AL("Alagoas"),
        AM("Amazonas"),
        AP("Amapá"),
        BA("Bahia"),
        CE("Ceará"),
        DF("Distrito Federal"),
        ES("Espírito Santo"),
        GO("Goiás"),
        MA("Maranhão"),
        MG("Minas Gerais"),
        MS("Mato Grosso do Sul"),
        MT("Mato Grosso"),
        PA("Pará"),
        PB("Paraíba"),
        PE("Pernambuco"),
        PI("Piauí"),
        PR("Paraná"),
        RJ("Rio de Janeiro"),
        RN("Rio Grande do Norte"),
        RO("Rondônia"),
        RR("Roraima"),
        RS("Rio Grande do Sul"),
        SC("Santa Catarina"),
        SE("Sergipe"),
        SP("São Paulo"),
        TO("Tocantins");

        private final String stateName;

        State(String stateName) {
            this.stateName = stateName;
        }

        public String getStateName() {
            return stateName;
        }
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        AddressEntity address = (AddressEntity) object;
        return Objects.equals(id, address.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
