package it.kpmg.reale.dbscheduler.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "NL_UNIT_OF_ACCOUNT", schema = "UNIT_OF_ACCOUNT", catalog = "IRFSS17")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UnitOfAccount implements Serializable {

    @Serial
    private static final long serialVersionUID = 547291276769325948L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_UNIT_OF_ACCOUNT")
    private Integer idUnitOfAccount;
    @Column(name = "COHORT", nullable = false)
    private int cohort;
    @Column(name = "ID_PORTFOLIO_IFRS_17", nullable = false)
    private int idPortfolioIFRS17;
}
