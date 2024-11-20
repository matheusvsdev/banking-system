package com.matheusvsdev.banking_system.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "tb_address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cep;

    @Enumerated(EnumType.STRING)
    private State state;

    private String city;

    private String district;

    private String street;

    private String number;

    private String complement;

    public Address() {
    }

    public Long getId() {
        return id;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
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

        Address address = (Address) object;
        return Objects.equals(id, address.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
