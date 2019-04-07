@echo on
echo "Building Outreach VFS Backend Services started..."

echo "Building Eureka Discovery Service started..."
cd C:\Jenkins\workspace\Backend-Services-Build-Job\EurekaServer
call mvn clean -X install -Dmaven.test.skip=true package docker:build
@echo on
echo "Building Eureka Discovery Service completed successfully ..."

echo "Building Zuul Service started..."
cd C:\Jenkins\workspace\Backend-Services-Build-Job\ZuulGateway
call mvn clean -X install -Dmaven.test.skip=true package docker:build
@echo on
echo "Building Zuul Service completed successfully ..."

echo "Building Common module started..."
cd C:\Jenkins\workspace\Backend-Services-Build-Job\outreach-vfs-common
call mvn clean -X install -Dmaven.test.skip=true package
@echo on
echo "Building Common module completed successfully ..."

echo "Building Login Service started..."
cd C:\Jenkins\workspace\Backend-Services-Build-Job\outreach-vfs-login
call mvn clean -X install -Dmaven.test.skip=true package docker:build
@echo on
echo "Building Login Service completed successfully ..."

echo "Building Admin Service started..."
cd C:\Jenkins\workspace\Backend-Services-Build-Job\outreach-vfs-admin
call mvn clean -X install -Dmaven.test.skip=true package docker:build
@echo on
echo "Building Admin Service completed successfully ..."

echo "Building Feedback Service started..."
cd C:\Jenkins\workspace\Backend-Services-Build-Job\outreach-vfs-feedback
call mvn clean -X install -Dmaven.test.skip=true package docker:build
@echo on
echo "Building Feedback Service completed successfully ..."

echo "Building Batch Service started..."
cd C:\Jenkins\workspace\Backend-Services-Build-Job\outreach-vfs-batch
call mvn clean -X install -Dmaven.test.skip=true package docker:build
@echo on
echo "Building Batch Service completed successfully ..."

echo "Building Outreach VFS Backend Services Completed successfully..."