FROM python:3.8-alpine
COPY ./exp/requirements.txt /exp/requirements.txt
WORKDIR /exp
RUN apk add --update \
&& pip install --upgrade pip  \
&& pip install -r requirements.txt \
&& rm -rf /var/cache/apk/*
COPY ./exp /exp
CMD ["python", "exp.py"]
