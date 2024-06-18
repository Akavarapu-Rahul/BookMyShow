package com.scaler.BookMyShow.models;

import com.scaler.BookMyShow.models.constants.BaseModel;
import com.scaler.BookMyShow.models.constants.SeatType;
import com.scaler.BookMyShow.models.constants.Status;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Seat extends BaseModel {
    private String seatNumber;
    @Enumerated(EnumType.STRING)
    private SeatType seatType;
    @Enumerated(EnumType.STRING)
    private Status status;

}
