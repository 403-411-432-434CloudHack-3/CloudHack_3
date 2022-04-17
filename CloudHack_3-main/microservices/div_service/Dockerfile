FROM python:3.8-alpine
COPY ./div/requirements.txt /div/requirements.txt
WORKDIR /div
RUN apk add --update \
&& pip install --upgrade pip  \
&& pip install -r requirements.txt \
&& rm -rf /var/cache/apk/*
COPY ./div /div
CMD ["python", "div.py"]
