from flask import Flask, jsonify, make_response, request

from mailing_service import handle_mailing_request, verify_request

app = Flask(__name__)

@app.route('/')
def hello():
    return "<h1>hello</h1>"

@app.route('/email/send', methods=["POST"])
def send_email():
    if request.is_json and verify_request(request.get_json()) and handle_mailing_request(request.get_json()):
        response_body,code = {"message" : "all good! email was sent"},200
    else :
        response_body,code = {"message" : "oops! something bad happened!"},500
    return make_response(response_body,code)