![image](https://user-images.githubusercontent.com/38681283/120556173-d0631600-c404-11eb-894a-6c7ec19704ca.png)

## SPOTIFY

## Auto-test project

##### Done in frame of diploma qualification test for AQA school QA.GURU

###### *If Spotify team doesn't agree with their logo presence here - please let me know and I will delete it.

## TABLE OF CONTENT

* [SPOTIFY](#spotify)
* [General info](#general-info)
* [Technology stack](#technology-stack)
* [Test Levels](#test-levels)
* [Typical API messages](#typical-api-messages)
* [Web UI autotest video](#web-ui-autotest-video)
* [Spotify mobile application autotests video](#spotify-mobile-application-autotests-video)
* [Last screenshot for live and emulated phones accordingly](#last-screenshot-for-live-and-emulated-phones-accordingly)
* [Spotify job screenshot](#spotify-job-screenshot)
* [Allure report in Jenkins](#allure-report-in-jenkins)
* [AllureTestOps screenshots](#alluretestops-screenshots)
* [Jira issue screenshot](#jira-issue-screenshot)
* [Mail screenshot](#mail-screenshot)
* [Chat message](#chat-message)

## General info

### :arrow_forward: Central node of project - Jenkins CI integrated with TMS Allure TestOps

## Jenkins run autotests on Selenoid server and transfer test reports data into Allure TestOps, that integrated with Jira.

## Also Jenkins send telegram chat and e-mail messages about job result.

## Technology stack

| GitHub | IDEA | Java | Junit5 | Gradle | Selenide | Selenoid | Allure | Jenkins |
|:-----:|:-----:|:----:|:------:|:------:|:--------:|:--------:|:------------:|:-------:|
|<img src="https://user-images.githubusercontent.com/38681283/120561870-048f0480-c40e-11eb-9ff8-c155f9d617c4.png" width="40" height="40"> | <img src="https://user-images.githubusercontent.com/38681283/120561799-e88b6300-c40d-11eb-91ba-d4103ef6d4b5.png" width="40" height="40"> | <img src="https://user-images.githubusercontent.com/38681283/120561837-f7721580-c40d-11eb-8590-7b3b0b5eb50d.png" width="40" height="40"> | <img src="https://user-images.githubusercontent.com/38681283/120562013-43bd5580-c40e-11eb-926f-1b8d3dc9e965.png" width="40" height="40"> | <img src="https://user-images.githubusercontent.com/38681283/120562398-fbeafe00-c40e-11eb-9fe7-3a641bf7115c.png" width="40" height="40"> | <img src="https://user-images.githubusercontent.com/38681283/120562458-1c1abd00-c40f-11eb-8ce8-2eb023f3e24f.png" width="40" height="40"> | <img src="https://user-images.githubusercontent.com/38681283/120562511-38b6f500-c40f-11eb-8b04-208bec6529aa.png" width="40" height="40"> | <img src="https://user-images.githubusercontent.com/38681283/120562749-b5e26a00-c40f-11eb-91d9-641e254428c9.png" width="40" height="40"> <img src="https://user-images.githubusercontent.com/38681283/120562784-c692e000-c40f-11eb-8298-aa3858159184.png" width="40" height="40"> | <img src="https://user-images.githubusercontent.com/38681283/120562827-e0342780-c40f-11eb-9430-05ae54f145b1.png" width="40" height="40"> |  

| Appium | Rest Assured | Selenium | Jira | Browserstack | Android Studio | Telegram |
|:-------------:|:--------:|:------:|:------------:|:--------------:|:---------:|:------:|
<img src="https://user-images.githubusercontent.com/38681283/120563090-72d4c680-c410-11eb-8a3f-2309be0a818f.png" width="40" height="40"> |<img src="https://user-images.githubusercontent.com/38681283/120566097-335da880-c417-11eb-9e7b-248f6d5d4370.png" width="50" height="40"> | <img src="https://user-images.githubusercontent.com/38681283/120566010-eed20d00-c416-11eb-940d-56923ceff1bf.png" width="40" height="40"> | <img src="https://user-images.githubusercontent.com/38681283/120563529-79b00900-c411-11eb-8ab7-d5caf8b11ac1.png" width="40" height="40"> | <img src="https://user-images.githubusercontent.com/38681283/120565685-4ae86180-c416-11eb-9e62-42edc0e07e14.png" width="40" height="40"> | <img src="https://user-images.githubusercontent.com/38681283/120563229-bf200680-c410-11eb-91a6-d54243d0cda6.png" width="40" height="40"> | <img src="https://user-images.githubusercontent.com/38681283/120566160-54be9480-c417-11eb-86b7-4445fcdc8183.png" width="40" height="40"> |

## Test Levels:

## :white_check_mark: API

#### - very fast tests that request information about artists, album, market, spotify user and verify it. Tests are logging API requests, responses, expected and actual results.

## Typical API messages

![image](https://user-images.githubusercontent.com/38681283/120557802-233dcd00-c407-11eb-9fe2-d65052a03f41.png)

## :white_check_mark: UI

#### - split into 3 set of tests: for Anonymous User, Login, Sign up, Registered User tests. Tests are logging only last screenshot, and video in normal workflow.

#### Failed tests providing screenshotof failed steps additionally.

## Web UI autotest video

![findtrack](https://user-images.githubusercontent.com/38681283/120558512-43ba5700-c408-11eb-8ab4-5f9e48b952f8.gif)

#### and last screenshot

![image](https://user-images.githubusercontent.com/38681283/120561043-87af5b00-c40c-11eb-8c2a-202bed1de2be.png)

## :white_check_mark: Mobile application

#### - testset designed for Android devices - "live" and emulated phones. it verifies common functionality like search band, composition, personal information.

#### Tests are logging last screenshot, screenshot vor assrtional steps and storing test's workflow video (stored locally).

## Spotify mobile application autotests video

![ScreenRecord_02062021_06-43-14](https://user-images.githubusercontent.com/38681283/120558842-bcb9ae80-c408-11eb-93a1-0458a09df578.gif)
![ScreenRecord_02062021_06-44-12](https://user-images.githubusercontent.com/38681283/120558846-bdeadb80-c408-11eb-99ae-61b1af11c2b3.gif)

## Last screenshot for live and emulated phones accordingly

![image](https://user-images.githubusercontent.com/38681283/120560727-eaecbd80-c40b-11eb-98c8-d8e4dfc5a6de.png)

## :arrow_forward: [Jenkins job][1]

## Spotify job screenshot

![image](https://user-images.githubusercontent.com/38681283/120642012-08a63b00-c47d-11eb-9687-b463348d2c78.png)

## Allure report in Jenkins

![image](https://user-images.githubusercontent.com/38681283/120564585-ed531580-c413-11eb-8515-40979492ec24.png)

## :arrow_forward: [Spotify Allure_TestOps][2]

## AllureTestOps screenshots

![image](https://user-images.githubusercontent.com/38681283/120640087-c0861900-c47a-11eb-891e-34382f8df197.png)
![image](https://user-images.githubusercontent.com/38681283/120640222-e0b5d800-c47a-11eb-9fc9-15d4bce0180c.png)
![image](https://user-images.githubusercontent.com/38681283/120640315-00e59700-c47b-11eb-81e5-b46814df3ea2.png)
![image](https://user-images.githubusercontent.com/38681283/120640404-1eb2fc00-c47b-11eb-8630-5e78fb6e5c92.png)
![image](https://user-images.githubusercontent.com/38681283/120641333-2921c580-c47c-11eb-9b68-25280b4f8e6e.png)

## :arrow_forward: [Jira issue - integrated with Allure_TestOps][3]

## Jira issue screenshot

#### (shown Allure TestOps launches and testcases statuses)

![image](https://user-images.githubusercontent.com/38681283/120621762-de498300-c466-11eb-9e71-f0a5001d446e.png)

## :arrow_forward: E-mail integration

## Mail screenshot

#### Jenkins sends emails with short report summary image to selected mailbox

![image](https://user-images.githubusercontent.com/38681283/120648070-ea900900-c483-11eb-94d0-9c32369078ce.png)

## :arrow_forward: Telegram integration

## Chat message

#### Jenkins sends messages with short report summary image to selected chat

![image](https://user-images.githubusercontent.com/38681283/120643739-355b5200-c47f-11eb-8a4d-bac92a8240c5.png)

#### :white_check_mark: Also Telegram Integrated with me :)

[![Telegram](https://img.shields.io/badge/-Telegram-0b0a1a?style=for-the-badge&logo=telegram&logoColor=27A0D9)](https://t.me/yuriy_logvinov)

[1]: https://jenkins.autotests.cloud/job/spotify_auto_diploma

[2]: https://allure.autotests.cloud/project/204/launches

[3]: https://jira.autotests.cloud/projects/AUTO/issues/AUTO-226
