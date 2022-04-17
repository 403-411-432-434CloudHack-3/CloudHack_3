# using flask_restful
from flask import Flask, jsonify, request
from flask_restful import Resource, Api

# creating the flask app
app = Flask(__name__)
app.secret_key = 'thisisjustarandomstring'
# creating an API object
api = Api(app)

# another resource to calculate the square of a number
class Add(Resource):

	def get(self, num1, num2):

		return jsonify({"ans":num1+num2})


# adding the defined resources along with their corresponding urls
api.add_resource(Add, '/add/<int:num1>/<int:num2>')


# driver function


app.run(debug = True,port='5051',host='0.0.0.0')

