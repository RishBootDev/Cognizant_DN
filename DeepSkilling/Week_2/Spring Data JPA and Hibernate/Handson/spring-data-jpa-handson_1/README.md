# Spring Data JPA Hands-on - 1

A complete Spring Boot application implementing all the hands-on exercises from **Hands-on 1 to Hands-on 9** of the Spring Data JPA and Hibernate learning module.

This project demonstrates the implementation of **Spring Data JPA**, **Hibernate**, **ORM concepts**, **CRUD operations**, **Transactions**, and **Repository abstraction** in a **single Spring Boot application**.

# Hands-on Implementation Tracker

| Hands-on | Topic | Status | Direct Implementation |
|----------|-------|--------|-----------------------|
| **Hands-on 1** | Spring Data JPA Quick Example | ✅ Completed | [pom.xml](pom.xml) • [application.properties](src/main/resources/application.properties) • [OrmLearnApplication.java](src/main/java/com/cognizant/ormlearn/OrmLearnApplication.java) • [Country.java](src/main/java/com/cognizant/ormlearn/model/Country.java) • [CountryRepository.java](src/main/java/com/cognizant/ormlearn/repository/CountryRepository.java) • [CountryService.java](src/main/java/com/cognizant/ormlearn/service/CountryService.java) |
| **Hands-on 2** | Hibernate XML Configuration Walkthrough | ✅ Simulated | [Hibernate XML Walkthrough](#-hibernate-xml-configuration-walkthrough) |
| **Hands-on 3** | Hibernate Annotation Configuration | ✅ Completed | [Country.java](src/main/java/com/cognizant/ormlearn/model/Country.java) |
| **Hands-on 4** | Difference between JPA, Hibernate & Spring Data JPA | ✅ Completed | [CountryRepository.java](src/main/java/com/cognizant/ormlearn/repository/CountryRepository.java) • [CountryService.java](src/main/java/com/cognizant/ormlearn/service/CountryService.java) |
| **Hands-on 5** | Country Management Services | ✅ Completed | [CountryService.java](src/main/java/com/cognizant/ormlearn/service/CountryService.java) • [CountryRepository.java](src/main/java/com/cognizant/ormlearn/repository/CountryRepository.java) • [country-data.sql](src/main/resources/db/country-data.sql) |
| **Hands-on 6** | Find Country by Code | ✅ Completed | [CountryService.java](src/main/java/com/cognizant/ormlearn/service/CountryService.java#findcountrybycode) |
| **Hands-on 7** | Add New Country | ✅ Completed | [CountryService.java](src/main/java/com/cognizant/ormlearn/service/CountryService.java#addcountry) |
| **Hands-on 8** | Update Country | ✅ Completed | [CountryService.java](src/main/java/com/cognizant/ormlearn/service/CountryService.java#updatecountry) |
| **Hands-on 9** | Delete Country | ✅ Completed | [CountryService.java](src/main/java/com/cognizant/ormlearn/service/CountryService.java#deletecountry) |

> 
---

#  Database Setup

Create the database.

```sql
create schema ormlearn;
use ormlearn;
```

Create the Country table.

```sql
create table country(
    co_code varchar(2) primary key,
    co_name varchar(50)
);
```

Load all countries.

```sql
source src/main/resources/db/country-data.sql;
```

---

# Application Configuration

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/ormlearn
spring.datasource.username=root
spring.datasource.password=root

spring.jpa.hibernate.ddl-auto=validate

logging.level.org.hibernate.SQL=trace
logging.level.org.springframework=info
```

# 📖 Hibernate XML Configuration Walkthrough

Hands-on 2 explains Hibernate XML configuration.

In Spring Boot, all of these responsibilities are managed automatically.

| Hibernate XML | Spring Data JPA |
|---------------|-----------------|
| SessionFactory | Managed by Spring Boot |
| Session | Managed internally |
| Transaction | `@Transactional` |
| session.save() | `repository.save()` |
| session.get() | `repository.findById()` |
| session.delete() | `repository.deleteById()` |
| session.createQuery().list() | `repository.findAll()` |

---

# 🏷 Hibernate Annotation Configuration

Implemented inside:

📄 **Country.java**

Annotations used:

```java
@Entity
@Table(name = "country")
@Id
@Column
```

These annotations map the Java entity to the database table.

---

#  JPA vs Hibernate vs Spring Data JPA

| JPA | Hibernate | Spring Data JPA |
|------|-----------|-----------------|
| Specification | ORM Implementation | Repository Abstraction |
| Defines persistence contracts | Implements JPA | Removes Boilerplate CRUD |
| No implementation | Actual ORM Provider | Built on Hibernate |

---

#  Implemented Features

✔ Get All Countries

✔ Find Country By Code

✔ Add Country

✔ Update Country

✔ Delete Country

✔ Search Country by Partial Name

✔ Exception Handling

✔ Transaction Management

✔ Repository Query Methods

---

#  Main Source Files

| File | Purpose |
|------|----------|
| `OrmLearnApplication.java` | Application Entry Point & Hands-on Simulation |
| `Country.java` | Entity Mapping |
| `CountryRepository.java` | Repository Layer |
| `CountryService.java` | Business Logic |
| `CountryNotFoundException.java` | Custom Exception |
| `application.properties` | Spring Boot Configuration |
| `country-data.sql` | Country Dataset |

---