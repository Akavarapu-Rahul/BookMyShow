package com.scaler.BookMyShow.controller;

import com.scaler.BookMyShow.dto.BookTicketRequestDTO;
import com.scaler.BookMyShow.dto.TicketResponseDTO;
import com.scaler.BookMyShow.models.Ticket;
import com.scaler.BookMyShow.service.TicketService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
public class TicketController {
    private TicketService ticketService;

    @PostMapping("/ticket")
    public ResponseEntity createTicket(@RequestBody BookTicketRequestDTO bookTicketRequestDTO){
        //Ticket ticket=-ticketService.bookTicket(bookTicketRequestDTO.getShowSeatIds());
        TicketResponseDTO ticket=new TicketResponseDTO();
        ticket.setAuditoriumName("AUDI 01");
        ticket.setMovieName("SUPER COMMANDO DHRUV");
        ticket.setTotalAmount(400);
        ticket.setTimeOfShow(LocalDateTime.now());
        ticket.setSeatNumbers(List.of("A01","A02"));
        return ResponseEntity.ok(ticket);
    }
}
