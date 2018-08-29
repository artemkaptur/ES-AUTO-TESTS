package com.epam.esauto.entity;

import java.util.Objects;

public class Order {
    private String name;
    private String tickets;
    private String date;
    private String time;
    private String seats;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTickets() {
        return tickets;
    }

    public void setTickets(String tickets) {
        this.tickets = tickets;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getSeats() {
        return seats;
    }

    public void setSeats(String seats) {
        this.seats = seats;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(name, order.name) &&
                Objects.equals(tickets, order.tickets) &&
                Objects.equals(date, order.date) &&
                Objects.equals(time, order.time) &&
                Objects.equals(seats, order.seats);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, tickets, date, time, seats);
    }

    @Override
    public String toString() {
        return "Order{" +
                "name='" + name + '\'' +
                ", tickets='" + tickets + '\'' +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", seats='" + seats + '\'' +
                '}';
    }
}
