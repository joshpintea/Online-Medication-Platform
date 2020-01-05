FROM python:3.6
ENV PYTHONUNBUFFERED 1
RUN mkdir /code
#RUN apt-get install python3-pymysql
WORKDIR /code
COPY requirements.txt /code/
RUN pip install -r requirements.txt
COPY . /code/