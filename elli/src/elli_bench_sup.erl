-module(elli_bench_sup).

-behaviour(supervisor).

%% API
-export([start_link/0]).

%% Supervisor callbacks
-export([init/1]).

%% ===================================================================
%% API functions
%% ===================================================================

start_link() ->
  supervisor:start_link({local, ?MODULE}, ?MODULE, []).

%% ===================================================================
%% Supervisor callbacks
%% ===================================================================

%% CAUTION : Assign big number to db pool will fail travis ci.
%%           Original value was 5000, too big! Even 512 crashes! keep 256
%%           till travis-ci environment accepts bigger size of db pool.

init([]) ->
  Port = application:get_env(elli_bench, port, 8081),
  ElliOpts = [{callback, elli_bench_cb}, {port, Port}],
  ElliSpec = {
      fancy_http,
      {elli, start_link, [ElliOpts]},
      permanent,
      5000,
      worker,
      [elli]},

  {ok, { {one_for_one, 5, 10}, [ElliSpec]} }.
