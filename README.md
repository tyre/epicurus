# Epicurus

![Analytics! Science!](http://www.volacci.com/files/imce-uploads/integrate-google-analytics-with-thesis.gif)

Noir service to generate keys for redis (and eventually riak) in conjunction with [socrates](https://github.com/tyre/socrates) and [plato](https://github.com/tyre/plato).

## Usage

```bash
lein deps
lein run
```

This will run the server on port 7737 by default (or change in src/epicurus/settings.clj).

GET request: http://localhost:7737/generate/event?app-name=Facebook&event-name=pageView&time=8764326

Response:

    HTTP/1.1 200 OK
    Date: Sun, 16 Sep 2012 15:32:46 GMT
    Set-Cookie: ring-session=7ab7871b-4a97-4316-aa3e-eac3c272a568;Path=/
    Content-Type: application/json; charset=ISO-8859-1
    Connection: close
    Server: Jetty(6.1.25)

    {"key":"Facebook-pageView-8764326"}

GET request: http://localhost:7737/generate/event-range?app-name=Facebook&event-name=pageView&start-time=8764326&end-time=8764328

    HTTP/1.1 200 OK
    Date: Sun, 16 Sep 2012 15:44:48 GMT
    Set-Cookie: ring-session=05ec2ce2-c49d-40d7-9af8-781b3c8751bd;Path=/
    Content-Type: application/json; charset=ISO-8859-1
    Connection: close
    Server: Jetty(6.1.25)

    {"key":["Facebook-pageView-8764326","Facebook-pageView-8764327","Facebook-pageView-8764328"]}

## API

#### Key generation

- /generate

  * GET /event
    + GET /unread
  * GET /event-range
    + GET /unread

## License

Copyright (C) 2012 Chris Maddox

Distributed under the Eclipse Public License, the same as Clojure.