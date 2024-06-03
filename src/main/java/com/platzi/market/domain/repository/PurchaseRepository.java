package com.platzi.market.domain.repository;

import com.platzi.market.domain.Purchase;

import java.util.List;
import java.util.Optional;

public interface PurchaseRepository {
    List<Purchase> getAll();
    // se pone optional ya que en ocaciones no haya clientes con compras
    Optional<List<Purchase>> getByClient(String clientId);
    Purchase save(Purchase purchase);
}
