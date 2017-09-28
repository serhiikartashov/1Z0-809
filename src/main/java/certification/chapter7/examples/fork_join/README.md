###Fork and Join Explained

The fork and join principle consists of two steps which are performed recursively. These two steps are the fork step and the join step.

###Fork
A task that uses the fork and join principle can fork (split) itself into smaller subtasks which can be executed concurrently.

###Join
Once the subtasks have finished executing, the task may join (merge) all the results into one result.

###ForkJoinPool
You submit tasks to a ForkJoinPool similarly to how you submit tasks to an ExecutorService. 
You can submit two types of tasks. A task that does not return any result (an "action"), 
and a task which does return a result (a "task").

###RecursiveAction
A RecursiveAction is a task which does not return any value. It just does some work, e.g. writing data to disk, and then exits.

A RecursiveAction may still need to break up its work into smaller chunks which can be executed by independent threads or CPUs.

###RecursiveTask
A RecursiveTask is a task that returns a result. It may split its work up into smaller tasks, 
and merge the result of these smaller tasks into a collective result. The splitting and 
merging may take place on several levels.

