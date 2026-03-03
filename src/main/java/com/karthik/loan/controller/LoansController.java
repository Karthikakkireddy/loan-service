package com.karthik.loan.controller;

import com.karthik.loan.constants.LoanConstants;
import com.karthik.loan.dtos.LoansDto;
import com.karthik.loan.dtos.ResponseDto;
import com.karthik.loan.service.ILoansService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path= "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
@RequiredArgsConstructor
public class LoansController
{

    private final ILoansService iLoansService;

    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createLoans(@RequestParam String mobileNumber)
    {
        iLoansService.createLoan(mobileNumber);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(LoanConstants.STATUS_201, LoanConstants.MESSAGE_201));
    }

    @GetMapping("/fetch")
    public ResponseEntity<ResponseDto> fetchLoanDetails(@RequestParam String mobileNumber)
    {
        LoansDto loansDto = iLoansService.fetchLoan(mobileNumber);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ResponseDto(LoanConstants.STATUS_200, LoanConstants.MESSAGE_200));

    }
}
