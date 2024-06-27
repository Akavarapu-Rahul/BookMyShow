package com.scaler.BookMyShow.service;

import com.scaler.BookMyShow.exception.ShowSeatAlreadyBookedException;
import com.scaler.BookMyShow.models.ShowSeat;
import com.scaler.BookMyShow.models.Ticket;
import com.scaler.BookMyShow.models.User;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface TicketService {

    @Transactional(isolation= Isolation.SERIALIZABLE)
    Ticket bookTicket(List<Integer> showSeatIds, int userId) throws ShowSeatAlreadyBookedException;
}
