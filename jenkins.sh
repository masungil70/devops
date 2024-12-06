#Jenkins install
sudo wget -O /usr/share/keyrings/jenkins-keyring.asc https://pkg.jenkins.io/debian-stable/jenkins.io-2023.key
echo deb [signed-by=/usr/share/keyrings/jenkins-keyring.asc] https://pkg.jenkins.io/debian-stable binary/ | sudo tee  /etc/apt/sources.list.d/jenkins.list > /dev/null
sudo apt-get update
sudo apt-get install jenkins -y

#실행 포트 변경 (8080 -> 9090)
sudo sed -i 's/HTTP_PORT=8080/HTTP_PORT=9090/' /etc/default/jenkins

sudo sed -i 's/check_tcp_port "http" "${HTTP_PORT}" "8080" "${HTTP_HOST}" "0.0.0.0" || return 2/check_tcp_port "http" "${HTTP_PORT}" "9090" "${HTTP_HOST}" "0.0.0.0" || return 2/' /etc/init.d/jenkins

sudo sed -i 's/Environment="JENKINS_PORT=8080"/Environment="JENKINS_PORT=9090"/' /lib/systemd/system/jenkins.service

#jenkins.service 변경으로 systemctl daemon-reload 해야한다 
sudo systemctl daemon-reload

#jenkins 계정에 docker 그룹 추가
sudo usermod -aG docker jenkins

#jenkins service 다시 시작
sudo systemctl restart jenkins


#jenkins 관리자 초기 비밀번호 확인 
sudo cat /var/lib/jenkins/secrets/initialAdminPassword
