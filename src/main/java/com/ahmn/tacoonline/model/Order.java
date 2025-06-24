package com.ahmn.tacoonline.model;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.CreditCardNumber;

public class Order {

    @NotBlank(message = "El nombre es oblibatorio")
    private String name;
    private String street;
    private String city;
    private String state;
    private String zip;

    @CreditCardNumber(message = "¡No es una tarjeta válida!")
    private String ccNumber;
    @Pattern(regexp = "^(0[1-9]1[0-2])([\\/])([2-9][0-9])$", message = "Debe tener un formato MM/AA")
    private String ccExpiration;
    @Digits(integer= 3, fraction = 0, message = "¡CVV inválido!")
    private String ccCVV;
}
