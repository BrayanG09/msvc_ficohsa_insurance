INSERT INTO ficohsa.insurance_conditions_mapping
(
    insurance_condition_mapping_id,
    insurance_id,
    insurance_condition_id,
    enabled,
    created_by,
    created_at
)
SELECT
    gen_random_uuid(),
    i.insurance_id,
    c.insurance_condition_id,
    TRUE,
    current_user,
    CURRENT_TIMESTAMP
FROM ficohsa.insurances i
CROSS JOIN ficohsa.insurance_conditions c
WHERE i.insurance_name IN ('Plan A', 'Plan B', 'Plan C', 'Plan D', 'Plan F', 'Plan G', 'Plan H', 'Plan I', 'Plan J', 'Plan K', 'Plan L');