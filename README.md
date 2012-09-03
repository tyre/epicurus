# epicurus

Noir service to generate keys for redis (and eventually riak) in conjunction with [socrates](https://github.com/tyre/socrates) and [plato](https://github.com/tyre/plato).

## Usage

```bash
lein deps
lein run
```

This will run the server on port 7737 by default (or change in src/epicurus/settings.clj).

Post this get request: http://localhost:7737/gen-key/event?app-name=Facebook&event-name=pageView&time=8764326

Boom! Generated key.

## License

Copyright (C) 2012 Chris Maddox

Distributed under the Eclipse Public License, the same as Clojure.