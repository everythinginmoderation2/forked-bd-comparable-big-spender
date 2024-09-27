package com.amazon.ata.comparable_comparator_sort.bigspender.types;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Represents a customer who uses AWS.
 */
public class Customer implements Comparable <Customer>{
    private String name;
    private LocalDate joinDate;

    /**
     * Constructor creating an AWS customer.
     * @param name The unique name of the customer.
     * @param joinDate The Data that the customer joined.
     */
    public Customer(String name, LocalDate joinDate) {
        this.name = name;
        this.joinDate = joinDate;
    }

    public String getName() {
        return name;
    }

    public LocalDate getJoinDate() {
        return joinDate;
    }

    @Override
    public String toString() {
        return "Customer{" +
            "name='" + name + '\'' +
            ", joinDate=" + joinDate +
            '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }

        if (getClass() != o.getClass()) {
            return false;
        }

        if (this == o) {
            return true;
        }

        Customer that = (Customer) o;
        return Objects.equals(name, that.name) &&
            Objects.equals(joinDate, that.joinDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, joinDate);
    }

    @Override
    public int compareTo(Customer o) {
        if (this.getName().compareTo(o.getName()) > 0) return 1;
        else if (this.getName().compareTo(o.getName()) < 0) return -1;
        if (this.getName().compareTo(o.getName()) == 0) {
            if (this.getJoinDate().isAfter(o.getJoinDate())) return 1;
            else if (this.getJoinDate().isBefore(o.getJoinDate())) return -1;
        }
        return 0;
    }
}
