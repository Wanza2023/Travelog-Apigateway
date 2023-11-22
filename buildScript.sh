./gradlew clean
./gradlew build
./gradlew bootJar

if [ -e ${gustjdw/travelog-apigateway:latest} ] ; then
  echo "기존 이미지 삭제"
  docker rmi gustjdw/travelog-apigateway:latest
fi

docker build --platform linux/amd64 -t gustjdw/travelog-apigateway:latest .
docker push gustjdw/travelog-apigateway:latest
