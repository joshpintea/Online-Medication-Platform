import time
import os

from pilotproducer import config

import pika

RABBIT_MQ_PASS = os.environ.get('RABBITMQ_PASS')
RABBIT_MQ_USER = os.environ.get('RABBITMQ_USER')

def send(message: str):
    credentials = pika.PlainCredentials(RABBIT_MQ_USER, RABBIT_MQ_PASS)
    # print(RABBIT_MQ_USER, RABBIT_MQ_PASS)
    while True:
        try:
            connection = pika.BlockingConnection(pika.ConnectionParameters('rabbitmq',
                                                                           5672,
                                                                           '/',
                                                                           credentials))
            break
        except pika.exceptions.AMQPConnectionError as ex:
            print(ex)
            print('Cannot connect yet, sleeping 5 seconds.')
            time.sleep(5)

    channel = connection.channel()
    channel.queue_declare(queue=config.QUEUE_NAME)

    channel.basic_publish(exchange='',
                          routing_key=config.ROUTING_KEY,
                          body=message)

    print("[x] Sent: %s" % message)

    connection.close()
