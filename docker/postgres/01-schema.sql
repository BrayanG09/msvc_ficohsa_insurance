CREATE SCHEMA IF NOT EXISTS ficohsa;

CREATE TABLE IF NOT EXISTS ficohsa.users(
    user_id UUID PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(100) NOT NULL,
    enabled BOOLEAN NOT NULL DEFAULT TRUE,
    created_by VARCHAR(100) NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_by VARCHAR(100),
    updated_at TIMESTAMP
);

CREATE TABLE IF NOT EXISTS ficohsa.insurance_categories (
    insurance_category_id UUID PRIMARY KEY,
    category_name VARCHAR(100) NOT NULL,
    description TEXT,
    enabled BOOLEAN NOT NULL DEFAULT TRUE,
    created_by VARCHAR(100) NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_by VARCHAR(100),
    updated_at TIMESTAMP
);

CREATE TABLE IF NOT EXISTS ficohsa.insurances (
    insurance_id UUID PRIMARY KEY,
    insurance_category_id UUID NOT NULL,
    insurance_name VARCHAR(150) NOT NULL,
    description TEXT,
    price NUMERIC(12,2) NOT NULL,
    enabled BOOLEAN NOT NULL DEFAULT TRUE,
    created_by VARCHAR(100) NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_by VARCHAR(100),
    updated_at TIMESTAMP,
    CONSTRAINT fk_insurance_category FOREIGN KEY (insurance_category_id) REFERENCES ficohsa.insurance_categories(insurance_category_id)
);

CREATE TABLE IF NOT EXISTS ficohsa.insurance_conditions (
    insurance_condition_id UUID PRIMARY KEY,
    description TEXT NOT NULL,
    enabled BOOLEAN NOT NULL DEFAULT TRUE,
    created_by VARCHAR(100) NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_by VARCHAR(100),
    updated_at TIMESTAMP
);

CREATE TABLE IF NOT EXISTS ficohsa.insurance_conditions_mapping (
    insurance_condition_mapping_id UUID PRIMARY KEY,
    insurance_id UUID NOT NULL,
    insurance_condition_id UUID NOT NULL,
    enabled BOOLEAN NOT NULL DEFAULT TRUE,
    created_by VARCHAR(100) NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_by VARCHAR(100),
    updated_at TIMESTAMP,
    CONSTRAINT fk_mapping_insurance FOREIGN KEY (insurance_id) REFERENCES ficohsa.insurances(insurance_id),
    CONSTRAINT fk_mapping_condition FOREIGN KEY (insurance_condition_id) REFERENCES ficohsa.insurance_conditions(insurance_condition_id),
    CONSTRAINT uk_insurance_condition UNIQUE (insurance_id, insurance_condition_id)
);

CREATE TABLE IF NOT EXISTS ficohsa.quotations
(
    quotation_id UUID NOT NULL,
    user_id UUID NOT NULL,
    insurance_id UUID NOT NULL,
    applicant_name VARCHAR(150) NOT NULL,
    applicant_identity VARCHAR(30) NOT NULL,
    applicant_email VARCHAR(150),
    applicant_phone VARCHAR(30),
    vehicle_year INTEGER NOT NULL,
    vehicle_brand VARCHAR(150) NOT NULL,
    vehicle_model VARCHAR(150) NOT NULL,
    vehicle_value NUMERIC(12,2) NOT NULL,
    status VARCHAR(30) NOT NULL,
    enabled BOOLEAN NOT NULL DEFAULT TRUE,
    created_by VARCHAR(100) NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_by VARCHAR(100),
    updated_at TIMESTAMP,
    CONSTRAINT pk_quotations PRIMARY KEY (quotation_id),
    CONSTRAINT fk_quotations_user FOREIGN KEY (user_id) REFERENCES ficohsa.users(user_id),
    CONSTRAINT fk_quotations_insurance FOREIGN KEY (insurance_id) REFERENCES ficohsa.insurances(insurance_id)
);