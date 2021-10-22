from flask import request
from functools import reduce

json_fields = ['destination', 'subject', 'body']

class Email:
    def __init__(self, destination, subject, body):
        self.destination=destination
        self.subject=subject
        self.body=body
    
    @staticmethod
    def __init_from_req__(req):
        return Email(req['destination'], req['subject'], req['body'])

class EmailService:
    @staticmethod
    def send(email : Email):
        return grid_send(email)

def verify_request(req):
    '''
    takes a flask request in
    verifies if the request contains all the fields in list json_fields
    this means json_fields should contain the required fields
    '''
    return reduce(lambda a,b : a and b, [field in req.keys() for field in json_fields])

from send_grid_service import send as grid_send

def handle_mailing_request(req):
    if not verify_request(req) : return False
    try:
        EmailService.send(Email.__init_from_req__(req))
        return True
    except Exception as e:
        print(e)
        return False
