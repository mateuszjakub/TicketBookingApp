package pl.touk.ticketbookingapp.model.entity;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public enum Ticket {

    ADULT(25), STUDENT(18), CHILD(12.50);

    private BigDecimal price;

    Ticket(double price) {
        this.price = BigDecimal.valueOf(price);
    }
}
