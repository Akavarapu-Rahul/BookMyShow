package com.scaler.BookMyShow.models;

import com.scaler.BookMyShow.models.constants.BaseModel;
import com.scaler.BookMyShow.models.constants.TicketStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
public class Ticket extends BaseModel {
    private double totalAmount;
    private LocalDateTime timeOfBooking;

    @ManyToMany
    private List<ShowSeat> showSeats;
    @ManyToOne
    private Show show;
    @Enumerated(EnumType.STRING)
    private TicketStatus ticketStatus;

}
