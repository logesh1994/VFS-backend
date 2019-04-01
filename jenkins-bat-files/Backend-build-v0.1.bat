echo "Building Outreach VFS Backend Services started..."

echo "Building Eureka Discovery Service started..."
cd C:\Jenkins\workspace\Backend Services Build Job\EurekaServer
mvn clean -X install package docker:build
echo "Building Eureka Discovery Service completed successfully ..."

echo "Building Zuul Service started..."
cd C:\Jenkins\workspace\Backend Services Build Job\ZuulGateway
mvn clean -X install package docker:build
echo "Building Zuul Service completed successfully ..."

echo "Building Common module started..."
cd C:\Jenkins\workspace\Backend Services Build Job\outreach-vfs-common
mvn clean -X install package
echo "Building Common module completed successfully ..."

echo "Building Login Service started..."
cd C:\Jenkins\workspace\Backend Services Build Job\outreach-vfs-login
mvn clean -X install package docker:build
echo "Building Login Service completed successfully ..."

echo "Building Admin Service started..."
cd C:\Jenkins\workspace\Backend Services Build Job\outreach-vfs-admin
mvn clean -X install package docker:build
echo "Building Admin Service completed successfully ..."

echo "Building Feedback Service started..."
cd C:\Jenkins\workspace\Backend Services Build Job\outreach-vfs-feedback
mvn clean -X install package docker:build
echo "Building Feedback Service completed successfully ..."

echo "Building Batch Service started..."
cd C:\Jenkins\workspace\Backend Services Build Job\outreach-vfs-batch
mvn clean -X install package docker:build
echo "Building Batch Service completed successfully ..."

echo "Building Outreach VFS Backend Services Completed successfully..."