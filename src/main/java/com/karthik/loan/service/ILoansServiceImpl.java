package com.karthik.loan.service;

import com.karthik.loan.constants.LoanConstants;
import com.karthik.loan.dtos.LoansDto;
import com.karthik.loan.entity.Loans;
import com.karthik.loan.exception.LoanAlreadyExistsException;
import com.karthik.loan.exception.ResourceNotFoundException;
import com.karthik.loan.mapper.LoansMapper;
import com.karthik.loan.repository.LoansRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@RequiredArgsConstructor
public class ILoansServiceImpl implements ILoansService
{
    private final LoansRepository loansRepository;
    @Override
    public void createLoan(String mobileNumber)
    {
        loansRepository.findByMobileNumber(mobileNumber)
                .ifPresent(loan -> {
                    throw new LoanAlreadyExistsException(
                            "Loan already registered with given mobileNumber " + mobileNumber
                    );
                });

        Loans newLoan = createNewLoan(mobileNumber);

        loansRepository.save(newLoan);

    }
    private Loans createNewLoan(String mobileNumber)
    {
        Loans newLoan = new Loans();
        long randomLoanNumber = 100000000000L + new Random().nextInt(900000000);
        newLoan.setLoanNumber(Long.toString(randomLoanNumber));
        newLoan.setMobileNumber(mobileNumber);
        newLoan.setLoanType(LoanConstants.HOME_LOAN);
        newLoan.setTotalLoan(LoanConstants.NEW_LOAN_LIMIT);
        newLoan.setAmountPaid(0);
        newLoan.setOutstandingAmount(LoanConstants.NEW_LOAN_LIMIT);
        return newLoan;
    }



    @Override
    public LoansDto fetchLoan(String mobileNumber) {
        Loans loans = loansRepository.findByMobileNumber(mobileNumber)
                .orElseThrow(() -> new ResourceNotFoundException("Loan", "mobileNumber", mobileNumber)
                );

        LoansDto loansDto = LoansMapper.mapToLoansDto(loans, new LoansDto());
        return loansDto;
    }
}
