-module(elli_bench_cb).
-export([handle/2, handle_event/3]).

-include_lib("elli/include/elli.hrl").
-behaviour(elli_handler).

handle(Req, _Args) ->
    %% Delegate to our handler function
    handle(Req#req.method, elli_request:path(Req), Req).

%% Plaintext test route 
handle('GET', [<<"plaintext">>], _Req) ->
    %% Reply with a normal response. 'ok' can be used instead of '200'
    %% to signal success.
    {ok,[{<<"Content-Type">>, <<"text/plain">>}], books_string()};

%% Json test route
handle('GET',[<<"json">>], _Req) ->
    %% Reply with a normal response. 'ok' can be used instead of '200'
    %% to signal success.
    { ok
    , [{<<"Content-Type">>, <<"application/json">>}]
    , jiffy:encode(books())
    };
handle(_, _, _Req) ->
    {404, [], <<"Not Found">>}.

%% @doc: Handle request events, like request completed, exception
%% thrown, client timeout, etc. Must return 'ok'.
handle_event(_Event, _Data, _Args) ->
    ok.

books() ->
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

books_string() ->
    <<"[{\"authors\": [\"George Orwell\"],\"isbn13\": 9780141036137,\"publishedDate\": \"April 27, 2014\",\"publisher\": \"Penguin\",\"title\": \"Animal Farm\"},{\"authors\": [\"George Orwell\"],\"isbn13\": 9780141036144,\"publishedDate\": \"April 27, 2014\",\"publisher\": \"Penguin\",\"title\": \"1984\"},{\"authors\": [\"William Sommerset Maugham\"],\"isbn13\": 9780099284864,\"publishedDate\": \"April 27, 2014\",\"publisher\": \"Vintage\",\"title\": \"The Razor\'s Edge\"}]">>.
