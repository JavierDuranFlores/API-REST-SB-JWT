CREATE DATABASE InmobiliariaTap;

CREATE TABLE inmuebles (
    idc CHARACTER VARYING (4),
    municipio CHARACTER VARYING (30) NOT NULL,
    colonia CHARACTER VARYING (30) NOT NULL,
    codigoPostal CHARACTER VARYING (5) NOT NULL,
    precio NUMERIC (12,2) NOT NULL,
    imagen CHARACTER VARYING (60) NOT NULL,


    CONSTRAINT pk_inmueble_idc PRIMARY KEY (idc)
);

INSERT INTO 
    inmuebles (idc, municipio, colonia, codigoPostal, precio, imagen) 
VALUES ('C310', 'Tapachula', 'Fraccionamiento Las Vegas', '30798',
         800000, '/img/casa1.jpg'),
       ('C311', 'Tapachula', 'Fraccionamiento Loma bonita', '30798',
         1000000, '/img/casa2.jpg'),
       ('C312', 'Tapachula', 'Lomas del tacana', '30798',
         810000, '/img/casa3.jpg'),
       ('C313', 'Tapachula', 'Bella Vista', '30798',
         970000, '/img/casa4.jpg'),
       ('C314', 'Tapachula', 'Juan Escutia', '30798',
         850000, '/img/casa5.jpg'),
       ('C315', 'Tapachula', 'Lazaro Cardenas', '30798',
         1200000, '/img/casa6.jpg'),
       ('C316', 'Tapachula', 'San Luis', '30798',
         500000, '/img/casa7.jpg'),
       ('C318', 'Tapachula', 'San Geronimo', '30798',
         650000, '/img/casa8.jpg'),
       ('C319', 'Tapachula', 'San Roman', '30798',
         700000, '/img/casa9.jpg'),
       ('C320', 'Tapachula', 'Lomas del soconusco', '30798',
         1000000, '/img/casa10.jpg');
