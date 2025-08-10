# Microservice2

Spring Boot微服务应用

## 本地开发

### 运行应用
```bash
mvn spring-boot:run
```

### 构建Docker镜像
```bash
docker build -t microservice2:latest .
```

## CI/CD

推送到以下分支会触发自动构建和部署：
- `dev` - 部署到开发环境
- `staging` - 部署到预发布环境

## API端点

- `GET /` - 主页面
- `GET /health` - 健康检查
