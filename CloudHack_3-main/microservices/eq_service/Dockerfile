FROM python:3.8-alpine
COPY ./eq/requirements.txt /eq/requirements.txt
WORKDIR /eq
RUN apk add --update \
&& pip install --upgrade pip  \
&& pip install -r requirements.txt \
&& rm -rf /var/cache/apk/*
COPY ./eq /eq
CMD ["python", "eq.py"]
