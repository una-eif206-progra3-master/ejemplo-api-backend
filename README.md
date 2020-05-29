# Ejemplo de Backend cuyo DAO consume un API externo Restful
En este ejemplo utilizando Spring Boot se demuestra como se puede consumir un API externo 

## Dependencias

- Java
- Spring Boot
  - Spring Boot Actuator
  - Spring Boot Web

## Mapeo

Es importante mapear el modelo con la respuesta del API externo

### Endpoint API Externo

```json
http://api.mlab.com/api/1/databases/students/collections/student?apiKey=12KfjNX97_amx0iUdS2I_eitAy3jSaOb
```

### Modelo Student

```java
@JsonIgnoreProperties(ignoreUnknown = true)
public class Student {
    
    @JsonProperty("_id")
    private Id id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("course")
    private String course;
    @JsonProperty("rating")
    private String rating;
    ...
```

### Modelo Id

```java
public class Id {

    @JsonProperty("$oid")
    private String $oid;
    ...
```

### Respuesta del API

```json
[
    {
        "_id": {
            "$oid": "5ebd78d9e7179a42f17715e5"
        },
        "name": "Juan Perez",
        "couse": "Progra 3",
        "rating": "A+"
    },
    {
        "_id": {
            "$oid": "5ebd7918e7179a42f17715f1"
        },
        "name": "Ana Sanchez",
        "couse": "Progra 2",
        "rating": "B+"
    },
    {
        "_id": {
            "$oid": "5ebd7a9fe7179a42f1771634"
        },
        "name": "Juan Perez",
        "couse": "Progra 3",
        "rating": "A+",
        "address": "Curridabat"
    },
    {
        "_id": {
            "$oid": "5ebd7bfee7179a42f1771700"
        },
        "name": "Pedro Jimenez",
        "couse": "Progra 1",
        "rating": "A+",
        "address": "Heredia",
        "phone": "88888888"
    }
]
```

## Consumir el API

Para consimir el API es necesario consumirlo utilizando Spring Boot y no Jersy para no mezclar dependencias de dos librerías que hacen lo mismo.

El `RestTemplate` es un elemento de Spring que sirve para consumir servicios, muy similar y mas sencillo al `client`de Jersy. 

```java
public class StudentDAOImpl implements StudentDAO {

    // Using logger for project
    final Logger logger = LogManager.getLogger(StudentDAOImpl.class);

    private static final String REST_URI = "https://api.mlab.com/api/1/databases/students/collections/student?apiKey=12KfjNX97_amx0iUdS2I_eitAy3jSaOb";

    public StudentDAOImpl() {
    }

    /**
     * Find all student from External API
     *
     * @return the list of Students
     */
    @Override
    public List<Student> findAll() {

        List<Student> studentList = null;
        RestTemplate restTemplate = new RestTemplate();
        studentList = Arrays.asList(restTemplate.getForObject(REST_URI, Student[].class));

        return studentList;
    }
}
```

