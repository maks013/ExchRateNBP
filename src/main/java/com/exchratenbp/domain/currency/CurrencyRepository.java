package com.exchratenbp.domain.currency;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface CurrencyRepository extends JpaRepository<CurrencyRequest, Long> {
}
