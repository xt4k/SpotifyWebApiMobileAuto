![image](https://user-images.githubusercontent.com/38681283/120556173-d0631600-c404-11eb-894a-6c7ec19704ca.png)
# SPOTIFY  Auto-test project.
##### Done in frame of diploma qualification test for AQA school QA.GURU
## Technology stack:
| GitHub | IDEA | Java | Junit5 | Gradle | Selenide | Selenoid | Allure | Jenkins | Jira |
|:-----:|:-----:|:----:|:------:|:------:|:--------:|:--------:|:------:|:-------:|:----:|
|<img src="https://user-images.githubusercontent.com/38681283/120561870-048f0480-c40e-11eb-9ff8-c155f9d617c4.png" width="40" height="40"> | <img src="https://user-images.githubusercontent.com/38681283/120561799-e88b6300-c40d-11eb-91ba-d4103ef6d4b5.png" width="40" height="40"> | <img src="https://user-images.githubusercontent.com/38681283/120561837-f7721580-c40d-11eb-8590-7b3b0b5eb50d.png" width="40" height="40"> | <img src="https://user-images.githubusercontent.com/38681283/120562013-43bd5580-c40e-11eb-926f-1b8d3dc9e965.png" width="40" height="40"> | <img src="https://user-images.githubusercontent.com/38681283/120562398-fbeafe00-c40e-11eb-9fe7-3a641bf7115c.png" width="40" height="40"> | <img src="https://user-images.githubusercontent.com/38681283/120562458-1c1abd00-c40f-11eb-8ce8-2eb023f3e24f.png" width="40" height="40"> | <img src="https://user-images.githubusercontent.com/38681283/120562511-38b6f500-c40f-11eb-8b04-208bec6529aa.png" width="40" height="40"> | <img src="https://user-images.githubusercontent.com/38681283/120562749-b5e26a00-c40f-11eb-91d9-641e254428c9.png" width="40" height="40"> <img src="https://user-images.githubusercontent.com/38681283/120562784-c692e000-c40f-11eb-8298-aa3858159184.png" width="40" height="40"> | <img src="https://user-images.githubusercontent.com/38681283/120562827-e0342780-c40f-11eb-9430-05ae54f145b1.png" width="40" height="40"> | <img src="https://user-images.githubusercontent.com/38681283/120563529-79b00900-c411-11eb-8ab7-d5caf8b11ac1.png" width="40" height="40"> | <img src="https://user-images.githubusercontent.com/38681283/120562988-3acd8380-c410-11eb-8519-96124894e3c1.png" width="40" height="40"> | <img src="https://user-images.githubusercontent.com/38681283/120563090-72d4c680-c410-11eb-8a3f-2309be0a818f.png" width="40" height="40"> | 

| RestAssured | Selenium | Appium | Browserstack | Android Studio | Telegram|
|:-----:|:---:|:---:|:-----:|:-----:|:-----:|
|<img src="https://user-images.githubusercontent.com/38681283/120563229-bf200680-c410-11eb-91a6-d54243d0cda6.png" width="40" height="40"> |
___
### :arrow_forward: As central CI node of project - Jenkins and test management system Allure TestOps
## Jenkins run autotests on Selenoid server and transfer test reports data into Allure TestOps that integrated with Jira.
## Also Jenkins send telegram chat and e-mail messages about job result.
#### Jenkins job
![image](https://user-images.githubusercontent.com/38681283/120564438-9b11f480-c413-11eb-9a8b-2d9fc5779b73.png)
### Allure report
![image](https://user-images.githubusercontent.com/38681283/120564585-ed531580-c413-11eb-8515-40979492ec24.png)
#### Allure TestOps
![image](https://user-images.githubusercontent.com/38681283/120564676-1673a600-c414-11eb-9282-b1d1c27600e9.png)
![image](https://user-images.githubusercontent.com/38681283/120564747-491d9e80-c414-11eb-9b82-062ec8a4ae04.png)






![](images/mainJenkins.png)

![image](https://user-images.githubusercontent.com/38681283/120561211-cb09c980-c40c-11eb-8423-a456c7717d31.png)


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

