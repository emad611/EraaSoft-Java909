CREATE TABLE Doctor (
    id     NUMBER PRIMARY KEY,
    name   VARCHAR2(55) UNIQUE,
    salary NUMBER
);

CREATE TABLE Patient (
    id   NUMBER PRIMARY KEY,
    name VARCHAR2(55) UNIQUE,
    age  NUMBER
);

CREATE TABLE Doctor_Patient (
    doctor_id  NUMBER,
    patient_id NUMBER,

    CONSTRAINT dp_pk PRIMARY KEY (doctor_id, patient_id),

    CONSTRAINT dp_doctor_fk
        FOREIGN KEY (doctor_id) REFERENCES Doctor(id),

    CONSTRAINT dp_patient_fk
        FOREIGN KEY (patient_id) REFERENCES Patient(id)
);