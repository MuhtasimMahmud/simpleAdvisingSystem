# simpleAdvisingSystem

User Management : Two types of user.
                  
                  1. Lecturer 
                  2. Students
                  
Featues :   1. Lecturer can create a new slot for student to book for their practical exam.
            2. Student can choose any slot from the given slots of the lecturer.
            3. Lecturer can view all the students who has a booked slot.
            


1. Use can register with an email address and his Role in this application.

![1  user registration](https://user-images.githubusercontent.com/58343930/204505628-ed7d6510-7729-4a64-9011-5719ec42ca89.png)


2. User can do login. After giving the login credential, based on the user role (Student/Lecturer) different window 
   will be shown to different different user.
      
![2  login](https://user-images.githubusercontent.com/58343930/204505842-943b1e10-5ced-437a-937b-dd9bc2843256.png)



3. After login as a student, a registration form will be shown. If the current loggedin student did not booked any 
   slot yet, then in the bottom it will show that "You have not booked any slot yet. Only after booking, you can cancel here:"

![3  student page](https://user-images.githubusercontent.com/58343930/204505869-deae4db6-e2cb-4689-b988-1c3d6c60c8d7.jpg)



4. After giving first name, last name, SID and choosing a slot, a student can click submit button and based on the reaminnig
   seat of that slot (if any vacancy of that slot) student can book that slot. Student don't need to feel the email box, 
   because in the backend autometicly the currect loggedin studen't email address will be fixed in the input.


![4 slots](https://user-images.githubusercontent.com/58343930/204505946-66260104-7f50-4535-bff4-c1a769e3559d.png)


5.  After successfully booking, a message will arrive at the top of the window which will show that "Successfully 
    registered your slot!" and in the bottom the message wil be changed as "You have booked you time in 'your choosed slot' ".

![5  slot booking](https://user-images.githubusercontent.com/58343930/204506030-bf47bcb1-8f09-4f12-bb25-7b4d5f71356d.jpg)


6. If any slot has 0 seat remaining, then student can't book that section.

![6   zero seat remaining](https://user-images.githubusercontent.com/58343930/204506232-67ad61c1-8cde-43ca-b923-34226c5c4ce7.png)


7. If that student choose a slot which has 0 seaat remaingin and press the submit button, then in the top of the window
   a message will be shown which is "sorry,  no  seat available for this slot. choose another slot."

![7   can't book msg for 0 seat](https://user-images.githubusercontent.com/58343930/204506380-5a012de1-0cda-4828-830d-ad8c33479def.png)


8. An user can't book another slot after booking a slot already. If he/she tries then in the top the message will be shown.

![8  student can't register more than one time](https://user-images.githubusercontent.com/58343930/204506471-0fae42b7-1601-4449-b3e4-9aa8e5ae710a.jpg)


9. If a student want to change his/her slot, then at first he/she has to cancel his/her previous booked slot. To do this,
   he/she has to press the "cancel booked slot" link in the bottom. After pressing that, a message will be shown in the top.
   
![9  slot booking  cancelation](https://user-images.githubusercontent.com/58343930/204506558-dab1e1d9-f66f-4ed2-b1ac-64ff229b39f4.jpg)


10. This is the lecturer page. He can see all the students who has a booked slot and he also can create a new slot for students.

![10  admin page](https://user-images.githubusercontent.com/58343930/204506583-74f05acc-83b0-4acd-81a8-bfc325d0d0d1.png)


11. To create a new slot, lecturer has to fill up the slot id, timing and total seat for that slot and press the create button.

![11  creating new slot](https://user-images.githubusercontent.com/58343930/204506694-93129c5e-8f2b-40a3-b497-def6ebcbed74.jpg)

12. After pressing the creating button, it the expected slot created successfully then the success message will be shown.

![12  creating new slot and success msg](https://user-images.githubusercontent.com/58343930/204506789-445775f0-4a8e-482f-a73d-ca6df9087ad7.jpg)


13. If the lecturer's given slot id is already existed then that message will be shown also and lecturer has to choose an 
    unique id.
    
    
![13  unique slot id needed](https://user-images.githubusercontent.com/58343930/204506895-bd71e34f-c700-4955-b232-848d8efb1eed.png)

14. Logout.

![14  LogOut](https://user-images.githubusercontent.com/58343930/204507017-00e65840-5a52-4957-b75f-3b29452a4330.png)



