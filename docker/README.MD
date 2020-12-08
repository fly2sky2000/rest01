docker pull nginx
docker pull java:8



docker build -t fly2sky2000/rest01:v1.0 .
docker build -t fly2sky2000/ui01:v1.0 .

docker login --username fly2sky2000


docker push fly2sky2000/rest01:v1.0
docker push fly2sky2000/ui01:v1.0


docker rmi fly2sky2000/rest01:v1.0
docker rmi fly2sky2000/ui01:v1.0
