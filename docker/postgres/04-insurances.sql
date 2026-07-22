INSERT INTO ficohsa.insurances
(
    insurance_id,
    insurance_category_id,
    insurance_name,
    description,
    price,
    enabled,
    created_by,
    created_at
)
SELECT
    gen_random_uuid(),
    insurance_category_id,
    'Plan A',
    'Cobertura básica contra accidentes y daños a terceros.',
    750.00,
    TRUE,
    current_user,
    CURRENT_TIMESTAMP
FROM ficohsa.insurance_categories
WHERE category_name='Seguros de auto';


INSERT INTO ficohsa.insurances
(
    insurance_id,
    insurance_category_id,
    insurance_name,
    description,
    price,
    enabled,
    created_by,
    created_at
)
SELECT
    gen_random_uuid(),
    insurance_category_id,
    'Plan B',
    'Cobertura completa con robo, daños propios y terceros.',
    1450.00,
    TRUE,
    current_user,
    CURRENT_TIMESTAMP
FROM ficohsa.insurance_categories
WHERE category_name='Seguros de auto';


INSERT INTO ficohsa.insurances
(
    insurance_id,
    insurance_category_id,
    insurance_name,
    description,
    price,
    enabled,
    created_by,
    created_at
)
SELECT
    gen_random_uuid(),
    insurance_category_id,
    'Plan C',
    'Cobertura total con vehículo de reemplazo y asistencia vial.',
    2300.00,
    FALSE,
    current_user,
    CURRENT_TIMESTAMP
FROM ficohsa.insurance_categories
WHERE category_name='Seguros de auto';

INSERT INTO ficohsa.insurances
(
    insurance_id,
    insurance_category_id,
    insurance_name,
    description,
    price,
    enabled,
    created_by,
    created_at
)
SELECT
    gen_random_uuid(),
    insurance_category_id,
    'Plan D',
    'Cobertura total con vehículo de reemplazo y asistencia vial.',
    2500.00,
    TRUE,
    current_user,
    CURRENT_TIMESTAMP
FROM ficohsa.insurance_categories
WHERE category_name='Seguros de auto';

INSERT INTO ficohsa.insurances
(
    insurance_id,
    insurance_category_id,
    insurance_name,
    description,
    price,
    enabled,
    created_by,
    created_at
)
SELECT
    gen_random_uuid(),
    insurance_category_id,
    'Plan F',
    'Cobertura total con vehículo de reemplazo y asistencia vial.',
    2700.00,
    TRUE,
    current_user,
    CURRENT_TIMESTAMP
FROM ficohsa.insurance_categories
WHERE category_name='Seguros de auto';

INSERT INTO ficohsa.insurances
(
    insurance_id,
    insurance_category_id,
    insurance_name,
    description,
    price,
    enabled,
    created_by,
    created_at
)
SELECT
    gen_random_uuid(),
    insurance_category_id,
    'Plan G',
    'Cobertura total con vehículo de reemplazo y asistencia vial.',
    3000.00,
    TRUE,
    current_user,
    CURRENT_TIMESTAMP
FROM ficohsa.insurance_categories
WHERE category_name='Seguros de auto';

INSERT INTO ficohsa.insurances
(
    insurance_id,
    insurance_category_id,
    insurance_name,
    description,
    price,
    enabled,
    created_by,
    created_at
)
SELECT
    gen_random_uuid(),
    insurance_category_id,
    'Plan H',
    'Cobertura total con vehículo de reemplazo y asistencia vial.',
    3000.00,
    TRUE,
    current_user,
    CURRENT_TIMESTAMP
FROM ficohsa.insurance_categories
WHERE category_name='Seguros de auto';


INSERT INTO ficohsa.insurances
(
    insurance_id,
    insurance_category_id,
    insurance_name,
    description,
    price,
    enabled,
    created_by,
    created_at
)
SELECT
    gen_random_uuid(),
    insurance_category_id,
    'Plan I',
    'Cobertura total con vehículo de reemplazo y asistencia vial.',
    3250.00,
    TRUE,
    current_user,
    CURRENT_TIMESTAMP
FROM ficohsa.insurance_categories
WHERE category_name='Seguros de auto';


INSERT INTO ficohsa.insurances
(
    insurance_id,
    insurance_category_id,
    insurance_name,
    description,
    price,
    enabled,
    created_by,
    created_at
)
SELECT
    gen_random_uuid(),
    insurance_category_id,
    'Plan J',
    'Cobertura total con vehículo de reemplazo y asistencia vial.',
    3500.00,
    TRUE,
    current_user,
    CURRENT_TIMESTAMP
FROM ficohsa.insurance_categories
WHERE category_name='Seguros de auto';

INSERT INTO ficohsa.insurances
(
    insurance_id,
    insurance_category_id,
    insurance_name,
    description,
    price,
    enabled,
    created_by,
    created_at
)
SELECT
    gen_random_uuid(),
    insurance_category_id,
    'Plan K',
    'Cobertura total con vehículo de reemplazo y asistencia vial.',
    3250.00,
    TRUE,
    current_user,
    CURRENT_TIMESTAMP
FROM ficohsa.insurance_categories
WHERE category_name='Seguros de auto';


INSERT INTO ficohsa.insurances
(
    insurance_id,
    insurance_category_id,
    insurance_name,
    description,
    price,
    enabled,
    created_by,
    created_at
)
SELECT
    gen_random_uuid(),
    insurance_category_id,
    'Plan L',
    'Cobertura total con vehículo de reemplazo y asistencia vial.',
    3500.00,
    TRUE,
    current_user,
    CURRENT_TIMESTAMP
FROM ficohsa.insurance_categories
WHERE category_name='Seguros de auto';