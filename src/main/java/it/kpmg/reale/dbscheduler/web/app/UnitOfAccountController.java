package it.kpmg.reale.dbscheduler.web.app;

import it.kpmg.reale.dbscheduler.entity.UnitOfAccount;
import it.kpmg.reale.dbscheduler.entity.UnitOfAccountView;
import it.kpmg.reale.dbscheduler.service.UnitOfAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/unitofaccount")
@RequiredArgsConstructor
public class UnitOfAccountController {
    private final UnitOfAccountService unitOfAccountService;

    @GetMapping("/{cohort}")
    public List<UnitOfAccountView> getUnitOfAccount(@PathVariable("cohort") int cohort){
        return unitOfAccountService.getUnitOfAccountByCohort(cohort);
    }

    @GetMapping("/")
    public List<UnitOfAccount> getUnitOfAccount(){
        return unitOfAccountService.getUnitOfAccount();
    }
}
