FROM python:3.8-alpine
COPY ./add/requirements.txt /add/requirements.txt
WORKDIR /add
RUN apk add --update \
&& pip install --upgrade pip  \
&& pip install -r requirements.txt \
&& rm -rf /var/cache/apk/*
COPY ./add /add
CMD ["python", "add.py"]
