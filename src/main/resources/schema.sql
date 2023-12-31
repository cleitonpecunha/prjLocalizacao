create table tb_cidade (
  id_cidade int not null primary key,
  ds_municipio varchar(50) not null,
  ds_uf varchar(2) not null,
  ds_regiao varchar(15) not null,
  qtd_habitantes bigint
);

insert into tb_cidade (id_cidade, ds_municipio, ds_uf, ds_regiao, qtd_habitantes) values
(2800308, 'Aracaju' ,'SE' ,'NORDESTE' ,602757),
(1501402, 'Belém' ,'PA' ,'NORTE' ,1303389),
(3106200, 'Belo Horizonte' ,'MG' ,'SUDESTE' ,2315560),
(1400100, 'Boa Vista','RR' ,'NORTE' ,413486),
(5300108, 'Brasília','DF' ,'CENTRO-OESTE' ,2817068),
(5002704, 'Campo Grand' ,'MS' ,'CENTRO-OESTE' ,897938),
(5103403, 'Cuiabá','MT' ,'CENTRO-OESTE' ,650912),
(4106902, 'Curitiba','PR' ,'SUL' ,1773733),
(4205407, 'Florianópolis' ,'SC' ,'SUL' ,537213),
(2304400, 'Fortaleza' ,'CE' ,'NORDESTE' ,2428678),
(5208707, 'Goiânia' ,'GO' ,'CENTRO-OESTE' ,1437237),
(2507507, 'João Pessoa' ,'PB' ,'NORDESTE' ,833932),
(1600303, 'Macapá' ,'AP' ,'NORTE' ,442933),
(2704302, 'Maceió' ,'AL' ,'NORDESTE' ,957916),
(1302603, 'Manaus' ,'AM' ,'NORTE' ,2063547),
(2408102, 'Natal' ,'RN' ,'NORDESTE' ,751300),
(1721000, 'Palmas' ,'TO' ,'NORTE' ,302692),
(4314902, 'Porto Alegre' ,'RS' ,'SUL' ,1332570),
(1100205, 'Porto Velho' ,'RO' ,'NORTE' ,460413),
(2611606, 'Recife' ,'PE' ,'NORDESTE' ,1488920),
(1200401, 'Rio Branco' ,'AC' ,'NORTE' ,1400000),
(3304557, 'Rio de Janeiro' ,'RJ' ,'SUDESTE' ,6211423),
(2927408, 'Salvador' ,'BA' ,'NORDESTE' ,2418005),
(2111300, 'São Luís' ,'MA' ,'NORDESTE' ,1037775),
(3550308, 'São Paulo' ,'SP' ,'SUDESTE' ,11451245),
(2211001, 'Teresina' ,'PI' ,'NORDESTE' ,866300),
(3205309, 'Vitória' ,'ES' ,'SUDESTE' ,322869);
