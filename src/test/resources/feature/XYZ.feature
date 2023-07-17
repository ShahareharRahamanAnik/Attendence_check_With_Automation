Feature: Course attendance check
Scenario Outline: Checking attendence
  Given MIST Student log in page
  When Student input '<StudentID>' and '<password>'
  And click on the log in button
  And Click on the Running Courses
  And Click on Course
  And Click on attendance
  Then log out from this page

  Examples:
  |StudentID|password|
  |201916053|201916053|