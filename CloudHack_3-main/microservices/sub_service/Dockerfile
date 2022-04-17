FROM python:3.8-alpine
COPY ./sub/requirements.txt /sub/requirements.txt
WORKDIR /sub
RUN apk add --update \
&& pip install --upgrade pip  \
&& pip install -r requirements.txt \
&& rm -rf /var/cache/apk/*
COPY ./sub /sub
CMD ["python", "sub.py"]
