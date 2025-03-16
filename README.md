# Supplier System

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