%%%-------------------------------------------------------------------
%% @doc cowboy_bench public API
%% @end
%%%-------------------------------------------------------------------

-module(cowboy_bench_app).

-behaviour(application).

%% Application callbacks
-export([start/2, stop/1]).

%%====================================================================
%% API
%%====================================================================

start(_StartType, _StartArgs) ->
  Dispatch =
    cowboy_router:compile(
      [ {'_',
         [ {"/", cowboy_bench_handler, []}
         , {"/plaintext", cowboy_bench_handler, []}
         , {"/json_jiffy", cowboy_bench_handler, []}
         , {"/json_jsx", cowboy_bench_handler, []}
         ]
        }
      ]),
  {ok, _} = cowboy:start_http( http_listener
                             , 100
                             , [{port, 8081}]
                             , [{env, [{dispatch, Dispatch}]}]
                             ),
  cowboy_bench_sup:start_link().

%%--------------------------------------------------------------------
stop(_State) ->
    ok.

%%====================================================================
%% Internal functions
%%====================================================================
