package com.scaler.BookMyShow.service;

import com.scaler.BookMyShow.exception.ShowSeatAlreadyBookedException;
import com.scaler.BookMyShow.models.ShowSeat;
import com.scaler.BookMyShow.models.Ticket;
import com.scaler.BookMyShow.models.User;

import java.util.List;

public interface TicketService {
    Ticket bookTicket(List<Integer> showSeatIds, User user) throws ShowSeatAlreadyBookedException;
}
