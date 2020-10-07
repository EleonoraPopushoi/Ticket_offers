package ru.netology.manager.manager;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.netology.manager.domain.Ticket;
import ru.netology.manager.domain.TicketWithComparatorByPrice;
import ru.netology.manager.repository.TicketRepository;

import java.util.Arrays;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TicketManager {
    private TicketRepository repository;

    public void addTicket(Ticket ticket) {
        repository.save(ticket);
    }

    public Ticket[] findAll(String from, String to, TicketWithComparatorByPrice ticketWithComparatorByPrice) {
        Ticket[] result = new Ticket[0];
        for (Ticket ticket : repository.getAll()) {
            int length = result.length;
            if (ticket.getDepartureAirport().equals(from) && ticket.getArrivalAirport().equals(to)) {
                Ticket[] tmp = new Ticket[length + 1];
                System.arraycopy(result, 0, tmp, 0, length);
                int lastIndex = tmp.length - 1;
                tmp[lastIndex] = ticket;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }
}
