package com.karthik.loan.service;

import com.karthik.loan.dtos.LoansDto;

public interface ILoansService
{
    /**
     *
     * @param mobileNumber - Mobile Number of the Customer
     */
    void createLoan(String mobileNumber);


    /**
     *
     * @param mobileNumber - Input mobile Number
     *  @return Loan Details based on a given mobileNumber
     */
    LoansDto fetchLoan(String mobileNumber);
}
