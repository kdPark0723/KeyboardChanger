  <h3 align="center">Keyboard Changer</h3>
  <p align="center">









## Table of Contents

- [About the Project](#about-the-project)

  - [Built With](#built-with)

- [Getting Started](#getting-started)

  - [Prerequisites](#prerequisites)
  - [Installation](#installation)
  - [Run Project](#run-project)

- [Usage](#usage)

- [License](#license)

  <!-- ABOUT THE PROJECT -->



## About The Project

​	다들 한영키가 고장 나거나 기타 오류로 한글이 입력이 되지 않아 당황스러운 경우가 있었을 것 입니다. 저희는 또한 이런 경우가 있었고 이에 아이디어를 얻어 영어로 한글문장을 입력하면 한글로 출력하는 프로젝트를 기획하였습니다.

### Built with

- Java (version 11)
- Kotlin (version 1.3.50)
- Gradle



<!-- GETTING STARTED -->

## Getting Started

<!-- PREREQUISITIES -->

### Prerequisites

JVM 설치

1. https://www.oracle.com/technetwork/java/javase/downloads/index.html 접속

2. Java SE 다운로드 탭의 JDKe 다운로드

   ![캡처](https://user-images.githubusercontent.com/50135193/70119966-cb59c500-16ae-11ea-8880-129739fc6cbb.PNG)

   

<!-- INSTALLATION -->

### Installation

1. 깃 설치

   ```sh
   sudo apt install git
   ```

2. Gradle 설치

   ```sh
   sudo apt-get install gradle
   ```

3. Gradle 패키지 설치 전 설정

   ```sh
   sudo wget -q -O - http://pkg.jenkins-ci.org/debian/jenkins-ci.org.key | sudo apt-key add 
   
   sudo sh -c 'echo deb http://pkg.jenkins-ci.org/debian binary/ > /etc/apt/sources.list.d/jenkins.list'
   ```

4. https://jenkins.io/index.html에서 패키지 다운로드 후 업데이트

   ```sh
   sudo apt-get update
   ```

5. jenkins 다운로드

   ```sh
   sudo apt-get install Jenkins
   ```

6. jenkins 시작

   ```sh
   service jenkins start
   ```

   

<!-- RUN PROJECT -->

### Run Project



<!-- USAGE EXAMPLE -->

## Usage

​	한글을 입력해야하지만 한영키가 고장났을 때 혹은 오류로 인하여 한글 입력이 불가능할 때 유용하게 사용이 가능합니다. 



<!-- LICENSE -->

## License

 This project is licensed under the MIT License.  See `LICENSE` for more information.





Git Hub Link: [ https://github.com/kdPark0723/KeyboardChanger ]( https://github.com/kdPark0723/KeyboardChanger )
