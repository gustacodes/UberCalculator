CREATE TABLE REGISTROS (
    data varchar(10),
	uber double,
    nove double,
    inDriver double,
    outros double,
    total double,
    lucro double,
    kmDia double,
    horasTrabalhadas double,
    viagens int
);

SELECT * FROM REGISTROS WHERE data BETWEEN '05/03/2023' AND '05/03/2023';
SELECT * FROM REGISTROS;
DROP TABLE REGISTROS;

CREATE TABLE DESPESAS (
	data varchar(10),
	combustivel double,
    refeicoes double,
    lavagem double,
    manutencao double,
    total double    
);

SELECT * FROM DESPESAS;
DROP TABLE DESPESAS;

CREATE TABLE MANUTENCAO (
	kmDoDia double,
	kmProxTrocaOleo double,
    kmProxTrocaCorreia double,
    kmProxTrocaCabos double
);

SELECT * FROM MANUTENCAO;
DROP TABLE MANUTENCAO;

CREATE TABLE METAS (
	metaDiaria double,
    metaMensal double
);

SELECT * FROM METAS;