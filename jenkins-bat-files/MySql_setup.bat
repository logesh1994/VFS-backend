echo "Setting up My SQL Server .."

call docker -H=172.18.2.50:2375 stop 512641mysql

call docker -H=172.18.2.50:2375 rm 512641mysql

call docker -H=172.18.2.50:2375 run --name=512641mysql --network=512641-bridge -p 10208:3306 -e MYSQL_ROOT_PASSWORD=pass@word1 -d mysql/mysql-server

call docker -H=172.18.2.50:2375 exec -t -i 512641mysql /bin/bash

mysql -uroot -ppass@word1

Use mysql;

update user set host=’%’ where user='root';

GRANT ALL PRIVILEGES ON *.* TO 'root'@'%' WITH GRANT OPTION;