# Supplier System

**Supplier System** — это приложение для управления поставками, разработанное с использованием **Spring Boot** и **PostgreSQL**. Приложение предоставляет возможность взаимодействия с базой данных, а также позволяет управлять данными через REST API.

## Описание

Приложение использует **Spring Boot** для создания RESTful сервисов и **PostgreSQL** для хранения данных. Также оно включает поддержку **Docker** для удобства развертывания.

## Функциональность приложения

Приложени позволяет:

- Добавлять поставляемый продукт в базу (`http://localhost/products`)
- Получать список поставляемых продуктов(`http://localhost/products`)
- Добавлять поставщика в базу(`http://localhost/suppliers`)
- Получать список поставщиков(`http://localhost/suppliers`)
- Устанавливать цену на поставку определенного продукты от поставщика на определенный период(`http://localhost/prices`)
- Просматривать стоимость поставок от определенного поставщика на определенную дату(`http://localhost/prices/suppliers/1?date=`)
- Просматривать стоимость поставок определенного продукта от всех поставщиков на определенную дату(`http://localhost/prices/products/1?date=`)
- Формировать поставки различных продуктов от определенного поставщика на текущую дату(`http://localhost/deliveries`)
- Формировать отчет по поставкам на определенный промежуток времени(`http://localhost/report?startDate=2025-02-14&endDate=2025-03-17`)

## API Эндпоинты

Ознакомиться с эндпоинтами и попробовать поработать с API можно по адресу `http://localhost/swagger-ui.html`
после локального развертывания приложения




## Запуск приложения

Для быстрого развертывания приложения, выполните следующие шаги.

### 1. Клонировать репозиторий

Сначала клонируйте репозиторий с исходным кодом:

```sh
git clone https://github.com/Saveliy19/supplier-system.git
cd supplier-system
```

### 2. Создать и настроить контейнеры Docker

Для сборки и запуска контейнеров, используйте `docker-compose`.

#### Создание и запуск контейнеров

```sh
docker-compose up --build
```

### 3. Приложение будет доступно по следующим адресам:

- **Spring Boot API**: `http://localhost:80`
- **Swagger UI для работы с эндпоинтами**: `http://localhost/swagger-ui.html`

### 4. Остановить контейнеры

Для остановки контейнеров используйте команду:

```sh
docker-compose down
```