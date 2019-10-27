from pilotproducer.producer import ActivityProducer

import sys


if __name__ == "__main__":
    if (len(sys.argv) < 2):
        print("Usage python -m pilotproducer [run_on_infinite]")
        exit(-1)

    producer = ActivityProducer()
    producer.run(infinite=(sys.argv[1] == "True"))
