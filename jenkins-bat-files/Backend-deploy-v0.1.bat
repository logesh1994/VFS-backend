echo "Deploying Outreach VFS Backend Services ..."

docker -H=172.18.2.50:2375 stop 512641-vfs-eureka
docker -H=172.18.2.50:2375 rm 512641-vfs-eureka
docker -H=172.18.2.50:2375 run --name=512641-vfs-eureka --network=512641-bridge -p 10200:10200 -d 512641-vfs-eureka

docker -H=172.18.2.50:2375 stop 512641-vfs-zuul
docker -H=172.18.2.50:2375 rm 512641-vfs-zuul
docker -H=172.18.2.50:2375 run --name=512641-vfs-zuul --network=512641-bridge -p 10201:10201 -d 512641-vfs-zuul

docker -H=172.18.2.50:2375 stop 512641-vfs-login
docker -H=172.18.2.50:2375 rm 512641-vfs-login
docker -H=172.18.2.50:2375 run --name=512641-vfs-login --network=512641-bridge -p 10202:10202 -d 512641-vfs-login

docker -H=172.18.2.50:2375 stop 512641-vfs-admin
docker -H=172.18.2.50:2375 rm 512641-vfs-admin
docker -H=172.18.2.50:2375 run --name=512641-vfs-admin --network=512641-bridge -p 10203:10203 -d 512641-vfs-admin

docker -H=172.18.2.50:2375 stop 512641-vfs-feedback
docker -H=172.18.2.50:2375 rm 512641-vfs-feedback
docker -H=172.18.2.50:2375 run --name=512641-vfs-feedback --network=512641-bridge -p 10204:10204 -d 512641-vfs-feedback

docker -H=172.18.2.50:2375 stop 512641-vfs-batch
docker -H=172.18.2.50:2375 rm 512641-vfs-batch
docker -H=172.18.2.50:2375 run --name=512641-vfs-batch --network=512641-bridge -p 10206:10206 -d 512641-vfs-batch

echo "Deploying Outreach VFS Backend Services Completed Successfully..."