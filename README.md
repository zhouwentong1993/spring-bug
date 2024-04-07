演示 spring boot 某个版本的 bug。
使用方法：mvn clean package，然后进入 target 目录下，通过 java -jar 启动刚才构建好的 jar 包。
通过 ab 压测 ab -c 1 -n 10000 http://localhost:8080/user/2
