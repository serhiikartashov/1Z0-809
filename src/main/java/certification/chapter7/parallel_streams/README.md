#Parallel Streams

## serial stream 
is a stream in which the results are ordered, with only one entry being processed at a time

## parallel stream 
is a stream that is capable of processing results concurrently, using multiple threads

By default, the number of threads available in a parallel stream is related to the
number of available CPUs in your environment. In order to increase the thread count, you would
need to create your own custom class.

For reduce() arguments:

1. The identity must be defined such that for all elements in the stream u, combiner.apply(identity, u) is equal to u

2. The accumulator operator op must be associative and stateless such that (a op b) op c is equal to a op (b op c).

3. The combiner operator must also be associative and stateless and compatible with the identity, such that for all 
u and t combiner.apply(u,accumulator.apply(identity,t)) is equal to accumulator.apply(u,t).

Requirements for collect()

1. The stream is parallel.

2. The parameter of the collect operation has the Collector.Characteristics.CONCURRENT characteristic.

3. Either the stream is unordered, or the collector has the characteristic Collector.Characteristics.UNORDERED.


