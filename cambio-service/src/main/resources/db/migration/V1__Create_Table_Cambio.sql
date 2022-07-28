create table cambio (
  id INT,
  from_currency varchar(3) NOT NULL,
  to_currency varchar(3) NOT NULL,
  conversion_factor decimal(65,2) NOT null,
  PRIMARY key (id)
);

