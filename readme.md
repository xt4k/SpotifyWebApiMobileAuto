# Spotify Autotesting project.
# done in frame of diploma qualification test for AQA shcool QA.GURU

# Project scope:
## API tests
## UI tests
## Mobile applications tests


Here is my Diploma project.


I have selected Spotify, according to idea, that it should follow to 3 diretions :

1) Interesting, at least enough to look at this project more carefully. (+)
2) Open position on some famous site (+)
3) It should have:
    - web site (+);
    - public API (+);
    - mobile application (+);

For every of such layers were designed several tests. Comments:
Web tests - splitted in 3 testset (Anonymous User, Registered, Sign Up). Because of Captcha protection against automatic
queries - SignUp tests has no chance to be stable, but I found a small workaroun that allow from time to time go through
captcha. But finally I decided do not waste time and left this test set as examples of failed and disabled tests. API
tests - Spotify API has several types of access and in frame of diploma project taken easiest to design one. Mobile
tests - Designed on localhost "live" phone and "android emulator" one. Also design ability to use mobile factory
browserstack, but because of bad connection, for free plan, it was delayed. In general, I got an experience in lot of
different skills, during diploma project and ready nex challenges.
