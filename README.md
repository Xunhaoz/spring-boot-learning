# scimonth-data-api

### 科學月刊API

**語言**: Java 21  
**框架**: Spring Boot 3.2.8
**ORM框架**: MyBatis Plus  
**專案管理工具**: gradle   
**開發環境**: JDK21   
**開發工具**: Eclipse/IntelliJ   
**MariaDB**: 10.4.32

## 環境變數設定

1.開發環境使用: .env.dev.example
2.部屬環境使用: .env.deploy.example
3.使用方式: 將.env.*.example複製成.env並依照檔案內說明調整參數

## IDE設定

若無法成功解析Controller參數[請參考](https://github.com/spring-projects/spring-framework/wiki/Upgrading-to-Spring-Framework-6.x#parameter-name-retention)

## Build Image

```
  ./gradlew jibDockerBuild
```

## 初始化測試環境的資料庫(啟動後關閉)

```
  docker compose run --rm -e INIT=true ap
```

## 部署

```
  docker-compose up -d
```
