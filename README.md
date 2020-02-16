This is a Spring Mvc project .
I have used Mongodb to store the data .. I could have used rdbms like psql , but it is time consuming to write queries for
jsonb in psql so i have used monogdb just because of quicker submission .
I have used Apache tomcat for spring deployment .
Store all .json files in /opt/tomcat/Employee folder for it get read and trasnfer data to mongodb 

API -> http://IP:8080/ue/get/details
    This is the get request to bring all the last 7 days details etc
    

API -> http://IP:8080/ue/add/content
    This would read all .json files and transfr data to mongodb
    
I am giving access to mongodb server which is hosted on EC2

Command - > ssh -X ue@ec2-15-206-178-19.ap-south-1.compute.amazonaws.com
Password -> ue@4321

When you are in the server just  type "mongo" enter and then "use user_experior" and then there are 2 collections
employee and activity which contain all the details 

(Security Points ignored due to submission deadline)
Note :- I have not set user and password in mongodb making it highly vulnerable for hacking , also mongodb should have been in private
subnet only accessible via internal IP from spring and externally via bastion host . Both of the issues can be resolved easily

The project is working , I have tried to cover every condition mentioned in the docs , if I have missed let me know ill do the changes
and submit

Deployment should not be an issue as all dependencies has scope as compiled , if there is an issue then let me know i give the 
IP of server which has this spring project deployed so you can check 


(Kindly ignore Graphql names in Spring  as I was starting with Graphql in spring and then switched to this project :) )
