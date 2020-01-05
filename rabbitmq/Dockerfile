FROM rabbitmq

# Define environment variables.

RUN rabbitmq-server

RUN rabbitmqctl add_user user user
RUN rabbitmqctl set_user_tags user administrator
RUN rabbotmqctl set_permissions -p / user  ".*" ".*" ".*"


