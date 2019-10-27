from pilotproducer import config

import pika


def send(message: str):
    connection = pika.BlockingConnection(pika.ConnectionParameters('localhost'))
    channel = connection.channel()
    channel.queue_declare(queue=config.QUEUE_NAME)

    channel.basic_publish(exchange='',
                          routing_key=config.ROUTING_KEY,
                          body=message)

    print("[x] Sent: %s" % message)

    connection.close()
