package com.karthik.loan.repository;

import com.karthik.loan.entity.Loans;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LoansRepository extends JpaRepository<Loans, Long>
{
    Optional<Loans> findByMobileNumber(String mobileNumber);
}
