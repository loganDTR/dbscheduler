create database IRFSS17
go
create schema UNIT_OF_ACCOUNT
go
create table UNIT_OF_ACCOUNT.NL_UNIT_OF_ACCOUNT
(
    ID_UNIT_OF_ACCOUNT   int identity,
    COHORT               int not null,
    ID_PORTFOLIO_IFRS_17 int not null
)
go
create table UNIT_OF_ACCOUNT.NL_UNIT_OF_ACCOUNT_DESCR
(
    ID                   int identity,
    ID_UNIT_OF_ACCOUNT   int not null,
    UNIT_OF_ACCOUNT      varchar(50) not null
)
go

insert into UNIT_OF_ACCOUNT.NL_UNIT_OF_ACCOUNT values (2021,2)
insert into UNIT_OF_ACCOUNT.NL_UNIT_OF_ACCOUNT values (2021,33)
insert into UNIT_OF_ACCOUNT.NL_UNIT_OF_ACCOUNT values (2022,33)
insert into UNIT_OF_ACCOUNT.NL_UNIT_OF_ACCOUNT values (2022,1)
insert into UNIT_OF_ACCOUNT.NL_UNIT_OF_ACCOUNT values (2022,2)
insert into UNIT_OF_ACCOUNT.NL_UNIT_OF_ACCOUNT_DESCR values (1,'Unit001')
insert into UNIT_OF_ACCOUNT.NL_UNIT_OF_ACCOUNT_DESCR values (2,'Unit002')
insert into UNIT_OF_ACCOUNT.NL_UNIT_OF_ACCOUNT_DESCR values (3,'Unit003')
insert into UNIT_OF_ACCOUNT.NL_UNIT_OF_ACCOUNT_DESCR values (4,'Unit004')
insert into UNIT_OF_ACCOUNT.NL_UNIT_OF_ACCOUNT_DESCR values (5,'Unit005')



IF EXISTS (SELECT * FROM sys.objects WHERE type = 'P' AND name = 'GET_UNIT_OF_ACCOUNT_BY_COHORT')
    DROP PROCEDURE UNIT_OF_ACCOUNT.GET_UNIT_OF_ACCOUNT_BY_COHORT;
GO

CREATE PROCEDURE UNIT_OF_ACCOUNT.GET_UNIT_OF_ACCOUNT_BY_COHORT
@COHORT INT
AS
BEGIN
    SET NOCOUNT ON;

    SELECT UA.ID_UNIT_OF_ACCOUNT, UD.UNIT_OF_ACCOUNT, ua.COHORT
    FROM UNIT_OF_ACCOUNT.NL_UNIT_OF_ACCOUNT UA
             INNER JOIN UNIT_OF_ACCOUNT.NL_UNIT_OF_ACCOUNT_DESCR UD
                 ON UA.ID_UNIT_OF_ACCOUNT = UD.ID_UNIT_OF_ACCOUNT
    WHERE UA.COHORT = @COHORT;
END
