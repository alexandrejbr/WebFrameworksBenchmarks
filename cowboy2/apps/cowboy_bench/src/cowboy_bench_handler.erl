-module(cowboy_bench_handler).

-export([init/2]).

init(Req, Opts) ->
  handle(Req, Opts).

handle(Req, State) ->
  Path = cowboy_req:path(Req),
  handle_path(Req, Path, State).

handle_path(Req0, <<"/">>, State) ->
  Req = cowboy_req:reply(200,
                         #{<<"content-type">> => <<"text/plain">>},
                         <<"Viva ao Benfica!">>,
                         Req0),
  {ok, Req, State};
handle_path(Req0, <<"/plaintext">>, State) ->
  Req = cowboy_req:reply(200,
                         #{<<"content-type">> => <<"text/plain">>},
                         books_string(),
                         Req0),
  {ok, Req, State};
handle_path(Req0, <<"/json_jiffy">>, State) ->
  Req = cowboy_req:reply(200,
                         #{<<"content-type">> => <<"application/json">>},
                         jiffy:encode(books_jiffy()),
                         Req0),
  {ok, Req, State};
handle_path(Req0, <<"/json_jsx">>, State) ->
  Req = cowboy_req:reply(200,
                         #{<<"content-type">> => <<"application/json">>},
                         jsx:encode(books_jsx()),
                         Req0),
  {ok, Req, State}.

books_jiffy() ->
    [
     {[
       {<<"authors">>, [<<"George Orwell">>]},
       {<<"isbn13">>, 9780141036137},
       {<<"publishedDate">>, <<"April 27, 2014">>},
       {<<"publisher">>, <<"Penguin">>},
       {<<"title">>, <<"Animal Farm">>}
      ]},
     {[
       {<<"authors">>, [<<"George Orwell">>]},
       {<<"isbn13">>, 9780141036144},
       {<<"publishedDate">>, <<"April 27, 2014">>},
       {<<"publisher">>, <<"Penguin">>},
       {<<"title">>, <<"1984">>}
      ]},
     {[
       {<<"authors">>, [<<"William Sommerset Maugham">>]},
       {<<"isbn13">>, 9780099284864},
       {<<"publishedDate">>, <<"April 27, 2014">>},
       {<<"publisher">>, <<"Vintage">>},
       {<<"title">>, <<"The Razor's Edge">>}
      ]}
    ].

books_jsx() ->
    [
     [
       {<<"authors">>, [<<"George Orwell">>]},
       {<<"isbn13">>, 9780141036137},
       {<<"publishedDate">>, <<"April 27, 2014">>},
       {<<"publisher">>, <<"Penguin">>},
       {<<"title">>, <<"Animal Farm">>}
      ],
     [
       {<<"authors">>, [<<"George Orwell">>]},
       {<<"isbn13">>, 9780141036144},
       {<<"publishedDate">>, <<"April 27, 2014">>},
       {<<"publisher">>, <<"Penguin">>},
       {<<"title">>, <<"1984">>}
      ],
     [
       {<<"authors">>, [<<"William Sommerset Maugham">>]},
       {<<"isbn13">>, 9780099284864},
       {<<"publishedDate">>, <<"April 27, 2014">>},
       {<<"publisher">>, <<"Vintage">>},
       {<<"title">>, <<"The Razor's Edge">>}
      ]
    ].

books_string() ->
    <<"[{\"authors\":[\"George Orwell\"],\"isbn13\":9780141036137,\"publishedDate\":\"April 27, 2014\",\"publisher\":\"Penguin\",\"title\":\"Animal Farm\"},{\"authors\":[\"George Orwell\"],\"isbn13\":9780141036144,\"publishedDate\":\"April 27, 2014\",\"publisher\":\"Penguin\",\"title\":\"1984\"},{\"authors\":[\"William Sommerset Maugham\"],\"isbn13\":9780099284864,\"publishedDate\":\"April 27, 2014\",\"publisher\":\"Vintage\",\"title\":\"The Razor\'s Edge\"}]">>.
