INSERT INTO ficohsa.insurance_categories
(
    insurance_category_id,
    category_name,
    description,
    enabled,
    created_by,
    created_at
)
VALUES
(gen_random_uuid(),'Seguros de vida','Cobertura para fallecimiento',TRUE,current_user,CURRENT_TIMESTAMP),
(gen_random_uuid(),'Seguros de salud','Cobertura médica y hospitalaria',TRUE,current_user,CURRENT_TIMESTAMP),
(gen_random_uuid(),'Seguros de auto','Protección para vehículos',TRUE,current_user,CURRENT_TIMESTAMP),
(gen_random_uuid(),'Seguros de fraude','Protección contra fraude financiero',TRUE,current_user,CURRENT_TIMESTAMP),
(gen_random_uuid(),'Seguros de Desempleo','Cobertura por pérdida de empleo',TRUE,current_user,CURRENT_TIMESTAMP),
(gen_random_uuid(),'Seguros financieros','Protección para obligaciones financieras',TRUE,current_user,CURRENT_TIMESTAMP),
(gen_random_uuid(),'Asistencias','Servicios de asistencia complementarios',TRUE,current_user,CURRENT_TIMESTAMP);