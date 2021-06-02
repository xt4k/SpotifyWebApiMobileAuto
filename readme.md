![image](https://user-images.githubusercontent.com/38681283/120556173-d0631600-c404-11eb-894a-6c7ec19704ca.png)
# SPOTIFY  Auto-test project.
##### Done in frame of diploma qualification test for AQA school QA.GURU
![image](https://user-images.githubusercontent.com/38681283/120552697-3a2cf100-c400-11eb-97aa-cddc3e21968a.png)
![image](https://user-images.githubusercontent.com/38681283/120561211-cb09c980-c40c-11eb-8423-a456c7717d31.png)
## Стек используемых технологий:
| GitHub | IDEA | Java | Junit5 | Gradle | Selenide |
|:------:|:----:|:----:|:------:|:------:|:--------:|
| <img src="images/GitHub.svg" width="40" height="40"> | <img src="images/IDEA.svg" width="40" height="40"> | <img src="images/JAVA.svg" width="40" height="40"> | <img src="images/Junit5.svg" width="40" height="40"> | <img src="images/Gradle.svg" width="40" height="40"> | <img src="images/Selenide.svg" width="40" height="40"> |

| Selenoid | Allure Report | Allure TO | Jenkins | Jira | Telegram |
|:--------:|:-------------:|:---------:|:-------:|:----:|:--------:|
| <img src="images/Selenoid.svg" width="40" height="40"> | <img src="images/Allure Report.svg" width="40" height="40"> | <img src="images/Allure TestOps.svg" width="40" height="40"> | <img src="images/Jenkins.svg" width="40" height="40"> | <img src="images/Jira.svg" width="40" height="40"> | <img src="images/Telegram.svg" width="40" height="40"> |
___
## Примеры используемых технологий:
### :arrow_forward: В качестве CI системы использован Jenkins

![](images/mainJenkins.png)

# Test Levels:
## :white_check_mark: API      
#### - very fast tests that request information about artists, album, market, spotify user and verify it. Tests are logging API requests, responses, expected and actual results.
### Typically it looks like this
![image](https://user-images.githubusercontent.com/38681283/120557802-233dcd00-c407-11eb-9fe2-d65052a03f41.png)
## :white_check_mark: UI            
#### - split into 3 set of tests: for Anonymous User, Login, Sign up, Registered User tests. Tests are logging only last screenshot, and video in normal workflow.
#### Failed tests providing screenshotof failed steps additionally.
#### Here it is video for passed autotest
![findtrack](https://user-images.githubusercontent.com/38681283/120558512-43ba5700-c408-11eb-8ab4-5f9e48b952f8.gif)
#### and last screenshot
![image](https://user-images.githubusercontent.com/38681283/120561043-87af5b00-c40c-11eb-8c2a-202bed1de2be.png)
## :white_check_mark: Mobile applications           
#### - testset designed for Android devices - "live" and emulated phones. it verifies common functionality like search band, composition, personal information. 
#### Tests are logging last screenshot, screenshot vor assrtional steps and storing test's workflow video (stored locally).
#### Here it is video for mobile autotests
![ScreenRecord_02062021_06-43-14](https://user-images.githubusercontent.com/38681283/120558842-bcb9ae80-c408-11eb-93a1-0458a09df578.gif)
![ScreenRecord_02062021_06-44-12](https://user-images.githubusercontent.com/38681283/120558846-bdeadb80-c408-11eb-99ae-61b1af11c2b3.gif)
#### and last screenshot for 'live' phone and emulated phone accordingly
![image](https://user-images.githubusercontent.com/38681283/120560727-eaecbd80-c40b-11eb-98c8-d8e4dfc5a6de.png)

