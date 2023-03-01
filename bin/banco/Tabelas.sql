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

SELECT * FROM REGISTROS;
DROP TABLE REGISTROS;

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