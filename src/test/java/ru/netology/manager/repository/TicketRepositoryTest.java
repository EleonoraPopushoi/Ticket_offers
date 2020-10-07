package ru.netology.manager.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.manager.domain.Ticket;
import ru.netology.manager.manager.TicketManager;
import ru.netology.manager.repository.TicketRepository;

import static org.junit.jupiter.api.Assertions.*;

class TicketRepositoryTest {
    private TicketRepository repository = new TicketRepository();
    TicketManager manager = new TicketManager(repository);

    private Ticket ticket1 = new Ticket(1, 1250, "CGF ", "CGI", 150);
    private Ticket ticket2 = new Ticket(2, 1050, "BVO ", "KUF", 90);
    private Ticket ticket3 = new Ticket(3, 1350, "AGZ ", "BES", 180);
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
        Ticket[] actual = repository.findAll();
        Ticket[] expected = {ticket1, ticket2, ticket3, ticket4};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSave() {
        repository.save(ticketToSave);
        Ticket[] actual = repository.findAll();
        Ticket[] expected = {ticket1, ticket2, ticket3, ticket4, ticketToSave};
        assertArrayEquals(actual, expected);
    }

    @Test
    void shouldFindById() {
        Ticket actual = repository.findById(2);
        Ticket expected = ticket2;
        assertEquals(expected, actual);
    }

    @Test
    void shouldRemoveById() {
        repository.removeById(3);
        Ticket[] actual = repository.findAll();
        Ticket[] expected = {ticket1, ticket2, ticket4};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldRemoveByIdNotExisted() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> repository.removeById(11));
    }

    @Test
    void shouldFindByIdNotExisted() {
        Ticket actual = repository.findById(15);
        assertEquals(null,actual);
    }
}
