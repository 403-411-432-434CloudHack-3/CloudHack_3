FROM python:3.8-alpine
COPY ./mod/requirements.txt /mod/requirements.txt
WORKDIR /mod
RUN apk add --update \
&& pip install --upgrade pip  \
&& pip install -r requirements.txt \
&& rm -rf /var/cache/apk/*
COPY ./mod /mod
CMD ["python", "mod.py"]
