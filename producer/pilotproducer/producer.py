from pilotproducer.activity_generate import generate_activity
from pilotproducer.send import send

import time
import json


class ActivityProducer:
    def __init__(self):
        self.last_activity = ''

    def run(self, infinite=True):
        while True:
            activity_dict, last_activity = generate_activity(last_activity=self.last_activity)
            self.last_activity = last_activity

            # activity_dict = {
            #     'patient_id': 14,
            #     'activity': 'Sleeping',
            #     'start': 1572190811208,
            #     'end': 1572253931208
            # }
            send(json.dumps(activity_dict))

            # sleep for one second
            time.sleep(1)

            if not infinite:
                break

