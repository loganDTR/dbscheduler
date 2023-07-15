package it.kpmg.reale.dbscheduler.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(
                name = "UnitOfAccountView.getUnitOfAccountByCohort",
                procedureName = "IRFSS17.UNIT_OF_ACCOUNT.GET_UNIT_OF_ACCOUNT_BY_COHORT",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "COHORT", type = Integer.class)
                },
                resultClasses = UnitOfAccountView.class
        )
})
@Data
public class UnitOfAccountView {
    @Id
    @Column(name = "ID_UNIT_OF_ACCOUNT")
    private int idUnitOfAccount;
    @Column(name = "UNIT_OF_ACCOUNT")
    private String unitOfAccount;
    @Column(name = "COHORT")
    private int cohort;
}
