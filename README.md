# Microservicio de Seguros Ficohsa

API REST para autenticacion, consulta de productos de seguro y registro de cotizaciones.

## Ejecutar con Docker (Opcion 1)
Con un solo comando puede levantar la base de datos y la API (Ubicado en la raiz del proyecto):

```bash
docker compose up --build
```

La primera ejecucion puede tardar varios minutos porque descarga imagenes y compila el proyecto.

Cuando termine de iniciar ya puede acceder a los siguientes recursos:

- API URL BASE: 
```bash
http://localhost:8080
```

- Swagger UI: 
```bash
http://localhost:8080/swagger-ui.html
```

- OpenAPI JSON
```bash
http://localhost:8080/v3/api-docs
```

- PostgreSQL
```bash
localhost:5439
Database: insurance_db
Usuario: ficohsa-seguros
Password: ficohsa_seguros!10
```

### Comandos utiles

```bash
# Levantar en segundo plano
docker compose up --build -d

# Ver logs de la API
docker compose logs -f app

# Detener y conservar datos
docker compose down

# Detener y eliminar el volumen de Postgres (reinicia datos seed)
docker compose down -v
```

### Solo base de datos con Docker
Si prefiere correr la API en su maquina y solo usar Postgres en Docker:

```bash
docker compose up postgres -d
```

Luego, desde la raiz del proyecto, inicie la aplicacion con Maven:

```bash
mvn clean spring-boot:run
```

O genere el JAR y ejecutelo:

```bash
mvn clean package -DskipTests
java -jar target/msvc_ficohsa_insurance-0.0.1-SNAPSHOT.jar
```

La API quedara en:
- http://localhost:8080
- Swagger UI: http://localhost:8080/swagger-ui.html

Con esto ya esta listo para realizar las pruebas (Ver seccion [Pruebas](#pruebas))

<hr>

## Ejecutar sin Docker (Opcion 2)

### 1. Preparar PostgreSQL

Crear una base con estos valores (o ajusta `src/main/resources/application.yml`):

- Host = `localhost`
- Puerto = `5439` (si usa el compose del proyecto) o `5432` (Puerto por defecto al instalar PostgreSQL)
- Database = `insurance_db`
- Usuario = `ficohsa-seguros`
- Password = `ficohsa_seguros!10`

Ejecute los scripts SQL en el siguiente orden:

1. `docker/postgres/01-schema.sql`
2. `docker/postgres/02-users.sql`
3. `docker/postgres/03-insurance-categories.sql`
4. `docker/postgres/04-insurances.sql`
5. `docker/postgres/05-insurance-conditions.sql`
6. `docker/postgres/06-insurance-condition-mapping.sql`
7. `docker/postgres/07-logs.sql`

### 3. Compilar y ejecutar

Con Maven instalado:
```bash
mvn clean spring-boot:run
```

O generar el JAR y ejecutarlo:
```bash
mvn clean package -DskipTests
java -jar target/msvc_ficohsa_insurance-0.0.1-SNAPSHOT.jar
```

La API quedara en:
- http://localhost:8080
- Swagger UI: http://localhost:8080/swagger-ui.html

## Credenciales de prueba
Usuarios cargados por seed:
- `brayan.alvarez`: `Brayan.10!`  (Habilitado)
- `alejandro.morales`: `Brayan.10!`  (Habilitado)
- `jose.morales`: `Brayan.10!`  (Deshabilitado)

## Pruebas
Las pruebas se pueden realizar desde POSTMAN o Utilizando swagger.

### POSTMAN
1. Utilizar la collecion de postman que se compartió.
2. Ejecute `POST /auth/verify` con un usuario habilitado.
3. El token automaticamente es seteado a una variable de la collecion si la verificacion es exitosa.
4. Pruebe los siguientes endpoints:
  - `GET /products` (listado paginado de productos/seguros)
  - `POST /quotations` (crear cotizacion; usa un `insuranceId` obtenido de `/products`)

### Swagger
1. Abra Swagger UI: http://localhost:8080/swagger-ui.html
2. Ejecute `POST /auth/verify` con un usuario habilitado.
3. Copie el valor de `data.token`.
4. Pulse **Authorize**, pegar el token y confirma.
5. Pruebe los siguientes endpoints:
  - `GET /products` (listado paginado de productos/seguros)
  - `POST /quotations` (crear cotizacion; usa un `insuranceId` obtenido de `/products`)


