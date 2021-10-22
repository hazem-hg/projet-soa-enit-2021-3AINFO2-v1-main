# intro-rest Project

# Mailling service


This microservice was implemented by Ahmed Mustapha Ghanmi

In order to try something new I tried developing this microservice in **Python** with Flask.

Used **MailGrid** as the mailing provider https://sendgrid.com/.

Deployed on **Heroku** : https://mailing-soa.herokuapp.com/.

## Endpoints :
**POST /email/send**

body : 

````json
{
    "destination" : "x@domain",
    "subject" : "email-subject",
    "body" : "email body"
}
````

## Try this project locally 

first set **SENDGRID_API_KEY** environment variable, then : 

````shell
py -m venv .venv
 .\.venv\Scripts\activate
pip install -r requirements.txt 
flask run
````
