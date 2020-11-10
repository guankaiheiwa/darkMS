# 				DarkMS服务器启动

## 1. Nginx

```sh
#反向代理配置
vi dark_gateway.conf
#配置内容
upstream gateway_upstream {
	server 127.0.0.1:81 max_fails=10 fail_timeout=5s;
}
server {
	listen       80;
	server_name api.darkms.com gateway.darkms.com;
	location / {
				   proxy_pass        http://gateway_upstream;
				   proxy_set_header   Host             $host;
				   proxy_set_header   X-Real-IP        $remote_addr;
				   proxy_set_header   wg-x-ip          $remote_addr;
				   proxy_set_header   X-Forwarded-For  $proxy_add_x_forwarded_for;
	#               proxy_set_header   wg-x-ip  $proxy_add_x_forwarded_for;
				   client_max_body_size    10m;
				   client_body_buffer_size 128k;
				   proxy_connect_timeout   90;
				   proxy_send_timeout      90;
				   proxy_read_timeout      90;
				   proxy_buffer_size       4k;
				   proxy_buffers           4 32k;
				   proxy_busy_buffers_size 64k;
				   proxy_temp_file_write_size 64k;
				   proxy_ignore_client_abort on;
				   proxy_next_upstream error timeout invalid_header http_503;
		}
}

```

## 2. Docker启动

​		Mac OSX启动，直接可视化操作启动Docker

### 		1）Redis

```sh
#docker查看镜像
docker images
#docker启动redis
docker restart redis
#进入reids客户端
docker exec -it redis redis-cli
#退出客户端
exit
```

### 		2）Nacos

```sh
cd /Users/hh/works/wserver/nacos/bin
#集群启动
sh ./startup.sh -P 8848
sh ./startup.sh -P 8849
sh ./startup.sh -P 8850
#停止
sh shutdown.sh
#本地域名访问
http://nacos.dark.com/nacos
```

### 		3）Zookeeper

```sh
#启动zk服务器
cd /Users/hh/works/wserver/zookeeper-3.4.14/bin./
./zkServer.sh start
#Cli连接
./zkCli.sh -server 127.0.0.1:2181
#输入help命令
help
ls /
create /zk-test mydata
get /zk-test
delete /zk_test
#退出客户端
exit
```

### 	    4）Seata

```sh
cd /Users/hh/works/wserver/seata/bin
sh ./seata-server.sh -p 8090
```

### 		5）RocketMQ

```sh
cd /Users/hh/works/wserver/rocketmq/bin
### 首先启动Name Server
nohup sh mqnamesrv &
### 启动Broker
nohup sh mqbroker -n localhost:9876 &
```

### 		6）Mysql

```sh
#启动mysql
```

### 		7）Sentinel

​				默认端口：8080

​				账号/密码：sentinel/sentinel

```sh
cd /Users/hh/works/wserver/sentinel
java -jar sentinel-dashboard-1.8.0.jar
```

