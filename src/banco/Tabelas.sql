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

CREATE TABLE DESPESAS (
	data varchar(10),
	combustivel double,
    refeicoes double,
    lavagem double,
    manutencao double,
    total double    
);

CREATE TABLE MANUTENCAO (
	kmDoDia double,
	kmProxTrocaOleo double,
    kmProxTrocaCorreia double,
    kmProxTrocaCabos double
);

CREATE TABLE METAS (	
	metaDiaria double
);