package com.amazon.ata.comparable_comparator_sort.bigspender;

import com.amazon.ata.comparable_comparator_sort.bigspender.dao.AwsServiceInvoiceDao;
import com.amazon.ata.comparable_comparator_sort.bigspender.types.Customer;
import com.amazon.ata.comparable_comparator_sort.bigspender.types.CustomerServiceSpend;
import com.amazon.ata.comparable_comparator_sort.bigspender.types.CustomerTotalSpend;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * A class that uses the AWS customer spending data provided by an
 * AwsServiceInvoiceDao to calculate information about the
 * customers.
 */
public class AwsCustomerStatistics {
    private AwsServiceInvoiceDao awsServiceInvoiceDao;

    /**
     * Creates a statistics instance with the provided DAO.
     * @param awsServiceInvoiceDao The AwsServiceInvoiceDao to use
     */
    public AwsCustomerStatistics(AwsServiceInvoiceDao awsServiceInvoiceDao) {
        this.awsServiceInvoiceDao = awsServiceInvoiceDao;
    }

    /**
     * Produces a list of the single service each AWS customer spent the most on,
     * sorted by customer name (ascending).
     * @return A list of CustomerServiceSpend representing the highest service
     *         spend for each customer, sorted by customer name
     */
    public List<CustomerServiceSpend> getTopServiceSpendForEachCustomer() {
        // PARTICIPANTS: Implement according to Javadoc and README
        List<CustomerServiceSpend> newOrderedList = new ArrayList<>();
        List<CustomerServiceSpend> exisistingUnorderedList = awsServiceInvoiceDao.getHighestServiceSpendsForEachCustomer();
        if (exisistingUnorderedList == null) return newOrderedList;
        if (exisistingUnorderedList.size() == 1) newOrderedList.add(exisistingUnorderedList.get(0));
        if (exisistingUnorderedList.size() == 2) {
            CustomerServiceSpend firstSpend = exisistingUnorderedList.get(0);
            CustomerServiceSpend lastSpend = exisistingUnorderedList.get(1);
            Customer firstSpendCustomer = firstSpend.getCustomer();
            Customer lastSpendCustomer = lastSpend.getCustomer();
            if (firstSpendCustomer.compareTo(lastSpendCustomer) == 0) {
                newOrderedList.addAll(exisistingUnorderedList);
                return newOrderedList;
            } else if (firstSpendCustomer.compareTo(lastSpendCustomer) > 0) {
                newOrderedList.add(lastSpend);
                newOrderedList.add(firstSpend);
                return newOrderedList;
            } else if (firstSpendCustomer.compareTo(lastSpendCustomer) < 0) {
                newOrderedList.add(firstSpend);
                newOrderedList.add(lastSpend);
                return newOrderedList;
            }
        }
        for (int i = 0; i < exisistingUnorderedList.size(); i++) {
            CustomerServiceSpend currentSpend = exisistingUnorderedList.get(i);
            CustomerServiceSpend nextSpend = exisistingUnorderedList.get(i + 1);
            Customer currentSpendCustomer = currentSpend.getCustomer();
            Customer nextSpendCustomer = nextSpend.getCustomer();
            if (currentSpendCustomer.compareTo(nextSpendCustomer) == 0) {
                newOrderedList.addAll(exisistingUnorderedList);
                return newOrderedList;
            } else if (currentSpendCustomer.compareTo(nextSpendCustomer) > 0) {
                newOrderedList.add(nextSpend);
                newOrderedList.add(currentSpend);
                return newOrderedList;
            } else if (currentSpendCustomer.compareTo(nextSpendCustomer) < 0) {
                newOrderedList.add(currentSpend);
                newOrderedList.add(nextSpend);
                return newOrderedList;
            }
        }
        return newOrderedList;
    }

    /**
     * Produces a list of *all* service spends of each AWS customer,
     * sorted by total spend (descending), then by the service spend (individual
     * service spend (descending), then service name).
     *
     * @return A list of CustomerServiceSpend, sorted by AWS customer
     * total spend and individual service spend.
     */
    public List<CustomerServiceSpend> getTopItemizedSpends() {
        // PARTICIPANTS: Implement according to Javadoc and README

        return null;
    }
}
