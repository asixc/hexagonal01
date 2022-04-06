package com.example.core.usescases;

import com.example.core.domain.Cart;
import com.example.core.domain.Product;
import com.example.ports.in.StockReportInPort;
import com.example.ports.out.StockReportOutPort;

import java.util.*;

public class StockReportUseCase implements StockReportInPort {

    private final ProductCRUDUseCase productCrud;
    private final CartCRUDUseCase cartCrud;
    private final StockReportOutPort stockReportOutPort;

    public StockReportUseCase(ProductCRUDUseCase productCrud, CartCRUDUseCase cartCrud, StockReportOutPort stockReportOutPort) {
        this.productCrud = productCrud;
        this.cartCrud = cartCrud;
        this.stockReportOutPort = stockReportOutPort;
    }

    @Override
    public void generateDailyReport() {
        final List<Cart> ordersPaid = this.cartCrud.getAllCartsPaid();
        if (ordersPaid.size() > 0) {
            final List<Product> productsStock = this.productCrud.findAll();

            ordersPaid.forEach(
                    order -> order.getProducts().forEach(
                            productOrder -> productsStock.stream().filter(p -> p.getId() == productOrder.getId())
                                    .findFirst().get().reduceStock()
                    ));
            final Map<String, String> stockReport = new HashMap<>();

            final List<Product> products = this.productCrud.findAll();
            productsStock.forEach(pr -> {
                stockReport.put(pr.getName(), "Hay [" + products.stream().filter(prstock -> prstock.getId() == pr.getId()).findFirst().get().getStock() + "] -> quedarán [" + pr.getStock()  + "]" );
            });
            final Double totalInvoiced  = ordersPaid.stream()
                    .map(Cart::getProducts)
                    .flatMap(List::stream)
                    .map(Product::getPrice)
                    .reduce(0.0, Double::sum);
            stockReport.put("Total Invoice", totalInvoiced.toString());
            this.stockReportOutPort.saveReport(stockReport);
        }

    }
}
