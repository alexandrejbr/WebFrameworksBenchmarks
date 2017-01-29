-module(cowboy_bench_handler).

-behaviour(cowboy_http_handler).

-export([init/3]).
-export([handle/2]).
-export([terminate/3]).


init(_, Req, _Opts) ->
  {ok, Req, []}.

handle(Req0, State) ->
  {Path, Req} = cowboy_req:path(Req0),
  handle_path(Req, Path, State).

handle_path(Req0, <<"/">>, State) ->
  {ok, Req} = cowboy_req:reply(200,
                               [{<<"content-type">>, <<"text/plain">>}],
                               <<"Viva ao Benfica!">>,
                               Req0),
  {ok, Req, State};
handle_path(Req0, <<"/plaintext">>, State) ->
  {ok, Req} = cowboy_req:reply(200,
                               [{<<"content-type">>, <<"text/plain">>}],
                               books_string(),
                               Req0),
  {ok, Req, State};
handle_path(Req0, <<"/json_jiffy">>, State) ->
  {ok, Req} = cowboy_req:reply(200,
                               [{<<"content-type">>, <<"application/json">>}],
                               jiffy:encode(books_jiffy()),
                               Req0),
  {ok, Req, State};
handle_path(Req0, <<"/json_jsx">>, State) ->
  {ok, Req} = cowboy_req:reply(200,
                               [{<<"content-type">>, <<"application/json">>}],
                               jsx:encode(books_jsx()),
                               Req0),
  {ok, Req, State}.



terminate(_Reason, _Req, _State) ->
  ok.


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
