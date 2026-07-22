INSERT INTO ficohsa.insurance_conditions
(
    insurance_condition_id,
    description,
    enabled,
    created_by,
    created_at
)
VALUES
(
gen_random_uuid(),
'La cobertura aplica únicamente para vehículos de uso particular.',
TRUE,
current_user,
CURRENT_TIMESTAMP
),
(
gen_random_uuid(),
'El asegurado deberá presentar denuncia policial en caso de robo.',
TRUE,
current_user,
CURRENT_TIMESTAMP
),
(
gen_random_uuid(),
'El deducible será aplicado según las condiciones de la póliza.',
TRUE,
current_user,
CURRENT_TIMESTAMP
),
(
gen_random_uuid(),
'La cobertura es válida únicamente dentro del territorio nacional.',
TRUE,
current_user,
CURRENT_TIMESTAMP
),
(
gen_random_uuid(),
'La póliza tendrá una vigencia de doce meses.',
TRUE,
current_user,
CURRENT_TIMESTAMP
);