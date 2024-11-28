## Problem

### Rate Limiter Proxy

## Statement

User requests for a service are routed through a rate limiting proxy to ensure that the network is not overloaded by non-critical requests.
The proxy has the following limits:
- The number of requests in any given second cannot exceed 3.
- The number of requests in any given 10 second period cannot exceed 20. A ten-second period includes all request; arriving from any time max(1, T-9) to T (inclusive of both) for any valid time T.
-  The number of requests in any given minute cannot exceed 60. Similar to above, 1 minute is from max(1, T-59) to T.

Any request that exceeds any of the above limits will be dropped by the proxy. Given the times at which different requests arrive sorted ascending, find how many requests will be dropped.
Note: Even if a request is dropped it is still considered for future calculations. Although, if a request is to be dropped due to multiple violations, it is still counted only once.


Example
n = 27

requestTime = [1, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7, 7, 7, 11, 11, 11, 11]

- Request 1 - Not Dropped.
- Request 1 - Not Dropped.
- Request 1 - Not Dropped.
- Request 1 - Dropped. At most 3 requests are allowed in one second.
- No request will be dropped till 6 as all comes at an allowed rate of 3 requests per second and the 10-second clause is also not violated.
- Request 7 - Not Dropped. The total number of requests has reached 20 now.
- Request 7 - Dropped. At most 20 requests are allowed in ten seconds.
- Request 7 - Dropped. At most 20 requests are allowed in ten seconds.
- Request 7 - Dropped. At most 20 requests are allowed in ten seconds. Note that the 1-second limit is also violated here.
- Request 11 - No: Dropped. The 10-second window has now become 2 to 11. Hence the total number of requests in this window is 20 now.
- Request 11 - Dropped. At most 20 requests are allowed in ten seconds.
- Request 11 - Dropped. At most 20 requests are allowed in ten seconds.
- Request 11 - Dropped. At most 20 requests are allowed in ten seconds. Also, at most 3 requests are allowed per second.

Hence, a total of 7 requests are dropped.
