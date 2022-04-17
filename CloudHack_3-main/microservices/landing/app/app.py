from flask import Flask, render_template, request, flash, redirect, url_for

import requests
import os

app = Flask(__name__)
app.secret_key = 'thisisjustarandomstring'
def modulus(n1,n2):
	return int(n1%n2)
def exponent(n1,n2):
	return n1**n2
def equal(n1,n2):
	if n1==n2:
		return True
	else:
		return False
@app.route('/', methods=['POST', 'GET'])
def index():
    try:
        number_1 = int(request.form.get("first"))
        number_2 = int(request.form.get('second'))
        operation = request.form.get('operation')
        result = 0
        if operation == 'add':
            result = requests.get('http://add-service:5051/add/'+str(number_1)+'/'+str(number_2)).json()['ans']
        elif operation == 'minus':
            result = requests.get('http://sub-service:5052/sub/'+str(number_1)+'/'+str(number_2)).json()['ans']
        elif operation == 'multiply':
            result = requests.get('http://mul-service:5053/mul/'+str(number_1)+'/'+str(number_2)).json()['ans']
        elif operation == 'divide':
            result = requests.get('http://div-service:5054/div/'+str(number_1)+'/'+str(number_2)).json()['ans']
        elif operation == 'modulus':
            result = requests.get('http://mod-service:5055/mod/'+str(number_1)+'/'+str(number_2)).json()['ans']
        elif operation == 'exponent':
            result = requests.get('http://exp-service:5056/exp/'+str(number_1)+'/'+str(number_2)).json()['ans']
        elif operation == 'equal':
            result = requests.get('http://eq-service:5057/eq/'+str(number_1)+'/'+str(number_2)).json()['ans']
        flash(f'The result of operation {operation} on {number_1} and {number_2} is {result}')

        return render_template('index.html')
    except:
        #flash('error')
        return render_template('index.html')
        
if __name__ == '__main__':
    app.run(
        debug=True,
        port=5050,
        host="0.0.0.0"
    )
