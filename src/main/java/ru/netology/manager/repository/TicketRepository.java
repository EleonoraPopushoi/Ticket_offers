package ru.netology.manager.repository;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.netology.manager.domain.Ticket;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TicketRepository {
    private Ticket[] tickets = new Ticket[0];

    public Ticket[] getAll() {
        return tickets;
    }

    public Ticket[] findAll() {
        return tickets;
    }

    public Ticket[] save(Ticket ticket) {
        int length = tickets.length + 1;
        Ticket[] tmp = new Ticket[length];
        System.arraycopy(tickets, 0, tmp, 0, tickets.length);
        tmp[tmp.length - 1] = ticket;
        tickets = tmp;
        return tmp;
    }

    public Ticket findById(int id) {
        for (Ticket ticket : tickets) {
            if (ticket.getId() == id) {
                return ticket;
            }
        }
        return null;
    }

    public void removeById(int id) {
        int length = tickets.length - 1;
        Ticket[] tmpArray = new Ticket[length];
        int i = 0;
        for (Ticket ticket : tickets) {
            if (ticket.getId() != id) {
                tmpArray[i] = ticket;
                i++;
            }
        }
        tickets = tmpArray;
    }

    public void removeAll() {
        tickets = new Ticket[0];
    }
}
