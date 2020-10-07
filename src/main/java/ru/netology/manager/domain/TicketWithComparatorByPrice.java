package ru.netology.manager.domain;

import java.util.Comparator;

public class TicketWithComparatorByPrice implements Comparator<Ticket> {
    @Override
    public int compare(Ticket t1, Ticket t2) {
        return t1.getPrice() - t2.getPrice();
    }
}
