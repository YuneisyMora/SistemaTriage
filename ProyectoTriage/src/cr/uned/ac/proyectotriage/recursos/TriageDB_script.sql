
CREATE TABLE paciente (
    id INT NOT NULL GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    nombre_completo   VARCHAR(200),
    edad              INT,
    motivo_consulta   VARCHAR(300),
    temperatura_corp  DOUBLE,
    freq_card         DOUBLE,
    nivel_dolor       INT,
    clasificacion     VARCHAR(50),   
    color             VARCHAR(50)   
);


