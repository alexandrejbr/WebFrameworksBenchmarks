var cluster = require('cluster')
  , numCPUs = require('os').cpus().length;

if(cluster.isMaster) {
  // Fork workers.
  for (var i = 0; i < numCPUs; i++) {
    cluster.fork();
  }

  cluster.on('exit', function(worker, code, signal) {
    console.log('worker ' + worker.pid + ' died');
  });

  return;
}

var http = require('http')
  , url = require('url');

var msg = [
              {
                title:"Animal Farm",
                authors:["George Orwell"],
                publisher:"Penguin",
                isbn13:9780141036137,
                publishedDate:"April 27, 2014"
              },
              {
                title:"1984",
                authors:["George Orwell"],
                publisher:"Penguin",
                isbn13:9780141036144,
                publishedDate:"April 27, 2014"
              },
              {
                title:"The Razor's Edge",
                authors:["William Sommerset Maugham"],
                publisher:"Vintage",
                isbn13:9780099284864,
                publishedDate:"April 27, 2014"
            }
          ];
var str = JSON.stringify(msg);

http.createServer(function (req, res) {
  var path = url.parse(req.url).pathname;
  
  switch (path) {
  case '/json':
    res.writeHead(200, {'Content-Type': 'application/json; charset=UTF-8'});
    res.end(JSON.stringify(msg));
    break;

  case '/text':
    res.writeHead(200, {'Content-Type': 'text/plain; charset=UTF-8'});
    res.end(str);
    break;

  default:
    res.writeHead(404, {'Content-Type': 'text/plain; charset=UTF-8'});
    res.end("NOT FOUND");
  }
}).listen(9001);