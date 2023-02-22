CREATE TABLE REGISTROS (
    data varchar(10),
	uber double,
    nove double,
    despesa double,
    total double,
    lucro double,
    kmDia double
);

SELECT * FROM REGISTROS;
DROP TABLE REGISTROS;

CREATE TABLE VEICULO (
	placa varchar(10) primary key,
    marca varchar(20),
    modelo varchar(30),
    kmRodados double,
    combustivel varchar(10)
);

SELECT * FROM VEICULO;
DROP TABLE VEICULO;

CREATE TABLE TROCAOLEO (
	kmMarcado double,
	kmProxTroca double
);

SELECT * FROM TROCAOLEO;
DROP TABLE TROCAOLEO;