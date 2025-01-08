package com.example.controller;

import com.example.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/update-required/{id}/{amt}")
    public String updateWithRequired(@PathVariable int id,@PathVariable Double amt)
    {
        accountService.updateBalanceRequired(id,amt);
        return "Updated balance with Required";
    }
    @PostMapping("/update-required-new/{id}/{amt}")
    public String updateWithRequiredNew(@PathVariable int id,@PathVariable Double amt)
    {
        accountService.updateBalanceRequiresNew(id,amt);
        return "Updated balance with Required new";
    }
    @PostMapping("/update-nested/{id}/{amount}")
    public String updateNested(@PathVariable int id, @PathVariable Double amount) {
        accountService.updateBalanceNested(id, amount);
        return "Balance updated with NESTED propagation";
    }
    @PostMapping("/update-supports/{id}/{amount}")
    public String updateSupports(@PathVariable int id, @PathVariable Double amount) {
        accountService.updateBalanceSupports(id, amount);
        return "Balance updated with SUPPORTS propagation";
    }
    @PostMapping("/update-not-supported/{id}/{amount}")
    public String updateNotSupported(@PathVariable int id, @PathVariable Double amount) {
        accountService.updateBalanceNotSupported(id, amount);
        return "Balance updated with NOT_SUPPORTED propagation";
    }

}
