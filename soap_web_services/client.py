import datetime

from suds.client import Client


WSDL = "http://localhost:8000/doctor_wsdl"
client = Client(WSDL)
# response = client.service.say_hello('hos', 2)
# print(response)
#
activities = client.service.get_activities_by_patient_id(2, datetime.datetime.now().date())
#
print(activities)

# ss = client.service.get_not_obeyed_medication_plan(2, datetime.datetime.now().date())
# print(ss)

# client.service.annotate_activity(24, False)