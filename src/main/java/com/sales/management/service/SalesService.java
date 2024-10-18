package com.sales.management.service;

import com.sales.management.model.Sales;

import java.util.List;

public interface SalesService {
    List<Sales> getAllSales();
    void addSales(Sales sales);
     Sales showSalesDetails(Long id);
    void editSales(Sales updatedSale);
}
