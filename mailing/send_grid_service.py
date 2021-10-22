from dotenv import load_dotenv

load_dotenv()  # take environment variables from .env.

import os
from sendgrid import SendGridAPIClient
from sendgrid.helpers.mail import Mail

from mailing_service import Email

def send(email : Email):
    message = Mail(
        from_email = 'amustaphag22@gmail.com',
        to_emails=email.destination,
        subject=email.subject,
        html_content=email.body
    )
    sg = SendGridAPIClient(os.environ.get('SENDGRID_API_KEY'))
    response = sg.send(message)
    return response
    

# message = Mail(
#     from_email='amustaphag22@gmail.com',
#     to_emails='ahmedmustapha.ghanmi@etudiant-enit.utm.tn',
#     subject='Sending once again jajajaja',
#     html_content='<strong>and easy to do anywhere, even with Python</strong>')
# try:
#     sg = SendGridAPIClient(os.environ.get('SENDGRID_API_KEY'))
#     response = sg.send(message)
#     print(response.status_code)
#     print(response.body)
#     print(response.headers)
# except Exception as e:
#     print(e.message)
