package com.devmtn30.TDD_Hexagonal.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
interface OrderRepository extends JpaRepository<Order,Long> {
}
