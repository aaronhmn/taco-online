package com.ahmn.tacoonline.model;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.CreditCardNumber;

@Data
public class Order {

    @NotBlank(message = "El nombre es obligatorio")
    private String deliveryName;
    @NotBlank(message = "La calle es obligatoria")
    private String deliveryStreet;
    @NotBlank(message = "La ciudad es obligatoria")
    private String deliveryCity;
    @NotBlank(message = "El state es obligatorio")
    private String deliveryState;
    @NotBlank(message = "El zip es obligatorio")
    private String deliveryZip;

    @CreditCardNumber(message = "¡No es una tarjeta válida!")
    private String ccNumber;
    @Pattern(regexp = "^(0[1-9]1[0-2])([\\/])([2-9][0-9])$", message = "Debe tener un formato MM/AA")
    private String ccExpiration;
    @Digits(integer= 3, fraction = 0, message = "¡CVV inválido!")
    private String ccCVV;
}
