@echo on
echo "Testing Outreach VFS Backend Services started..."

echo "Testing Common module started..."
cd C:\Jenkins\workspace\Backend-Services-Build-Job\outreach-vfs-common
call mvn test
@echo on
echo "Testing Common module completed successfully ..."

echo "Testing Login Service started..."
cd C:\Jenkins\workspace\Backend-Services-Build-Job\outreach-vfs-login
call mvn test
@echo on
echo "Testing Login Service completed successfully ..."

echo "Testing Admin Service started..."
cd C:\Jenkins\workspace\Backend-Services-Build-Job\outreach-vfs-admin
call mvn test
@echo on
echo "Testing Admin Service completed successfully ..."

echo "Testing Feedback Service started..."
cd C:\Jenkins\workspace\Backend-Services-Build-Job\outreach-vfs-feedback
call mvn test
@echo on
echo "Testing Feedback Service completed successfully ..."

echo "Testing Batch Service started..."
cd C:\Jenkins\workspace\Backend-Services-Build-Job\outreach-vfs-batch
call mvn test
@echo on
echo "Testing Batch Service completed successfully ..."

echo "Testing Outreach VFS Backend Services Completed successfully..."