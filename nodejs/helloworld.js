var startTime = new Date().getTime();

const http = require('http');

const requestListener = function (req, res) {
  res.writeHead(200);
  res.end('Hello, World!');
};

const server = http.createServer(requestListener);
server.listen(8080);

var endTime = new Date().getTime();

console.log('TIME1: ' + startTime);
console.log('TIME2: ' + endTime);
