# 업데이트
sudo apt update -y

# 업그레이드
sudo apt upgrade -y

#open jdk17 설치 
sudo apt install openjdk-17* -y

#docker 설치시 필요한 패키지 사전 설치 
sudo apt-get install apt-transport-https ca-certificates curl gnupg-agent software-properties-common -y

#Docker의 공식 GPG키 추가
curl -fsSL https://download.docker.com/linux/ubuntu/gpg | sudo apt-key add -

#Docker의 공식 apt 저장소 추가
sudo add-apt-repository "deb [arch=amd64] https://download.docker.com/linux/ubuntu $(lsb_release -cs) stable"

#시스템 패키지 업데이트
sudo apt-get update -y

#Docker 설치
#docker 설치시 필요한 패키지 사전 설치 
sudo apt-get install apt-transport-https ca-certificates curl gnupg-agent software-properties-common -y

#Docker의 공식 GPG키 추가
curl -fsSL https://download.docker.com/linux/ubuntu/gpg | sudo apt-key add -

#Docker의 공식 apt 저장소 추가
sudo add-apt-repository "deb [arch=amd64] https://download.docker.com/linux/ubuntu $(lsb_release -cs) stable"

#시스템 패키지 업데이트
sudo apt-get update -y

#Docker 설치
sudo apt  install docker.io docker-compose -y

#docker sudo 권한 그룹 설정 
sudo usermod -aG docker $USER

#현재 로그인 계정에 docker 그룹 추가 
newgrp docker