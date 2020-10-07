package ru.netology.manager.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.manager.TicketRepository;
import ru.netology.manager.domain.Ticket;
import ru.netology.manager.domain.TicketByPriceAscComparator;


import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class TicketManagerTest {
    private TicketRepository repository = new TicketRepository();
    private TicketManager manager = new TicketManager(repository);

    private Ticket ticket1 = new Ticket(1, 1250, "CGF", "CGI", 150);
    private Ticket ticket2 = new Ticket(2, 1050, "BVO", "KUF", 90);
    private Ticket ticket3 = new Ticket(3, 1350, "AGZ", "BES", 180);
    private Ticket ticket4 = new Ticket(4, 2150, "TOF", "KUF", 550);
    private Ticket ticketToSave = new Ticket(5, 1050, "TOF", "KUF", 70);

    @BeforeEach
    @Test
    void setUp() {
        repository.save(ticket1);
        repository.save(ticket2);
        repository.save(ticket3);
        repository.save(ticket4);
    }

    @Test
    void shouldFindAll() {
        Ticket[] actual = manager.findAll("BVO", "KUF", new TicketByPriceAscComparator());
        Ticket[] expected = {ticket2};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindNothing() {
        Ticket[] actual = manager.findAll("KZN", "LED", new TicketByPriceAscComparator());
        Ticket[] expected = {};
        assertArrayEquals(expected, actual);
    }
}
