from pilotproducer.activity_generate import generate_activity
from pilotproducer.send import send

import time
import json


class ActivityProducer:
    def __init__(self):
        self.last_activity = ''

    def run(self, infinite=True):
        while True:
            print("hello")

            activity_dict, last_activity = generate_activity(last_activity=self.last_activity)
            if activity_dict['patient_id'] is None:
                print("No patient found in database")
            else:
                self.last_activity = last_activity
                send(json.dumps(activity_dict))
            # sleep for one second
            time.sleep(1)

            if not infinite:
                break

