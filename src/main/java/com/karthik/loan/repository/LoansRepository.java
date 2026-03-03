package com.karthik.loan.repository;

import com.karthik.loan.entity.Loans;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoansRepository extends JpaRepository<Loans, Long>
{

}
