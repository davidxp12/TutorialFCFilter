CREATE TABLE veiculo(
  id integer,
  marca text,
  modelo text,
  categoria text,
  ano integer,
  placa text,
  chassi text,
  estadoGeral text,
  regiaoEntrega text,
  tipoMercadoria text,
  quantidadeMaxima integer
)
WITH (OIDS=FALSE);
ALTER TABLE veiculo OWNER TO labarq;