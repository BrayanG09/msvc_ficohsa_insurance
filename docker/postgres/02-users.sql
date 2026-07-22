INSERT INTO ficohsa.users
(
    user_id,
    username,
    password,
    enabled,
    created_by,
    created_at
)
VALUES
(
    gen_random_uuid(),
    'brayan.alvarez',
    '$2a$12$3VVC9HK9NMA1bwDN3ySNNeKcs04ntzka5.nu0mArTnCrh4gi//HZK', -- Brayan.10!
    TRUE,
    current_user,
    CURRENT_TIMESTAMP
),
(
    gen_random_uuid(),
    'alejandro.morales',
    '$2a$12$v64NL3rVdadbrs0GZ/hUWunC2gon75piBl7IoVG.1XeeBygDFznge', -- Brayan.10!
    TRUE,
    current_user,
    CURRENT_TIMESTAMP
),
(
    gen_random_uuid(),
    'jose.morales',
    '$2a$12$d3TJ/a5q0l9VOV97OKYZmOkTAgXFPAWmieOjuHinWi6IUuwVTvrMu', -- Brayan.10!
    FALSE,
    current_user,
    CURRENT_TIMESTAMP
);