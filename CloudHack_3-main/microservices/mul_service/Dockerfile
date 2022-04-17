FROM python:3.8-alpine
COPY ./mul/requirements.txt /mul/requirements.txt
WORKDIR /mul
RUN apk add --update \
&& pip install --upgrade pip  \
&& pip install -r requirements.txt \
&& rm -rf /var/cache/apk/*
COPY ./mul /mul
CMD ["python", "mul.py"]
