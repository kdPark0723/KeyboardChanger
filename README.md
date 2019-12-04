  <h3 align="center">Keyboard Changer</h3>
  <p align="center">









## Table of Contents

- [About the Project](#about-the-project)

  - [Built With](#built-with)

- [Getting Started](#getting-started)

  - [Prerequisites](#prerequisites)
  - [Installation](#installation)

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

7. Jenkins 접속 후 Manage Jenkins > Manage plugins 에서 프로젝트에 필요한 SpringInitalzr plugin 다운로드

8. Manage Jenkins > Global Tool Configuration에서 Git, Gradle 경로 입력(which git / which gradle 명령어로 위치 확인 가능)

   ![1575438095464](https://user-images.githubusercontent.com/50135193/70116744-f4765780-16a6-11ea-99fa-2c0b4a91f226.png)

   

   ![1575438165899](https://user-images.githubusercontent.com/50135193/70116750-f7714800-16a6-11ea-85c4-106f7a0e146f.png)

   

9. Jenkins에서 New Item을 누른 후 Freestyle 선택 후 General에서 Github project url 입력

   ![1575438195563](https://user-images.githubusercontent.com/50135193/70116755-f809de80-16a6-11ea-844c-7660dbb9e0b5.png)

   

10. Source Code Management에서 Repository URL 입력과 Credentials (github 아이디/비번) 추가

    - Branch를 명시해줘야 Build시 오류가 발생하지 않음 (github에서 feature/cicd 브랜치를 만들어서 지정해준다)

      ![1575438431384](https://user-images.githubusercontent.com/50135193/70116770-00621980-16a7-11ea-8dbf-033f8ad61674.png)

      

11. Build Environment에서 Build시 이전 workspace 삭제

    ![1575438501492](https://user-images.githubusercontent.com/50135193/70116773-022bdd00-16a7-11ea-8cf3-51de637e50aa.png)

    

    

12. Add Build step에서 Invoke Gradle script 선택 후 Use Gradle Wrapper 선택하고 Make gradlew executable 선택 (Tasks는 build , Switches 에서 --scan옵션을 추가함)

    ![1575438578652](https://user-images.githubusercontent.com/50135193/70116775-035d0a00-16a7-11ea-8eda-77d1539e02a5.png)

    

<!-- USAGE EXAMPLE -->

## Usage

​	한글을 입력해야하지만 한영키가 고장났을 때 혹은 오류로 인하여 한글 입력이 불가능할 때 유용하게 사용이 가능합니다. 



<!-- LICENSE -->

## License

 This project is licensed under the MIT License.  See `LICENSE` for more information.





Git Hub Link: [ https://github.com/kdPark0723/KeyboardChanger ]( https://github.com/kdPark0723/KeyboardChanger )
