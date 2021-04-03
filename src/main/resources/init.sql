START TRANSACTION;
# create user medcenter identified with sha256_password by 'password';
# grant all on medcenter.* to medcenter;
DROP DATABASE IF EXISTS medcenter;
CREATE DATABASE medcenter;
use medcenter;
CREATE TABLE patient
(
    id              SERIAL,
    patient_name    VARCHAR(15),
    surname         VARCHAR(15),
    patronymic      VARCHAR(15),
    date_of_birth     DATE,
    passport_number  CHAR(11),
    work_place       VARCHAR(50),
    insurance_number int,
    insurance_type   varchar(50),
    PRIMARY KEY (id)
);
CREATE TABLE department
(
    id              SERIAL,
    department_name text,
    PRIMARY KEY (id)
);
CREATE TABLE record
(
    id            SERIAL,
    patient_id    BIGINT UNSIGNED,
    created_at    datetime default current_timestamp,
    department_id BIGINT UNSIGNED,
    content       JSON,
    PRIMARY KEY (id),
    FOREIGN KEY (department_id) REFERENCES department (id) ON UPDATE CASCADE,
    FOREIGN KEY (patient_id) REFERENCES patient (id)
);
CREATE TABLE doctor
(
    id             SERIAL,
    doctor_name    VARCHAR(15),
    surname        VARCHAR(15),
    patronymic     VARCHAR(15),
    specialization VARCHAR(50),
    department_id  BIGINT UNSIGNED,
    PRIMARY KEY (id),
    FOREIGN KEY (department_id) REFERENCES department (id)
);
COMMIT;