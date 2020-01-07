from scripts.patient_listing import get_all_patients

import random
import datetime


def random_date(start, end):
    return start + datetime.timedelta(
        # Get a random amount of seconds between `start` and `end`
        seconds=random.randint(0, int((end - start).total_seconds())),
    )


def generate_activity_interval():
    now = datetime.datetime.now()
    end = now + datetime.timedelta(hours=3)

    start_activity = random_date(now, end)
    end_activity = random_date(end, end + datetime.timedelta(hours=20))

    return start_activity, end_activity


def date_to_utc(date):
    ts = date.timestamp()
    utc_offset = datetime.datetime.fromtimestamp(ts) - datetime.datetime.utcfromtimestamp(ts)

    minutes = utc_offset / datetime.timedelta(minutes=1)

    return date - datetime.timedelta(minutes=minutes)


def generate_activity(last_activity: str):
    activities = ["Leaving", "Toileting", "Showering", "Sleeping", "Breakfast",
                  "Lunch", "Dinner", "Snack", "Spare_Time/TV", "Grooming"]

    activity_label = random.choice([activity for activity in activities if not activity == last_activity])
    start_activity, end_activity = generate_activity_interval()

    patients = get_all_patients()

    if len(patients) == 0:
        print("No patient found")
        patient_id = None
    else:
        patient_id = random.choice(patients)

    return {
        'patient_id': patient_id,
        'activity': activity_label,
        'start': int(datetime.datetime.timestamp(date_to_utc(start_activity)) * 1000),
        'end': int(datetime.datetime.timestamp(date_to_utc(end_activity)) * 1000)
    }, activity_label


