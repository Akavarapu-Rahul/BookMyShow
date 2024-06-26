package com.scaler.BookMyShow.service;

import com.scaler.BookMyShow.exception.ShowSeatAlreadyBookedException;
import com.scaler.BookMyShow.models.ShowSeat;
import com.scaler.BookMyShow.models.Ticket;
import com.scaler.BookMyShow.models.constants.ShowSeatStatus;
import com.scaler.BookMyShow.repository.ShowSeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TicketServiceImpl implements TicketService{

    @Autowired
    private ShowSeatRepository showSeatRepository;

    @Override
    @Transactional(isolation= Isolation.SERIALIZABLE)
    public Ticket bookTicket(List<Integer> showSeatIds, int userId) throws ShowSeatAlreadyBookedException {
        //TODO - optimize the DB calls
        //check the status of all the seats -> if anyone of them is not available, throw exception
        for(Integer showSeatId :  showSeatIds){
            ShowSeat seat=showSeatRepository.findById(showSeatId).get(); //bulk fetch the showSeats to optimize
            if(!seat.getShowSeatStatus().equals(ShowSeatStatus.AVAILABLE)){
                throw new ShowSeatAlreadyBookedException("Show Seat is booked by someone else");

            }
        }

        //locked the seats
        for(Integer showSeatId : showSeatIds){
            ShowSeat seat=showSeatRepository.findById(showSeatId).get();
            seat.setShowSeatStatus(ShowSeatStatus.LOCKED);
            showSeatRepository.save(seat);

        }

        return new Ticket();
    }

    public List<Ticket> getAllTickets(){
        return null;
    }
}
