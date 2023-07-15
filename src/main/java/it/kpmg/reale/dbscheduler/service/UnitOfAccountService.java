package it.kpmg.reale.dbscheduler.service;

import it.kpmg.reale.dbscheduler.entity.UnitOfAccount;
import it.kpmg.reale.dbscheduler.entity.UnitOfAccountView;
import it.kpmg.reale.dbscheduler.repository.UnitOfAccountRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.StoredProcedureQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UnitOfAccountService {
    private final EntityManager entityManager;

    private final UnitOfAccountRepository unitOfAccountRepository;

    public List<UnitOfAccount> getUnitOfAccount(){
        return unitOfAccountRepository.findAll();
    }

    public List<UnitOfAccountView> getUnitOfAccountByCohort(int cohort) {
        StoredProcedureQuery query = entityManager.createNamedStoredProcedureQuery("UnitOfAccountView.getUnitOfAccountByCohort");
        query.setParameter("COHORT", cohort);
        query.execute();

        return query.getResultList();
    }
}